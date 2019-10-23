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

        holder.nome2 = imageList.get(position).getNome();
        holder.preco2 = imageList.get(position).getPreco();
        

        Picasso.get().load(imageList.get(position).getUrl()).into(holder.imageView);

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
        ImageButton addToCart;
        String nome2, preco2;

        public ViewHolder(View itemView){

            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            description = (TextView) itemView.findViewById(R.id.description);
            nome = (TextView) itemView.findViewById(R.id.nome);
            preco = (TextView) itemView.findViewById(R.id.preco);
            addToCart = (ImageButton) itemView.findViewById(R.id.add);


            addToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new Database(mContext).addToCart(new Order(
                            "ID",
                            nome2,
                            "1",
                            preco2,
                            "0"));


                    Toast.makeText(mContext, "Adicionado ao carrinho", Toast.LENGTH_SHORT).show();
                }
            });



    

        }
            
                
    }




}









