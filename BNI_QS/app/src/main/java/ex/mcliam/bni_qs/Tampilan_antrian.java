package ex.mcliam.bni_qs;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Tampilan_antrian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_antrian);
    }

    public void next(View view) {
        Intent intent = new Intent (Tampilan_antrian.this, frag_tiket.class);
        startActivity(intent);
    }
}
