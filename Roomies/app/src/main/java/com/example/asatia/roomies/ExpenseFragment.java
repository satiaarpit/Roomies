package com.example.asatia.roomies;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExpenseFragment extends Fragment {

    MainActivity activity;
    TextView arpit,rutvij,valmik,utsav,nirav;
    FloatingActionButton back;
    public  void onAttach(Activity a)    {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    public ExpenseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_expense, container, false);
        Map<String,Double> map=activity.getExpense();
        arpit=(TextView)rootView.findViewById(R.id.arpit_expense);
        arpit.setText("Arpit : Spent $"+map.get("Arpit"));
        nirav=(TextView)rootView.findViewById(R.id.nirav_expense);
        nirav.setText("Nirav : Spent $"+map.get("Nirav"));
        rutvij=(TextView)rootView.findViewById(R.id.rutvij_expense);
        rutvij.setText("Rutvij : Spent $"+map.get("Rutvij"));
        utsav=(TextView)rootView.findViewById(R.id.utsav_expense);
        utsav.setText("Utsav : Spent $"+map.get("Utsav"));
        valmik=(TextView)rootView.findViewById(R.id.valmik_expense);
        valmik.setText("Valmik : Spent $"+map.get("Valmik"));
        back=(FloatingActionButton)rootView.findViewById(R.id.expense_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new BillList());
            }
        });
        return rootView;
    }
}
