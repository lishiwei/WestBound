package com.lishiwei.core;






import org.json.JSONException;
import org.json.JSONObject;

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
        return json;
    }
}
