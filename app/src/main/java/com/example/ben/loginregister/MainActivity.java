package com.example.ben.loginregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    EditText Email;
    EditText Password;
    Button btnSign;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email = (EditText)findViewById(R.id.edtMail);
        Password = (EditText)findViewById(R.id.edtPassword);

        btnSign  = (Button)findViewById(R.id.btnSignin);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }   // onClick
        });

        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Register();
            }
        });


    }



    //Local listener receiving callbacks from other activities
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void Login(){
        String mail = Email.getText().toString();

        SharedPreferences SP = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        Set<String> loginmail = SP.getStringSet("myStrings",null);

        SharedPreferences.Editor editor = SP.edit();
        editor.putStringSet("display",loginmail);
        editor.commit();

        if (loginmail.contains(mail)){
            Toast.makeText(this, "Giriş doğrulandı !", Toast.LENGTH_SHORT).show();
            Intent implicit = new Intent(MainActivity.this,ImplicitIntents.class);
            startActivity(implicit);
        }
        else {
            Toast.makeText(this, "You should be registered first!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Register(){
        Intent myIntent = new Intent(MainActivity.this, Register.class);
        startActivityForResult(myIntent, 101);
    }
}
