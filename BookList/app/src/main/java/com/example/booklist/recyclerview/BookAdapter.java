package com.example.booklist.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.booklist.R;
import com.example.booklist.model.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    List<Book> mData;
    BookCallback callback;

    public BookAdapter(List<Book> data, BookCallback callback) {
        mData = data;
        this.callback = callback;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);

        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        // bind book item data
        Glide.with(holder.itemView.getContext())
                .load(mData.get(position).getDrawableResource())
        .transform(new CenterCrop(), new RoundedCorners(16))
        .into(holder.imgBook);

        holder.ratingBar.setRating((float) 4.5);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBook, imgFav, imgContainer;
        TextView title, author, pages, rate;
        RatingBar ratingBar;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBook = itemView.findViewById(R.id.item_book_img);
            imgContainer = itemView.findViewById(R.id.container);
            title = itemView.findViewById(R.id.item_book_title);
            author = itemView.findViewById(R.id.item_book_author);
            pages = itemView.findViewById(R.id.item_book_pages_reviews);
            rate = itemView.findViewById(R.id.item_book_score);
            ratingBar = itemView.findViewById(R.id.item_book_ratingBar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onBookItemClick(getAdapterPosition(), imgContainer,
                            imgBook, title, author, pages, rate, ratingBar);
                }
            });
        }
    }

}
