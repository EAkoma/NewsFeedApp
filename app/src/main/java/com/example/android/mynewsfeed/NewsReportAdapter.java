package com.example.android.mynewsfeed;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsReportAdapter extends ArrayAdapter<NewsReport> {

    public NewsReportAdapter(Context context, List<NewsReport> newsreports) {
        super(context, 0, newsreports);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.newsfeed_list_item, parent, false);
        }

        NewsReport currentNewsReport = getItem(position);
        TextView newsTypeView = (TextView) listItemView.findViewById(R.id.news_type);
        newsTypeView.setText(currentNewsReport.getmArticleType());

        TextView newsSectionTypeView = (TextView) listItemView.findViewById(R.id.section_name);
        newsSectionTypeView.setText(currentNewsReport.getmSectionName());

        TextView newsArticleNameView = (TextView) listItemView.findViewById(R.id.article_name);
        newsArticleNameView.setText(currentNewsReport.getmArticleName());

        Date dateObject = new Date(currentNewsReport.getmPublishTimeInMillisec());
        TextView dateView = (TextView) listItemView.findViewById(R.id.publish_date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

}
