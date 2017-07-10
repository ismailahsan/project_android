package ex.mcliam.antrianq;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by McLiam on 11/20/2016.
 */

public class BuatAkun extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buat_akun);

        Intent i = this.getIntent();

    }
}
