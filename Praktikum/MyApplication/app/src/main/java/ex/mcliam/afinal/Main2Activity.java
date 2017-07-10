package ex.mcliam.afinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    MenuItem keluar;
    Button login;
    EditText nama;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        SharedPreferences sp = getSharedPreferences("dataku", MODE_PRIVATE);

        //ambil data, bisa d class yang berbeda
        String namanya = sp.getString("nama","");
        final String pasword = sp.getString("password", "");

        nama = (EditText) findViewById(R.id.nama);
        pass = (EditText) findViewById(R.id.pass);

        login = (Button) findViewById(R.id.masuk);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nama.setText(namanya);
                pass.setText(pasword);
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });

        keluar = (MenuItem)findViewById(R.id.exit);
        keluar.setOnMenuItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public void onClick(View view) {   //ini toastnya
       if (view == keluar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Mauki keluar ?");
            builder.setMessage("Apakah nada inign keluar? ? ")
                    .setCancelable(false)
                    .setPositiveButton("Ya",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    MainActivity.this.finish();
                                }
                            })
                    .setNegativeButton("Tidak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            }).show();
        }
    }
}
