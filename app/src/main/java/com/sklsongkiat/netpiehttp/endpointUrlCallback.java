package com.sklsongkiat.netpiehttp;

import android.content.Context;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class endpointUrlCallback {

    interface APICallback{
        void cb(String json);
    }

    APICallback apiCallback;

    public void setCallback(APICallback apiCallback){
        this.apiCallback = apiCallback;
    }

    private String endpoint = httpConstant.url+"topic/" +
            httpConstant.appId + "/home?auth=" +
            httpConstant.keyNetPie + ":" +
            httpConstant.secretKeyNetPie;

    private Context context;

    public endpointUrlCallback(Context context){

        this.context = context;
    }

    public void GET(){

        Ion.with(context)
                .load(endpoint)
                .asString()
                .setCallback(new FutureCallback<String>() {
                    @Override
                    public void onCompleted(Exception e, String jsonObject) {
                        apiCallback.cb(jsonObject);
                    }
                });
    }

}
