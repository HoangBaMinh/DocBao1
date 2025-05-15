package com.example.newspaper.database.repositories;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.paging.PagingSource;

import com.example.newspaper.database.DatabaseHandler;
import com.example.newspaper.database.dao.CategoryDao;
import com.example.newspaper.database.dao.UserDao;
import com.example.newspaper.models.Category;
import com.example.newspaper.models.User;

import java.util.List;

public class UserRepository {
    private UserDao userDao;

    private LiveData<List<User>> users;

    private PagingSource<Integer, Category> pagingSource;

    public UserRepository(Context context){
        DatabaseHandler dbh = DatabaseHandler.getInstance(context);

        this.userDao = dbh.getUserDao();
        this.users = userDao.findAlls();
//        this.pageArticles = articleDao.getPageArticle();
    }
}
