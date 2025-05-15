package com.example.newspaper;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newspaper.database.repositories.ArticleRepository;
import com.example.newspaper.models.Article;
import com.example.newspaper.pojo.ArticleWithCategory;
import com.example.newspaper.ui.adapters.ArticleRecycleViewAdapter;
import com.example.newspaper.ui.adapters.view_items.ArticleViewItem;
import com.example.newspaper.ui.adapters.view_models.ArticleViewModel;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsPointActivity extends AppCompatActivity {
    TextView title, childTitle;
    RecyclerView recyclerView;
    ArticleViewModel articleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_news_point);

        findViewById(R.id.back_icon).setOnClickListener(v -> {
            finish();
        });

        title = findViewById(R.id.title);
        childTitle = findViewById(R.id.childTitle);
        recyclerView = findViewById(R.id.highlightRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String type = getIntent().getStringExtra("type");
        assert type != null;

        // Xử lý tiêu đề
        long startTime, endTime;
        if (type.equals("newest")) {
            title.setText("Tin mới nhất");
            childTitle.setText(String.format("TIN MỚI NHẤT TRONG NGÀY %s", LocalDate.now()));
            startTime = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
            endTime = LocalDate.now().plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        } else {
            title.setText("Điểm tin");
            childTitle.setText(String.format("ĐIỂM TIN NỔI BẬT HÔM QUA %s", LocalDate.now().minusDays(1)));
            startTime = LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
            endTime = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        }

        // Lấy dữ liệu
        ArticleRepository articleRepository = new ArticleRepository(this);
        List<ArticleWithCategory> articles = articleRepository.getTopArticles(startTime, endTime);
        // Chuyển dữ liệu sang dạng hiển thị
        List<ArticleViewItem> items = new ArrayList<>();
        for (ArticleWithCategory article : articles) {
            items.add(new ArticleViewItem(article, ArticleViewItem.TypeDisplay.POINT));
        }
        recyclerView.setAdapter(new ArticleRecycleViewAdapter(items));
    }
}
