package edu.cmu.mutuelle.mutuelle.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import edu.cmu.mutuelle.mutuelle.R;


public class NearbyHospital extends Fragment
{


    public NearbyHospital()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.nearbyhospital_fragment, container, false);
    }

}
