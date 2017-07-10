package ex.mcliam.sederhana;

import android.net.nsd.NsdManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ini d kerja setelah buat variabel textview
        textView = (TextView) findViewById(R.id.bertanya);

        //untuk menyambungkan fragmentnya
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        Class_Masuk masuk = new Class_Masuk();
        fragmentTransaction.add(R.id.frag_container,masuk);
        fragmentTransaction.commit();

        //lajut yg textview
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Class_BuatAkun buat_akun = new Class_BuatAkun();
                fragmentTransaction.replace(R.id.frag_container,buat_akun);
                fragmentTransaction.commit();
            }
        });
    }
}
