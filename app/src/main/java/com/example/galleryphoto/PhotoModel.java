package com.example.galleryphoto;

import android.os.Parcel;
import android.os.Parcelable;

public class PhotoModel implements Parcelable {
    String title;
    String url_img;

    public PhotoModel(String title, String url_img) {
        this.title = title;
        this.url_img = url_img;
    }

    protected PhotoModel(Parcel in) {
        title = in.readString();
        url_img = in.readString();
    }

    public static final Creator<PhotoModel> CREATOR = new Creator<PhotoModel>() {
        @Override
        public PhotoModel createFromParcel(Parcel in) {
            return new PhotoModel(in);
        }

        @Override
        public PhotoModel[] newArray(int size) {
            return new PhotoModel[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl_img() {
        return url_img;
    }

    public void setUrl_img(String url_img) {
        this.url_img = url_img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(url_img);
    }
}
