package br.com.jose.lembretelivros.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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

	public Reminder(){
		this.date = new GregorianCalendar().getTime();
	}

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

	// Altera somente a data
	public void setOnlyDate(Date date){
		//Converte date para Calendar
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(this.date);

		//Pega as horas e os minutos, pois não devem ser alterados
		int hour = calendar.get(Calendar.HOUR);
		int minutes = calendar.get(Calendar.MINUTE);
		int amPm = calendar.get(Calendar.AM_PM);

		//Seta uma nova data
		calendar.setTime(date);
		//Seta as horas e os minutos originais na nova data
		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.MINUTE, minutes);
		calendar.set(Calendar.AM_PM, amPm);

		this.date = calendar.getTime();
	}

	// Altera somente o horario
	public void setTime(Date time){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(this.date);

		//Armazena o dia, mes e ano em variaveis
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		//Seta uma nova data, com o novo horario
		calendar.setTime(time);
		//Seta o dia, mes e ano no novo horario
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);

		this.date = calendar.getTime();
	}

	public int getBookId(){
		return bookId;
	}

	public void setBookId(int bookId){
		this.bookId = bookId;
	}

	public String convertDateToString(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		return dateFormat.format(this.date);
	}

	public String convertTimeToString(){
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

		return timeFormat.format(this.date);
	}
}
