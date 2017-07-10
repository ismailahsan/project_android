package models; /**
 * Created by McLiam on 12/26/2016.
 */

import models.Models;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApi {
    @GET("contohjson")
    Call<Models> getDataAdmin();
}
