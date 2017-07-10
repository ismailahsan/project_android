package ex.mcliam.mid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView textView = (TextView) findViewById(R.id.output);

        Intent i = this.getIntent();
        textView.setText(i.getStringExtra("pesan"));
    }
}
