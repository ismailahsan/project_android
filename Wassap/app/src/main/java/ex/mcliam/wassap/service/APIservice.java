package ex.mcliam.wassap.service;

/**
 * Created by McLiam on 4/3/2017.
 */

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import ex.mcliam.wassap.BuildConfig;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class APIservice {

    private APIinterface apiInterface;

    public APIservice(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(builder())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(APIinterface.class);
    }

    private OkHttpClient builder() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient().newBuilder();
        okHttpClient.connectTimeout(20, TimeUnit.SECONDS);
        okHttpClient.writeTimeout(20, TimeUnit.SECONDS);
        okHttpClient.readTimeout(90, TimeUnit.SECONDS);


        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url()
                        .newBuilder()
                        .addQueryParameter("k", BuildConfig.API_KEY)
                        .build();

                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });

        return okHttpClient.build();
    }

    public void getCityList(Callback callback){
        apiInterface.getCity().enqueue(callback);
    }

    public void getMovieList(String id, Callback callback){
        apiInterface.getMovie(id).enqueue(callback);
    }
}
