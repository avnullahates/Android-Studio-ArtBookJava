package com.ates.artbookjava;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ates.artbookjava.databinding.ReceylerViewBinding;

import java.util.ArrayList;

public class ArtAdaptor  extends RecyclerView.Adapter<ArtAdaptor.ArtHolder> {


    ArrayList<Art> artArrayList;

    public ArtAdaptor (ArrayList<Art> artArrayList){
        this.artArrayList = artArrayList;

    }


    @NonNull
    @Override
    public ArtHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ReceylerViewBinding receylerViewBinding = ReceylerViewBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new  ArtHolder(receylerViewBinding);



    }

    @Override
    public void onBindViewHolder(@NonNull ArtHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(artArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),ArtActivity.class);
                intent.putExtra("info","old");
                intent.putExtra("artId", artArrayList.get(position).id);
                holder.itemView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return artArrayList.size();
    }

    public class ArtHolder extends RecyclerView.ViewHolder{
        private ReceylerViewBinding binding;



        public ArtHolder(ReceylerViewBinding binding) {

            super(binding.getRoot());
            this.binding = binding;

        }
    }


}
