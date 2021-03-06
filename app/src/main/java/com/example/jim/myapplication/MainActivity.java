package com.example.jim.myapplication;

import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import static java.lang.Thread.sleep;


public class MainActivity extends ActionBarActivity {

    ImageView imgSnake1, imgSnake2, imgSnake3;
    EditText txtDegrees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgSnake1 = (ImageView) findViewById(R.id.imgSnake1);
        imgSnake2 = (ImageView) findViewById(R.id.imgSnake2);
        imgSnake3 = (ImageView) findViewById(R.id.imgSnake3);
        txtDegrees = (EditText) findViewById(R.id.txtDegrees);

        imgSnake2.setOnTouchListener(mSnakeTouchListener);
        imgSnake3.setOnTouchListener(mSnakeTouchListener);

    }

    View.OnTouchListener mSnakeTouchListener = new View.OnTouchListener()  {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (v.getId() == R.id.imgSnake2)
                toggleAlpha(v);
            else
                shakeImage(v);

            return true;
        }
    };

    private void shakeImage(View v) {
        float d = Float.parseFloat(txtDegrees.getText().toString());
        v.animate().setDuration(1000).rotationBy(d);
    }

    private void toggleAlpha(View v) {

        if (v.getAlpha() == .5)
            v.setAlpha((float) 1);
        else
            v.setAlpha((float) .5);
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

    public void shakeSnake(View v) {
        imgSnake1.setAlpha(20);
        imgSnake1.getDrawable().invalidateSelf();
    }

    public void restoreSnake(View v) {
        imgSnake1.setAlpha(255);
        imgSnake1.getDrawable().invalidateSelf();
        imgSnake2.setAlpha(255);
        imgSnake3.animate().rotation(0);
    }
}
