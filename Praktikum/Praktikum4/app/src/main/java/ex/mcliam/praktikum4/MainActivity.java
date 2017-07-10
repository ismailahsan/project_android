package ex.mcliam.praktikum4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pindah = (Button) findViewById(R.id.pindah);

        pindah.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("pesan", "Dari Aktivity pertama");
                startActivity(i);
            }
        });


    }
}
