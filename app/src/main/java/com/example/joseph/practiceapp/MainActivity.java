package com.example.joseph.practiceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    private Button buttonLeft;
    private Button buttonRight;

    @Override
    public void onClick(View v)
    {

        try {
            int i = Integer.parseInt(textView.getText().toString());
            switch(v.getId()){
                case R.id.up_button:
                    textView.setText(""+(i+1));
                    break;
                case R.id.down_button:
                    textView.setText(""+(i-1));
                    break;
                default:

            }
        }
        catch (IllegalArgumentException e)
        {
            textView.setText("I Broke :(");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.not_button);
        buttonRight = (Button) findViewById(R.id.up_button);
        buttonLeft = (Button) findViewById(R.id.down_button);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        buttonRight.setOnClickListener(this);
        buttonLeft.setOnClickListener(this);

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

        return super.onOptionsItemSelected(item);
    }
}
