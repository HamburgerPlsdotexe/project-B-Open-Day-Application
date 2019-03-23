package com.example.project_b_open_day_application;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Courses) {
            // Create a new intent to open the {@link NumbersActivity}
            Intent CoursesIntent = new Intent(MainActivity.this, CoursesActivity.class);

            // Start the new activity
            startActivity(CoursesIntent);


        } else if (id == R.id.nav_Dates) {
            Intent DatesIntent = new Intent(MainActivity.this, DatesActivity.class);
            startActivity(DatesIntent);

        } else if (id == R.id.nav_Contact) {
            Intent ContactIntent = new Intent(MainActivity.this, ContactsActivity.class);
            startActivity(ContactIntent);

        } else if (id == R.id.nav_BuildingPlan) {
            Intent BuildPlanIntent = new Intent(MainActivity.this, BuildingPlanActivity.class);
            startActivity(BuildPlanIntent);

        } else if (id == R.id.nav_ContactForm) {
            Intent ContactFormIntent = new Intent(MainActivity.this, CoursesActivity.class);
            startActivity(ContactFormIntent);

        } else if (id == R.id.nav_CourseInformation) {
            Intent CoursesInformationIntent = new Intent(MainActivity.this, CoursesInformationActivity.class);
            startActivity(CoursesInformationIntent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}