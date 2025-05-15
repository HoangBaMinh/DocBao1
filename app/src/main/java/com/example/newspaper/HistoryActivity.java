package com.example.newspaper;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.graphics.RectKt;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newspaper.database.repositories.ArticleRepository;
import com.example.newspaper.database.repositories.ReadHistoryRepository;
import com.example.newspaper.models.Article;
import com.example.newspaper.pojo.ArticleWithCategory;
import com.example.newspaper.ui.adapters.ArticleRecycleViewAdapter;
import com.example.newspaper.ui.adapters.view_items.ArticleViewItem;
import com.example.newspaper.ui.adapters.view_models.ArticleViewModel;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArticleViewModel articleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_history);

        findViewById(R.id.back_icon).setOnClickListener(v -> {
            finish();
        });

        TextView title = findViewById(R.id.title);
        String type = getIntent().getStringExtra("type");
        if (type.equals("history")) title.setText("Bài viết đã xem");
        else if (type.equals("saved")) title.setText("Bài viết đã lưu");

        recyclerView = findViewById(R.id.listViews);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ReadHistoryRepository historyRepository = new ReadHistoryRepository(this);
        ArticleRepository articleRepository = new ArticleRepository(this);
        articleViewModel = new ArticleViewModel(articleRepository);

        int userId = 1;

        // Lấy trực tiếp danh sách articleId đã xem
        List<Integer> articleIds = historyRepository.findAlls(userId);  // Không cần Thread nữa
        List<ArticleWithCategory> articles = articleRepository.getArticlesByIds(articleIds);
        List<ArticleViewItem> items = new ArrayList<>();
        for (ArticleWithCategory article : articles) {
            items.add(new ArticleViewItem(article, ArticleViewItem.TypeDisplay.HISTORY));
        }
        recyclerView.setAdapter(new ArticleRecycleViewAdapter(items));
    }
}