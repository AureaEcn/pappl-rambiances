package com.lam_delille.pappl_rambiances.data;

import android.graphics.Color;

import com.lam_delille.pappl_rambiances.common.Vector;

public class Marker implements Comparable<Marker> {

	 // Unique identifier of Marker
    private String name = null;
    // Marker's physical location (Lat, Lon, Alt)
    private final PhysicalLocation physicalLocation = new PhysicalLocation();
    // Marker's default color
    private int color = Color.WHITE;
    
    //------Données pour l'AR------
    // For tracking Markers which have no altitude
    private boolean noAltitude = false;
    // Distance from camera to PhysicalLocation in meters
    private double distance = 0.0;
    // Is within the radar
    private boolean isOnRadar = false;
    // Is in the camera's view
    private boolean isInView = false;
    // Physical location's X, Y, Z relative to the camera's location
    private final Vector locationXyzRelativeToPhysicalLocation = new Vector();
	
    private float initialY = 0.0f;
	@Override
	public int compareTo(Marker arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	 public Marker(String name, double latitude, double longitude, double altitude, int color) {
	        set(name, latitude, longitude, altitude, color);
	    }

	 public void set(String name, double latitude, double longitude, double altitude, int color) {
	        if (name == null)
	            throw new NullPointerException();

	        this.name = name;
	        this.physicalLocation.set(latitude, longitude, altitude);
	        this.color = color;
	        this.isOnRadar = false;
	        this.isInView = false;
	        this.locationXyzRelativeToPhysicalLocation.set(0, 0, 0);
	        this.initialY = 0.0f;
	        if (altitude == 0.0d)
	            this.noAltitude = true;
	        else
	            this.noAltitude = false;
	    }
}
