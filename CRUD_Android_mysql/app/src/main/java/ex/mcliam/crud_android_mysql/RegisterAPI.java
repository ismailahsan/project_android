package ex.mcliam.crud_android_mysql;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by McLiam on 6/1/2017.
 */

public interface RegisterAPI {

    @FormUrlEncoded
    @POST("/insert.php")
    Call<Value>daftar(@Field("nim") String nim,
                      @Field("nama") String nama,
                      @Field("kelas") String kelas,
                      @Field("sesi") String sesi);

    @GET("view.php")
    Call<Value> view();
}
