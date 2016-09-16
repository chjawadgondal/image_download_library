package com.app.demo.restapi.network;

import android.content.Context;

import com.app.demo.restapi.respone.ServerResponse;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


/**
 * This class extend the Retrofit CallBack
 * class to provide more control on call back method of Call back
 * class.
 * @param <T>
 */
public class RestCallback<T> implements Callback {
    private ServerConnectListener listener;
    private int requestCode;
    private Context mContext;


    public RestCallback(ServerConnectListener listener, int requestCode,
                        Context context) {
        this.listener = listener;
        this.requestCode = requestCode;
        this.mContext = context;
    }


    @Override
    public void success(Object responseObject, Response response) {
        if(responseObject instanceof ServerResponse){
            ((ServerResponse)responseObject).setRequestCode(this.requestCode);
        }
        listener.onSuccess(responseObject);
    }

    @Override
    public void failure(RetrofitError retrofitError) {
        listener.onFailure(retrofitError);
    }
}
