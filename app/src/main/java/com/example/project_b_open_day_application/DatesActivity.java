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
import android.support.v7.widget.CardView;
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

        CardView aprCard = rootView.findViewById(R.id.apr_card);
        CardView meiCard = rootView.findViewById(R.id.mei_card);

        aprCard.setOnClickListener(this);
        meiCard.setOnClickListener(this);

        return rootView;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.apr_card:
                Context context = view.getContext();
                Intent intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "April");
                context.startActivity(intent);
                break;

            case R.id.mei_card:
                context = view.getContext();
                intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "Mei");
                context.startActivity(intent);
                break;

        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Datums open dagen");
    }
}