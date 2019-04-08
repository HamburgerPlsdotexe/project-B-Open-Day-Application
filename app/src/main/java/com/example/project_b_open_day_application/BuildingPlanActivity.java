package com.example.project_b_open_day_application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


import com.github.barteksc.pdfviewer.PDFView;

public class BuildingPlanActivity extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName();
    PDFView pdfView;
    Integer pageNumber = 0;
    String BuildingSelected;
    String FloorSelected;
    String[] arrayBuildings = {"99","103","107"};
    String[] arrayFloors = {"BG","1e","2e","3e","4e","5e"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View fragment_BuildingPlan = inflater.inflate(R.layout.fragment_building_plan, container, false);

        //declaring the fragment Buildingplan in spinnerbuilding.
        // So all ID from this fragment can be found there
        Spinner spinnerBuilding = fragment_BuildingPlan.findViewById(R.id.spinner_building);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterBuilding = ArrayAdapter.createFromResource(this.getActivity(), R.array.buildingArray, android.R.layout.simple_spinner_dropdown_item);
        // Specify the layout to use when the list of choices appears
        adapterBuilding.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //If clicked on item from Building, it gives a id that i use from array
        // that has all the different buildings.
        spinnerBuilding.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                BuildingSelected = arrayBuildings[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Apply the adapter to the spinner
        spinnerBuilding.setAdapter(adapterBuilding);

        Spinner spinnerFloor = fragment_BuildingPlan.findViewById(R.id.spinner_floor);
        ArrayAdapter<CharSequence> adapterFloor = ArrayAdapter.createFromResource(this.getActivity(), R.array.floorArray, android.R.layout.simple_spinner_dropdown_item);
        adapterFloor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFloor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                FloorSelected = arrayFloors[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerFloor.setAdapter(adapterFloor);

        //Find ID of button and set an Onclicklistener to the button
        Button buttonPDF = (Button) fragment_BuildingPlan.findViewById(R.id.button_refreshPDF);
        buttonPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pdfView = (PDFView) getView().findViewById(R.id.pdfView);
                String pdfFile = BuildingSelected + " " + FloorSelected + ".pdf";
                displayFromAsset(pdfFile);
            }
        });
        return fragment_BuildingPlan;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(R.string.nav_BuildingPlan);

    }

    private void displayFromAsset(String assetFileName) {
        pdfView.fromAsset(assetFileName)
                .defaultPage(pageNumber)
                .enableSwipe(false)
                .swipeHorizontal(false)
                .enableAnnotationRendering(true)
//               .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }
}