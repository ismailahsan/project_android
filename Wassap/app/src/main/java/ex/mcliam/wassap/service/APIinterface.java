package ex.mcliam.wassap.service;
import ex.mcliam.wassap.model.City;
import ex.mcliam.wassap.model.Movie;


/**
 * Created by McLiam on 4/3/2017.
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIinterface {

    @GET("api/jadwal-bioskop")
    Call<City> getCity();

    @GET("api/jadwal-bioskop")
    Call<Movie> getMovie(
            @Query("id") String id);

}
