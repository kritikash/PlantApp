package com.example.plantsapp1;

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

import org.w3c.dom.Text;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mImageName = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();

    private Context  mcontext;

    public RecyclerViewAdapter(ArrayList<String> mImageName, ArrayList<String> Image,  Context context) {
        this.mImageName = mImageName;
        this.mImage = Image;

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
                .load(mImage.get(position))
                .into(holder.image);
         holder.imageName.setText(mImageName.get(position));
         
         holder.parent_layout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Log.d(TAG, "onClick: clicked on: " + mImageName.get(position));
                 Intent intent = new Intent(mcontext, PlantList2.class);
                 intent.putExtra("PLANT_NAME",mImageName.get(position));
                 intent.putExtra("URL",mImage.get(position));

                 intent.putExtra("POS",position);
//                 intent.putExtra("Text",mText.get(position));



                 mcontext.startActivity(intent);
                 Toast.makeText(mcontext, mImageName.get(position), Toast.LENGTH_SHORT).show();

             }
         });


    }

    @Override
    public int getItemCount() {
        return mImageName.size();
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
