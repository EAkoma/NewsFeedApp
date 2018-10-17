package com.example.android.mynewsfeed;

public class NewsReport {
    private String mArticleType;
    private String mSectionName;
    private String mArticleName;
    private String mPublishTimeInMillisec;
    private String mUrl;
    private String mAuthorName;

    public NewsReport(String articleType, String sectionName, String articleName, String timeMillisec, String url, String author ) {

        mArticleType = articleType;
        mSectionName = sectionName;
        mArticleName = articleName;
        mPublishTimeInMillisec = timeMillisec;
        mUrl = url;
        mAuthorName = author;
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

    public String getmPublishTimeInMillisec() {
        return mPublishTimeInMillisec;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmAuthorName() {
        return mAuthorName;
    }
}
