package com.example.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.booklist.model.Book;
import com.example.booklist.recyclerview.BookAdapter;
import com.example.booklist.recyclerview.BookCallback;
import com.example.booklist.recyclerview.CustomItemAnimator;

import java.util.ArrayList;
import java.util.List;

import androidx.core.util.Pair;

public class MainActivity extends AppCompatActivity implements BookCallback {

    private RecyclerView rvBooks;
    private BookAdapter bookAdapter;
    private List<Book> mData;
    private Button btnAddBook, btnRemoveBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initBooks();
        setupBookAdapter();
    }

    private void initView() {
        btnAddBook = findViewById(R.id.btn_add);
        btnRemoveBook = findViewById(R.id.btn_remove);
        rvBooks = findViewById(R.id.rv_books);
        rvBooks.setLayoutManager(new LinearLayoutManager(this));
        rvBooks.setHasFixedSize(true);

        rvBooks.setItemAnimator(new CustomItemAnimator());

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                addBook();
            }
        });

        btnRemoveBook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                removeBook();
            }
        });
    }

    private void addBook() {
        Book book = new Book(R.drawable.nondesigner);
        mData.add(book);
        bookAdapter.notifyItemInserted(1);
    }

    private void removeBook() {
        mData.remove(1);
        bookAdapter.notifyItemRemoved(1);
    }

    private void initBooks() {
        mData = new ArrayList<>();
        mData.add(new Book(R.drawable.book1));
        mData.add(new Book(R.drawable.gatsby));
        mData.add(new Book(R.drawable.gatsby2));
        mData.add(new Book(R.drawable.nondesigner));
        mData.add(new Book(R.drawable.thefault));
        mData.add(new Book(R.drawable.themessy));
    }

    private void setupBookAdapter() {
        bookAdapter = new BookAdapter(mData, this);
        rvBooks.setAdapter(bookAdapter);
    }

    @Override
    public void onBookItemClick(int pos, ImageView imgContainer,
                ImageView imgBook, TextView title, TextView authorName,
                TextView nbpages, TextView score, RatingBar ratingBar)
    {
        Intent intent = new Intent(this, BookDetailsActivity.class);
        intent.putExtra("bookObject", mData.get(pos));

        Pair<View, String> p1 = Pair.create((View)imgContainer, "containerTN");
        Pair<View, String> p2 = Pair.create((View)imgBook, "bookImgTN");
        Pair<View, String> p3 = Pair.create((View)title, "bookTitleTN");
        Pair<View, String> p4 = Pair.create((View)authorName, "bookAuthorTN");
        Pair<View, String> p5 = Pair.create((View)nbpages, "bookPagesTN");
        Pair<View, String> p6 = Pair.create((View)score, "bookScoreTN");
        Pair<View, String> p7 = Pair.create((View)ratingBar, "bookRatingTN");

        ActivityOptionsCompat optionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,p1,p2,p3,p4,p5,p6,p7);

        startActivity(intent, optionsCompat.toBundle());
    }
}