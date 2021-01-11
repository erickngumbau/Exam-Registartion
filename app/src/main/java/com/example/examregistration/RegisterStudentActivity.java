package com.example.examregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterStudentActivity extends AppCompatActivity {

    private EditText units,regno;
    private Button savestudentreg;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        units = findViewById(R.id.units);
        regno=findViewById(R.id.regno);
        savestudentreg=findViewById(R.id.savestudentreg);
        db = new DatabaseHelper(RegisterStudentActivity.this);

        savestudentreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String reg =regno.getText().toString().trim();
                String unts =units.getText().toString().trim();

                long value = db.addnewRegistration(reg, unts);
                if(value>0){
                    Toast.makeText(RegisterStudentActivity.this, regno.getText().toString()+" Registered", Toast.LENGTH_SHORT).show();
                    regno.setText("");
                    units.setText("");
                }

            }
        });


    }
}