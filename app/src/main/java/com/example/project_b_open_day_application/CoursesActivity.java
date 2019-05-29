package com.example.project_b_open_day_application;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class CoursesActivity extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_courses, container, false);

        CardView commCard = rootView.findViewById(R.id.feb_card);
        CardView commMedCard = rootView.findViewById(R.id.comm_media_card);
        CardView commMedGamCard = rootView.findViewById(R.id.crea_med_gam_des_card);
        CardView infCard = rootView.findViewById(R.id.inf_card);
        CardView tinfCard = rootView.findViewById(R.id.tinf_card);

        commCard.setOnClickListener(this);
        commMedCard.setOnClickListener(this);
        commMedGamCard.setOnClickListener(this);
        infCard.setOnClickListener(this);
        tinfCard.setOnClickListener(this);

        return rootView;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.feb_card:
                Context context = view.getContext();
                Intent intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "communicatie");
                context.startActivity(intent);
                break;

            case R.id.comm_media_card:
                context = view.getContext();
                intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "communicatieNmediaDesign");
                context.startActivity(intent);
                break;

            case R.id.crea_med_gam_des_card:
                context = view.getContext();
                intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "creativeMediaNGameTechnology");
                context.startActivity(intent);
                break;

            case R.id.inf_card:
                context = view.getContext();
                intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "informatica");
                context.startActivity(intent);
                break;

            case R.id.tinf_card:
                context = view.getContext();
                intent = new Intent(context, com.example.project_b_open_day_application.ItemDetailActivity.class);
                intent.putExtra("DesiredFragment", "technischeInformatica");
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
