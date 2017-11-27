package br.com.jose.lembretelivros.Tasks;

import android.content.Context;
import android.os.AsyncTask;

import br.com.jose.lembretelivros.database.AppDatabase;
import br.com.jose.lembretelivros.models.Reminder;

/**
 * Created by jose on 26/11/17.
 */

public class insertReminderTask extends AsyncTask<Reminder, Void, Void>{

	private Context context;

	public insertReminderTask(Context context){
		this.context = context;
	}

	@Override
	protected Void doInBackground(Reminder... reminders){
		AppDatabase.getInstance(context).reminderDao().insertReminder(reminders[0]);

		return null;
	}
}
