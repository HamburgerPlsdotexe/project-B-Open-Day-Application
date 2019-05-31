package com.example.project_b_open_day_application;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project_b_open_day_application.R;

import java.util.Calendar;
import java.util.Objects;


public class AprilFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_april, container, false);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.sharebutton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareintent = new Intent();
                shareintent.setAction(Intent.ACTION_SEND);
                shareintent.putExtra(Intent.EXTRA_SUBJECT, getContext().getString(R.string.share_message_header));
                shareintent.setType("text/plain");
                shareintent.putExtra(Intent.EXTRA_TEXT, getContext().getString(R.string.share_message_april));
                ////shareintent.putExtra(android.intent.extra.STREAM, message); to add attachments
                if (shareintent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(Intent.createChooser(shareintent, getContext().getString(R.string.select_social_media_platform_message)));
                }
            }
        });

        FloatingActionButton fad = (FloatingActionButton) v.findViewById(R.id.calendarbutton);
        fad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2019, 4, 1, 10, 00);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2019, 4, 1, 14, 00);
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
                calendarIntent.putExtra(CalendarContract.Events.TITLE, getContext().getString(R.string.calendar_event_title));
                calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Wijnhaven 107 3011 WN Rotterdam");
                String titleCalenderIntent = getContext().getString(R.string.select_calendar_message);
                Intent calendarIntentwithChooser = Intent.createChooser(calendarIntent, titleCalenderIntent);
                if (calendarIntentwithChooser.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(calendarIntentwithChooser);
                }
            }
        });

        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("1 april");
    }

}