package com.example.project_b_open_day_application;

import android.content.Intent;
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.sharebutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareintent = new Intent();
                shareintent.setAction(Intent.ACTION_SEND);
                shareintent.putExtra(Intent.EXTRA_SUBJECT, "Kijk naar deze open dag!");
                shareintent.setType("text/plain");
                shareintent.putExtra(Intent.EXTRA_TEXT, "Ik heb een CMI open dag gevonden op Hogeschool Rotterdam" +
                        " \nHet bevindt zich op 30 februari 2019 van 10:00 tot 16:00");
                ////shareintent.putExtra(android.intent.extra.STREAM, message); to add attachments
                if (shareintent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(shareintent, "Choose your sharing platform"));
                }
            }
        });

        FloatingActionButton fad = (FloatingActionButton) findViewById(R.id.calendarbutton);
        fad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2019, 3, 24, 11, 00);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2019, 3, 24, 16, 30);
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.Events.TITLE, "Open day CMI HR");
                calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");
                String titleCalenderIntent = "Choose your prefered calendar";
                Intent calendarIntentwithChooser = Intent.createChooser(calendarIntent, titleCalenderIntent);
                if (calendarIntentwithChooser.resolveActivity(getPackageManager()) != null) {
                    startActivity(calendarIntentwithChooser);
                }
            }
        });

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
