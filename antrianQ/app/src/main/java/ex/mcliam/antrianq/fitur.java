package ex.mcliam.antrianq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class fitur extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitur);

        Intent i = this.getIntent();

        Button mulai = (Button) findViewById(R.id.mulai);

        mulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(fitur.this, MenuUtama.class);
                startActivity(i);
            }
        });
    }
}
