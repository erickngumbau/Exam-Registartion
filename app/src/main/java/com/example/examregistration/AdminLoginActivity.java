package com.example.examregistration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText username,password,usernamesignup,passwordsignup;
    private TextView signup,login;
    private Button btnregister;
    private RelativeLayout laylogin,laysignup;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        db= new DatabaseHelper(this);

        laylogin = findViewById(R.id.layoutlogin);
        laysignup = findViewById(R.id.layoutsignup);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        signup=findViewById(R.id.signup);
        login = findViewById(R.id.login);

        usernamesignup =findViewById(R.id.signupusername);
        passwordsignup=findViewById(R.id.signuppass);

        btnregister = findViewById(R.id.signupregister);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                laysignup.setVisibility(View.VISIBLE);
                laylogin.setVisibility(View.INVISIBLE);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String usernm = username.getText().toString().trim();
                String pass=password.getText().toString().trim();

                Boolean res=  db.checkAdmin(usernm,pass);

                if(res==true){
                    Intent intent = new Intent(AdminLoginActivity.this,RegisterStudentActivity.class);
//                    intent.putExtra("username",usernm);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AdminLoginActivity.this, "Incorrect Credentials", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username =usernamesignup.getText().toString().trim();
                String passw =passwordsignup.getText().toString().trim();

                long value = db.addAdmin(username, passw);
                if(value>0){
                    laysignup.setVisibility(View.INVISIBLE);
                    laylogin.setVisibility(View.VISIBLE);
                }
//                else{
//                    Toast.makeText(AdminLoginActivity.this, "Some Error", Toast.LENGTH_SHORT).show();
//                }

            }
        });

    }
}