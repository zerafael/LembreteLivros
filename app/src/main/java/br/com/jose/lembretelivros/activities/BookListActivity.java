package br.com.jose.lembretelivros.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.jose.lembretelivros.R;
import br.com.jose.lembretelivros.Tasks.Refreshable;
import br.com.jose.lembretelivros.Tasks.getBooksTask;
import br.com.jose.lembretelivros.adapters.BookAdapter;
import br.com.jose.lembretelivros.models.Book;

public class BookListActivity extends AppCompatActivity implements Refreshable<Book>{

	private RecyclerView bookRecyclerView;
	private TextView noBooksAvailable;

	private List<Book> books = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_list);

		bookRecyclerView = findViewById(R.id.book_recycler_view);
		bookRecyclerView.setLayoutManager(new LinearLayoutManager(this));

		noBooksAvailable = findViewById(R.id.no_book_text_view);

		updateBooks();
	}

	@Override
	protected void onResume(){
		super.onResume();

		//Sempre que voltar a essa tela, pesquisa se há mais livros no banco
		new getBooksTask(this).execute(this);
	}

	private void updateBooks(){

		// Se a lista estiver vazia, RecyclerView fica invisivel e a mensagem fica visivel
		if(books.isEmpty()){
			bookRecyclerView.setVisibility(View.GONE);
			noBooksAvailable.setVisibility(View.VISIBLE);
		}
		else{
			bookRecyclerView.setVisibility(View.VISIBLE);
			noBooksAvailable.setVisibility(View.GONE);
		}

		// Cria um adapter para a RecyclerView e passa a lista de livros que aparecera na RecyclerView
		bookRecyclerView.setAdapter(new BookAdapter(books, this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_add_book, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == R.id.menu_item_add_book){
			Intent intent = new Intent(this, AddBookActivity.class);
			startActivity(intent);

			return true;
		}
		return false;
	}

	@Override
	public void refresh(List<Book> books){
		this.books = books;

		updateBooks();
	}
}