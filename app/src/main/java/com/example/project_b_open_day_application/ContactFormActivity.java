package com.example.project_b_open_day_application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class ContactFormActivity extends Fragment implements View.OnClickListener {

    private Button sendBtn;
    private String subjectString;
    private String nameString;
    private String emailString;
    private String messageString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //returning our layout file
        //change R.layout.yourlayoutfilename for each of your fragments
        View v = inflater.inflate(R.layout.fragment_contact_form, container, false);
        EditText subject = v.findViewById(R.id.Inhoud_onderwerpveld);
        EditText name = v.findViewById(R.id.Inhoud_naamveld);
        EditText email = v.findViewById(R.id.Inhoud_emailveld);
        EditText message = v.findViewById(R.id.Inhoud_berichtveld);
        sendBtn = v.findViewById(R.id.sendmessage);

        this.subjectString = subject.getText().toString();
        this.emailString = email.getText().toString();
        this.messageString = message.getText().toString();
        this.nameString = name.getText().toString();

        sendBtn.setOnClickListener(this);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle(R.string.nav_ContactForm);
    }

    private void sendMail(String subject, String message, String email) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto: service@hr.nl"));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        intent.putExtra(Intent.EXTRA_EMAIL, email);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void onClick(View view){
        this.sendMail(this.subjectString, this.messageString, "service@hr.nl ");
    }

}
