package ex.mcliam.laporan3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView username = (TextView) findViewById(R.id.output);

        Intent i = this.getIntent();
        username.setText(i.getStringExtra("pesan"));
    }
}
