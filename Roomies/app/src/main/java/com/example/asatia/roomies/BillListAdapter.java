package com.example.asatia.roomies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asatia on 10/12/2015.
 */
public class BillListAdapter extends ArrayAdapter<BillListItem> {

    Context context;
    ArrayList<BillListItem> arrayList;
    LayoutInflater inflater;
    int resource;

    public BillListAdapter(Context context, int resource,ArrayList<BillListItem> arrayList) {
        super(context, resource,arrayList);
        this.context = context;
        this.arrayList = arrayList;
        this.resource=resource;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public View getView (int position, View convertView, ViewGroup parent)  {
        ViewHolder viewHolder=null;
        if(convertView==null)    {
            convertView=inflater.inflate(resource,null);
            viewHolder=new ViewHolder();
            viewHolder.dateLabel=(TextView)convertView.findViewById(R.id.dateLabel);
            viewHolder.date=(TextView)convertView.findViewById(R.id.date);
            viewHolder.shop=(TextView)convertView.findViewById(R.id.shop);
            viewHolder.shopLabel=(TextView)convertView.findViewById(R.id.shopLabel);
            viewHolder.paidBy=(TextView)convertView.findViewById(R.id.paidBy);
            viewHolder.paidByLabel=(TextView)convertView.findViewById(R.id.paidByLabel);
            viewHolder.amount=(TextView)convertView.findViewById(R.id.amount);
            viewHolder.amountLabel=(TextView)convertView.findViewById(R.id.amountLabel);
            viewHolder.sharedBy=(TextView)convertView.findViewById(R.id.sharedBy);
            viewHolder.sharedByLabel=(TextView)convertView.findViewById(R.id.sharedByLabel);
            convertView.setTag(viewHolder);
            }
        else    {
            viewHolder=(ViewHolder)convertView.getTag();}
        BillListItem billList=arrayList.get(position);
        viewHolder.dateLabel.setText("Date :");
        viewHolder.date.setText(billList.getDate());
        viewHolder.amount.setText(String.valueOf(billList.getAmount()));
        viewHolder.shop.setText(billList.getShop());
        viewHolder.sharedBy.setText(billList.getSharedBy());
        viewHolder.paidBy.setText(billList.getPaidBy());
        return convertView;
        }
class ViewHolder{
    public TextView dateLabel,date,shop,shopLabel,paidBy,paidByLabel,amount,amountLabel,sharedBy,sharedByLabel;
}

}
