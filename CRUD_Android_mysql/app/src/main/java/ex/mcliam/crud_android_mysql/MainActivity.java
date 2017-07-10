package ex.mcliam.crud_android_mysql;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.measureAllChildren;
import static android.R.attr.mediaRouteButtonStyle;
import static android.R.attr.onClick;
import static android.R.attr.progress;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "http:/mcliam.000webhostapp.com/";
    private RadioButton radioButton;
    private ProgressDialog progressDialog;

    @BindView(R.id.radioSesi) RadioGroup radioGroup;
    @BindView(R.id.editTextNIM) EditText edtNim;
    @BindView(R.id.editTextNama) EditText edtNama;
    @BindView(R.id.editTextKelas) EditText edtKelas;

    @OnClick(R.id.btnDaftar) void daftar(){
        //membuat progress dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Memuat Data ....");
        progressDialog.show();

        //mengabil data data edittext
        String nim = edtNim.getText().toString();
        String nama = edtNama.getText().toString();
        String kelas = edtKelas.getText().toString();

        //mengambil data dari radioGrup
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        String sesi = radioButton.getText().toString();

        //parsing data
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RegisterAPI api = retrofit.create(RegisterAPI.class);
        Call<Value> call = api.daftar(nim, nama, kelas, sesi);
        call.enqueue(new Callback<Value>() {
            @Override
            public void onResponse(Call<Value> call, Response<Value> response) {
                String value = response.body().getValue();
                String message = response.body().getMessage();
                progressDialog.dismiss();
                if (value.equals("1")){
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Value> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Jaringan Error!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnView) void lihat() {
        startActivity(new Intent(MainActivity.this, lihat_data.class));
    }
}
