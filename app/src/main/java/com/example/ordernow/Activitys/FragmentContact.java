package com.example.ordernow.Activitys;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordernow.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import static com.example.ordernow.Activitys.Cardapio.QrMenu;

public class FragmentContact extends Fragment {

    ImageButton btn_add;

    View v ;
    private DatabaseReference reference;
    private StorageReference mStorageRef;


    private RecyclerView recyclerView;

    private ArrayList<Images> imageList;
    private RecyclerAdapter recyclerAdapter;

    public FragmentContact() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.contact_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.contact_recyclerview);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        reference = FirebaseDatabase.getInstance().getReference();

        mStorageRef = FirebaseStorage.getInstance().getReference();

        imageList = new ArrayList<>();

        init();

        return v;
    }


    private void init() {

        clearAll();

        Query query = reference.child("Images");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    if(snapshot.child("QrMenu").getValue().toString().equals(QrMenu)) {

                        Images images = new Images();

                        images.setUrl(snapshot.child("url").getValue().toString());
                        images.setDescription(snapshot.child("description").getValue().toString());
                        images.setNome(snapshot.child("nome").getValue().toString());
                        images.setPreco(snapshot.child("preco").getValue().toString());

                        imageList.add(images);
                    }

                }

                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getContext(), imageList);

                recyclerView.setAdapter(recyclerAdapter);
                recyclerAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void clearAll(){

        if(imageList != null){

            imageList.clear();

            if(recyclerAdapter != null){

                recyclerAdapter.notifyDataSetChanged();

            }

        }

        imageList = new ArrayList<>();

    }
}

