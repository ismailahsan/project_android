package ex.mcliam.mid;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button keluar;
    Button login;
    Button toast;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keluar = (Button) findViewById(R.id.exit);
        keluar.setOnClickListener(this);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(this);

        toast = (Button) findViewById(R.id.login);
        toast.setOnClickListener(this);

        username = (EditText) findViewById(R.id.username);

    }

    public void onClick(View view) {


        if (username.getText().toString().equals("admin")){
            if (view == login){
            login.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("pesan", "admin");
                    startActivity(i);
                }
            });
        } }
        else {
            Toast.makeText(this, "username salah", Toast.LENGTH_SHORT).show();
        }

         if (view == keluar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Keluar ?");
            builder.setMessage("Apakah anda inign keluar? ? ")
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
