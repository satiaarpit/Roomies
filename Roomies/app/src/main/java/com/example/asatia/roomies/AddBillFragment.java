package com.example.asatia.roomies;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddBillFragment extends Fragment {

    MainActivity activity;
    FloatingActionButton button,backButton;
    TextView date,amount,shop,payer,sharer;
    public AddBillFragment() {

    }
    public void onAttach(Activity a)    {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_add_bill, container, false);
        date=(TextView)rootView.findViewById(R.id.addBillDate);
        if(activity.newBillItem.getDate()!=null)    {
            date.setText(activity.newBillItem.getDate());
        }
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillDateFragment());
            }
        });
        amount=(TextView)rootView.findViewById(R.id.addBillAmount);
        if(activity.newBillItem.getAmount()!=null)
            amount.setText( activity.newBillItem.getAmount());
        amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillAmountFragment());
            }
        });
        shop =(TextView)rootView.findViewById(R.id.addBillShop);
        if(activity.newBillItem.getShop()!=null)
            shop.setText(activity.newBillItem.getShop());
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    activity.changeFragment(new AddBillShopFragment());
            }
        });
        payer=(TextView)rootView.findViewById(R.id.addBillPayer);
        if(activity.newBillItem.getPaidBy()!=null)
            payer.setText(activity.newBillItem.getPaidBy());
        payer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillPayerFragment());
            }
        });
        sharer=(TextView)rootView.findViewById(R.id.addBillShare);
        if(activity.newBillItem.getSharedBy()!=null)
            sharer.setText(activity.newBillItem.getSharedBy());
        sharer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillSharer());
            }
        });
        button=(FloatingActionButton)rootView.findViewById(R.id.addBillButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(activity.newBillItem.getAmount()==null||activity.newBillItem.getShop()==null||
                        activity.newBillItem.getPaidBy()==null||activity.newBillItem.getDate()==null||
                        activity.newBillItem.getSharedBy()==null)
                    Toast.makeText(activity.getApplicationContext(),"Please fill",Toast.LENGTH_SHORT);
                else    {
                    activity.addToBill();
                }
            }});
        backButton=(FloatingActionButton)rootView.findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new BillList());
            }
        });
        return rootView;
    }
}
