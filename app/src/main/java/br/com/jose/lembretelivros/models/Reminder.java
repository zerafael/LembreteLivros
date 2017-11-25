package br.com.jose.lembretelivros.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by jose on 24/11/17.
 */

@Entity(foreignKeys = @ForeignKey(entity = Book.class,
									parentColumns = "book_id",
									childColumns = "book_id"))
public class Reminder{

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "reminder_id")
	private int id;
	private Date date;
	@ColumnInfo(name = "book_id")
	private int bookId;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public Date getDate(){
		return date;
	}

	public void setDate(Date date){
		this.date = date;
	}

	public int getBookId(){
		return bookId;
	}

	public void setBookId(int bookId){
		this.bookId = bookId;
	}
}
