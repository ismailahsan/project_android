package ex.mcliam.tugas3;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class luas extends AppCompatActivity implements View.OnClickListener {

    //membuat variabel
    EditText sisi;
    Button hitung;
    private Integer nsisi, hasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luas);

        Intent i = this.getIntent(); //menerima intent

        this.sisi = (EditText) findViewById(R.id.sisi);
        hitung = (Button) findViewById(R.id.luas);
        hitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nsisi = Integer.valueOf(sisi.getText().toString()); //mengambil inputan dari edittext
        hasil = nsisi * nsisi;

        AlertDialog.Builder pesan = new AlertDialog.Builder(this); //menampilkan dialog
        pesan.setTitle("Luas Persegi");
        pesan.setMessage(Integer.toString(hasil)).show();
    }
}