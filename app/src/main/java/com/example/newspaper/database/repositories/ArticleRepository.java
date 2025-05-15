package com.example.newspaper.database.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.newspaper.database.DatabaseHandler;
import com.example.newspaper.database.dao.ArticleDao;
import com.example.newspaper.models.Article;
import com.example.newspaper.pojo.ArticleWithCategory;

import java.util.List;
import java.util.concurrent.Executors;

public class ArticleRepository {
    private ArticleDao articleDao;

    public ArticleRepository(Context context) {
        DatabaseHandler dbh = DatabaseHandler.getInstance(context);

        this.articleDao = dbh.getArticleDao();
    }

    public void insert(Article article) {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.articleDao.insert(article);
        });
    }

    public void update(Article article) {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.articleDao.update(article);
        });
    }

    public void delete(Article article) {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.articleDao.delete(article);
        });
    }

    public void deleteAll() {
        Executors.newSingleThreadExecutor().execute(() -> {
            this.articleDao.deleteAlls();
        });
    }

    public List<ArticleWithCategory> getArticlesByIds(List<Integer> articleIds) {
        return articleDao.getArticlesByIds(articleIds);
    }

    public List<ArticleWithCategory> getPagedArticles(int limit, int offset) {
        return articleDao.getArticlesPaged(limit, offset);
    }

    public List<ArticleWithCategory> getTopArticles(long startTime, long endTime) {
        return articleDao.getTopArticles(startTime, endTime);
    }
}