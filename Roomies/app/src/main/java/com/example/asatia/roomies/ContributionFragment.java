package com.example.asatia.roomies;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContributionFragment extends Fragment {
    MainActivity activity;
    TextView arpit,rutvij,valmik,utsav,nirav;
    FloatingActionButton back;
    public  void onAttach(Activity a)    {
        super.onAttach(a);
        activity=(MainActivity)a;
    }

    public ContributionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate(R.layout.fragment_contribution, container, false);
        Map<String,Double> map=activity.getContribution();
        arpit=(TextView)rootView.findViewById(R.id.arpit_contribution);
        arpit.setText("Arpit : Contributes $"+map.get("Arpit"));
        nirav=(TextView)rootView.findViewById(R.id.nirav_contribution);
        nirav.setText("Nirav : Contributes $"+map.get("Nirav"));
        rutvij=(TextView)rootView.findViewById(R.id.rutvij_contribution);
        rutvij.setText("Rutvij : Contributes $"+map.get("Rutvij"));
        utsav=(TextView)rootView.findViewById(R.id.utsav_contribution);
        utsav.setText("Utsav : Contributes $"+map.get("Utsav"));
        valmik=(TextView)rootView.findViewById(R.id.valmik_contribution);
        valmik.setText("Valmik : Contributes $"+map.get("Valmik"));
        back=(FloatingActionButton)rootView.findViewById(R.id.contribution_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.changeFragment(new BillList());
            }
        });
        return rootView;
    }
}
