package com.app.demo.restapi.network;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.HttpURLConnection;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Request;
import retrofit.client.UrlConnectionClient;
import retrofit.converter.GsonConverter;

/**
 * This class initialize the RETROFIT
 * REST API handler main classes. These initialize method are get
 * called when application started By ApplicationClass.
 */
public class RestClient {
    private ApiService apiService;


    // Adding Headers
    static RequestInterceptor requestInterceptorWithHeaderAndVersion = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("API-Version", ApiService.API_VERSION);
            request.addHeader("access_token", "");
        }
    };


    public RestClient() {
        Gson gson = new GsonBuilder().setDateFormat(
                "yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'").create();
        RestAdapter restAdapter;
        restAdapter = new RestAdapter.Builder()
                .setClient(new MyUrlConnectionClient())
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(ApiService.BASE_URL)
                .setConverter(new GsonConverter(gson))
                .setRequestInterceptor(requestInterceptorWithHeaderAndVersion).build();

        apiService = restAdapter.create(ApiService.class);
    }


    public ApiService getApiService() {
        return apiService;
    }

    public final class MyUrlConnectionClient extends UrlConnectionClient {
        @Override
        protected HttpURLConnection openConnection(Request request) throws IOException {
            HttpURLConnection connection = super.openConnection(request);
            connection.setConnectTimeout(100 * 1000);
            connection.setReadTimeout(100 * 1000);
            return connection;
        }
    }
}
