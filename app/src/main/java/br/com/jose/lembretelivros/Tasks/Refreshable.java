package br.com.jose.lembretelivros.Tasks;

import java.util.List;

import br.com.jose.lembretelivros.models.Book;

/**
 * Created by jose on 25/11/17.
 */

public interface Refreshable{

	void refresh(List<Book> books);
}
