package edu.cmu.mutuelle.mutuelle.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.cmu.mutuelle.mutuelle.R;
import edu.cmu.mutuelle.mutuelle.models.Report;


public class ReportsAdapter extends BaseAdapter
{
    private static ArrayList<Report> reportsList;
    private LayoutInflater layoutInflater;
    public ReportsAdapter(Context context, ArrayList<Report> reports){
        reportsList = reports;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount()
    {
        return reportsList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return reportsList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;
        if (convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.reports_list, null);
            viewHolder = new ViewHolder();
            viewHolder.visitedDate = (TextView)convertView.findViewById(R.id.visited_date);
            viewHolder.checkedInTime = (TextView)convertView.findViewById(R.id.checkedInTime);
            viewHolder.hospitalCheckedIn = (TextView)convertView.findViewById(R.id.checkedInHospital);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.visitedDate.setText(reportsList.get(position).getCheckedInDate());
        viewHolder.hospitalCheckedIn.setText(reportsList.get(position).getHospitalCheckedIn());
        viewHolder.checkedInTime.setText(reportsList.get(position).getCheckedInTime());
        return convertView;
    }
    public static class ViewHolder
    {
        TextView visitedDate;
        TextView checkedInTime;
        TextView hospitalCheckedIn;

        public ViewHolder()
        {

        }
    }
}
