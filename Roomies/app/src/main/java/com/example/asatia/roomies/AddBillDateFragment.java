package com.example.asatia.roomies;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddBillDateFragment extends Fragment {

    MainActivity activity;
    FloatingActionButton button,backButton;
    EditText dateText;
    public AddBillDateFragment() {
        // Required empty public constructor
    }
    public void onAttach(Activity a)    {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_add_bill_date, container, false);
        dateText=(EditText)rootView.findViewById(R.id.Date);
        if(activity.newBillItem.getDate()!=null)
            dateText.setText(activity.newBillItem.getDate());
        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerFragment datePicker=new DatePickerFragment(dateText);
                FragmentTransaction ft=activity.getFragmentManager().beginTransaction();
                datePicker.show(ft,"Date");
            }
        });
        button=(FloatingActionButton)rootView.findViewById(R.id.saveDate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.newBillItem.setDate(" " + String.valueOf(dateText.getText()));
                if(activity.isEdit)
                    activity.changeFragment(new ViewBillFragment());
                else
                    activity.changeFragment(new AddBillFragment());
            }
        });
        backButton=(FloatingActionButton)rootView.findViewById(R.id.backButtonDate);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillFragment());
            }
        });
        return rootView;
    }

}
