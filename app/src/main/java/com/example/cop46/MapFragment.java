package com.example.cop46;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.content.Context.MODE_PRIVATE;


public class MapFragment extends Fragment {

    private String query_location;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        loadData();
        Log.i("TAG","Here is the valuerino!!" + query_location);
        return inflater.inflate(R.layout.mapview_layout,container,false);
    }

    public void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(UserHome.SEARCH_DATA,MODE_PRIVATE);
        query_location = sharedPreferences.getString(UserHome.TEXT, "nada");
    }

}
