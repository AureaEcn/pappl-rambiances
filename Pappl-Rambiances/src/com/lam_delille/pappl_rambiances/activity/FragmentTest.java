package com.lam_delille.pappl_rambiances.activity;

import com.lam_delille.pappl_rambiances.R;
import com.lam_delille.pappl_rambiances.common.Navigation;
import com.lam_delille.pappl_rambiances.data.SpatialData;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTest extends FragmentMarqueurs {
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
	      // Inflate the layout for this fragment
   	      return inflater.inflate(
		              R.layout.fragment_test, container, false);
		   }

	@Override
	public void onLocationUpdate() {
		
		
	}

	@Override
	public void onOrientationUpdate() {
		TextView textView=(TextView)this.getView().findViewById(R.id.test_orientation);
		if(textView!=null) textView.setText("Orientation=azimuth:"+(int)Navigation.getAzimuth()+
				"\t pitch:"+(int)Navigation.getPitch()+
				"\t roll:"+(int)Navigation.getRoll());
	}
	
	
}
