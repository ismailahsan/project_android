package ex.mcliam.praktikum8;

import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("dataku", MODE_PRIVATE);

        //isi data
        SharedPreferences.Editor ed = sp.edit();
        ed.putString("nama", "ismail ahsan");
        ed.putInt("umur", 20);
        ed.commit();

        //ambil data, bisa d class yang berbeda
        String nama = sp.getString("nama","");
        int umur = sp.getInt("umur", 0);


        String nama = "mail";
        int umur = 20;

        //buat dialog untuk menalpilkan data
        AlertDialog ad = new AlertDialog.Builder(this).create();
        ad.setMessage("Yang jalankan program ini"+nama+" berumur "+umur);
        ad.show();

    }
}