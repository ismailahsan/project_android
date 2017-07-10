package ex.mcliam.praktikum5;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String namaku, emailku, passwordku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("state_email", emailku);
        savedInstanceState.putString("state_nama", namaku);
        savedInstanceState.putString("state_pass", passwordku);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        emailku = savedInstanceState.getString("state_email");
        namaku = savedInstanceState.getString("state_nama");
        passwordku = savedInstanceState.getString("state_pass");
        super.onRestoreInstanceState(savedInstanceState);
    }

    public void klikSimpan (View v){
        emailku = "ismailahsan10@gmail.com";
        namaku = "Ismail Ahsan Mas'ud";
        passwordku = "abcde12345";
    }

    public void klikTampil (View v){
        EditText username = (EditText) findViewById(R.id.username);
        EditText email = (EditText) findViewById(R.id.email);
        EditText password = (EditText) findViewById(R.id.password);

        username.setText(namaku);
        email.setText(emailku);
        password.setText(passwordku);
    }

}
