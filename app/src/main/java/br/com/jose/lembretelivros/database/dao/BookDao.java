package br.com.jose.lembretelivros.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.jose.lembretelivros.models.Book;

/**
 * Created by jose on 24/11/17.
 */

@Dao
public interface BookDao {

	@Query("SELECT * FROM book")
	List<Book> getAllBooks();

	@Query("SELECT * FROM book WHERE book_id = :id")
	Book getBookById(int id);

	@Insert
	void insertBook(Book book);

	@Update
	void updateBook(Book book);

	@Delete
	void deleteBook(Book book);
}
