package ex.mcliam.sp_login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText nama = (EditText) findViewById(R.id.nama);
        EditText pin = (EditText) findViewById(R.id.pin);
        Button masuk = (Button) findViewById(R.id.masuk);
        TextView buatakun = (TextView) findViewById(R.id.buatakun);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nama.getText("")){
                    Toast.makeText(this, "masukkan nama !", Toast.LENGTH_LONG);
                }

                if (pin.getText("")){
                    Toast.makeText(this, "masukkan pin !", Toast.LENGTH_LONG);
                }
            }
        });

        buatakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, buat_akun.class));
            }
        });
    }
}
