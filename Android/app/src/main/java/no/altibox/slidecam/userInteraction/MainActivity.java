package no.altibox.slidecam.userInteraction;

import android.app.Activity;
import android.os.Bundle;

import butterknife.ButterKnife;
import no.altibox.slidecam.R;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }
}