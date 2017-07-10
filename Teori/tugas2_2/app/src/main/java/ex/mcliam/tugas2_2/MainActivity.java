package ex.mcliam.tugas2_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText rupiah;
    TextView yen;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rupiah = (EditText) this.findViewById(R.id.rupiah);
        yen = (TextView) this.findViewById(R.id.Yen);
        convert = (Button) this.findViewById(R.id.hitung);
        convert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double val = Double.parseDouble(rupiah.getText().toString());
        yen.setText(Double.toString(val * 0.0082));
    }
}
