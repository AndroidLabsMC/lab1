package com.AndroidLabsMC.lab1.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListViewActivity extends AppCompatActivity {
    private ArrayList<String> toDelete;
    private ArrayAdapter<String> adapter;
    private ArrayList things;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toDelete = new ArrayList<>();
        things = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.list_of_stuff)));
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, things);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);






        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new  AbsListView.MultiChoiceModeListener() {




            @Override
            public void onItemCheckedStateChanged(android.view.ActionMode mode, int position, long id, boolean checked) {
                if (checked) {
                    toDelete.add(adapter.getItem(position));
                } else {
                    toDelete.remove(adapter.getItem(position));
                }
            }

            @Override
            public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
                MenuInflater menuInflater = getMenuInflater();
                menuInflater.inflate(R.menu.menu_context, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_delete:
                        for (String item2 : toDelete) {
                            things.remove(item2);
                        }
                        mode.finish();
                        return true;
                    default:
                        return false;
                }
            }



            @Override
            public void onDestroyActionMode(android.view.ActionMode mode) {
                toDelete.clear();

            }


        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Long press the "+ itemValue+" for context menu", Toast.LENGTH_LONG)
                        .show();

            }
        });

    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_refresh:
                Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
                things.clear();
                things.addAll(Arrays.asList(getResources().getStringArray(R.array.list_of_stuff)));
                adapter.notifyDataSetChanged();
                break;
            case R.id.action_expandable:
                startActivity(new Intent(this, ExpandableListViewActivity.class));

                break;
            case R.id.action_settings:
                startActivity(new Intent(this, Settings.class));
                break;
            default:


        }
        return super.onOptionsItemSelected(item);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }








}