package br.com.jose.lembretelivros.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.jose.lembretelivros.R;
import br.com.jose.lembretelivros.models.Reminder;

/**
 * Created by jose on 26/11/17.
 */

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ReminderHolder>{

	private List<Reminder> reminders;
	private Context context;

	public class ReminderHolder extends RecyclerView.ViewHolder{
		private Reminder reminder;

		private TextView date;
		private TextView time;

		public ReminderHolder(View itemView){
			super(itemView);

			date = itemView.findViewById(R.id.item_list_reminder_date);
			time = itemView.findViewById(R.id.item_list_reminder_time);
		}

		public void bindReminder(Reminder reminder){
			this.reminder = reminder;
			date.setText(reminder.convertDateToString());
			time.setText(reminder.convertTimeToString());
		}
	}

	public ReminderAdapter(List<Reminder> reminders, Context context){
		this.reminders = reminders;
		this.context = context;
	}

	@Override
	public ReminderHolder onCreateViewHolder(ViewGroup parent, int viewType){
		View view = LayoutInflater.from(context).inflate(R.layout.item_list_reminder, parent, false);

		return new ReminderAdapter.ReminderHolder(view);
	}

	@Override
	public void onBindViewHolder(ReminderHolder holder, int position){
		Reminder reminder = reminders.get(position);

		holder.bindReminder(reminder);
	}

	@Override
	public int getItemCount(){
		return reminders.size();
	}
}
