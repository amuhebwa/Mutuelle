package edu.cmu.mutuelle.mutuelle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import edu.cmu.mutuelle.mutuelle.R;
import edu.cmu.mutuelle.mutuelle.adapters.ReportsAdapter;
import edu.cmu.mutuelle.mutuelle.models.Report;


public class Reports extends Fragment
{


    public Reports()
    {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.reports_fragment, container, false);
        ListView reportsListView = (ListView)view.findViewById(R.id.reportsListView);
        ArrayList<Report> dummyData = generateDummyData();
        reportsListView.setAdapter(new ReportsAdapter(getActivity(), dummyData));
        return view;
    }

    public ArrayList<Report> generateDummyData()
    {
        ArrayList<Report> dummyReportData = new ArrayList<>();
        Report report = new Report();
        report.setCheckedInDate("14-June-2016");
        report.setCheckedInTime("15:30pm");
        report.setHospitalCheckedIn("King Faisal Hospital");
        dummyReportData.add(report);

        report = new Report();
        report.setCheckedInDate("14-July-2016");
        report.setCheckedInTime("23:30pm");
        report.setHospitalCheckedIn("X Hospital");
        dummyReportData.add(report);
        return dummyReportData;
    }
}
