package cn.almsound.www.almhttpserverlibrary;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Map;

import javax.net.ssl.SSLServerSocketFactory;

import fi.iki.elonen.NanoHTTPD;

/**
 * Created by jacke on 2017/2/21 0021.
 * HttpServer
 */

public class HttpServer extends NanoHTTPD {

    private OnHttpServeListener onHttpServeListener;

    public HttpServer(int port) {
        super(port);
    }

    @Override
    public Response serve(IHTTPSession session) {
        if (onHttpServeListener != null) {
            return onHttpServeListener.onHttpServer(session);
        } else {
            return super.serve(session);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public Response serve(String uri, Method method, Map<String, String> headers, Map<String, String> parms, Map<String, String> files) {
        if (onHttpServeListener != null)
            return onHttpServeListener.onHttpServer(uri, method, headers, parms, files);
        else return super.serve(uri, method, headers, parms, files);
    }

    @Override
    public synchronized void closeAllConnections() {
        super.closeAllConnections();
    }

    @Override
    protected ClientHandler createClientHandler(Socket finalAccept, InputStream inputStream) {
        return super.createClientHandler(finalAccept, inputStream);
    }

    @Override
    protected ServerRunnable createServerRunnable(int timeout) {
        return super.createServerRunnable(timeout);
    }

    @Override
    protected boolean useGzipWhenAccepted(Response r) {
        return super.useGzipWhenAccepted(r);
    }

    @Override
    public ServerSocketFactory getServerSocketFactory() {
        return super.getServerSocketFactory();
    }

    @Override
    public void setServerSocketFactory(ServerSocketFactory serverSocketFactory) {
        super.setServerSocketFactory(serverSocketFactory);
    }

    @Override
    public String getHostname() {
        return super.getHostname();
    }

    @Override
    public TempFileManagerFactory getTempFileManagerFactory() {
        return super.getTempFileManagerFactory();
    }

    @Override
    public void makeSecure(SSLServerSocketFactory sslServerSocketFactory, String[] sslProtocols) {
        super.makeSecure(sslServerSocketFactory, sslProtocols);
    }

    @Override
    public void setAsyncRunner(AsyncRunner asyncRunner) {
        super.setAsyncRunner(asyncRunner);
    }

    @Override
    public void setTempFileManagerFactory(TempFileManagerFactory tempFileManagerFactory) {
        super.setTempFileManagerFactory(tempFileManagerFactory);
    }

    @Override
    public void start() throws IOException {
        super.start();
    }

    @Override
    public void start(int timeout) throws IOException {
        super.start(timeout);
    }

    @Override
    public void start(int timeout, boolean daemon) throws IOException {
        super.start(timeout, daemon);
    }

    @Override
    public void stop() {
        super.stop();
    }

    public HttpServer(String hostname, int port) {
        super(hostname, port);
    }

    public void setOnHttpServeListener(OnHttpServeListener onHttpServeListener) {
        this.onHttpServeListener = onHttpServeListener;
    }

    public interface OnHttpServeListener {

        /**
         * 此方法被优先执行
         *
         * @param session IHTTPSession
         * @return Response
         */
        Response onHttpServer(IHTTPSession session);

        /**
         * 如果onHttpServer(IHTTPSession session)方法中有处理，此方法不被执行
         *
         * @param uri     uri
         * @param method  method
         * @param headers headers
         * @param parms   parms
         * @param files   files
         * @return Response
         */
        @Deprecated
        Response onHttpServer(String uri, Method method, Map<String, String> headers, Map<String, String> parms, Map<String, String> files);
    }
}
