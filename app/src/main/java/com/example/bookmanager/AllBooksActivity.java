package com.example.bookmanager;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmanager.adapter.BookRecyclerViewAdapter;
import com.example.bookmanager.dto.Book;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    private RecyclerView booksRecyclerView;

    private BookRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_books);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        adapter = new BookRecyclerViewAdapter(this);
        booksRecyclerView = findViewById(R.id.booksRecView);

        booksRecyclerView.setAdapter(adapter);
        booksRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,
                           "Die drei ???",
                           "Robert Arthur",
                           128,
                           "https://images.sk-static.com/images/media/img/col6/20211217-105314-139957.png",
                           "Short description",
                           "A really long description of ???"
        ));
        adapter.setBooks(books);
    }
}