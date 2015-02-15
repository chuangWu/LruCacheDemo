package chuang.lrucachedemo.android.activity;

import android.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import chuang.lrucachedemo.R;
import chuang.lrucachedemo.android.fragment.ImgsListFragment;


public class MainActivity extends AbsActivity {


    @Override
    protected Fragment createFragment() {
        return new ImgsListFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
