package com.app.download.callback;

import org.apache.http.HttpRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.net.Proxy;



public abstract class ProxyHandle {

	
	public abstract void applyProxy(AbstractAjaxCallback<?, ?> cb, HttpRequest request, DefaultHttpClient client);
	
	public abstract Proxy makeProxy(AbstractAjaxCallback<?, ?> cb);
	
	
	
}
