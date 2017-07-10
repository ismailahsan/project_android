package ex.mcliam.wassap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.MenuItem;

import ex.mcliam.wassap.adapter.ShowTimeListAdapter;
import ex.mcliam.wassap.model.MovieData;


public class activity_showtime extends AppCompatActivity {

    private RecyclerView rvShowtime;

    private LinearLayoutManager linearLayoutManager;
    private ShowTimeListAdapter showtimeListAdapter;

    private MovieData movieData;
    private String date;

    public static void start(Context context, MovieData movieData, String date) {
        Intent intent = new Intent(context, activity_showtime.class);
        intent.putExtra(activity_showtime.class.getSimpleName() + ".movie", movieData);
        intent.putExtra(activity_showtime.class.getSimpleName() + ".date", date);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showtime);

        movieData = getIntent().getParcelableExtra(activity_showtime.class.getSimpleName() + ".movie");
        date = getIntent().getStringExtra(activity_showtime.class.getSimpleName() + ".date");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml(movieData.getMovie()));
        actionBar.setSubtitle(date);
        actionBar.setDisplayHomeAsUpEnabled(true);

        rvShowtime = (RecyclerView) findViewById(R.id.rv_showtime);

        linearLayoutManager = new LinearLayoutManager(this);
        showtimeListAdapter = new activity_showtime(this);

        rvShowtime.setLayoutManager(linearLayoutManager);
        rvShowtime.setAdapter(showtimeListAdapter);

        showtimeListAdapter.addAll(movieData.getJadwal());
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}