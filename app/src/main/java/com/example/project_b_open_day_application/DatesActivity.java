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

public class DatesActivity extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_dates, container, false);

        Button febBtn = (Button) rootView.findViewById(R.id.feb14);
        Button aprBtn = (Button) rootView.findViewById(R.id.apr1);

        febBtn.setOnClickListener(this);
        aprBtn.setOnClickListener(this);

        return rootView;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.feb14:
                Context context = view.getContext();
                Intent intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "februari");
                context.startActivity(intent);
                break;

            case R.id.apr1:
                context = view.getContext();
                intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "april");
                context.startActivity(intent);
                break;

        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Dates of open days");
    }
}