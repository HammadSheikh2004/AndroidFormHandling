package com.example.formhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView signup;
    Button registerButton;
    EditText registername,registeremail,registerpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        signup = findViewById(R.id.signup);
        registername = findViewById(R.id.registerName);
        registeremail = findViewById(R.id.registerEmail);
        registerpassword = findViewById(R.id.registerPassword);
        registerButton = findViewById(R.id.registerButton);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signin = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(signin);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRegister();
            }
        });
    }

    public void onRegister(){
        String name = registername.getText().toString().trim();
        String email = registeremail.getText().toString().trim();
        String password = registerpassword.getText().toString().trim();
        boolean checkName=false,checkEmail=false,checkPassword=false;

        if(name.equals("")){
            registername.setError("Name must be Required!");
            checkName = false;
        }else{
            registername.setError(null);
            checkName = true;
        }
        if(email.equals("")){
            registeremail.setError("Email must be Required!");
            checkEmail = false;
        }else{
            registeremail.setError(null);
            checkEmail = true;
        }
        if(password.equals("")){
            registerpassword.setError("Password must be Required!");
        } else if(password.length()<8) {
            registerpassword.setError("Password must be 8 character or Above!");
            checkPassword = false;
        }else{
            registerpassword.setError(null);
            checkPassword = true;
        }

        if((checkName && checkEmail && checkPassword)==true){
            Toast.makeText(this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
            registername.setText("");
            registeremail.setText("");
            registerpassword.setText("");
        }
    }
}
