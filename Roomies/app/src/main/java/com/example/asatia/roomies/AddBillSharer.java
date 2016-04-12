package com.example.asatia.roomies;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddBillSharer extends Fragment {

    MainActivity activity;
    CheckedTextView arpit,nirav,utsav,rutvij,valmik,all;
    FloatingActionButton button,backButton;
    public AddBillSharer() {
        // Required empty public constructor
    }
    public void onAttach(Activity a)    {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView= inflater.inflate(R.layout.fragment_add_bill_sharer, container, false);
        all=(CheckedTextView)rootView.findViewById(R.id.checkBoxAll);
        arpit=(CheckedTextView)rootView.findViewById(R.id.checkBoxArpit);
        nirav=(CheckedTextView)rootView.findViewById(R.id.checkBoxNirav);
        rutvij=(CheckedTextView)rootView.findViewById(R.id.checkBoxRutvij);
        utsav=(CheckedTextView)rootView.findViewById(R.id.checkBoxUtsav);
        valmik=(CheckedTextView)rootView.findViewById(R.id.checkBoxValmik);
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!all.isChecked())    {
                    all.setCheckMarkDrawable(R.drawable.checked);
                    all.setChecked(true);
                    arpit.setClickable(false);
                    arpit.setTextColor(Color.parseColor("#B3B3B3"));
                    arpit.setCheckMarkDrawable(R.drawable.checked);
                    nirav.setClickable(false);
                    nirav.setTextColor(Color.parseColor("#B3B3B3"));
                    nirav.setCheckMarkDrawable(R.drawable.checked);
                    rutvij.setClickable(false);
                    rutvij.setTextColor(Color.parseColor("#B3B3B3"));
                    rutvij.setCheckMarkDrawable(R.drawable.checked);
                    utsav.setClickable(false);
                    utsav.setTextColor(Color.parseColor("#B3B3B3"));
                    utsav.setCheckMarkDrawable(R.drawable.checked);
                    valmik.setClickable(false);
                    valmik.setTextColor(Color.parseColor("#B3B3B3"));
                    valmik.setCheckMarkDrawable(R.drawable.checked);
                }
                else  {
                    all.setCheckMarkDrawable(R.drawable.unchecked);
                    all.setChecked(false);
                    arpit.setClickable(true);
                    arpit.setTextColor(Color.parseColor("#000000"));
                    arpit.setCheckMarkDrawable(R.drawable.unchecked);
                    rutvij.setClickable(true);
                    rutvij.setTextColor(Color.parseColor("#000000"));
                    rutvij.setCheckMarkDrawable(R.drawable.unchecked);
                    nirav.setClickable(true);
                    nirav.setTextColor(Color.parseColor("#000000"));
                    nirav.setCheckMarkDrawable(R.drawable.unchecked);
                    utsav.setClickable(true);
                    utsav.setTextColor(Color.parseColor("#000000"));
                    utsav.setCheckMarkDrawable(R.drawable.unchecked);
                    valmik.setClickable(true);
                    valmik.setTextColor(Color.parseColor("#000000"));
                    valmik.setCheckMarkDrawable(R.drawable.unchecked);
                }
            }
        });
        arpit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!arpit.isChecked()) {
                    arpit.setCheckMarkDrawable(R.drawable.checked);
                    arpit.setChecked(true);
                }
                else {
                    arpit.setCheckMarkDrawable(R.drawable.unchecked);
                    arpit.setChecked(false);
                }
            }
        });
        nirav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!nirav.isChecked()) {
                    nirav.setCheckMarkDrawable(R.drawable.checked);
                    nirav.setChecked(true);
                }
                else {
                    nirav.setCheckMarkDrawable(R.drawable.unchecked);
                    nirav.setChecked(false);
                }
            }
        });
        rutvij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!rutvij.isChecked()) {
                    rutvij.setCheckMarkDrawable(R.drawable.checked);
                    rutvij.setChecked(true);
                } else {
                    rutvij.setCheckMarkDrawable(R.drawable.unchecked);
                    rutvij.setChecked(false);
                }
            }
        });
        utsav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!utsav.isChecked()) {
                    utsav.setCheckMarkDrawable(R.drawable.checked);
                    utsav.setChecked(true);
                } else {
                    utsav.setCheckMarkDrawable(R.drawable.unchecked);
                    utsav.setChecked(false);
                }
            }
        });
        valmik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!valmik.isChecked()) {
                    valmik.setCheckMarkDrawable(R.drawable.checked);
                    valmik.setChecked(true);
                } else {
                    valmik.setCheckMarkDrawable(R.drawable.unchecked);
                    valmik.setChecked(false);
                }
            }
        });
        button=(FloatingActionButton)rootView.findViewById(R.id.saveSharer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String share="";
                if(all.isChecked())
                    share+="Arpit Nirav Rutvij Utsav Valmik";
                else {
                    if (arpit.isChecked())
                        share += (String) arpit.getText() + " ";
                    if (nirav.isChecked())
                        share += (String) nirav.getText() + " ";
                    if (rutvij.isChecked())
                        share += (String) rutvij.getText() + " ";
                    if (valmik.isChecked())
                        share += (String) valmik.getText() + " ";
                    if (utsav.isChecked())
                        share += (String) utsav.getText() + " ";
                }
                activity.newBillItem.setSharedBy(share);
                if(activity.isEdit)
                    activity.changeFragment(new ViewBillFragment());
                else
                    activity.changeFragment(new AddBillFragment());
            }
        });
        backButton=(FloatingActionButton)rootView.findViewById(R.id.backButtonSharer);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new AddBillFragment());
            }
        });
        return rootView;
    }


}
