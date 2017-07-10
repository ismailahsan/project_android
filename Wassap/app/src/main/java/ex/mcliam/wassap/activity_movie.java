package ex.mcliam.wassap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.net.SocketTimeoutException;

import ex.mcliam.wassap.adapter.MovieListAdapter;
import ex.mcliam.wassap.listener.RecyclerItemClickListener;
import ex.mcliam.wassap.model.CityData;
import ex.mcliam.wassap.model.Movie;
import ex.mcliam.wassap.service.APIservice;
import ex.mcliam.wassap.util.DividerItemDecoration;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class activity_movie extends AppCompatActivity implements RecyclerItemClickListener {

    private RecyclerView rvMovie;
    private SwipeRefreshLayout swipeRefreshLayout;

    private LinearLayoutManager linearLayoutManager;
    private MovieListAdapter movieListAdapter;

    private APIservice apiService;
    private CityData cityData;
    private Movie movie;

    public static void start(Context context, CityData cityData) {
        Intent intent = new Intent(context, activity_movie.class);
        intent.putExtra(activity_movie.class.getSimpleName(), cityData);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        cityData = getIntent().getParcelableExtra(activity_movie.class.getSimpleName());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(cityData.getKota());
        actionBar.setDisplayHomeAsUpEnabled(true);

        rvMovie = (RecyclerView) findViewById(R.id.rv_movie);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);

        linearLayoutManager = new LinearLayoutManager(this);
        movieListAdapter = new MovieListAdapter(this);
        movieListAdapter.setRecyclerViewItemClickListener(this);

        rvMovie.setLayoutManager(linearLayoutManager);
        rvMovie.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        rvMovie.setAdapter(movieListAdapter);

        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });

        loadData(cityData.getId());
    }

    private void loadData(String id){
        if (swipeRefreshLayout != null)
            swipeRefreshLayout.post(new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(true);
                }
            });


        apiService = new APIservice();
        apiService.getMovieList(id, new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                movie = (Movie) response.body();

                if(movie != null){
                    if(movie.getStatus().equals("success")) {
                        movieListAdapter.addAll(movie.getData());
                    }else{
                        Toast.makeText(activity_movie.this, movie.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    Log.i("STATUS", movie.getStatus());
                }else{
                    Toast.makeText(activity_movie.this, "No Data!", Toast.LENGTH_LONG).show();
                }

                if (swipeRefreshLayout != null)
                    swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                if(t instanceof SocketTimeoutException) {
                    Toast.makeText(activity_movie.this, "Request Timeout. Please try again!", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(activity_movie.this, "Connection Error!", Toast.LENGTH_LONG).show();
                }

                Log.i("FAILURE", t.toString());

                if (swipeRefreshLayout != null)
                    swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void refreshData(){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                movieListAdapter.clear();
                loadData(cityData.getId());
            }
        });
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

    @Override
    public void onItemClick(int position, View view) {
        activity_showtime.start(this, movieListAdapter.getItem(position), movie.getDate());
    }
}