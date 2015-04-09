package no.altibox.slidecam.userInteraction.widgets.drawerToggle;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class CustomActionBarDrawerToggle extends ActionBarDrawerToggle {
    private OnDrawerOpenedListener onDrawerOpenedListener;
    private OnDrawerClosedListener onDrawerClosedListener;

    public CustomActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
        super(activity, drawerLayout, toolbar, openDrawerContentDescRes, closeDrawerContentDescRes);
    }

    @Override
    public void onDrawerOpened(View drawerView) {
        super.onDrawerOpened(drawerView);
        if (onDrawerOpenedListener != null) {
            onDrawerOpenedListener.opened();
        }
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        super.onDrawerClosed(drawerView);
        if (onDrawerClosedListener != null) {
            onDrawerClosedListener.closed();
        }
    }

    public void setOnDrawerOpenedListener(OnDrawerOpenedListener onDrawerOpenedListener) {
        this.onDrawerOpenedListener = onDrawerOpenedListener;
    }

    public void setOnDrawerClosedListener(OnDrawerClosedListener onDrawerClosedListener) {
        this.onDrawerClosedListener = onDrawerClosedListener;
    }
}
