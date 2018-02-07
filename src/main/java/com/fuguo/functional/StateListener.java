package com.fuguo.functional;

/**
 * @author 00938658-王富国
 * @description: TODO
 * @date 2018-01-20 15:58
 * @since V1.0.0
 */
public interface StateListener {

    int DISCONNECTED = 0;

    int CONNECTED = 1;

    int RECONNECTED = 2;

    void stateChanged(int connected);

}
