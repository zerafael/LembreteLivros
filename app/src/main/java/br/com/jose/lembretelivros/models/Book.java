package br.com.jose.lembretelivros.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.media.Image;

import java.io.Serializable;

/**
 * Created by jose on 21/11/17.
 */

@Entity
public class Book implements Serializable{

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "book_id")
	private int id;
	private String name;
	@ColumnInfo(name = "pages")
	private Integer numberPages;

	public Book(){
	}

	public Book(String name, int numberPages){
		this.name = name;
		this.numberPages = numberPages;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public Integer getNumberPages(){
		return numberPages;
	}

	public void setNumberPages(Integer numberPages){
		this.numberPages = numberPages;
	}
}