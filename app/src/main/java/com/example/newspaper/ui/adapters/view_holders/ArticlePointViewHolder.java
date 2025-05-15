package com.example.newspaper.ui.adapters.view_holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.newspaper.R;
import com.example.newspaper.ui.adapters.view_items.ArticleViewItem;
import com.example.newspaper.utils.DateTimeFormatterUtil;

public class ArticlePointViewHolder extends BaseViewHolder<ArticleViewItem>{

    private TextView item_category, item_time, item_title, item_description;
    private ImageView item_image;

    public ArticlePointViewHolder(@NonNull View itemView) {
        super(itemView);
        item_category = itemView.findViewById(R.id.item_category);
        item_time = itemView.findViewById(R.id.item_time);
        item_title = itemView.findViewById(R.id.item_title);
        item_description = itemView.findViewById(R.id.item_description);
        item_image = itemView.findViewById(R.id.item_image);
    }

    @Override
    public void onBindViewHolder(ArticleViewItem item) {
        DateTimeFormatterUtil formatter = new DateTimeFormatterUtil();

        item_category.setText(item.getArticle().category.getName());
        item_time.setText(formatter.formatInHours(item.getArticle().article.getPublishedAt()));
        item_title.setText(item.getArticle().article.getTitle());
        item_description.setText(item.getArticle().article.getSummary());
        Glide.with(itemView.getContext())
                .load(item.getArticle().article.getThumbnailUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(item_image);
    }

}
