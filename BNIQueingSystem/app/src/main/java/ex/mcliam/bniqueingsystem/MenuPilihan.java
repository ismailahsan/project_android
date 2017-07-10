package ex.mcliam.bniqueingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MenuPilihan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pilihan);

    }

    public void infoLayanan (View v){
        Intent intent = new Intent(MenuPilihan.this, InfoLayanan.class);
        MenuPilihan.this.startActivity(intent);

    }

    public void mengantri (View v){
        Intent info = new Intent(MenuPilihan.this, MenuUtama.class);
        MenuPilihan.this.startActivity(info);

    }


}
