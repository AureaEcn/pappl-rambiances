package com.lam_delille.pappl_rambiances.activity;

import com.lam_delille.pappl_rambiances.activity.FragmentDetails;
import com.lam_delille.pappl_rambiances.activity.FragmentTest;
import com.lam_delille.pappl_rambiances.R;
import com.lam_delille.pappl_rambiances.R.id;
import com.lam_delille.pappl_rambiances.R.layout;
import com.lam_delille.pappl_rambiances.R.menu;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.hardware.SensorEvent;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends NetworkActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		replaceMainFragment(new FragmentTest());
		replaceDetailsFragment(new FragmentDetails());
	}

	public void onLocationChanged(Location location) {
		super.onLocationChanged(location); //les méthodes mères mettent à jour la location dans SpatialData
		Fragment fragment=this.getFragmentManager().findFragmentById(R.id.fragment_main);
		if(fragment!=null&&fragment instanceof FragmentMarkers) 
			((FragmentMarkers)fragment).onLocationUpdate();
	}

	public void onSensorChanged(SensorEvent evt){
		super.onSensorChanged(evt); //les méthodes mères mettent à jour l'orientation dans SpatialData
		Fragment fragment=this.getFragmentManager().findFragmentById(R.id.fragment_main);
		if(fragment!=null&&fragment instanceof FragmentMarkers) 
			((FragmentMarkers)fragment).onOrientationUpdate();
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		//TODO Mettre en place les actions de l'action bar
		case(R.id.action_vue_test):
			replaceMainFragment(new FragmentTest());
		return true;
		case(R.id.action_vue_carte_2D):
			replaceMainFragment(new FragmentMap());
			return true;
		case(R.id.action_vue_AR):
			replaceMainFragment(new FragmentAR());
			return true;
		case(R.id.action_options):
			return true;
		case(R.id.action_aide):
			return true;
		default:
			return false;
		}
	}

	private void replaceMainFragment(Fragment newFragment){
		Fragment oldFragment=this.getFragmentManager().findFragmentById(R.id.fragment_main);
		if(oldFragment==null ||!oldFragment.getClass().equals(newFragment.getClass())){
		FragmentTransaction transaction = this.getFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_main,newFragment,newFragment.getClass().getName());
		transaction.commit();
		}
	}
	
	private void replaceDetailsFragment(Fragment newFragment){
		Fragment oldFragment=this.getFragmentManager().findFragmentById(R.id.fragment_details);
		if(oldFragment==null ||!oldFragment.getClass().equals(newFragment.getClass())){
		FragmentTransaction transaction = this.getFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_details,newFragment,newFragment.getClass().getName());
		transaction.commit();
		}
	}

	

}
