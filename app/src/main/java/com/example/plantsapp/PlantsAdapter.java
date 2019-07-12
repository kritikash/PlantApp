package com.example.plantsapp;



import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class PlantsAdapter extends FirestoreAdapter<PlantsAdapter.ViewHolder> {
    private static Context context;


    public interface OnPlantsSelectedListener {

            void onPlantsSelected(DocumentSnapshot restaurant);

            void onNavClicked();

            void onDrawerClicked();

//        Intent intent  = Intent(this.PlantsAdapter,PlantList2.class);
//        startActivity(intent);
        }

        private OnPlantsSelectedListener mListener;

        public PlantsAdapter(Context context , Query query, OnPlantsSelectedListener listener) {
            super(query);
            mListener = listener;
            this.context = context;

        }


    @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new ViewHolder(inflater.inflate(R.layout.layout_listitem, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.bind(getSnapshot(position), mListener);
        }



        static class ViewHolder extends RecyclerView.ViewHolder {

            ImageView imageView;
            TextView nameView;
            ImageView circleImageView;


            public ViewHolder(View itemView) {
                super(itemView);

                nameView = itemView.findViewById(R.id.image_name);
                circleImageView = itemView.findViewById(R.id.image);
            }

            public void bind(final DocumentSnapshot snapshot,
                             final OnPlantsSelectedListener listener) {

                Plant plant = snapshot.toObject(Plant.class);

                nameView.setText(plant.getName());

                Glide.with(context)
                        .load(plant.getUrl())
                        .into(circleImageView);

              //  circleImageView.setImageURI(Uri.parse(plant.getUrl()));


                // Click listener
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (listener != null) {
                            listener.onPlantsSelected(snapshot);
                        }

                    }
                });
            }

        }
    }

