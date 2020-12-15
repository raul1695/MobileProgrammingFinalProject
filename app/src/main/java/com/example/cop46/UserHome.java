package com.example.cop46;
import android.content.Intent;
import android.content.SharedPreferences;
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

import org.w3c.dom.Text;


public class UserHome extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // These two variables are used along the shared preference library in order to store app data locally
    public static final String SEARCH_DATA = "searchData";
    public static final String TEXT = "text";

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

        // This with authentication logic. If the user is null, the user is "guest"
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

    // This function is required as the behavior of the original onBackPressed was unsatisfactory
    //Overiding this function allows the back press to close instead of returning to the parent activity
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



    // this function deals with the drawer menu logic
    // The intents detail the different activity changes depending the btn clicked
    // click sign_in_menu btn = send user to sign in activity
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
            TextView search_input = findViewById(R.id.search_param);
            String loc = search_input.getText().toString();

            if(loc.isEmpty()) {

                loc = "33175";

            }
            saveSearch(loc);

            Log.i("TAG","Here is the value!" + loc);
            startActivity(i);
        }

    }

    // This function saves onto the memory a variable that can then be accessed by all activities.
    // This feature is important because it will allow me to give each tab of my search result
    // access to the "searched" data term. 
    // with this info each individual tab can perform an api query and re-interpret the data as needed
    public void saveSearch(String s){
        SharedPreferences sharedPreferences = getSharedPreferences(SEARCH_DATA,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT,s);
        editor.apply();
    }


}




