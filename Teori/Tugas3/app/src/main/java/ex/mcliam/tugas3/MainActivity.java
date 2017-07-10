package ex.mcliam.tugas3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button pertama, kedua, ketiga, facebook, menelfon, kamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertama = (Button) findViewById(R.id.pertama); // menghubungkan variabel dengan id
        pertama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, luas.class); // intent eksplisit
                startActivity(i);
            }
        });

        kedua = (Button) findViewById(R.id.kedua);
        kedua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainActivity.this, konversi.class); //intent eksplisit
                startActivity(j);
            }
        });

        ketiga = (Button) findViewById(R.id.ketiga); // hubungkan variabel dengan id
        ketiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainActivity.this, nama.class); //intent eksplisit
                startActivity(k);
            }
        });

        facebook = (Button) findViewById(R.id.fb); // menghubungkan variabel dengan id
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri urlfb = Uri.parse("http://www.facebook.com"); //data
                Intent fb = new Intent(Intent.ACTION_VIEW, urlfb); //intent implisit
                startActivity(fb);
            }
        });

        menelfon = (Button) findViewById(R.id.telfon); // menghubungkan variabel dengan id
        menelfon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri nomorhp = Uri.parse("tel:089601604926"); //data
                Intent menelfon = new Intent(Intent.ACTION_CALL, nomorhp); //intent implisit
                startActivity(menelfon);
            }
        });

        kamera = (Button) findViewById(R.id.kamera); // menghubungkan variabel dengan id
        kamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent selfie = new Intent("android.media.action.IMAGE_CAPTURE"); //intent implisit
                startActivity(selfie);
            }
        });
    }
}
