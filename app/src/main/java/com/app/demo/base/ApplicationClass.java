package com.app.demo.base;

import android.app.Application;

import com.app.demo.restapi.network.RestClient;
import com.app.download.callback.AjaxCallback;
import com.app.download.callback.BitmapAjaxCallback;
import com.app.download.util.FetchUtility;

import java.io.File;

/**
 * Created by jawad
 */
public class ApplicationClass extends Application {
    public static String TAG = "ApplicationClass";
    private static RestClient restClient;
    private static ApplicationClass _instance;
    private static File cacheDir;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        _instance = this;
        initializeRestClient();
        initFetcherCacheLocation();
        initFetcher();
    }

    public static ApplicationClass getInstance() {
        return ApplicationClass._instance;
    }

    private void initializeRestClient() {
        restClient = new RestClient();
    }

    public static RestClient getRestClient() {
        return restClient;
    }



    /**
     * Initialize image fetching library
     */
    private void initFetcher() {
        // set the max number of concurrent network connections, default is 4
        AjaxCallback.setNetworkLimit(8);

        // set the max number of icons (image width <= 50) to be cached in
        // memory, default is 20
        BitmapAjaxCallback.setIconCacheLimit(20);

        // set the max number of images (image width > 50) to be cached in
        // memory, default is 20
        BitmapAjaxCallback.setCacheLimit(160);

        // set the max size of an image to be cached in memory, default is 1600
        // pixels (ie. 400x400)
        BitmapAjaxCallback.setPixelLimit(400 * 400);

        // set the max size of the memory cache, default is 1M pixels (4MB)
        BitmapAjaxCallback.setMaxPixelLimit(8000000);
    }

    /**
     * Init cache directory you like to use
     */
    private void initFetcherCacheLocation() {
        cacheDir = new File(getRootPath());
        FetchUtility.setCacheDir(cacheDir);
    }


    public static File getFetcherDir() {
        return cacheDir;
    }

    public static String getRootPath() {
        File path = ApplicationClass.getInstance().getApplicationContext().getExternalFilesDir(null);
        if (path == null) {
            path = ApplicationClass.getInstance().getApplicationContext().getFilesDir();
        }
        return path.toString();
    }

}