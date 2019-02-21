package org.pursuit.fragmentsappfromscratch;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.pursuit.fragmentsappfromscratch.fragments.DisplayFragement;
import org.pursuit.fragmentsappfromscratch.fragments.InputFragment;

public class MainActivity extends AppCompatActivity implements InputFragment.OnInputFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputFragment inputFragment = InputFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_activity_container, inputFragment).commit();

    }

    @Override
    public void onInputFragmentInteraction(String input, String input2, String input3) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_activity_container, DisplayFragement.newInstance(input,input2, input3))
                .commit();
    }
}
