package com.example.newspaper.database.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.paging.PagingSource;

import com.example.newspaper.database.DatabaseHandler;
import com.example.newspaper.database.dao.ReadHistoryDao;
import com.example.newspaper.models.Article;
import com.example.newspaper.models.ReadHistory;
import com.example.newspaper.pojo.ArticleWithReadHistory;

import java.util.List;
import java.util.concurrent.Executors;

public class ReadHistoryRepository {

    private ReadHistoryDao readHistoryDao;

    private List<ReadHistory> readHistories;


    public ReadHistoryRepository(Context context) {
        DatabaseHandler dbh = DatabaseHandler.getInstance(context);
        this.readHistoryDao = dbh.getReadHistoryDao();
    }

    public void insert(ReadHistory readHistory) {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.readHistoryDao.insert(readHistory);
        });
    }

    public void update(ReadHistory readHistory) {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.readHistoryDao.update(readHistory);
        });
    }

    public void delete(ReadHistory readHistory) {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.readHistoryDao.delete(readHistory);
        });
    }


    public void deleteAll(int userId) {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.readHistoryDao.deleteAll(userId);
        });
    }

    public List<Integer> findAlls(int userId) {
        return this.readHistoryDao.findAllByUserId(userId);
    }

}
