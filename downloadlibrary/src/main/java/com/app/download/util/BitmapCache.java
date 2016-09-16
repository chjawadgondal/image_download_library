package com.app.download.util;

import android.graphics.Bitmap;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * Fetcher internal use only.
 * 
 */

public class BitmapCache extends LinkedHashMap<String, Bitmap>{

	private static final long serialVersionUID = 1L;
	
	private int maxCount;
	private int maxPixels;
	private int maxTotalPixels;
	private int pixels;
	
	public BitmapCache(int mc, int mp, int mtp){
		
		super(8, 0.75F, true);
		
		this.maxCount = mc;
		this.maxPixels = mp;
		this.maxTotalPixels = mtp;
		
	}
	
	@Override
	public Bitmap put(String key, Bitmap bm){
		Bitmap old = null;
		
		int px = pixels(bm);
		if(px <= maxPixels){
			pixels += px;
			old = super.put(key, bm);
			if(old != null){
				pixels -= pixels(old);
			}			
			
			//FetchUtility.debug("put", key);
		}else{
			//FetchUtility.debug("reject", px + ":" + bm.getWidth() + ":" + bm.getHeight() + ":" + key);
		}
		return old;
	}
	
	
	@Override
	public Bitmap remove(Object key){
		
		Bitmap old = super.remove(key);
		if(old != null){
			pixels -= pixels(old);
		}
		return old;
	}
	
	@Override
	public void clear(){
		super.clear();
		pixels = 0;
	}
	
	private int pixels(Bitmap bm){
		if(bm == null) return 0;
		return bm.getWidth() * bm.getHeight();
	}
	
	private void shrink(){
		if(pixels > maxTotalPixels){
			Iterator<String> keys = keySet().iterator();
			
			while(keys.hasNext()){
				
				keys.next();
				keys.remove();
				
				if(pixels <= maxTotalPixels){
					break;
				}
			}
		}
	}
	
	
	@Override
	public boolean removeEldestEntry(Entry<String, Bitmap> eldest) {
		if(pixels > maxTotalPixels || size() > maxCount){
			remove(eldest.getKey());
		}
		shrink();
		return false;
    }
	
}
