package com.lam_delille.pappl_rambiances.activity;

import com.lam_delille.pappl_rambiances.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentDetails extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
	      // Inflate the layout for this fragment
   	      return inflater.inflate(
		              R.layout.fragment_details, container, false);
		   }
}
