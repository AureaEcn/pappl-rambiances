package com.lam_delille.pappl_rambiances.activity;

import com.lam_delille.pappl_rambiances.activity.FragmentDetails;
import com.lam_delille.pappl_rambiances.activity.FragmentTest;
import com.lam_delille.pappl_rambiances.R;
import com.lam_delille.pappl_rambiances.R.id;
import com.lam_delille.pappl_rambiances.R.layout;
import com.lam_delille.pappl_rambiances.R.menu;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.hardware.SensorEvent;
import android.location.Location;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends MarkerActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initialize();

	}

	protected void initialize(){
		FragmentDetails fragmentDetails=new FragmentDetails();
		FragmentTest fragmentTest=new FragmentTest();
		FragmentTransaction transaction = this.getFragmentManager()
				.beginTransaction();
		transaction.replace(R.id.fragment_main,fragmentTest,"fragementTest");
		transaction.replace(R.id.fragment_details, fragmentDetails,"fragmentDetails");
		transaction.commit();
	}


	public void onLocationChanged(Location location) {
		super.onLocationChanged(location); 
		//TODO Mise à jour des fragments en fonction de la nouvelle location
	}

	public void onSensorChanged(SensorEvent evt){
		super.onSensorChanged(evt);
		//TODO Mettre à jour le fragment AR en fonction de la nouvelle orientation
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
        	return true;
        case(R.id.action_vue_carte_2D):
        	return true;
        case(R.id.action_vue_AR):
        	return true;
        case(R.id.action_options):
        	return true;
        case(R.id.action_aide):
        	return true;
        default:
        	return false;
        }
       
        
        
    }



}
