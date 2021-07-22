package com.example.HelluApp.DailyStamp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.HelluApp.R;

import java.util.List;

public class daily_stamp_write_noteAdapter extends RecyclerView.Adapter<daily_stamp_write_noteAdapter.ViewHolder> {
    List<daily_stamp_write_note> items;
    Context context;
    int itemLayout;

    public daily_stamp_write_noteAdapter(Context context, List<daily_stamp_write_note> items, int itemLayout) {
        this.context = context;
        this.items = items;
        this.itemLayout = itemLayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.daily_stamp_write_item, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        daily_stamp_write_note item = items.get(position);
        //holder.setItem(item);
        holder.daily_image.setImageResource(item.getPicture());
        holder.daily_date.setText(item.getCreateDateStr());
        holder.daily_text.setText(item.getContents());
        holder.itemView.setTag(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView daily_image;
        TextView daily_date;
        TextView daily_text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            daily_image = itemView.findViewById(R.id.daily_write_image);
            daily_date = itemView.findViewById(R.id.daily_write_date);
            daily_text = itemView.findViewById(R.id.daily_write_text);

        }

    }

}
