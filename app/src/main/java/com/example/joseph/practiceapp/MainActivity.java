package com.example.joseph.practiceapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoadFinished{
    public static final String MAIN_ACTIVITY = "main_activity";
    private TextView textView;
    private TextView mysteryText;
    private Button buttonLeft;
    private Button buttonRight;
    private Button mysteryButton;
    private Button activityButton;
    private Button fragmentButton;

    @Override
    public void onLoadFinished(String str){
            if(!isFinishing())
            {
                mysteryText.setText(str);
            }
    }

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
                case R.id.new_activity_button:
                    ListActivity.start(this);
                    break;
                case R.id.fragment_button:
                    FragmentActivity.start(this);
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
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(String.valueOf(textView.getId()), textView.getText().toString());
        outState.putString(String.valueOf(mysteryText.getId()), mysteryText.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(HeadlessFragment.newInstance(),"fragment_headless").commit();
        textView = (TextView) findViewById(R.id.not_button);
        mysteryText = (TextView) findViewById(R.id.output_text);

        buttonRight = (Button) findViewById(R.id.up_button);
        buttonLeft = (Button) findViewById(R.id.down_button);
        mysteryButton = (Button) findViewById(R.id.mystery_button);
        activityButton = (Button) findViewById(R.id.new_activity_button);
        fragmentButton = (Button) findViewById(R.id.fragment_button);

        mysteryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((HeadlessFragment)getSupportFragmentManager().findFragmentByTag("fragment_headless")).work("d20")) {
                    mysteryText.setText(R.string.default_loading_text);
                    //new LoadingTask(MainActivity.this).execute();
                }
            }
        });

        buttonRight.setOnClickListener(this);
        buttonLeft.setOnClickListener(this);
        activityButton.setOnClickListener(this);
        fragmentButton.setOnClickListener(this);

        if(savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(String.valueOf(textView.getId())));
            mysteryText.setText(savedInstanceState.getString(String.valueOf(mysteryText.getId())));
        }


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
