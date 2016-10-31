package com.lishiwei.core;






import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;

/**
 * Created by shiwei on 2016/9/11.
 */
public class JsonUtils {
    public static JSONObject getPageInfo(int pageSize, int pageNo)
    {
         JSONObject json = new JSONObject();
        try {
            json.put("pageSize", pageSize);
            json.put("pageNo", pageNo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),json.toString());

        return json;
    }public static JsonObject getPageInfoBody(int pageSize, int pageNo)
    {
         JsonObject json = new JsonObject();

            json.setPageNo(pageNo+"");
            json.setPageSize(pageSize+"");

//        Log.d("aaaaaaa", "getPageInfoBody: "+json.toString());
//        RequestBody body=RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),json.toString());
//        Log.d("aaaaaaaa", "getPageInfoBody: "+body.toString());
        return json;
    }
}
