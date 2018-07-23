package com.example.admin.glidetest;

import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class BaseAdapterTest extends BaseAdapter {

    private List<Map<Object,String>> data;

    public BaseAdapterTest(List<Map<Object,String>> list){
        this.data = list;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        mViewHolder holder ;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, null);
            holder = new mViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (mViewHolder) view.getTag();
        }
        holder.imageView.setImageResource(Integer.parseInt(data.get(position).get("image")));
        holder.textView.setText(data.get(position).get("text"));
        return null;
    }

    class mViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public mViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
