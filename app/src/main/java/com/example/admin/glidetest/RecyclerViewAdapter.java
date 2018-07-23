package com.example.admin.glidetest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Map;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myViewHolder>{

    private Context mContext;
    private List<Map<String,Object>> data;

    public RecyclerViewAdapter(Context context, List<Map<String,Object>> data){
        this.mContext = context;
        this.data=data;
    }

    @NonNull
    @Override/*负责为item创建视图*/
    public RecyclerViewAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item,parent,false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override/*负责将数据绑定到item的视图上*/
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.myViewHolder viewHolder, int position) {
//        Log.d("============>>>", ""+viewHolder.imageView);
//        viewHolder.imageView.setImageResource((Integer) data.get(position).get("image"));
        Glide.with(mContext).load("http://guolin.tech/book.png").into(viewHolder.imageView);
        viewHolder.textView.setText((String) data.get(position).get("text"));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
        }
    }
}