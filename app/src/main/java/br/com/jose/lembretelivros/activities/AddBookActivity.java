package br.com.jose.lembretelivros.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.jose.lembretelivros.R;
import br.com.jose.lembretelivros.Tasks.insertBookTask;
import br.com.jose.lembretelivros.database.AppDatabase;
import br.com.jose.lembretelivros.models.Book;

public class AddBookActivity extends AppCompatActivity{

	private EditText name;
	private EditText numberPages;
	private Button saveButton;
	private Book book;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_book);

		book = new Book();

		name = findViewById(R.id.book_name);
		numberPages = findViewById(R.id.book_pages);
		saveButton = findViewById(R.id.save_button);

		saveButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				// Se algum dos campos do formulario nao foram preenchidos, não é salvo no BD
				if(name.getText().toString().equals("") || numberPages.getText().toString().equals(""))
					Toast.makeText(AddBookActivity.this, R.string.message_text_missing, Toast.LENGTH_SHORT).show();
				else {
					book.setName(name.getText().toString());
					book.setNumberPages(Integer.parseInt(numberPages.getText().toString()));

					//Inicia a task para inserir livro no banco de dados
					new insertBookTask(getBaseContext()).execute(book);

					// Ao terminar sai da activity e volta para a lista
					finish();
				}
			}
		});
	}
}