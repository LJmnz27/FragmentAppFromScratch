package org.pursuit.fragmentsappfromscratch.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.pursuit.fragmentsappfromscratch.R;


public class DisplayFragement extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private View rootView;
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private TextView displayTextView;


    public DisplayFragement() {
        // Required empty public constructor
    }

    public static DisplayFragement newInstance(String mParam1, String mParam2, String mParam3) {
        DisplayFragement fragment = new DisplayFragement();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, mParam1);
        args.putString(ARG_PARAM2, mParam2);
        args.putString(ARG_PARAM3, mParam3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView= inflater.inflate(R.layout.fragment_display_fragement,container,false);
        displayTextView =rootView.findViewById(R.id.display_text_view);
        String newText = mParam1 + " " + mParam2 +" "+ mParam3;
        displayTextView.setText(newText);
        return rootView;
    }

}
