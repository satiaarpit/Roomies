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


public class AddBillShopFragment extends Fragment {

    MainActivity activity;
    EditText shopName;
    FloatingActionButton button,backButton;
    public AddBillShopFragment() {
    }

    public void onAttach(Activity a)    {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_add_bill_shop, container, false);
        shopName=(EditText)rootView.findViewById(R.id.Shop);
        if(activity.newBillItem.getShop()!=null)
            shopName.setText(activity.newBillItem.getShop());
        button=(FloatingActionButton)rootView.findViewById(R.id.saveShop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shopName.getText()!=null)
                {
                InputMethodManager inputManager = (InputMethodManager)
                        activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                    activity.newBillItem.setShop(String.valueOf(shopName.getText()));
                    if(activity.isEdit)
                        activity.changeFragment(new ViewBillFragment());
                    else
                        activity.changeFragment(new AddBillFragment());
                }

            }
        });
        backButton=(FloatingActionButton)rootView.findViewById(R.id.backButtonShop);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillFragment());
            }
        });
        return rootView;
    }

}
