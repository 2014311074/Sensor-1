package com.example.jong.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Jong on 2015-01-27.
 */
public class SubActivity extends Activity implements View.OnClickListener{

    private Button Gravity,Light,Orientation,Information;
    private TextView text;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Gravity = (Button) findViewById(R.id.ButtonGravity);
        Light = (Button) findViewById(R.id.ButtonLight);
        Orientation = (Button) findViewById(R.id.ButtonOrientation);
        Information = (Button) findViewById(R.id.ButtonInformation);
        Gravity.setOnClickListener(this);
        Light.setOnClickListener(this);
        Orientation.setOnClickListener(this);
        Information.setOnClickListener(this);
        text = (TextView) findViewById(R.id.textView2);

    }

    protected void onResume(){
        super.onResume();

    }

    protected void onPause(){
        super.onPause();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ButtonGravity:
                Intent next0 = new Intent(getBaseContext(),Accelator.class);
                startActivity(next0);

                break;
            case R.id.ButtonLight:
                Intent next3 = new Intent(getBaseContext(), com.example.jong.myapplication.Light.class);
                startActivity(next3);

                break;
            case R.id.ButtonOrientation:
                Intent next2 = new Intent(getBaseContext(), com.example.jong.myapplication.Orientation.class);
                startActivity(next2);

                break;
            case R.id.ButtonInformation:
                Intent next1 = new Intent(getBaseContext(), com.example.jong.myapplication.Information.class);
                startActivity(next1);

                break;

        }



    }


}
