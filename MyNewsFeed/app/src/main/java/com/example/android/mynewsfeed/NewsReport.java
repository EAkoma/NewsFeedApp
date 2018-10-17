package com.example.android.mynewsfeed;

public class NewsReport {
    private String mArticleType;
    private String mSectionName;
    private String mArticleName;
    private long mPublishTimeInMillisec;
    private String mUrl;

    public NewsReport(String articleType, String sectionName, String articleName, long timeMillisec, String url) {

        mArticleType = articleType;
        mSectionName = sectionName;
        mArticleName = articleName;
        mPublishTimeInMillisec = timeMillisec;
        mUrl = url;
    }


    public String getmArticleType() {
        return mArticleType;
    }

    public String getmSectionName() {
        return mSectionName;
    }

    public String getmArticleName() {
        return mArticleName;
    }

    public long getmPublishTimeInMillisec() {
        return mPublishTimeInMillisec;
    }

    public String getmUrl() {
        return mUrl;
    }
}
