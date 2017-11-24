package br.com.jose.lembretelivros.models;

import android.media.Image;

/**
 * Created by jose on 21/11/17.
 */

public class Book{

	private String name;
	private Integer numberPages;

	public Book(String name, int numberPages){
		this.name = name;
		this.numberPages = numberPages;
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