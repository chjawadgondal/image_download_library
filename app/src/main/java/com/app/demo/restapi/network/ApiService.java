package com.app.demo.restapi.network;


import com.app.demo.restapi.respone.ImageResponse;
import com.app.demo.restapi.respone.SearchLiveFeedsResponse;

import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;


public interface ApiService {

    String API_VERSION = "2.0";

    public static String BASE_URL = "http://";

    public static String APP_URL = "/followitqawebapi.azurewebsites.net/api/";

    public static String GET_SEARCH_LIVE_URL = APP_URL
            + "SearchLiveFeeds";

    public static String GET_FEED_URL = "/pastebin.com/raw/wgkJgazE";

    @FormUrlEncoded
    @POST(GET_SEARCH_LIVE_URL)
    void getSearchLiveFeeds(@Field("SearchType") int SearchType,
                            @Field("SearchModuleType") int SearchModuleType,
                            @Field("SearchGroupId") int SearchGroupId,
                            @Field("SearchText") String SearchText,
                            @Field("DrawnPolygon") String DrawnPolygon,
                            @Field("Latitude") Double Latitude,
                            @Field("Longitude") Double Longitude,
                            @Field("Page") int Page,
                            @Field("PageSize") int PageSize,
                            @Field("Distance") int Distance,
                            @Field("Beds") int Beds,
                            @Field("Baths") int Baths,
                            @Field("Carspaces") int Carspaces,
                            @Field("MinPrice") int MinPrice,
                            @Field("MaxPrice") int MaxPrice,
                            @Field("SelectedPropertyFeatures") String selectedPropertyFeatures,
                            @Field("SelectedPropertyTypes") String selectedPropertyTypes,
                            @Field("Keywords") String Keywords,
                            Callback<SearchLiveFeedsResponse> callback);

    @FormUrlEncoded
    @GET(GET_FEED_URL)
    void getFeeds(Callback<ImageResponse> callback);
}
