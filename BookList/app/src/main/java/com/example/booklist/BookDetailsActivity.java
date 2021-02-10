package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

import com.bumptech.glide.Glide;
import com.example.booklist.model.Book;

public class BookDetailsActivity extends AppCompatActivity {
    ImageView imgBook;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        imgBook = findViewById(R.id.item_book_img);
        ratingBar = findViewById(R.id.item_book_ratingBar);

        Book item = (Book) getIntent().getExtras().getSerializable("bookObject");

        loadBookData(item);
    }

    private void loadBookData(Book item) {
        Glide.with(this).load(item.getDrawableResource()).into(imgBook);
    }
}