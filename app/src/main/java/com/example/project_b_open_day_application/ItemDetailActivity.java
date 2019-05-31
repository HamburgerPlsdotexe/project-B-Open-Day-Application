package com.example.project_b_open_day_application;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.example.project_b_open_day_application.Courses.CommunicatieActivity;
import com.example.project_b_open_day_application.Courses.InformaticaActivity;
import com.example.project_b_open_day_application.Courses.TechnischeinformaticaActivity;

import java.util.Calendar;

public class ItemDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            String DesiredFragment = getIntent().getStringExtra("DesiredFragment");
            Fragment fragment = null;
            switch (DesiredFragment) {
                case "communicatie":
                    fragment = new CommunicatieActivity();
                    break;
                case "communicatieNmediaDesign":
                    fragment = new CommunicatieNmediaDesign();
                    break;
                case "creativeMediaNGameTechnology":
                    fragment = new CreativeMediaAndGameTechnologies();
                    break;
                case "informatica":
                    fragment = new InformaticaActivity();
                    break;
                case "technischeInformatica":
                    fragment = new TechnischeinformaticaActivity();
                    break;
                case "April":
                    fragment = new AprilFragment();
                    break;
                case "Mei":
                    fragment = new MeiFragment();
                    break;
            }
            if (fragment != null) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.item_detail_container, fragment);
                ft.commit();
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, com.example.project_b_open_day_application.ItemDetailActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
