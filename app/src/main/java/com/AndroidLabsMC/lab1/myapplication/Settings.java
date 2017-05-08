package com.AndroidLabsMC.lab1.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity {
    private EditText ed1;
    private Button b1;

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Bamf = "Bamf";


    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        ed1=(EditText)findViewById(R.id.editText);



        b1=(Button)findViewById(R.id.save_button);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b  = ed1.getText().toString();


                SharedPreferences.Editor editor = sharedpreferences.edit();


                editor.putString(Bamf, b);


                editor.apply();
                Toast.makeText(Settings.this,"Thanks for the Bamf", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_back:
                finish();
                break;
            default:


        }
        return super.onOptionsItemSelected(item);

    }

}