package com.sevanjoe.expressreminder.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sevanjoe.expressreminder.R;
import com.sevanjoe.expressreminder.model.bean.Sms;
import com.sevanjoe.expressreminder.presenter.HomePresenter;
import com.sevanjoe.expressreminder.presenter.impl.HomePresenterImpl;
import com.sevanjoe.expressreminder.ui.view.HomeView;
import com.sevanjoe.library.base.BaseActivity;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class HomeActivity extends BaseActivity implements HomeView {

    @InjectView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    private HomePresenter homePresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

        ButterKnife.inject(this);

        initToolbar();
        initView();
	}

    @Override
    protected void setSystemBarColor() {
        updateSystemBarColor(R.color.colorPrimaryDark);
    }

    private void initToolbar() {
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    private void initView() {
        homePresenter = new HomePresenterImpl(this);
        homePresenter.showExpressList();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_home, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

    @Override
    public void showExpressList(List<Sms> smsList) {

    }
}
