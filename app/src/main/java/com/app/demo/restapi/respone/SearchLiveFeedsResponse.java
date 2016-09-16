package com.app.demo.restapi.respone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Response with modal class for the fetch image
 * API service.
 */
public class SearchLiveFeedsResponse extends ServerResponse implements
        Serializable {

    private SearchLiveFeedsData Data;

    public SearchLiveFeedsData getData() {
        return Data;
    }

    public void setData(SearchLiveFeedsData data) {
        this.Data = data;
    }

    /**
     * Modal class for this response
     */
    public class SearchLiveFeedsData {

        private List<LiveFeed> LiveFeeds = new ArrayList<>();


        public List<LiveFeed> getLiveFeeds() {
            return LiveFeeds;
        }

        public void setLiveFeeds(List<LiveFeed> LiveFeeds) {
            this.LiveFeeds = LiveFeeds;
        }

        public class LiveFeed implements Serializable {

            public String getPropertyImageUrl() {
                return PropertyImageUrl;
            }

            public void setPropertyImageUrl(String propertyImageUrl) {
                PropertyImageUrl = propertyImageUrl;
            }
            private String PropertyImageUrl;
            private List<String> PropertyImageUrls;

        }
    }
}
