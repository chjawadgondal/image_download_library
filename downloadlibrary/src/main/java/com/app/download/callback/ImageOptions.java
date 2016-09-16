package com.app.download.callback;

import android.graphics.Bitmap;

import com.app.download.Fetcher;


public class ImageOptions {

	public boolean memCache = true;
	public boolean fileCache = true;
	public Bitmap preset;
	public int policy;
	
	public int targetWidth;
	public int fallback;
	public int animation;
	public float ratio;
	public int round;
	public float anchor = Fetcher.ANCHOR_DYNAMIC;

	
}
