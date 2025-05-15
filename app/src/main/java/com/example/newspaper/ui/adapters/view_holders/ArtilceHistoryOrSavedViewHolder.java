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

public class ArtilceHistoryOrSavedViewHolder extends BaseViewHolder<ArticleViewItem> {

    private TextView categoryText;
    private TextView titleText;
    private TextView savedOrReadAtText;
    private ImageView thumbnailImage;

    public ArtilceHistoryOrSavedViewHolder(@NonNull View itemView) {
        super(itemView);
        categoryText = itemView.findViewById(R.id.category);
        titleText = itemView.findViewById(R.id.title);
        savedOrReadAtText = itemView.findViewById(R.id.saved_or_read_at);
        thumbnailImage = itemView.findViewById(R.id.thumbnail);

    }

    @Override
    public void onBindViewHolder(ArticleViewItem item) {
        DateTimeFormatterUtil formatter = new DateTimeFormatterUtil();

        categoryText.setText(item.getArticle().category.getName());
        titleText.setText(item.getArticle().article.getTitle());

        String readAt = formatter.formatInHours(item.getArticle().article.getPublishedAt());
        savedOrReadAtText.setText("Đã xem " + readAt);

        Glide.with(itemView.getContext())
                .load(item.getArticle().article.getThumbnailUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(thumbnailImage);
    }
}
