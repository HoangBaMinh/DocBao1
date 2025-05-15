package com.example.newspaper.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.newspaper.models.SearchHistory;

import java.util.List;

@Dao
public interface SearchHistoryDao {
    @Insert
    void insert(SearchHistory SearchHistory);

    @Update
    void update(SearchHistory SearchHistory);

    @Delete
    void delete(SearchHistory SearchHistory);

    @Query("DELETE FROM search_history_table")
    void deleteAlls();

    @Query("SELECT * FROM search_history_table WHERE :userId")
    List<SearchHistory> getSearchHistoryByUserId(int userId);

    @Query("SELECT keyword, COUNT(*) AS search_count FROM search_history_table GROUP BY keyword ORDER BY search_count DESC LIMIT 10;")
    List<String> getSearchTrends();

}
