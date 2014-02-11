package com.lam_delille.pappl_rambiances.data;

import java.util.List;

import com.lam_delille.pappl_rambiances.ui.Marker;

/**
 * This abstract class should be extended for new data sources.
 * 
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public abstract class DataSource {

    public abstract List<Marker> getMarkers();
}
