package ex.mcliam.bni_qs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pilih_Lokasi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_lokasi);

    }

    public void lihat(View view) {
        Intent intent = new Intent (getApplicationContext(), Menu_Antrian.class);
        startActivity(intent);
    }
}
