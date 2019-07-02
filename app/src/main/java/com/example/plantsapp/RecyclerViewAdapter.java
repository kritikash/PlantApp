package com.example.plantsapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageName = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();

    private ArrayList<Plant> plantArrayList = new ArrayList<>();

    private Context  mcontext;

    public RecyclerViewAdapter(ArrayList<Plant> plants,  Context context) {
       this.plantArrayList = plants;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");


       // holder.image.setImageURI(Uri.parse(mImage.get(position)));
        Glide.with(mcontext)
                .load(plantArrayList.get(position).getUrl())
                .into(holder.image);
         holder.imageName.setText(plantArrayList.get(position).getName());
         
         holder.parent_layout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Log.d(TAG, "onClick: clicked on: " + plantArrayList.get(position));
                 Intent intent = new Intent(mcontext, PlantList2.class);
                 intent.putExtra("PLANT_NAME", String.valueOf(plantArrayList.get(position).getName()));
                 intent.putExtra("URL", String.valueOf(plantArrayList.get(position).getUrl()));
                 intent.putExtra("POS",position);
                 intent.putExtra("Text", String.valueOf(plantArrayList.get(position).getDesc()));

                 mcontext.startActivity(intent);
                 Toast.makeText(mcontext, plantArrayList.get(position).getName(), Toast.LENGTH_SHORT).show();

             }
         });
    }

    @Override
    public int getItemCount() {
        return plantArrayList.size();
    }

    //declare all circular widgets here
    public class ViewHolder extends RecyclerView.ViewHolder{

       ImageView image;
       TextView imageName;
       RelativeLayout parent_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parent_layout  = itemView.findViewById(R.id.parent_layout);

        }
    }
}
