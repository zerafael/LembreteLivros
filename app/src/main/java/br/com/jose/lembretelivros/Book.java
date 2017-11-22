package br.com.jose.lembretelivros;

/**
 * Created by jose on 21/11/17.
 */

public class Book{

	private String name;
	private int numberPages;

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getNumberPages(){
		return numberPages;
	}

	public void setNumberPages(int numberPages){
		this.numberPages = numberPages;
	}
}