package br.com.jose.lembretelivros.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by jose on 25/11/17.
 */

public class Converters{

	@TypeConverter
	public static Date toDate(Long value){
		if(value == null)
			return null;

		return new Date(value);
	}

	@TypeConverter
	public static Long fromDate(Date date){
		if(date == null)
			return null;

		return date.getTime();
	}
}
