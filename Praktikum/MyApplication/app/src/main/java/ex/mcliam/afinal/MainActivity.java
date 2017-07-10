package ex.mcliam.afinal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nama;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sp = getSharedPreferences("dataku", MODE_PRIVATE);

        nama = (EditText) findViewById(R.id.nama);
        pass = (EditText) findViewById(R.id.pass);

        String namanya = nama.getText().toString();
        String password = pass.getText().toString();

        if (namanya.isEmpty()||password.isEmpty()){
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
        } else

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu);
        return  true;
    }
}
