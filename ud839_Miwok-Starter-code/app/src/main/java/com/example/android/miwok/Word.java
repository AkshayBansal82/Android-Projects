package com.example.android.miwok;


public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int msongResourceId;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String mDefaultTranslation, String mMiwokTranslation,int a) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.msongResourceId=a;
    }

    public Word(String mDefaultTranslation, String mMiwokTranslation, int imageResourceID, int a) {
        this.mDefaultTranslation = mDefaultTranslation;
        this.mMiwokTranslation = mMiwokTranslation;
        this.mImageResourceId = imageResourceID;
        this.msongResourceId=a;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceID() {
        return mImageResourceId;
    }

    public int getsongResourceID() {
        return msongResourceId;
    }

    public Boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
