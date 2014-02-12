package com.lam_delille.pappl_rambiances.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
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

    private static final String TAG = "ARData";
    private static final AtomicBoolean dirty = new AtomicBoolean(false);
    private static final float[] locationArray = new float[3];

    /* defaulting to our place */
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
    private static final Object azimuthLock = new Object();
    private static float azimuth = 0;
    private static final Object rollLock = new Object();
    private static float roll = 0;
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
     * Add a List of Markers to our Collection.
     * 
     * @param markers
     *            List of Markers to add.
     */
   
    /**
     * Set the current Azimuth.
     * 
     * @param azimuth
     *            float representing the azimuth.
     */
    public static void setAzimuth(float azimuth) {
        synchronized (SpatialData.azimuthLock) {
            SpatialData.azimuth = azimuth;
        }
    }

    /**
     * Get the current Azimuth.
     * 
     * @return azimuth float representing the azimuth.
     */
    public static float getAzimuth() {
        synchronized (SpatialData.azimuthLock) {
            return SpatialData.azimuth;
        }
    }

    /**
     * Set the current Roll.
     * 
     * @param roll
     *            float representing the roll.
     */
    public static void setRoll(float roll) {
        synchronized (SpatialData.rollLock) {
            SpatialData.roll = roll;
        }
    }

    /**
     * Get the current Roll.
     * 
     * @return roll float representing the roll.
     */
    public static float getRoll() {
        synchronized (SpatialData.rollLock) {
            return SpatialData.roll;
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
