package com.lam_delille.pappl_rambiances.data;


import java.util.concurrent.atomic.AtomicBoolean;

import android.location.Location;
import android.util.Log;

import com.lam_delille.pappl_rambiances.common.Matrix;
import com.lam_delille.pappl_rambiances.common.Orientation.ORIENTATION;


/**
 * Abstract class which should be used to set global data.
 * 
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public abstract class SpatialData {

    private static final String TAG = "SpatialData";
    

    /* defaulting to our place */
    public static final Location noLocation=new Location("noLocation");
    public static final Location hardFix = new Location("ATL");
    static {
        hardFix.setLatitude(39.931261);
        hardFix.setLongitude(-75.051267);
        hardFix.setAltitude(1);
        
        
    }

   
    private static final Object currentLocationLock = new Object();
    private static Location currentLocation = hardFix;
    private static final Object rotationMatrixLock = new Object();
    private static Matrix rotationMatrix = new Matrix();

    private static final Object orientationLock = new Object();
    private static ORIENTATION orientation = ORIENTATION.UNKNOWN;
    private static final Object orientationAngleLock = new Object();
    private static int orientationAngle = 0;



  

   

   

   

    /**
     * Set the current location.
     * 
     * @param currentLocation
     *            Location to set.
     * @throws NullPointerException
     *             if Location param is NULL.
     */
    public static void setCurrentLocation(Location currentLocation) {
        if (currentLocation == null) throw new NullPointerException();

        Log.d(TAG, "current location. location=" + currentLocation.toString());
        synchronized (SpatialData.currentLocationLock) {
            SpatialData.currentLocation = currentLocation;
        }
        onLocationChanged(currentLocation);
    }

    private static void onLocationChanged(Location location) {
       
    }

    /**
     * Get the current Location.
     * 
     * @return Location representing the current location.
     */
    public static Location getCurrentLocation() {
        synchronized (SpatialData.currentLocationLock) {
            return SpatialData.currentLocation;
        }
    }

    /**
     * Set the rotation matrix.
     * 
     * @param rotationMatrix
     *            Matrix to use for rotation.
     */
    public static void setRotationMatrix(Matrix rotationMatrix) {
        synchronized (SpatialData.rotationMatrixLock) {
            SpatialData.rotationMatrix = rotationMatrix;
        }
    }

    /**
     * Get the rotation matrix.
     * 
     * @return Matrix representing the rotation matrix.
     */
    public static Matrix getRotationMatrix() {
        synchronized (SpatialData.rotationMatrixLock) {
            return SpatialData.rotationMatrix;
        }
    }



    /**
     * Set the current orientation.
     * 
     * @param orientation
     *            ORIENTATION representing the orientation.
     */
    public static void setDeviceOrientation(ORIENTATION orientation) {
        synchronized (SpatialData.orientationLock) {
            SpatialData.orientation = orientation;
        }
    }

    /**
     * Get the current orientation.
     * 
     * @return orientation ORIENTATION representing the orientation.
     */
    public static ORIENTATION getDeviceOrientation() {
        synchronized (SpatialData.orientationLock) {
            return SpatialData.orientation;
        }
    }

    /**
     * Set the current orientation angle.
     * 
     * @param angle
     *            int representing the orientation angle.
     */
    public static void setDeviceOrientationAngle(int angle) {
        synchronized (SpatialData.orientationAngleLock) {
            SpatialData.orientationAngle = angle;
        }
    }

    /**
     * Get the current orientation angle.
     * 
     * @return angle int representing the orientation angle.
     */
    public static int getDeviceOrientationAngle() {
        synchronized (SpatialData.orientationAngleLock) {
            return SpatialData.orientationAngle;
        }
    }
}
