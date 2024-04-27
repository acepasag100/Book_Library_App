package com.example.booklibraryapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private Activity activity;
    private ArrayList<String> id, title, author, pages;

    public CustomAdapter(Activity activity,
                         Context context,
                         ArrayList id,
                         ArrayList title,
                         ArrayList author,
                         ArrayList pages){
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvID.setText(String.valueOf(id.get(position)));
        holder.tvTitle.setText(String.valueOf(title.get(position)));
        holder.tvAuthor.setText(String.valueOf(author.get(position)));
        holder.tvPage.setText(String.valueOf(pages.get(position)));
        holder.mainLayout.setOnClickListener(v -> {
            Intent intent = new Intent(context, UpdateActivity.class);
            intent.putExtra("id", String.valueOf(id.get(position)));
            intent.putExtra("title", String.valueOf(title.get(position)));
            intent.putExtra("author", String.valueOf(author.get(position)));
            intent.putExtra("pages", String.valueOf(pages.get(position)));
            //context.startActivity(intent);
            activity.startActivityForResult(intent, 1);
        });
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvID, tvTitle, tvAuthor, tvPage;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvID = itemView.findViewById(R.id.tvID);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvPage = itemView.findViewById(R.id.tvPageNumber);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
