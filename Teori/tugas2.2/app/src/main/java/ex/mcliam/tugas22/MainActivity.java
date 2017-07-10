package ex.mcliam.tugas22;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText rupiah;
    TextView won;
    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rupiah = (EditText) this.findViewById(R.id.rupiah);
        won = (TextView) this.findViewById(R.id.Won);
        convert = (Button) this.findViewById(R.id.hitung);
        convert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        double val = Double.parseDouble(rupiah.getText().toString());
        won.setText(Double.toString(val * 0.0876));
    }
}
