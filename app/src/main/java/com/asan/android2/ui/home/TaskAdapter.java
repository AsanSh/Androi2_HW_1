package com.asan.android2.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asan.android2.R;
import com.asan.android2.RecyclerViewClickInterface;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<String> list;
    private RecyclerViewClickInterface recyclerViewClickInterface;

   // public TaskAdapter(RecyclerViewClickInterface recyclerViewClickInterface) {
   public TaskAdapter() {
    this.list = new ArrayList<>();
        //this.recyclerViewClickInterface = recyclerViewClickInterface;
        list.add("sasha");
        list.add("pasha");
        list.add("lesha");
        list.add("kesha");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
//        if(position % 2 == 0){
//            holder.view.setBackGroundResource(R.color.black);
//        } else {
//            holder.view.setBackGroundResource(R.color.white);
//        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItem(String title) {
        list.add(0, title);
        notifyItemInserted(0);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.textTitle);

        }

        public void bind(String s) {
            textTitle.setText(s);
        }
    }
}
