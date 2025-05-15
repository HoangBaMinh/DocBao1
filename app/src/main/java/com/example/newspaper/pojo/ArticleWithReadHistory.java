package com.example.newspaper.pojo;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.newspaper.models.Article;
import com.example.newspaper.models.ReadHistory;

public class ArticleWithReadHistory {
    @Embedded
    public Article article;

    @Relation(
            parentColumn = "articleId",
            entityColumn = "id"
    )
    public ReadHistory readHistory;
}
