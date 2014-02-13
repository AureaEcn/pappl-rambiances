package com.lam_delille.pappl_rambiances.activity;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.lam_delille.pappl_rambiances.R;
import com.lam_delille.pappl_rambiances.common.Navigation;
import com.lam_delille.pappl_rambiances.data.SpatialData;

import android.app.Fragment;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTest extends FragmentMarqueurs {
	private static final int TIME_DELAY_LOCATION_RECEPTION=10000; //Délai maximal aceptable entre l'heure actuelle et l'heure de réception de la location GPS
	
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
	      // Inflate the layout for this fragment
   	      return inflater.inflate(
		              R.layout.fragment_test, container, false);
		   }

	@Override
	public void onResume(){
		//Nécessaire pour actualiser les données en cas de changement fragments/navigation?
		super.onResume();
		onLocationUpdate();
		onOrientationUpdate();
	}
	
	@Override
	public void onLocationUpdate() {
		showLastLocation();
		showGpsSignalStregnth();
		
	}
	
	@Override
	public void onOrientationUpdate() {
		showOrientation();
	}
	
	
	private void showLastLocation(){
		TextView textView=(TextView)this.getView().findViewById(R.id.test_location);
		Location location=SpatialData.getCurrentLocation();
		if(location.getProvider().equals("noLocation")){
			textView.setText("Dernière location GPS= inconnue");
		}else if(location.getProvider().equals("hardFix")){
			textView.setText("Position Debug="+toString(location));
		}else{
			textView.setText("Dernière location GPS="+toString(location));
		}
	}
	
	private String toString(Location location){
		//Formatage date
		Date date = new Date(location.getTime());
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss:SSS");
		String dateFormatted = formatter.format(date);
		//Affichage des valeurs de location formatées
		return( "\nlat:"+location.getLatitude()+
		"\n lon:"+location.getLongitude()+
		"\n alt:"+location.getAltitude()+
		"\n accuracy:"+location.getAccuracy()+"m"+
		"\n time:"+dateFormatted);
	}
	
	private void showGpsSignalStregnth(){
		//TODO A faire
		//Le signal GPS est considéré fort si la dernière location reçue est suffisament récente?
		//ou si l'écart temps entre 2 locations est suffisament court? A voir
	}
	
	private void showOrientation(){
		//Pitch/Azimuth/roll vient de Navigation.class mais sont basés sur la matrixRotation de SpatialData.clas
				TextView textView=(TextView)this.getView().findViewById(R.id.test_orientation);
				if(textView!=null) textView.setText("Orientation=azimuth:"+(int)Navigation.getAzimuth()+
						"\t pitch:"+(int)Navigation.getPitch()+
						"\t roll:"+(int)Navigation.getRoll());
	}

	
	
	
}
