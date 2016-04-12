package com.example.asatia.roomies;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewBillFragment extends Fragment {

    MainActivity activity;
    FloatingActionButton savebutton,backButton,deleteButton;
    TextView date,amount,shop,payer,sharer;
    public ViewBillFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity a)  {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_view_bill, container, false);
        activity.isEdit=true;
        date=(TextView)rootView.findViewById(R.id.billDate);
        date.setText(activity.newBillItem.getDate());
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillDateFragment());
            }
        });
        amount=(TextView)rootView.findViewById(R.id.billAmount);
        amount.setText(activity.newBillItem.getAmount());
        amount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillAmountFragment());
            }
        });
        shop=(TextView)rootView.findViewById(R.id.billShop);
        shop.setText(activity.newBillItem.getShop());
        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillShopFragment());
            }
        });
        sharer=(TextView)rootView.findViewById(R.id.billShare);
        sharer.setText(activity.newBillItem.getSharedBy());
        sharer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillSharer());
            }
        });
        payer=(TextView)rootView.findViewById(R.id.billPayer);
        payer.setText(activity.newBillItem.getPaidBy());
        payer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillPayerFragment());
            }
        });
        savebutton=(FloatingActionButton)rootView.findViewById(R.id.saveBillButton);
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder hint=new AlertDialog.Builder(activity);
                hint.setMessage("Do you want to save changes?");
                hint.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.updateBill();
                    }
                });
                hint.setNegativeButton("NO",new DialogInterface.OnClickListener()  {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog=hint.create();
                alertDialog.show();
            }
        });
        deleteButton=(FloatingActionButton)rootView.findViewById(R.id.deleteBillButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder hint=new AlertDialog.Builder(activity);
                hint.setMessage("Do you want to delete this bill?");
                hint.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.deleteBill();
                    }
                });
                hint.setNegativeButton("NO",new DialogInterface.OnClickListener()  {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog=hint.create();
                alertDialog.show();
            }
        });
        backButton=(FloatingActionButton)rootView.findViewById(R.id.editBillBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder hint = new AlertDialog.Builder(activity);
                hint.setMessage("Do you want to leave?");
                hint.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        activity.changeFragment(new BillList());
                    }
                });
                hint.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog alertDialog = hint.create();
                alertDialog.show();
            }
        });
        return rootView;
    }

}
