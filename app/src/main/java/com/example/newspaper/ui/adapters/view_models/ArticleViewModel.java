package com.example.newspaper.ui.adapters.view_models;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newspaper.database.repositories.ArticleRepository;
import com.example.newspaper.pojo.ArticleWithCategory;

import java.util.List;
import java.util.concurrent.Executors;

public class ArticleViewModel extends ViewModel {
    private final ArticleRepository repository;
    private final MutableLiveData<List<ArticleWithCategory>> articles = new MutableLiveData<>();

    public ArticleViewModel(ArticleRepository repository) {
        this.repository = repository;
    }

    public LiveData<List<ArticleWithCategory>> getArticles() {
        return articles;
    }

    public void loadArticles(int limit, int offset) {
        Executors.newSingleThreadExecutor().execute(() -> {
            List<ArticleWithCategory> data = repository.getPagedArticles(limit, offset);
            articles.postValue(data);
        });
    }
}