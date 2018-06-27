package com.example.ben.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mine BAYRAKDAR on 14.11.2017.
 */

public class Register extends Activity implements View.OnClickListener {

    public List<String> list = new ArrayList<String>();


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.register);

        final EditText edtName = (EditText) findViewById(R.id.edtName);
        final EditText edtAge = (EditText) findViewById(R.id.edtAge);
        final EditText edtMailRegister = (EditText) findViewById(R.id.edtMailRegister);
        final EditText edtPasswordRegister = (EditText) findViewById(R.id.edtPasswordRegister);
        Button Registerbtn = (Button) findViewById(R.id.Registerbtn);

        
        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences SP = getSharedPreferences("MYPREFS", MODE_PRIVATE);


                String newMailRegister = edtMailRegister.getText().toString();

                SharedPreferences.Editor editor = SP.edit();
                Set<String> myStrings = SP.getStringSet("myStrings", new HashSet<String>());

// Add the new value.
                myStrings.add(newMailRegister);

// Save the list.
                editor.putStringSet("myStrings", myStrings);
                editor.commit();


                Intent signin = new Intent(Register.this, MainActivity.class);
                startActivity(signin);
            }
        });
    }


    @Override
    public void onClick(View v) {
        // Close current screen - Terminate Activity2
        finish();
    }
}
