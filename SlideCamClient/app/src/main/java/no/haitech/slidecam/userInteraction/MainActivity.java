package no.haitech.slidecam.userInteraction;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import butterknife.InjectView;
import no.haitech.slidecam.R;
import no.haitech.slidecam.userInteraction.widgets.drawerToggle.CustomActionBarDrawerToggle;


public class MainActivity extends ActionBarActivity {
    @InjectView(R.id.drawer_layout) DrawerLayout drawerLayout;
    @InjectView(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        setupActionBar();
        setupDrawerLayout();
    }

    private void setupActionBar() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }

    private void setupDrawerLayout() {
        CustomActionBarDrawerToggle drawerToggle = new CustomActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.general_drawer_open, R.string.general_drawer_closed);
        drawerToggle.setOnDrawerOpenedListener(() -> {
            // Change title.
        });
        drawerToggle.setOnDrawerClosedListener(() -> {
            // Change to previous title.
        });
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
}
