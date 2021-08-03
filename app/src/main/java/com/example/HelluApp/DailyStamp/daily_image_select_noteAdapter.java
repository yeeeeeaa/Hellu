package com.example.HelluApp.DailyStamp;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HelluApp.R;


import java.util.ArrayList;

public class daily_image_select_noteAdapter extends RecyclerView.Adapter<daily_image_select_noteAdapter.ItemViewHolder> {
    public ArrayList<Uri> albumImageList;
    public Context mContext;

    public daily_image_select_noteAdapter(ArrayList<Uri> albumImageList, Context mContext){
        this.albumImageList = albumImageList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public daily_image_select_noteAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.daily_stamp_write_image_item, parent, false);
        daily_image_select_noteAdapter.ItemViewHolder viewHolder = new daily_image_select_noteAdapter.ItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull daily_image_select_noteAdapter.ItemViewHolder holder, int position) {
        holder.imageView.setImageURI(albumImageList.get(position));
    }

    @Override
    public int getItemCount() {
        return albumImageList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;

        public ItemViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view_select);
        }
    }
}
