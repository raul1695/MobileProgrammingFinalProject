package com.example.cop46;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UserHome extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        if(user !=null)
        {
            TextView tv1 = (TextView)findViewById(R.id.textView4);
            tv1.setText( user.getDisplayName());
        }


    }

    }




