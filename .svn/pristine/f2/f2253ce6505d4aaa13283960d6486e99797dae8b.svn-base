package cn.almsound.www.testhttpserver;


import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/**
 * Created by jacke on 2017/2/21 0021.
 */

public class HttpServerServiceConnection implements ServiceConnection {

    private HttpServerService httpServerService;
    private MainActivity mainActivity;

    public HttpServerServiceConnection(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder iBinder) {
        HttpServerServiceBinder httpServerServiceBinder = (HttpServerServiceBinder) iBinder;
        httpServerService = httpServerServiceBinder.getHttpServerService();
        mainActivity.getHttpServerService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }


    public HttpServerService getHttpServerService(){
        return httpServerService;
    }
}
