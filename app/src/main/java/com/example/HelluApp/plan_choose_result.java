package com.example.HelluApp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.ml.modeldownloader.CustomModelDownloadConditions;
import com.google.firebase.ml.modeldownloader.DownloadType;
import com.google.firebase.ml.modeldownloader.FirebaseModelDownloader;

import org.tensorflow.lite.Interpreter;

import java.io.File;

public class plan_choose_result extends AppCompatActivity {
    TextView present_weight, goal_weight, exercise_plan, prefer_ex, usual_act;
    double max_result;
    int index;
    String EditWeight, GoalWeight, numberOfWeekOfExercise, normalActivity;

    //'ai로 선별해주는 플랜 결과 보기' 버튼을 누르면 나오는 화면
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_choose_result);

        present_weight = findViewById(R.id.present_weight);
        goal_weight = findViewById(R.id.goal_weight);
        prefer_ex = findViewById(R.id.prefer_ex);
        exercise_plan = findViewById(R.id.exercise_plan);
        usual_act = findViewById(R.id.usual_act);

        // plan_choose에서 넘어온 값 받기
        Intent intent = getIntent();
        // bundle을 통해 Extra를 모두 가져온다.
        Bundle bundle = intent.getExtras();

        EditWeight = bundle.getString("EditWeight");
        GoalWeight = bundle.getString("GoalWeight");
        numberOfWeekOfExercise = bundle.getString("numberOfWeekOfExercise");
        normalActivity = bundle.getString("normalActivity");

        // 출력
        present_weight.setText(EditWeight);
        goal_weight.setText(GoalWeight);
        exercise_plan.setText(numberOfWeekOfExercise);
        usual_act.setText(normalActivity);

        prefer_Exercises();
    }

    public void prefer_Exercises(){
        CustomModelDownloadConditions conditions = new CustomModelDownloadConditions.Builder()
                .requireWifi()
                .build();
        FirebaseModelDownloader.getInstance()
                .getModel("model_surveyAI", DownloadType.LOCAL_MODEL, conditions)
                .addOnSuccessListener(model -> {
                    // Download complete. Depending on your app, you could enable the ML
                    // feature, or switch from the local model to the remote model, etc.

                    // The CustomModel object contains the local path of the model file,
                    // which you can use to instantiate a TensorFlow Lite interpreter.
                    File modelFile = model.getFile();
                    if (modelFile != null) {
                        Interpreter interpreter = new Interpreter(modelFile);

                        // 1. 라디오 버튼의 값을 하나하나 받아서 input에 넣을 값 구분.
                        // 2. 위치에 맞게 배열
                        // 3. 그리고 input에 넣기.
                        // 모델의 Input
                        //float[][] input = {{1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
                        // 입력값 모두 0으로 초기화
                        float[][] input = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
                        float[][] output = new float[1][7]; // 모델의 Output

                        interpreter.run(input, output); // 모델 실행

                        // 모델 결과값 출력하기
                        for (int i = 0; i < 7; i++) {
                            // 결과값 중에 최댓값 선정하기
                            if(i == 0){
                                index = 0;
                                max_result = output[0][i];
                            }
                            if(max_result < output[0][i]){
                                index = i;
                                max_result = output[0][i];
                            }
                        }

                        switch(index){
                            case 0:
                                prefer_ex.setText("체육관 운동");
                                break;

                            case 1:
                                prefer_ex.setText("웨이트 트레이닝");
                                break;

                            case 2:
                                prefer_ex.setText("수영");
                                break;

                            case 3:
                                prefer_ex.setText("팀 스포츠");
                                break;

                            case 4:
                                prefer_ex.setText("조깅");
                                break;

                            case 5:
                                prefer_ex.setText("요가");
                                break;

                            case 6:
                                prefer_ex.setText("줌바 댄스");
                                break;

                            default:
                                break;
                        }
                        interpreter.close(); // 인터프리터 종료
                    }
                });
    }
}