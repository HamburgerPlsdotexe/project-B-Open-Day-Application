package com.example.project_b_open_day_application;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class CoursesActivity extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_courses, container, false);

        Button informaticaBtn = (Button) rootView.findViewById(R.id.informaticaOpleiding);
        Button communicatieBtn = (Button) rootView.findViewById(R.id.communicatieOpleiding);
        Button technischeinformaticaBtn = (Button) rootView.findViewById(R.id.technischeinformaticaOpleiding);
        Button cmgtBtn = (Button) rootView.findViewById(R.id.cmgtOpleiding);

        informaticaBtn.setOnClickListener(this);
        communicatieBtn.setOnClickListener(this);
        technischeinformaticaBtn.setOnClickListener(this);
        cmgtBtn.setOnClickListener(this);


        return rootView;
    }
  
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.informaticaOpleiding:
                Context context = view.getContext();
                Intent intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "informatica");
                context.startActivity(intent);
                break;

            case R.id.communicatieOpleiding:
                context = view.getContext();
                intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "communicatie");
                context.startActivity(intent);
                break;

            case R.id.technischeinformaticaOpleiding:
                context = view.getContext();
                intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "TI");
                context.startActivity(intent);
                break;

            case R.id.cmgtOpleiding:
                context = view.getContext();
                intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "CMGT");
                context.startActivity(intent);
                break;


        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("List of Courses");

    }

}
