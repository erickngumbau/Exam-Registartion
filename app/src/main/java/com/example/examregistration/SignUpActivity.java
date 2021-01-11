package com.example.examregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private EditText name, reg,password,signupusername,signuppass;
    private TextView unitselect;
    private RelativeLayout layout1;
    private Button signup;
    private Spinner spinner;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signup =findViewById(R.id.signupregister);
        signupusername = findViewById(R.id.signupusername);
        signuppass = findViewById(R.id.signuppass);

        db=new DatabaseHelper(this);
        name=findViewById(R.id.name);
        reg=findViewById(R.id.username);
        password=findViewById(R.id.password);
        unitselect=findViewById(R.id.unitselect);
        spinner=findViewById(R.id.spinner);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username =signupusername.getText().toString().trim();
                String passw =signuppass.getText().toString().trim();

                long value = db.addUser(username, passw);
                if(value>0){
                    Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(SignUpActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}