package com.fdbr.android.base;

import com.fdbr.android.App;
import com.fdbr.android.utils.Constant;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Wandy on 8/16/2016.
 */

/**
 * Created by Wandy on 8/12/2016.
 */
public abstract class BaseNetworkManager implements Interceptor {
    private static Retrofit retrofit;
    //private static Retrofit retrofitToken;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = getHttpClient(getInterceptor());
            retrofit = initiateRetrofit(okHttpClient);
        }
        return retrofit;
    }

    public static Retrofit getRetrofitForToken()
    {
        return initiateRetrofit(getHttpClient(getInterceptorForToken()));
    }

    private static Retrofit initiateRetrofit(OkHttpClient okHttpClient)
    {
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static OkHttpClient getHttpClient(Interceptor interceptor) {

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(interceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
        /*int cacheSize = 10 * 1024 * 1024; // 10 MiB
        Cache cache = new Cache(context.getCacheDir(), cacheSize);
        builder.cache(cache);*/
        return httpClient;
    }

    public static Interceptor getInterceptor()
    {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(getRequest(chain));
            }
        };
        return interceptor;
    }

    public static Interceptor getInterceptorForToken()
    {
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(getRequestForToken(chain));
            }
        };
        return  interceptor;
    }


    private static Request getRequestForToken(Chain chain)
    {
        Request request = chain.request()
                .newBuilder()
                .addHeader("version", Constant.API_VERSION)
                .addHeader("device", Constant.DEVICE_TYPE)
                .addHeader("key", Constant.ANDROID_KEY)
                .build();
        return request;
    }

    private static Request getRequest(Chain chain)
    {
        Request request = chain.request()
                .newBuilder()
                .addHeader("version", Constant.API_VERSION)
                .addHeader("device", Constant.DEVICE_TYPE)
                .addHeader("authorization", App.getInstance().getFromPreference(Constant.ACCESS_TOKEN_PREF))
                .build();
        return request;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        Response response = chain.proceed(request);
        return response;
    }

}
