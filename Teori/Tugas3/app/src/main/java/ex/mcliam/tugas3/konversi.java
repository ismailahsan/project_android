package ex.mcliam.tugas3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class konversi extends AppCompatActivity {

    //membuat variabel
    EditText rupiah;
    TextView yen;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi);

        Intent j = this.getIntent(); //menerima intent

        rupiah = (EditText) findViewById(R.id.rupiah); //menghubungkan variabel dgn id
        yen = (TextView) findViewById(R.id.Yen);
        convert = (Button) findViewById(R.id.hitung);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override\
            public void onClick(View v) {
                double val = Double.parseDouble(rupiah.getText().toString()); //mengambil data
                yen.setText(Double.toString(val * 0.0082)); //mencetak
            }
        });
    }
}
