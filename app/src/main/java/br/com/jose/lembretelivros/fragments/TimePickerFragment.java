package br.com.jose.lembretelivros.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.jose.lembretelivros.R;
import br.com.jose.lembretelivros.activities.AddReminderActivity;

/**
 * Created by jose on 26/11/17.
 */

public class TimePickerFragment extends DialogFragment{

	private static final String ARG_TIME = "arg_time";
	private static final int AM = 0;
	private static final int PM = 1;

	private TimePicker timePicker;

	public static TimePickerFragment newInstance(Date time){
		TimePickerFragment timeDialog = new TimePickerFragment();

		Bundle args = new Bundle();
		args.putSerializable(ARG_TIME, time);

		timeDialog.setArguments(args);

		return timeDialog;
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		View v = LayoutInflater.from(getActivity()).inflate(R.layout.reminder_time, null);

		timePicker = v.findViewById(R.id.time_picker_reminder);
		timePicker.setIs24HourView(true);
		setTime();

		return new AlertDialog.Builder(getActivity()).setView(v).setTitle(R.string.time_picker_title).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialogInterface, int i){
				int hour = timePicker.getCurrentHour();
				int minutes = timePicker.getCurrentMinute();
				int amPm = hour >= 12 ? PM : AM;
				hour = hour % 12;

				Calendar calendar = new GregorianCalendar();
				calendar.set(Calendar.HOUR, hour);
				calendar.set(Calendar.MINUTE, minutes);
				calendar.set(Calendar.AM_PM, amPm);
				AddReminderActivity.updateTime(calendar.getTime());
			}
		}).create();
	}

	private void setTime(){
		Date time = (Date)getArguments().getSerializable(ARG_TIME);

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(time);

		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);

		hour = calendar.get(Calendar.AM_PM) == 0 ? hour : hour + 12;

		timePicker.setCurrentHour(hour);
		timePicker.setCurrentMinute(minute);
	}
}
