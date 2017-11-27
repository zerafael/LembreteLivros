package br.com.jose.lembretelivros.Tasks;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import br.com.jose.lembretelivros.database.AppDatabase;
import br.com.jose.lembretelivros.models.Book;

/**
 * Created by jose on 25/11/17.
 */

public class getBooksTask extends AsyncTask<Context, Void, List<Book>>{

	private Refreshable ref;

	public getBooksTask(Refreshable ref){
		this.ref = ref;
	}

	@Override
	protected List<Book> doInBackground(Context... contexts){
		return AppDatabase.getInstance(contexts[0]).bookDao().getAllBooks();
	}

	@Override
	protected void onPostExecute(List<Book> books){
		ref.refresh(books);
	}
}