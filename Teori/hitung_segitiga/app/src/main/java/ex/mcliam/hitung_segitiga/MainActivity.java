package ex.mcliam.hitung_segitiga;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    EditText alas;
    EditText tinggi;
    Button hitung;
    private Double ntinggi, nalas, hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tinggi = (EditText) findViewById(R.id.tinggi);
        this.alas = (EditText) findViewById(R.id.alas);
        hitung = (Button) findViewById(R.id.tombol);
        hitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nalas = Double.valueOf(alas.getText().toString());
        ntinggi = Double.valueOf(tinggi.getText().toString());
        hasil = 0.5 * nalas * ntinggi;

        AlertDialog.Builder pesan = new AlertDialog.Builder(this);
        pesan.setTitle("Luas Segitiga");
        pesan.setMessage(Double.toString(hasil)).show();
    }
}
