package com.example.cop46;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity
{

    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OnClick(View button_view)
    {

        if( button_view.getId() == R.id.sign_button )
    {
        Intent i = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(i);
    }

        if( button_view.getId() == R.id.guest_button )
        {
            Intent i = new Intent(MainActivity.this, UserHome.class);
            startActivity(i);
        }
    }









}