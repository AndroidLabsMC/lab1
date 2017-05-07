package com.example.paul.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ListView listView;
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           //Creating the instance of PopupMenu
                                           PopupMenu popup = new PopupMenu(MainActivity.this, button1);
                                           //Inflating the Popup using xml file
                                           popup.getMenuInflater()
                                                   .inflate(R.menu.popup, popup.getMenu());

                                           //registering popup with OnMenuItemClickListener
                                           popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                               public boolean onMenuItemClick(MenuItem item) {
                                                   Toast.makeText(
                                                           MainActivity.this,
                                                           "You Clicked : " + item.getTitle(),
                                                           Toast.LENGTH_SHORT
                                                   ).show();
                                                   return true;
                                               }
                                           });

                                           popup.show(); //showing popup menu
                                       }
                                   });
        String[] values = new String[] { "Item 1",
                "Item 2",
                "Item 3",
                "Item 4",
        };
        listView = (ListView) findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        // Assign adapter to ListView
        listView.setAdapter(adapter);
        registerForContextMenu(listView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.second:
                Intent intent=new Intent(this,SecondPage.class);
                startActivity(intent);
                return true;
            case R.id.third:
                Intent intent2=new Intent(this,ThirdPage.class);
                startActivity(intent2);
                return true;
            case R.id.fourth:
                Intent intent3=new Intent(this,FourthPage.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }



    @Override
    public void onCreateContextMenu(ContextMenu
                                            menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v,
                menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context,
                menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.fifth:
                Intent intent = new Intent(this, FifthPage.class);
                startActivity(intent);
                return true;

            default:
                return super.onContextItemSelected(item);


        }
    }


}