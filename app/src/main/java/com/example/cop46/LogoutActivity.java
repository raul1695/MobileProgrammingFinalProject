package com.example.cop46;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogoutActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        if(user !=null)
        {
            FirebaseAuth.getInstance().signOut();
            Intent i = new Intent(LogoutActivity.this, MainActivity.class);
            startActivity(i);
            //logout
        }
        else {
            Intent i = new Intent(LogoutActivity.this, MainActivity.class);
            startActivity(i);
        }

    }

}