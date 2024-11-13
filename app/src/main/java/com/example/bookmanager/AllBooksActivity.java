package com.example.bookmanager;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
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
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book(1,
                           "Die drei ???",
                           "Robert Arthur",
                           128,
                           "https://images.sk-static.com/images/media/img/col6/20211217-105314-139957.png",
                           "Die drei Detektive ist eine Jugendbuch-Reihe.",
                           "Sie stammt aus den Vereinigten Staaten und wurde in viele Sprachen übersetzt. In Deutschland startete die Buchreihe 1968 mit den Übersetzungen der englischsprachigen Originale und wird seit 1993, nachdem die Reihe in den Vereinigten Staaten eingestellt worden war, mit Geschichten deutschsprachiger Autoren fortgesetzt."
        ));
        books.add(new Book(1,
                           "Alex Rider Scorpia",
                           "Anthony Horowitz",
                           352,
                           "https://bilder.buecher.de/produkte/23/23800/23800159n.jpg",
                           "Alex Rider - Scorpia ist Alex Riders fünfter Fall.",
                           "Für MI6-Agent Alex Rider bricht eine Welt zusammen, als er erfährt, dass sein Vater ein hochbezahlter Killer gewesen sein soll, der vom MI6 ermordet wurde."
        ));
        adapter.setBooks(books);
    }
}