package edu.cmu.mutuelle.mutuelle.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import edu.cmu.mutuelle.mutuelle.PaymentDetails;
import edu.cmu.mutuelle.mutuelle.R;


public class Payment extends Fragment {


    public Payment() {
    }

    private Spinner selectPlanSpinner;
    private Button continueButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.payment_fragment, container, false);
        selectPlanSpinner = (Spinner) view.findViewById(R.id.selectplanSpinner);
        addDummyData(selectPlanSpinner);
        continueButton = (Button) view.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PaymentDetails.class));
            }
        });
        return view;
    }

    public void addDummyData(Spinner selectPlanSpinner) {
        List<String> dummyPlanData = new ArrayList<>();
        dummyPlanData.add("1 year/5000");
        dummyPlanData.add("2 years/8000");
        dummyPlanData.add("3 years/14000");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, dummyPlanData);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectPlanSpinner.setAdapter(dataAdapter);
    }
}
