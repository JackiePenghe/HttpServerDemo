package cn.almsound.www.testhttpserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.io.IOException;

import cn.almsound.www.almhttpserverlibrary.HttpServer;
import cn.almsound.www.testhttpserver.utils.Constants;

/**
 * Created by jacke on 2017/2/21 0021.
 * HttpServerService
 */

public class HttpServerService extends Service {

    private HttpServer httpServer;
    private HttpServerServiceBinder httpServerServiceBinder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return httpServerServiceBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        httpServer = new HttpServer(Constants.PORT);
        httpServerServiceBinder = new HttpServerServiceBinder(HttpServerService.this);
    }

    public void start() {
        try {
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        httpServer.stop();
    }

    public void setOnHttpServerListener(HttpServer.OnHttpServeListener onHttpServerListener) {
        httpServer.setOnHttpServeListener(onHttpServerListener);
    }

}
