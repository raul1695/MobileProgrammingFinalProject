package com.example.cop46;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.TaskStackBuilder;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UserHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private FirebaseAuth mAuth;
    private FirebaseUser user;
    String Query_Parameter;
    DrawerLayout drawerLayout;
    NavigationView nagivationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();


        drawerLayout = findViewById(R.id.drawer_layout);
        nagivationView = findViewById(R.id.nav_view);
        NavigationView nagivationView_special = (NavigationView) findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar4);

        setSupportActionBar(toolbar);

        nagivationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        nagivationView.setNavigationItemSelectedListener(this);

        if(user !=null)
        {
            //find by id the menu_username_text textview and set it to the user's display name.
            View headerView = nagivationView.getHeaderView(0);
            TextView navUsername = (TextView) (headerView.findViewById(R.id.menu_username_text));
            TextView menu_title_text = (TextView) (headerView.findViewById(R.id.menu_title_text));
            navUsername.setVisibility(headerView.VISIBLE);
            navUsername.setText("Welcome... "+ user.getDisplayName());
            menu_title_text.setText("Main Menu User");

            nagivationView_special.getMenu().findItem(R.id.sign_in_menu).setVisible(false);

        }
        else {
            //hide the menu_username_text

            //hide the avi_menu element
            View headerView = nagivationView.getHeaderView(0);
            TextView navUsername = (TextView) (headerView.findViewById(R.id.menu_username_text));
            navUsername.setVisibility(headerView.VISIBLE);
            navUsername.setText("You are currently a guest...");

            //hide the logout element
            nagivationView_special.getMenu().findItem(R.id.logout_btn_menu).setVisible(false);

            //hide the fav_menu menu element.
            nagivationView_special.getMenu().findItem(R.id.fav_menu).setVisible(false);

            //make visible the menu_guest_text element.
        }


    }

    @Override
    public void onBackPressed()
    {
        if( drawerLayout.isDrawerOpen(GravityCompat.START) )
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.logout_btn_menu:
                Log.i("TAG", "this is the right clause!");
                Intent i = new Intent(UserHome.this, LogoutActivity.class);
                startActivity(i);
                return true;

            case R.id.fav_menu:
                Log.i("TAG", "this is the right clause!");
                Intent e = new Intent(UserHome.this, FavoriteActivity.class);
                startActivity(e);
                return true;

            case R.id.sign_in_menu:
                Log.i("TAG", "this is the right clause!1");
                Intent s = new Intent(UserHome.this, LoginActivity.class);
                startActivity(s);
                return true;

            default:
                return false;
        }

    }


    public void OnClick(View button_view)
    {

        if( button_view.getId() == R.id.search_btn )
        {
            Intent i = new Intent(UserHome.this, SearchActivity.class);
            i.putExtra("QUERY_URL", Query_Parameter);
            startActivity(i);
        }

    }

}




