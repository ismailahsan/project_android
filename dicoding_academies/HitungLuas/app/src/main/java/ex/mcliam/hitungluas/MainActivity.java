package ex.mcliam.hitungluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPanjang, edtLebar;
    private Button hitung, toast;
    private TextView hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPanjang = (EditText)findViewById(R.id.edt_panjang);
        edtLebar = (EditText)findViewById(R.id.edt_lebar);
        hitung = (Button)findViewById(R.id.btn_hitung);
        toast = (Button)findViewById(R.id.btn_toast);
        hasil = (TextView)findViewById(R.id.txt_hasil);

        hitung.setOnClickListener(this);
        toast.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == hitung){
            if(TextUtils.isEmpty(edtPanjang.getText()) || TextUtils.isEmpty(edtLebar.getText())){

                Toast.makeText(this,"Nilai yang dimasukkan tidak boleh kosong",Toast.LENGTH_SHORT).show();

            }else {
                String panjang = edtPanjang.getText().toString().trim();
                String lebar = edtLebar.getText().toString().trim();

                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);

                double luas = p * l;

                hasil.setText("Luas = "+luas);
            }
        }
    }
}