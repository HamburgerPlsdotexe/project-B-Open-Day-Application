package com.example.project_b_open_day_application;

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
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.informaticaOpleiding:
                fragment = new InformaticaActivity();
                replaceFragment(fragment);
                break;

            case R.id.communicatieOpleiding:
                fragment = new CommunicatieActivity();
                replaceFragment(fragment);
                break;

            case R.id.technischeinformaticaOpleiding:
                fragment = new TechnischeinformaticaActivity();
                replaceFragment(fragment);
                break;

            case R.id.cmgtOpleiding:
                fragment = new CmgtActivity();
                replaceFragment(fragment);
                break;


        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}
