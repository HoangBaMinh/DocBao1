package com.example.newspaper.database.repositories;

import android.content.Context;

import com.example.newspaper.database.DatabaseHandler;
import com.example.newspaper.database.dao.SearchHistoryDao;
import com.example.newspaper.models.SearchHistory;

import java.util.List;
import java.util.concurrent.Executors;

public class SearchHistoryRepository {
    private SearchHistoryDao searchHistoryDao;

    public SearchHistoryRepository(Context context) {
        DatabaseHandler dbh = DatabaseHandler.getInstance(context);

        this.searchHistoryDao = dbh.getSearchHistoryDao();
    }

    public void insert(SearchHistory searchHistory) {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.searchHistoryDao.insert(searchHistory);
        });
    }

    public void update(SearchHistory searchHistory) {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.searchHistoryDao.update(searchHistory);
        });
    }

    public void delete(SearchHistory searchHistory) {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.searchHistoryDao.delete(searchHistory);
        });
    }

    public void deleteAll() {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.searchHistoryDao.deleteAlls();
        });
    }

    public List<SearchHistory> getSearchHistory(int userId) {
        return searchHistoryDao.getSearchHistoryByUserId(userId);
    }

    public List<String> getSearchTrends(){
        return searchHistoryDao.getSearchTrends();
    }
}
