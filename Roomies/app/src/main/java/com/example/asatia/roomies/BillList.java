package com.example.asatia.roomies;


import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BillList extends Fragment {

    ListView listView;
    View rootView;
    MainActivity activity;
    ArrayList<BillListItem> arrayList;
    FloatingActionButton button,settle;

    public BillList() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity a)  {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    public interface BillListInterface  {
        public ArrayList<BillListItem> getBillList();
        public void addBillList(BillListItem item);
        public void setBillList(ArrayList<BillListItem> a);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =inflater.inflate(R.layout.fragment_bill_list, container, false);
        listView=(ListView)rootView.findViewById(R.id.bill);
        arrayList=activity.getBillList();
        BillListAdapter billListAdapter=new BillListAdapter(getActivity().getApplication().getApplicationContext(),R.layout.bill_list_item,arrayList);
        listView.setAdapter(billListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                activity.newBillItem.setID(arrayList.get(position).getID());
                activity.newBillItem.setDate(arrayList.get(position).getDate());
                activity.newBillItem.setAmount(arrayList.get(position).getAmount());
                activity.newBillItem.setShop(arrayList.get(position).getShop());
                activity.newBillItem.setPaidBy(arrayList.get(position).getPaidBy());
                activity.newBillItem.setSharedBy(arrayList.get(position).getSharedBy());
                ViewBillFragment frag=new ViewBillFragment();
                activity.changeFragment(frag);
            }
        });
        button=(FloatingActionButton)rootView.findViewById(R.id.floatingButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddBillFragment frag=new AddBillFragment();
                activity.changeFragment(frag);
            }
        });
        settle=(FloatingActionButton)rootView.findViewById(R.id.settleButton);
        settle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new SettleAmountFragment());
            }
        });
        return rootView;
    }
}
