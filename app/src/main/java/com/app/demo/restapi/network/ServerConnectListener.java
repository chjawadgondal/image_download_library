package com.app.demo.restapi.network;

/**
 * This class has been created to handle the
 * API request call back method.
 * Very generic call back method has been used to make
 * is able to receive all type of modal response
 */
public interface ServerConnectListener {
    /**
     * Called if server call was successful
     *
     * @param response
     */

    void onSuccess(Object response);

    /**
     * Called if server call was failed.
     *
     */

    void onFailure(Throwable t);
}
