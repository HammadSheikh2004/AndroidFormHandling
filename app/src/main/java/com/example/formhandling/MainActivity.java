package com.example.formhandling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextEmail,editTextPassword;
    Button signInButton;

    Button RegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        signInButton = findViewById(R.id.signInButton);
        RegisterButton = findViewById(R.id.Register);

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerActivity = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(registerActivity);
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();
            };
        });
    };
    public void SignIn(){
      String email = editTextEmail.getText().toString().trim();
      String password = editTextPassword.getText().toString().trim();
      boolean checkEmail = false, checkPassword = false;

      if (email.equals("")){
          editTextEmail.setError("Email must be Required!");
          checkEmail = false;
      }else{
          editTextEmail.setError(null);
          checkEmail = true;
      }

        if (password.equals("")){
            editTextPassword.setError("Password must be Required!");
        }else if(password.length()<8){
            editTextPassword.setError("Password must be 8 Character or Above!");
            checkPassword = false;
        }else{
            editTextPassword.setError(null);
            checkPassword = true;
        }

        if ((checkEmail && checkPassword) == true){
            Toast.makeText(this, "SignIn SuccessFully.", Toast.LENGTH_SHORT).show();
            editTextEmail.setText("");
            editTextPassword.setText("");
        }

    };
};