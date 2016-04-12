package com.example.asatia.roomies;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.ToggleButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity
 {
     Menu menu;
    BillListItem newBillItem;
    BillList billList=new BillList();
    BillDataBase database;
     ListView menuList;
     boolean isEdit=false;
     DrawerLayout drawerLayout;
     ActionBarDrawerToggle toggle;
    private static final int RESOLVE_CONNECTION_REQUEST_CODE = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database=new BillDataBase(this);
        newBillItem=new BillListItem();
        android.app.FragmentManager fragmentManager= getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, billList);
        fragmentTransaction.commit();
        android.support.v7.app.ActionBar bar=getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(0xFF64B5F6));
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        toggle=new ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.drawer_open,
                R.string.drawer_close
        );
        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(toggle);
        menuList=(ListView)findViewById(R.id.menu);
        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,new String[]{"Bills","Expenses","Contributions"});
        menuList.setAdapter(adapter);
        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        changeFragment(new BillList());
                        drawerLayout.closeDrawers();
                        break;
                    case 1:
                        changeFragment(new ExpenseFragment());
                        drawerLayout.closeDrawers();
                        break;
                    case 2:
                        changeFragment(new ContributionFragment());
                        drawerLayout.closeDrawers();
                        break;
                }
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setIcon(R.drawable.dolar_o);
    }

    protected void onPostCreate(Bundle savedInstances)  {
         super.onPostCreate(savedInstances);
         toggle.syncState();
     }

     public void onConfigurationChanged(Configuration config)    {
         super.onConfigurationChanged(config);
         toggle.onConfigurationChanged(config);
     }

    public void changeFragment(Fragment fragment)
    {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }


    public void addToBill()  {
        if(database.insertBill(newBillItem))    {
            newBillItem=new BillListItem();
            changeFragment(new BillList());
        }
    }

    public ArrayList<BillListItem> getBillList() {
        BillListItem[] item=database.getBills();
        ArrayList<BillListItem> arrayList=new ArrayList<BillListItem>();
        for(int i=0;i<item.length;i++)  {
            arrayList.add(item[i]);
        }
        return arrayList;
    }

    public Map<String,Double> getContribution() {
        return database.getBillContribution();
    }
    public void updateBill()    {
        if(database.updateBill(newBillItem)) {
            Toast.makeText(this,"Bill update Successfully",Toast.LENGTH_SHORT).show();
            newBillItem=new BillListItem();
            isEdit=false;
            changeFragment(new BillList());
        }
    }

     public Map<String,Double> getExpense() {
         return database.getBillExpense();
     }

    public void deleteBill()    {
        if(database.deleteBill(newBillItem.getID())) {
            Toast.makeText(this,"Bill deleted Successfully",Toast.LENGTH_SHORT).show();
            newBillItem=new BillListItem();
            isEdit=false;
            changeFragment(new BillList());
        }
    }

     public void deleteBills()    {
         if(database.deleteBills()) {
             Toast.makeText(this,"Bills deleted Successfully",Toast.LENGTH_SHORT).show();
             newBillItem=new BillListItem();
             changeFragment(new BillList());
         }
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu=menu;
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(toggle.onOptionsItemSelected(item))
            return true;
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
