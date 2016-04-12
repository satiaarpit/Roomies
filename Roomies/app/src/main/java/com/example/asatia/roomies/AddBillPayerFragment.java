package com.example.asatia.roomies;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddBillPayerFragment extends Fragment {

    MainActivity activity;
    String payer="";
    FloatingActionButton button,backButton;
    RadioButton one,two,three,four,five;
    public AddBillPayerFragment() {
        // Required empty public constructor
    }

    public void onAttach(Activity a)    {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_add_bill_payer, container, false);
        button=(FloatingActionButton)rootView.findViewById(R.id.savePayer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(payer!=null) {
                    activity.newBillItem.setPaidBy(payer);
                    if(activity.isEdit)
                        activity.changeFragment(new ViewBillFragment());
                    else
                        activity.changeFragment(new AddBillFragment());
                }
            }
        });
        one=(RadioButton)rootView.findViewById(R.id.arpit);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payer="Arpit";

            }
        });
        two=(RadioButton)rootView.findViewById(R.id.nirav);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payer="Nirav";
            }
        });
        three=(RadioButton)rootView.findViewById(R.id.rutvij);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payer="Rutvij";

            }
        });
        four=(RadioButton)rootView.findViewById(R.id.utsav);
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payer = "Utsav";

            }
        });
        five=(RadioButton)rootView.findViewById(R.id.valmik);
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payer="Valmik";

            }
        });
        backButton=(FloatingActionButton)rootView.findViewById(R.id.backButtonPayer);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillFragment());
            }
        });
        return  rootView;
    }
}
