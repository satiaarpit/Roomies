package com.example.asatia.roomies;


import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettleAmountFragment extends Fragment {

    MainActivity activity;
    TextView arpit,rutvij,valmik,utsav,nirav;
    FloatingActionButton back,settle;
    public SettleAmountFragment() {
        // Required empty public constructor
    }
    public  void onAttach(Activity a)    {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        double amount[]=new double [5];
        View rootView=inflater.inflate(R.layout.fragment_settle_amount, container, false);
        ArrayList<BillListItem> items=activity.getBillList();
        BillListItem bill;
        for(int i=0;i<items.size();i++) {
            bill=items.get(i);
            String sharer[]=bill.getSharedBy().split(" ");
            double share=Double.parseDouble(bill.getAmount())/sharer.length;
            for(int j=0;j<sharer.length;j++)    {
                switch (sharer[j])  {
                    case "Arpit":
                        amount[0]+=share;
                        break;
                    case "Nirav":
                        amount[1]+=share;
                        break;
                    case "Rutvij":
                        amount[2]+=share;
                        break;
                    case "Utsav":
                        amount[3]+=share;
                        break;
                    case "Valmik":
                        amount[4]+=share;
                        break;
                }
            }
            switch (bill.getPaidBy())   {
                case "Arpit":
                    amount[0]-=Double.parseDouble(bill.getAmount());
                    break;
                case "Nirav":
                    amount[1]-=Double.parseDouble(bill.getAmount());
                    break;
                case "Rutvij":
                    amount[2]-=Double.parseDouble(bill.getAmount());
                    break;
                case "Utsav":
                    amount[3]-=Double.parseDouble(bill.getAmount());
                    break;
                case "Valmik":
                    amount[4]-=Double.parseDouble(bill.getAmount());
                    break;
            }
        }
        arpit=(TextView)rootView.findViewById(R.id.arpitAmount);
        if(amount[0]<0)
            arpit.setText("Arpit : Receives $"+(Math.round(Math.abs(amount[0])*100))/100.0);
        else
            arpit.setText("Arpit : Gives $"+(Math.round(Math.abs(amount[0])*100))/100.0);
        nirav=(TextView)rootView.findViewById(R.id.niravAmount);
        if(amount[1]<0)
            nirav.setText("Nirav : Receives $"+(Math.round(Math.abs(amount[1])*100))/100.0);
        else
            nirav.setText("Nirav : Gives $"+(Math.round(Math.abs(amount[1])*100))/100.0);
        rutvij=(TextView)rootView.findViewById(R.id.rutvijAmount);
        if(amount[2]<0)
            rutvij.setText("Rutvij : Receives $"+(Math.round(Math.abs(amount[2])*100))/100.0);
        else
            rutvij.setText("Rutvij : Gives $"+(Math.round(Math.abs(amount[2])*100))/100.0);
        utsav=(TextView)rootView.findViewById(R.id.utsavAmount);
        if(amount[3]<0)
            utsav.setText("Utsav : Receives $"+(Math.round(Math.abs(amount[3])*100))/100.0);
        else
            utsav.setText("Utsav : Gives $"+(Math.round(Math.abs(amount[3])*100))/100.0);
        valmik=(TextView)rootView.findViewById(R.id.valmikAmount);
        if(amount[4]<0)
            valmik.setText("Valmik : Receives $"+(Math.round(Math.abs(amount[4])*100))/100.0);
        else
            valmik.setText("Valmik : Gives $"+(Math.round(Math.abs(amount[4])*100))/100.0);
        back=(FloatingActionButton)rootView.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new BillList());
            }
        });
        settle=(FloatingActionButton)rootView.findViewById(R.id.settle);
        settle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new ConfirmFragment());
            }
        });
        return rootView;
    }
}
