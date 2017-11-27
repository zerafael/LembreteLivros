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

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import br.com.jose.lembretelivros.R;
import br.com.jose.lembretelivros.activities.AddReminderActivity;

/**
 * Created by jose on 26/11/17.
 */

public class DatePickerFragment extends DialogFragment{

	private static final String ARG_DATE = "arg_date";

	private DatePicker datePicker;

	public static DatePickerFragment newInstance(Date date){
		DatePickerFragment dateDialog = new DatePickerFragment();

		Bundle args = new Bundle();
		args.putSerializable(ARG_DATE, date);

		dateDialog.setArguments(args);

		return dateDialog;
	}

	@NonNull
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		View v = LayoutInflater.from(getActivity()).inflate(R.layout.reminder_date, null);

		datePicker = v.findViewById(R.id.date_picker_reminder);
		setDate();

		return new AlertDialog.Builder(getActivity()).setView(v).setTitle(R.string.date_picker_title).setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener(){
			@Override
			public void onClick(DialogInterface dialogInterface, int i){
				int year = datePicker.getYear();
				int month = datePicker.getMonth();
				int day = datePicker.getDayOfMonth();
				AddReminderActivity.updateDate(new GregorianCalendar(year, month, day).getTime());
			}
		}).create();
	}

	private void setDate(){
		Date date = (Date)getArguments().getSerializable(ARG_DATE);

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);

		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);

		datePicker.updateDate(year, month, day);
	}
}
