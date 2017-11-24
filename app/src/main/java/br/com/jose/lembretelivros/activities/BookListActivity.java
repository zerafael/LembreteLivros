package br.com.jose.lembretelivros.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.jose.lembretelivros.R;
import br.com.jose.lembretelivros.adapters.BookAdapter;
import br.com.jose.lembretelivros.models.Book;

public class BookListActivity extends AppCompatActivity{

	private RecyclerView bookRecyclerView;
	private TextView noBooksAvailable;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_list);

		bookRecyclerView = findViewById(R.id.book_recycler_view);
		bookRecyclerView.setLayoutManager(new LinearLayoutManager(this));

		noBooksAvailable = findViewById(R.id.no_book_text_view);

		List<Book> books = new ArrayList<>();
//		for(int i = 0; i < 100; i++){
//			Book book = new Book("Livro " + i, 42);
//			books.add(book);
//		}

		if(books.isEmpty()){
			bookRecyclerView.setVisibility(View.GONE);
			noBooksAvailable.setVisibility(View.VISIBLE);
		}
		else{
			bookRecyclerView.setVisibility(View.VISIBLE);
			noBooksAvailable.setVisibility(View.GONE);
		}

		bookRecyclerView.setAdapter(new BookAdapter(books, this));
	}
}
