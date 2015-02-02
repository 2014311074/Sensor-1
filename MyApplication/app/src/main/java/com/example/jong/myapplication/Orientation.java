package com.example.jong.myapplication;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Jong on 2015-02-02.
 */
public class Orientation extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mOrientation;
    TextView text;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        mSensorManager = (SensorManager)getSystemService((SENSOR_SERVICE));
        mOrientation=mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        text = (TextView)findViewById(R.id.textView2);
            }

    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this,mOrientation,SensorManager.SENSOR_DELAY_UI);
    }

    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ORIENTATION){
            text.setText("방향 센서값\n\n방위각: "+event.values[0]+"\n피치:"+event.values[1]+"\n롤:"+event.values[2]);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
