package com.app.demo.restapi.respone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jawad on 9/11/2016.
 */
public class ImageResponse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("color")
    @Expose
    private String color;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("liked_by_user")
    @Expose
    private Boolean likedByUser;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("current_user_collections")
    @Expose
    private List<Object> currentUserCollections = new ArrayList<Object>();
    @SerializedName("urls")
    @Expose
    private Urls urls;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();
    @SerializedName("links")
    @Expose
    private Links__ links;

    /**
     *
     * @return
     * The id
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The createdAt
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     *
     * @param createdAt
     * The created_at
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     *
     * @return
     * The width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     *
     * @param width
     * The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     *
     * @return
     * The height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     *
     * @param height
     * The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     *
     * @return
     * The color
     */
    public String getColor() {
        return color;
    }

    /**
     *
     * @param color
     * The color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     *
     * @return
     * The likes
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     *
     * @param likes
     * The likes
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     *
     * @return
     * The likedByUser
     */
    public Boolean getLikedByUser() {
        return likedByUser;
    }

    /**
     *
     * @param likedByUser
     * The liked_by_user
     */
    public void setLikedByUser(Boolean likedByUser) {
        this.likedByUser = likedByUser;
    }

    /**
     *
     * @return
     * The user
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     * The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     * The currentUserCollections
     */
    public List<Object> getCurrentUserCollections() {
        return currentUserCollections;
    }

    /**
     *
     * @param currentUserCollections
     * The current_user_collections
     */
    public void setCurrentUserCollections(List<Object> currentUserCollections) {
        this.currentUserCollections = currentUserCollections;
    }

    /**
     *
     * @return
     * The urls
     */
    public Urls getUrls() {
        return urls;
    }

    /**
     *
     * @param urls
     * The urls
     */
    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    /**
     *
     * @return
     * The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @param categories
     * The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     *
     * @return
     * The links
     */
    public Links__ getLinks() {
        return links;
    }

    /**
     *
     * @param links
     * The links
     */
    public void setLinks(Links__ links) {
        this.links = links;
    }


    public class Category {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("photo_count")
        @Expose
        private Integer photoCount;
        @SerializedName("links")
        @Expose
        private Links_ links;

        /**
         *
         * @return
         * The id
         */
        public Integer getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(Integer id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The photoCount
         */
        public Integer getPhotoCount() {
            return photoCount;
        }

        /**
         *
         * @param photoCount
         * The photo_count
         */
        public void setPhotoCount(Integer photoCount) {
            this.photoCount = photoCount;
        }

        /**
         *
         * @return
         * The links
         */
        public Links_ getLinks() {
            return links;
        }

        /**
         *
         * @param links
         * The links
         */
        public void setLinks(Links_ links) {
            this.links = links;
        }

    }



    public class Links {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("html")
        @Expose
        private String html;
        @SerializedName("photos")
        @Expose
        private String photos;
        @SerializedName("likes")
        @Expose
        private String likes;

        /**
         *
         * @return
         * The self
         */
        public String getSelf() {
            return self;
        }

        /**
         *
         * @param self
         * The self
         */
        public void setSelf(String self) {
            this.self = self;
        }

        /**
         *
         * @return
         * The html
         */
        public String getHtml() {
            return html;
        }

        /**
         *
         * @param html
         * The html
         */
        public void setHtml(String html) {
            this.html = html;
        }

        /**
         *
         * @return
         * The photos
         */
        public String getPhotos() {
            return photos;
        }

        /**
         *
         * @param photos
         * The photos
         */
        public void setPhotos(String photos) {
            this.photos = photos;
        }

        /**
         *
         * @return
         * The likes
         */
        public String getLikes() {
            return likes;
        }

        /**
         *
         * @param likes
         * The likes
         */
        public void setLikes(String likes) {
            this.likes = likes;
        }

    }

    public class Links_ {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("photos")
        @Expose
        private String photos;

        /**
         *
         * @return
         * The self
         */
        public String getSelf() {
            return self;
        }

        /**
         *
         * @param self
         * The self
         */
        public void setSelf(String self) {
            this.self = self;
        }

        /**
         *
         * @return
         * The photos
         */
        public String getPhotos() {
            return photos;
        }

        /**
         *
         * @param photos
         * The photos
         */
        public void setPhotos(String photos) {
            this.photos = photos;
        }

    }

    public class Links__ {

        @SerializedName("self")
        @Expose
        private String self;
        @SerializedName("html")
        @Expose
        private String html;
        @SerializedName("download")
        @Expose
        private String download;

        /**
         *
         * @return
         * The self
         */
        public String getSelf() {
            return self;
        }

        /**
         *
         * @param self
         * The self
         */
        public void setSelf(String self) {
            this.self = self;
        }

        /**
         *
         * @return
         * The html
         */
        public String getHtml() {
            return html;
        }

        /**
         *
         * @param html
         * The html
         */
        public void setHtml(String html) {
            this.html = html;
        }

        /**
         *
         * @return
         * The download
         */
        public String getDownload() {
            return download;
        }

        /**
         *
         * @param download
         * The download
         */
        public void setDownload(String download) {
            this.download = download;
        }

    }

    public class ProfileImage {

        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("medium")
        @Expose
        private String medium;
        @SerializedName("large")
        @Expose
        private String large;

        /**
         *
         * @return
         * The small
         */
        public String getSmall() {
            return small;
        }

        /**
         *
         * @param small
         * The small
         */
        public void setSmall(String small) {
            this.small = small;
        }

        /**
         *
         * @return
         * The medium
         */
        public String getMedium() {
            return medium;
        }

        /**
         *
         * @param medium
         * The medium
         */
        public void setMedium(String medium) {
            this.medium = medium;
        }

        /**
         *
         * @return
         * The large
         */
        public String getLarge() {
            return large;
        }

        /**
         *
         * @param large
         * The large
         */
        public void setLarge(String large) {
            this.large = large;
        }

    }

    public class Urls {

        @SerializedName("raw")
        @Expose
        private String raw;
        @SerializedName("full")
        @Expose
        private String full;
        @SerializedName("regular")
        @Expose
        private String regular;
        @SerializedName("small")
        @Expose
        private String small;
        @SerializedName("thumb")
        @Expose
        private String thumb;

        /**
         *
         * @return
         * The raw
         */
        public String getRaw() {
            return raw;
        }

        /**
         *
         * @param raw
         * The raw
         */
        public void setRaw(String raw) {
            this.raw = raw;
        }

        /**
         *
         * @return
         * The full
         */
        public String getFull() {
            return full;
        }

        /**
         *
         * @param full
         * The full
         */
        public void setFull(String full) {
            this.full = full;
        }

        /**
         *
         * @return
         * The regular
         */
        public String getRegular() {
            return regular;
        }

        /**
         *
         * @param regular
         * The regular
         */
        public void setRegular(String regular) {
            this.regular = regular;
        }

        /**
         *
         * @return
         * The small
         */
        public String getSmall() {
            return small;
        }

        /**
         *
         * @param small
         * The small
         */
        public void setSmall(String small) {
            this.small = small;
        }

        /**
         *
         * @return
         * The thumb
         */
        public String getThumb() {
            return thumb;
        }

        /**
         *
         * @param thumb
         * The thumb
         */
        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

    }

    public class User {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("profile_image")
        @Expose
        private ProfileImage profileImage;
        @SerializedName("links")
        @Expose
        private Links links;

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The username
         */
        public String getUsername() {
            return username;
        }

        /**
         *
         * @param username
         * The username
         */
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The profileImage
         */
        public ProfileImage getProfileImage() {
            return profileImage;
        }

        /**
         *
         * @param profileImage
         * The profile_image
         */
        public void setProfileImage(ProfileImage profileImage) {
            this.profileImage = profileImage;
        }

        /**
         *
         * @return
         * The links
         */
        public Links getLinks() {
            return links;
        }

        /**
         *
         * @param links
         * The links
         */
        public void setLinks(Links links) {
            this.links = links;
        }

    }
}
