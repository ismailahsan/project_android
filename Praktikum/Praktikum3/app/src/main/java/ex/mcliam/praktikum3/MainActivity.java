package ex.mcliam.praktikum3;

import android.app.Activity;
import android.content.DialogInterface;
import android.database.CharArrayBuffer;
import android.net.Uri;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity implements View.OnClickListener {

    Button toast;
    Button keluar;
    Button list;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ini utnuk tampilkan toast
        toast = (Button) findViewById(R.id.toast);
        toast.setOnClickListener(this);

        keluar = (Button) findViewById(R.id.keluar);
        keluar.setOnClickListener(this);

        list = (Button) findViewById(R.id.list);
        list.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


        //list view
    public void onClick(View view) {   //ini toastnya
        //toastnya
        if (view == toast) {
            Toast.makeText(this, "ini toasnya", Toast.LENGTH_SHORT).show();
        }
        //alert dialognya
        else if (view == keluar) {
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
        }else if (view == list){
            final CharSequence[] items = {"Ismail", "Ahsan", "Mas'ud"};
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Nama Lengkapku");
            builder.setItems(items, new  DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int item){
                    Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                }
            }).show();
        }
    }
}