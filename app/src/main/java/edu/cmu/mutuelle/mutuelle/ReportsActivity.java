package edu.cmu.mutuelle.mutuelle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import edu.cmu.mutuelle.mutuelle.adapters.ReportsAdapter;
import edu.cmu.mutuelle.mutuelle.models.Report;

public class ReportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reports);
        ListView reportsListView = (ListView) findViewById(R.id.reportsListView);
        ArrayList<Report> dummyData = generateDummyData();
        reportsListView.setAdapter(new ReportsAdapter(this, dummyData));
    }

    public ArrayList<Report> generateDummyData() {
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
