package ex.mcliam.bniqueingsystem;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.id.progress;
import static com.google.gson.internal.bind.TypeAdapters.URL;

public class MenuUtama extends AppCompatActivity {

    public static final String URL = "192.168.43.249/";
    private RadioButton radioSexButton;
    private ProgressDialog progress;
    Spinner sp;

    @OnClick(R.id.btnMengantri) void daftar() {

//membuat progress dialog
        progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Loading ...");
        progress.show();
        //mengambil data dari edittext
        String cabang = sp.getSelectedItem().toString();




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.daftar(cabang);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progress.dismiss();
                if (value.equals("1")) {
                    Toast.makeText(MenuUtama.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MenuUtama.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progress.dismiss();
                Toast.makeText(MenuUtama.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_utama);

        sp = (Spinner)findViewById(R.id.spinnerCabang);
        Intent intent = getIntent();

    }

}
