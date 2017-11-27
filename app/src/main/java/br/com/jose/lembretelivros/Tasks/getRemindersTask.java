package br.com.jose.lembretelivros.Tasks;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

import br.com.jose.lembretelivros.database.AppDatabase;
import br.com.jose.lembretelivros.models.Reminder;

/**
 * Created by jose on 26/11/17.
 */

public class getRemindersTask extends AsyncTask<Integer, Void, List<Reminder>>{

	private Refreshable ref;
	private Context context;

	public getRemindersTask(Refreshable ref){
		this.ref = ref;
		this.context = (Context) ref;
	}

	@Override
	protected List<Reminder> doInBackground(Integer... integers){
		return AppDatabase.getInstance(context).reminderDao().getAllRemindersFromBook(integers[0]);
	}

	@Override
	protected void onPostExecute(List<Reminder> reminders){
		ref.refresh(reminders);
	}
}
