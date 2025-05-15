package com.example.newspaper.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.newspaper.models.Category;

import java.util.List;

@Dao
public interface CategoryDao {
    @Insert
    void insert(Category category);

    @Update
    void update(Category category);

    @Delete
    void delete(Category category);

    @Query("DELETE FROM category_table")
    void deleteAlls();

    @Query("SELECT * FROM category_table ORDER BY id ASC")
    LiveData<List<Category>> findAlls();

    @Query("SELECT * FROM category_table ORDER BY id ASC")
    List<Category> getAllDirect();
}
