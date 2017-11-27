package br.com.jose.lembretelivros.activities;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Date;

import br.com.jose.lembretelivros.R;
import br.com.jose.lembretelivros.Tasks.insertReminderTask;
import br.com.jose.lembretelivros.fragments.DatePickerFragment;
import br.com.jose.lembretelivros.fragments.TimePickerFragment;
import br.com.jose.lembretelivros.models.Reminder;

public class AddReminderActivity extends AppCompatActivity{

	private static final String DIALOG_DATE = "DialogDate";
	private static final String DIALOG_TIME = "DialogTime";

	private static Button dateButton;
	private static Button timeButton;

	private static Reminder reminder;

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_reminder);

		reminder = new Reminder();
		reminder.setBookId((int)getIntent().getExtras().get("bookId"));

		dateButton = findViewById(R.id.date_button_reminder);
		dateButton.setText(reminder.convertDateToString());
		dateButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				FragmentManager manager = getSupportFragmentManager();
				DatePickerFragment dateDialog = DatePickerFragment.newInstance(reminder.getDate());
				dateDialog.show(manager, DIALOG_DATE);
			}
		});

		timeButton = findViewById(R.id.time_button_reminder);
		timeButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				FragmentManager manager = getSupportFragmentManager();
				TimePickerFragment timeDialog = TimePickerFragment.newInstance(reminder.getDate());
				timeDialog.show(manager, DIALOG_TIME);
			}
		});
		timeButton.setText(reminder.convertTimeToString());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu){
		MenuInflater inflater = getMenuInflater();

		inflater.inflate(R.menu.menu_add_reminder, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item){
		if(item.getItemId() == R.id.menu_item_add_reminder){
			new insertReminderTask(getBaseContext()).execute(reminder);
			finish();
			return true;
		}
		return false;
	}

	// Atualiza a data do lembrete e do botão
	public static void updateDate(Date date){
		reminder.setOnlyDate(date);
		dateButton.setText(reminder.convertDateToString());
	}

	// Atualiza o horario do lembrete e do botão
	public static void updateTime(Date time){
		reminder.setTime(time);
		timeButton.setText(reminder.convertTimeToString());
	}
}
