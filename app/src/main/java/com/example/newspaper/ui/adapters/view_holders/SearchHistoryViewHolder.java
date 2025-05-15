package com.example.newspaper.ui.adapters.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.newspaper.R;
import com.example.newspaper.models.SearchHistory;

public class SearchHistoryViewHolder extends BaseViewHolder<SearchHistory>{
    TextView historyTopic;
    ImageView deleteIcon;

    public SearchHistoryViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void onBindViewHolder(SearchHistory item) {
        historyTopic = findViewById(R.id.history_topic);
        deleteIcon = findViewById(R.id.delete);
    }
}
