package ex.mcliam.hitung_persegi;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText sisi;
    Button hitung;
    private Integer nsisi, hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.sisi = (EditText) findViewById(R.id.sisi);
        hitung = (Button) findViewById(R.id.tombol);
        hitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nsisi = Integer.valueOf(sisi.getText().toString());
        hasil = nsisi * nsisi;

        AlertDialog.Builder pesan = new AlertDialog.Builder(this);
        pesan.setTitle("Luas Persegi");
        pesan.setMessage(Integer.toString(hasil)).show();
    }
}
