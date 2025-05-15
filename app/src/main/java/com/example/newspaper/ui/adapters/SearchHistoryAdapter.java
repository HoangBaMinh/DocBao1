package com.example.newspaper.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.newspaper.R;
import com.example.newspaper.models.SearchHistory;
import com.example.newspaper.ui.adapters.view_holders.ArticleCategoryViewHolder;
import com.example.newspaper.ui.adapters.view_holders.ArticleViewHolder;
import com.example.newspaper.ui.adapters.view_holders.BaseViewHolder;
import com.example.newspaper.ui.adapters.view_holders.NotificationViewHolder;
import com.example.newspaper.ui.adapters.view_holders.SearchHistoryViewHolder;
import com.example.newspaper.ui.adapters.view_items.ArticleViewItem;

import java.util.List;

public class SearchHistoryAdapter extends BaseRecycleViewAdapter<SearchHistory>{
    private List<SearchHistory> items;
    private boolean isLoading = false;

    public SearchHistoryAdapter(List<SearchHistory> items) {
        super(items);
        this.items = items;
    }

    public void setArticles(List<SearchHistory> articles) {
        this.items = articles;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new SearchHistoryViewHolder(inflater.inflate(R.layout.item_history_search_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBindViewHolder(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }

    public void setLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }
}
