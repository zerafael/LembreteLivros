package br.com.jose.lembretelivros.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.jose.lembretelivros.R;
import br.com.jose.lembretelivros.activities.BookDetailsActivity;
import br.com.jose.lembretelivros.models.Book;

/**
 * Created by jose on 23/11/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookHolder>{

	private List<Book> books;
	private Context context;

	public class BookHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

		private Book book;

		private TextView name;
		private TextView pages;
		//private ImageView image;

		public BookHolder(View itemView){
			super(itemView);
			itemView.setOnClickListener(this);

			name = itemView.findViewById(R.id.item_list_book_name);
			pages = itemView.findViewById(R.id.item_list_book_pages);
			//image = itemView.findViewById(R.id.item_list_book_image);
		}

		public void bindBook(Book book){
			this.book = book;
			name.setText(book.getName());
			pages.setText(book.getNumberPages().toString());
		}

		@Override
		public void onClick(View view){
			Intent intent = new Intent(context, BookDetailsActivity.class);
			intent.putExtra("book", book);
			context.startActivity(intent);
		}
	}

	public BookAdapter(List<Book> books, Context context){
		this.books = books;
		this.context = context;
	}

	@Override
	public BookHolder onCreateViewHolder(ViewGroup parent, int viewType){
		View view = LayoutInflater.from(context).inflate(R.layout.item_list_book, parent, false);

		return new BookHolder(view);
	}

	@Override
	public void onBindViewHolder(BookHolder holder, int position){
		Book book = books.get(position);

		holder.bindBook(book);
	}

	@Override
	public int getItemCount(){
		return books.size();
	}
}