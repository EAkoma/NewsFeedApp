package com.example.android.mynewsfeed;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsReportActivity extends AppCompatActivity
        implements LoaderManager.LoaderCallbacks<List<NewsReport>> {

    private static final String THE_GUARDIAN_REQUEST_URL = "https://content.guardianapis.com/search?order-by=newest&page-size=15&api-key=700cb6e3-adb2-4790-aa8a-ef54d760a8f8";
    private static final int NEWSREPORT_LOADER_ID = 1;
    private NewsReportAdapter mAdapter;

    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newsfeed_activity);

        ListView newsreportListView = (ListView) findViewById(R.id.list);

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        newsreportListView.setEmptyView(mEmptyStateTextView);

        mAdapter = new NewsReportAdapter(this, new ArrayList<NewsReport>());
        newsreportListView.setAdapter(mAdapter);
        newsreportListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                NewsReport currentNewsReport = mAdapter.getItem(position);
                Uri newsreportUri = Uri.parse(currentNewsReport.getmUrl());

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsreportUri);

                startActivity(websiteIntent);
            }
        });

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWSREPORT_LOADER_ID, null, this);
        } else {
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }

    @Override
    public Loader<List<NewsReport>> onCreateLoader(int i, Bundle bundle) {
        return new NewsreportLoader(this, THE_GUARDIAN_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<NewsReport>> loader, List<NewsReport> newsreports) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);
        mEmptyStateTextView.setText(R.string.no_newsreports);

        // Clear the adapter of previous earthquake data
        //mAdapter.clear();

        if (newsreports != null && !newsreports.isEmpty()) {
            mAdapter.addAll(newsreports);
            //updateUi(newsreports);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<NewsReport>> loader) {
        mAdapter.clear();
    }

}

