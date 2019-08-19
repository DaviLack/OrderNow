package com.example.ordernow.Activitys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordernow.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static final String TAG = "RecyclerAdapter";

    private Context mContext;
    private ArrayList<Images> imageList;

    public RecyclerAdapter (Context context, ArrayList<Images> imageList){
        this.mContext = context;
        this.imageList = imageList;

    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.description.setText(imageList.get(position).getDescription());
        holder.nome.setText(imageList.get(position).getNome());
        holder.preco.setText(imageList.get(position).getPreco());

        Picasso.get().load(imageList.get(position).getUrl())
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView description;
        TextView nome;
        TextView preco;


        public ViewHolder(View itemView){

            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            description = (TextView) itemView.findViewById(R.id.description);
            nome = (TextView) itemView.findViewById(R.id.nome);
            preco = (TextView) itemView.findViewById(R.id.preco);

        }

    }
}
