package edu.cmu.mutuelle.mutuelle.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import edu.cmu.mutuelle.mutuelle.R;

/**
 * Created by root on 12/10/16.
 */

public class ViewCustomerImageFragment extends Fragment {

    ImageView customerImage;
    ImageButton imageCloseButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.view_customer_id_fragment, container, false);

        return view;
    }
}