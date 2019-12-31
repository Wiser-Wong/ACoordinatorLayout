package com.wiser.acoordinatorlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.MessageFormat;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    private Context context;

    private int size;

    public RecyclerAdapter(Context context,int size){
        this.context = context;
        this.size = size;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        if (holder.itemView instanceof TextView)
            ((TextView)holder.itemView).setText(MessageFormat.format("测试{0}", position));
    }

    @Override
    public int getItemCount() {
        return size;
    }

    class RecyclerHolder extends RecyclerView.ViewHolder{

        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
