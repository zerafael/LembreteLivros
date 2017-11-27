package br.com.jose.lembretelivros.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.jose.lembretelivros.R;
import br.com.jose.lembretelivros.Tasks.Refreshable;
import br.com.jose.lembretelivros.Tasks.getRemindersTask;
import br.com.jose.lembretelivros.adapters.ReminderAdapter;
import br.com.jose.lembretelivros.models.Book;
import br.com.jose.lembretelivros.models.Reminder;

/**
 * Created by jose on 25/11/17.
 */

public class BookDetailsActivity extends AppCompatActivity implements View.OnClickListener, Refreshable<Reminder>{

	private Book book;
	private EditText name;
	private EditText numberPages;
	private FloatingActionButton addReminder;
	private RecyclerView reminderRecyclerView;

	private List<Reminder> reminders = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_book_detail);
		book = (Book)getIntent().getExtras().get("book");

		name = findViewById(R.id.detail_book_name);
		name.setEnabled(false);
		name.setText(book.getName());

		numberPages = findViewById(R.id.detail_book_pages);
		numberPages.setEnabled(false);
		numberPages.setText(book.getNumberPages().toString());

		reminderRecyclerView = findViewById(R.id.reminder_recycler_view);
		reminderRecyclerView.setLayoutManager(new LinearLayoutManager(this));

		addReminder = findViewById(R.id.floating_menu_add_reminder);
		addReminder.setOnClickListener(this);
	}

	@Override
	protected void onResume(){
		super.onResume();

		new getRemindersTask(this).execute(book.getId());
	}

	public void updateReminders(){
		reminderRecyclerView.setAdapter(new ReminderAdapter(reminders, this));
	}

	@Override
	public void onClick(View view){
		Intent intent = new Intent(this, AddReminderActivity.class);
		intent.putExtra("bookId", book.getId());

		startActivity(intent);
	}

	// É chamado da Task para passar os dados entre a Task e a Activity
	@Override
	public void refresh(List<Reminder> reminders){
		this.reminders = reminders;

		//Manda atualizar a recyclerView com novos lembretes
		updateReminders();
	}
}
