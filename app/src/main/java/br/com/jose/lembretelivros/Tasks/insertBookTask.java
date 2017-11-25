package br.com.jose.lembretelivros.Tasks;

import android.content.Context;
import android.os.AsyncTask;

import br.com.jose.lembretelivros.database.AppDatabase;
import br.com.jose.lembretelivros.models.Book;

/**
 * Created by jose on 25/11/17.
 */

public class insertBookTask extends AsyncTask<Book, Void, Void>{

	private Context context;

	public insertBookTask(Context context){
		this.context = context;
	}

	@Override
	protected Void doInBackground(Book... books){
		AppDatabase.getInstance(context).bookDao().insertBook(books[0]);

		return null;
	}
}