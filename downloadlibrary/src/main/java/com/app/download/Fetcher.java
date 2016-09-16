package com.app.download;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * The main class of Fetcher. All methods are actually inherited from AbstractFetcher.
 *
 */
public class Fetcher extends AbstractFetcher<Fetcher> {

	
	public Fetcher(Activity act) {
		super(act);
	}
	
	public Fetcher(View view) {
		super(view);
	}
	
	public Fetcher(Context context) {
		super(context);
	}
	
	public Fetcher(Activity act, View root){
		super(act, root);
	}
	

}


