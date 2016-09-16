package com.app.demo.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;

import com.app.demo.base.ApplicationClass;
import com.app.download.Fetcher;
import com.app.download.callback.AjaxStatus;
import com.app.download.callback.BitmapAjaxCallback;
import com.app.download.util.FetchUtility;

import java.io.File;

/**
 * Class to provide utility method to fetch images
 */
public class ImageUtility {

    private static Fetcher instanceFetcher;

    /**
     * Method to fetch the image bitmap by URL and assign this to image view provided.
     *
     * @param imageView
     * @param loading
     * @param imageUrl
     * @param context
     * @param fetcherObj
     */
    public static void fetchThumbnail(final ImageView imageView, final View loading, String imageUrl, final Context context, Fetcher fetcherObj) {
        Fetcher fetcher = fetcherObj;
        if (fetcher == null) {
            fetcher = getFetcherInstance(context);
        }

        File file = FetchUtility.getCacheFile(ApplicationClass.getFetcherDir(), imageUrl);
        if (file.exists()) {
            imageView.setVisibility(View.VISIBLE);
            Bitmap bmp = BitmapFactory.decodeFile(file.getAbsolutePath());
            imageView.setImageBitmap(bmp);
        } else {
            fetcher.id(imageView).image(imageUrl, true, true, 300, 0, new BitmapAjaxCallback() {
                @Override
                protected void callback(String url, ImageView iv, Bitmap bm, AjaxStatus status) {
                    iv.setVisibility(View.VISIBLE);
                    iv.setImageBitmap(bm);
                }
            });
        }
    }

    /**
     * Get instance of Fetcher Library
     * @param mContext
     * @return
     */

    public static Fetcher getFetcherInstance(Context mContext) {
        if (instanceFetcher == null) {
            instanceFetcher = new Fetcher(mContext);
        }
        return instanceFetcher;
    }
}
