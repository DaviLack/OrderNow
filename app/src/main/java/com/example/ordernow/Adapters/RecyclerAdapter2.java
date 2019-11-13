package com.example.ordernow.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordernow.Carrinho.Carrinho;
import com.example.ordernow.Carrinho.Order;
import com.example.ordernow.Database.Database;
import com.example.ordernow.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder> {

    private static final String TAG = "RecyclerAdapter2";

    private Context mContext;
    private ArrayList<Restaurants> restList;



    public RecyclerAdapter2 (Context context, ArrayList<Restaurants> restList){
        this.mContext = context;
        this.restList = restList;

    }

    @NonNull
    @Override
    public RecyclerAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_item2, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.especialidade.setText(restList.get(position).getEspecialidade());
        holder.nomer.setText(restList.get(position).getNomer());
        holder.nota.setText(restList.get(position).getNota());

        holder.nomer2 = restList.get(position).getNomer();
        holder.nota2 = restList.get(position).getNota();


        Picasso.get().load(restList.get(position).getImgrest()).into(holder.imageView2);

    }

    @Override
    public int getItemCount() {
        return restList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView2;
        TextView especialidade;
        TextView nomer;
        TextView nota;
        String nomer2, nota2;

        public ViewHolder(View itemView){

            super(itemView);

            imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
            especialidade = (TextView) itemView.findViewById(R.id.especialidade);
            nomer = (TextView) itemView.findViewById(R.id.nomer);
            nota = (TextView) itemView.findViewById(R.id.nota);

        }


    }




}









