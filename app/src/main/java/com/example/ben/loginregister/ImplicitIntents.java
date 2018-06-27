package com.example.ben.loginregister;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Mine BAYRAKDAR on 15.11.2017.
 */

public class ImplicitIntents extends AppCompatActivity {

    Button btnOpenWebsite, btnOpenLocation, btnShare;
    EditText edtOpenWebsite, edtOpenLocation, edtShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicitintent);
        setTitle("Implicit Intents");

        /*SharedPreferences SP = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        String display = SP.getString("display","");*/

        btnOpenWebsite = (Button)findViewById(R.id.btnOpenWebSite);
        btnOpenLocation = (Button)findViewById(R.id.btnOpenLocation);
        btnShare = (Button)findViewById(R.id.btnShare);

        edtOpenWebsite = (EditText) findViewById(R.id.edtOpenWebsite);
        edtOpenLocation = (EditText)findViewById(R.id.edtOpenLocation);
        edtShare = (EditText)findViewById(R.id.edtShare);

        btnOpenWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView webView = new WebView(ImplicitIntents.this);
                setContentView(webView);
                String url = edtOpenWebsite.getText().toString();
                webView.loadUrl("http://" + url);
            }
        });

        btnOpenLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = edtOpenLocation.getText().toString();
                Intent map = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?q=" + location));
                startActivity(map);
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, edtShare.getText().toString());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });
    }
}
