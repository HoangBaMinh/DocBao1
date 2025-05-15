package com.example.newspaper.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.newspaper.models.ReadHistory;
import com.example.newspaper.pojo.ArticleWithReadHistory;

import java.util.List;

@Dao
public interface ReadHistoryDao {
    @Insert
    void insert(ReadHistory readHistory);

    @Update
    void update(ReadHistory readHistory);

    @Delete
    void delete(ReadHistory readHistory);

    @Transaction
    @Query("SELECT articleId FROM read_history_table WHERE userId = :userId ORDER BY readAt DESC")
    List<Integer> findAllByUserId(int userId);

    @Query("DELETE FROM read_history_table WHERE userId = :userId")
    void deleteAll(int userId);
}
