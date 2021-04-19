package com.asan.android2.ui.onboard;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asan.android2.R;
import com.asan.android2.RecyclerViewClickInterface;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private String[] titles = new String[]{"Fast", "Free", "Powerful"};
    private String[] description = new String[]{"Самый крутой", "Всегда бесплатно", "Самое лучшее"};
    private Integer[] images = {
            R.drawable.ic_hw_fast,
            R.drawable.ic_hw_free,
            R.drawable.ic_hw_power
    };

    private RecyclerViewClickInterface recyclerViewClickInterface;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pager_board, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public void setRecyclerViewClickInterface(RecyclerViewClickInterface recyclerViewClickInterface) {
        this.recyclerViewClickInterface = recyclerViewClickInterface;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textTitle, textDesc;
        Button btnStart;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.textTitle);
            textDesc = itemView.findViewById(R.id.textDesc);
            imageView = itemView.findViewById(R.id.imageView);
            btnStart = itemView.findViewById(R.id.btnStart);
            btnStart.setOnClickListener(v -> {
                recyclerViewClickInterface.onItemClick(getAdapterPosition());
            });


        }

        public void bind(int position) {

            // Drawable d = imageView.getResources().getDrawable(images[position]);
            textTitle.setText(titles[position]);
            textDesc.setText(description[position]);
            imageView.setImageResource(images[position]);
            // imageView.setImageDrawable(d);
            if (position == titles.length - 1) {
                btnStart.setVisibility(View.VISIBLE);
            } else {
                btnStart.setVisibility(View.INVISIBLE);
            }
        }
    }
}
