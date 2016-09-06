package com.lishiwei.core.Retrofit;

import com.lishiwei.model.BaseResponseBody;
import com.lishiwei.model.Exhibition;
import com.lishiwei.model.Gallery;
import com.lishiwei.model.News;
import com.squareup.okhttp.ResponseBody;

import org.json.JSONObject;

import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Header;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by lishiwei on 15/12/31.
 */
public interface RetrofitService {

    //    @Multipart
//    @POST("http://175.102.32.178:8080/westbund/app/news/list.do")
//    Call<ResponseBody> upload(
//            @Part("reqJson") RequestBody reqJson,
//
//            @Part("image\";filename=\"spash_skip.png\"") RequestBody file,
//
//            @Part("apikey") RequestBody apikey);

//    @POST("http://192.168.1.179:8080/westbund/app/news/list.do")
//    Observable<BaseResponseBody<News>> getNews(@Body JSONObject jsonObject);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("app/news/list.do")
    Observable<BaseResponseBody<News>> getNews(@Body JSONObject jsonObject);

    @FormUrlEncoded
    @POST("http://192.168.1.179:8080/westbund/app/ex/list.do")
    Observable<BaseResponseBody<Exhibition>> getExhibition(@Body JSONObject jsonObject);

    @FormUrlEncoded
    @POST("http://175.102.32.178:8080/westbund/app/gallery/listSimple.do")
    Observable<BaseResponseBody<Gallery>> getGallery(@Body JSONObject jsonObject);

    @FormUrlEncoded
    @POST("http://175.102.32.178:8080/westbund/app/news/one.do")
    Observable<ResponseBody> getNewsDetail(@Body JSONObject jsonObject);

    @FormUrlEncoded
    @POST("http://175.102.32.178:8080/westbund/app/gallery/list.do")
    Observable<ResponseBody> GetData(@Body JSONObject jsonObject);


}
