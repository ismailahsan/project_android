package model;

/**
 * Created by McLiam on 12/26/2016.
 */

import model.Models;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("example/aktor")
    Call<model> loadActor();
}
