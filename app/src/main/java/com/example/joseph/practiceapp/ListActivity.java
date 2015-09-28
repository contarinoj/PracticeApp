package com.example.joseph.practiceapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private RecyclerView recycler;

    public static void start(Context context){
        Intent i = new Intent(context, ListActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recycler = (RecyclerView) findViewById(R.id.recycler_view);
        List<Object> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");
        list.add("Bye");
        list.add("What");
        list.add("John");
        list.add("Lennon");
        list.add(new Integer(2));
        list.add("Working");
        list.add("as");
        list.add("intended");
        list.add(new Boolean(true));
        list.add("Should");
        list.add("be");
        list.add(new Double(2.2));
        list.add("long");
        list.add("enough");
        list.add("Nope");
        list.add("Hello");
        list.add("World");
        list.add("Bye");
        list.add("What");
        list.add("John");
        list.add("Lennon");
        list.add(new Integer(2));
        list.add("Working");
        list.add("as");
        list.add("intended");
        list.add(new Boolean(true));
        list.add("Should");
        list.add("be");
        list.add(new Double(2.2));
        list.add("long");
        list.add("enough");
        list.add("Hello");
        list.add("World");
        list.add("Bye");
        list.add("What");
        list.add("John");
        list.add("Lennon");
        list.add(new Integer(2));
        list.add("Working");
        list.add("as");
        list.add("intended");
        list.add(new Boolean(true));
        list.add("Should");
        list.add("be");
        list.add(new Double(2.2));
        list.add("long");
        list.add("enough");
        list.add("That'll do it");

        ListAdapter adapter = new ListAdapter(this,list);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
