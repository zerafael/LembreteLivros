package br.com.jose.lembretelivros.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import br.com.jose.lembretelivros.database.dao.BookDao;
import br.com.jose.lembretelivros.models.Book;
import br.com.jose.lembretelivros.models.Reminder;


/**
 * Created by jose on 24/11/17.
 */
@Database(entities = {Book.class, Reminder.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase{

	private static final String DATABASE_NAME = "lembrete-livros";

	public abstract BookDao bookDao();

	private static AppDatabase instance;

	public static AppDatabase getInstance(Context context){
		if(instance == null)
			instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();

		return instance;
	}
}
