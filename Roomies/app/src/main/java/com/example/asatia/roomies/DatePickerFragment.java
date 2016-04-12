package com.example.asatia.roomies;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by asatia on 10/21/2015.
 */
public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText dateText;
    public DatePickerFragment() {

    }
    public  DatePickerFragment(View v)    {
        dateText=(EditText)v;
    }
    public Dialog onCreateDialog(Bundle savedInstances) {
        Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }
    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateText.setText(""+dayOfMonth+"/"+monthOfYear+"/"+year);
    }
}
