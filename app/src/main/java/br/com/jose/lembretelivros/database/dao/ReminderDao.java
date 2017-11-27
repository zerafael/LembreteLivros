package br.com.jose.lembretelivros.database.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import br.com.jose.lembretelivros.models.Reminder;

/**
 * Created by jose on 26/11/17.
 */

@Dao
public interface ReminderDao{


	@Query("SELECT * FROM reminder")
	List<Reminder> getAllReminders();

	@Query("SELECT * FROM reminder WHERE book_id = :id")
	List<Reminder> getAllRemindersFromBook(int id);

	@Query("SELECT * FROM reminder WHERE reminder_id = :id")
	Reminder getReminderById(int id);

	@Insert
	void insertReminder(Reminder reminder);

	@Update
	void updateReminder(Reminder reminder);

	@Delete
	void deleteReminder(Reminder reminder);
}
