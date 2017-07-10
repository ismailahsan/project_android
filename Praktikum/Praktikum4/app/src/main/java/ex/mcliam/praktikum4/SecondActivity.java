package ex.mcliam.praktikum4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

/**
 * Created by McLiam on 11/17/2016.
 */

public class SecondActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        TextView kedua = (TextView) findViewById(R.id.kedua);

        //menerima intent yg diberikan
        Intent i = this.getIntent();
        kedua.setText("Activity 2" + i.getStringExtra("pesan"));
    }
 }
