package org.pursuit.fragmentsappfromscratch.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.pursuit.fragmentsappfromscratch.R;


public class InputFragment extends Fragment {
    private OnInputFragmentInteractionListener mListener;
    private Button sendTextButton;
    private EditText firstEditText;
    private EditText secondEditText;
    private EditText thirdEditText;

    public InputFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnInputFragmentInteractionListener){
            mListener = (OnInputFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString()
                    + " no interface implemented");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstEditText = view.findViewById(R.id.input_fragment_editText_1);
        secondEditText = view.findViewById(R.id.input_fragment_editText_2);
        thirdEditText = view.findViewById(R.id.input_fragment_editText_3);
        sendTextButton = view.findViewById(R.id.input_fragment_submit_button);
        sendTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = firstEditText.getText().toString();
                String input2 = secondEditText.getText().toString();
                String input3 = thirdEditText.getText().toString();
                onButtonPressed(input1,input2,input3);
                mListener.onInputFragmentInteraction(input1,input2,input3);
//                Fragment fragment = null;
//                fragment = new AboutFragment();
//                replaceFragment(fragment);

            }
        });

    }

    public void onButtonPressed(String input, String input2, String inpout3) {
        if (mListener != null) {
            mListener.onInputFragmentInteraction(input,input2,inpout3);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnInputFragmentInteractionListener {
        void onInputFragmentInteraction(String input, String input2, String input3);
    }
    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.main_activity_container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
