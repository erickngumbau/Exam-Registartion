package com.example.examregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    private EditText name,date, reg,password;
    private TextView upload,unitselect;
    private ImageView imageView;
    private RelativeLayout layout1;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name=findViewById(R.id.name);
        date=findViewById(R.id.date);
        reg=findViewById(R.id.username);
        password=findViewById(R.id.password);
        unitselect=findViewById(R.id.unitselect);
        upload=findViewById(R.id.upload);
        imageView=findViewById(R.id.image);

        spinner=findViewById(R.id.spinner);

    }
}