package com.example.jong.myapplication;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;


public class MainActivity extends Activity {
    private ProgressBar progressBar;
    private int progressStatus=0;
    private int progressSecondaryStatus=0;
    private Handler handler = new Handler();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById((R.id.progressBar));


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus <= 10) {
                    if (progressSecondaryStatus <= 10)
                        progressSecondaryStatus = buffering();
                    progressStatus = working();

                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            progressBar.setSecondaryProgress(progressSecondaryStatus);
                        }
                    });

                }//while end
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setVisibility(View.GONE);
                        Intent next = new Intent(getBaseContext(),SubActivity.class);
                        startActivity(next);
                        finish();
                        overridePendingTransition(0,0);

                    }
                });

            }//end run()

            private int buffering() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return progressSecondaryStatus += 2;
            }//end buffering()

            private int working() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return ++progressStatus;
            }//end working()

        }).start();
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
