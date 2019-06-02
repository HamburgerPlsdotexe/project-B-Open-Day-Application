package com.example.project_b_open_day_application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StartPageActivity extends Fragment {


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_start_page, container, false);

            final TextView textview = view.findViewById(R.id.date_apr);
            textview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ItemDetailActivity.class);
                    startActivity(intent);
                }
            });
            return view;
        }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(R.string.nav_StartScreen);
    }

    public void onClick(View v){
        Intent intent; /*
        switch(v.getId()){
            case R.id.nav_Courses:
                fragment = new CoursesActivity();
                break;

            case R.id.date_mei:
                Context context = View.getContext();
                Intent intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "Mei");
                context.startActivity(intent);
                break;

            case R.id.date_apr:
                context = View.getContext();
                intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "April");
                context.startActivity(intent);
                break;

        }
        startActivity(intent); */
    }
}