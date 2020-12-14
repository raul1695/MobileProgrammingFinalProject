package com.example.cop46;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class ListFragment extends Fragment {

    private String query_location;

    private Context context;
    private RecyclerView recyclerView;
    private GymAdapter gymAdapter;

    private ArrayList<Gym> gymList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        loadData();
        Log.i("TAG","Here is the valuerisssssno!!" + query_location);
        return inflater.inflate(R.layout.list_layout,container,false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.context = getContext();
        recyclerView = view.findViewById(R.id.gym_Recycler);
        populateData();
        gymAdapter = new GymAdapter(context, gymList);
        recyclerView.setAdapter(gymAdapter);

    }

    public void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(UserHome.SEARCH_DATA,MODE_PRIVATE);
        query_location = sharedPreferences.getString(UserHome.TEXT, "nada");
    }

    private void populateData() {
        gymList.add(new Gym("image_1", "Android"));
        gymList.add(new Gym("imageee_1", "ffffsssdsfsf"));
        gymList.add(new Gym("i4355ma55ge_1", "An8765421droid1111"));


    }
}
