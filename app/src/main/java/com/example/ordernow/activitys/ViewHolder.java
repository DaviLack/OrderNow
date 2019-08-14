package com.example.ordernow.Activitys;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ordernow.R;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;


    public ViewHolder(View itemView) {
        super(itemView);

        mView = itemView;

    }

    public void setDetails(Context ctx, String title, String description, String image){

        TextView mTitleView = mView.findViewById(R.id.rTitleTv);
        TextView mDetailTv = mView.findViewById(R.id.rDescriptionTv);
        ImageView mImageTv = mView.findViewById(R.id.rImageView);

        mTitleView.setText(title);
        mDetailTv.setText(description);
        Picasso.get().load(image).into(mImageTv);

    }

}


