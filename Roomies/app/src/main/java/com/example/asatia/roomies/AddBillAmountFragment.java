package com.example.asatia.roomies;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class AddBillAmountFragment extends Fragment {

    MainActivity activity;
    EditText amount;
    FloatingActionButton button,backButton;
    public void onAttach(Activity a)    {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    public AddBillAmountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_add_bill_amount, container, false);
        amount=(EditText)rootView.findViewById(R.id.Amount);
        if(activity.newBillItem.getAmount()!=null)
            amount.setText(activity.newBillItem.getAmount());
        button=(FloatingActionButton)rootView.findViewById(R.id.saveAmount);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amount.getText()!=null)    {
                    InputMethodManager inputManager = (InputMethodManager)
                            activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    try {
                        String text = String.valueOf(amount.getText());
                        activity.newBillItem.setAmount(text);
                        if(activity.isEdit)
                            activity.changeFragment(new ViewBillFragment());
                        else
                            activity.changeFragment(new AddBillFragment());
                    } catch (Exception e)   {
                        Toast.makeText(activity.getApplicationContext(),"Enter valid amount",Toast.LENGTH_SHORT);
                    }
                }
            }
        });
        backButton=(FloatingActionButton)rootView.findViewById(R.id.backButtonAmount);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillFragment());
            }
        });
        return rootView;
    }
}
