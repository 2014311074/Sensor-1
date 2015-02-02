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
public class Light extends Activity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mLight;
    TextView text;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        mSensorManager = (SensorManager)getSystemService((SENSOR_SERVICE));
        mLight=mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        text = (TextView)findViewById(R.id.textView2);
    }

    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener(this,mLight,SensorManager.SENSOR_DELAY_UI);
    }

    protected void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_LIGHT){
            text.setText("조도센서값\n\n빛의밝기: "+event.values[0]+"LUX");
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
