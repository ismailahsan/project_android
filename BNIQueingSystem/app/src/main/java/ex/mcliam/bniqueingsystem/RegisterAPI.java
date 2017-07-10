package ex.mcliam.bniqueingsystem;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by McLiam on 5/20/2017.
 */

public interface RegisterAPI {
    @FormUrlEncoded
    @POST("/view.php")
    Call<Value> daftar(@Field("cabang") String cabang
                       );
}
