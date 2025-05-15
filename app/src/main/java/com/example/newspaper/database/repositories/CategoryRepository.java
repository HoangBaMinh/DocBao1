package com.example.newspaper.database.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.paging.PagingSource;

import com.example.newspaper.database.DatabaseHandler;
import com.example.newspaper.database.dao.ArticleDao;
import com.example.newspaper.database.dao.CategoryDao;
import com.example.newspaper.models.Article;
import com.example.newspaper.models.Category;

import java.util.List;

public class CategoryRepository {

    private CategoryDao categoryDao;

    private LiveData<List<Category>> categories;

    private PagingSource<Integer, Category> pagingSource;

    public CategoryRepository(Context context){
        DatabaseHandler dbh = DatabaseHandler.getInstance(context);

        this.categoryDao = dbh.getCategoryDao();
        this.categories = categoryDao.findAlls();
//        this.pageArticles = articleDao.getPageArticle();
    }
}
