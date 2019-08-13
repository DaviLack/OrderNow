package com.example.ordernow.Activitys;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;


    public ViewHolder(View itemView) {
        super(itemView);

        mView = itemView;

    }

    public void setDetails(Context ctx, String title, String description, String image){

        TextView mTitleView = mView.findWiewById(R.id.rTitleTv);
        TextView mDetailTv = mView.findWiewById(R.id.mDetailTv);
        TextView mImageTv = mView.findWiewById(R.id.mImageTv);

        mTitleTv.setText(title);
        mDetailTv.setText(description);
        Picasso.get().load(image).into(mImageTv);

    }

}


