package chuang.lrucachedemo.android.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import chuang.lrucachedemo.R;

/**
 * Created by N-251 on 2015/2/15.
 */
public abstract class AbsActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.content_frame);
        if(fragment==null){
            fragment = createFragment();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        }
    }

    protected abstract Fragment createFragment();

    protected abstract int getLayoutId();
}
