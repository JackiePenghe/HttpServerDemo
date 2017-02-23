package cn.almsound.www.testhttpserver;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.almsound.www.almhttpserverlibrary.HttpServer;
import cn.almsound.www.almhttpserverlibrary.utils.HttpConstants;
import cn.almsound.www.testhttpserver.adapter.ListViewAdapter;
import cn.almsound.www.testhttpserver.utils.Constants;
import cn.almsound.www.testhttpserver.utils.LogUtil;
import cn.almsound.www.testhttpserver.utils.MacAddressUtil;
import fi.iki.elonen.NanoHTTPD;

import static cn.almsound.www.testhttpserver.R.id.address;
import static fi.iki.elonen.NanoHTTPD.IHTTPSession;
import static fi.iki.elonen.NanoHTTPD.Method;
import static fi.iki.elonen.NanoHTTPD.Response;
import static fi.iki.elonen.NanoHTTPD.newFixedLengthResponse;


public class MainActivity extends AppCompatActivity implements HttpServer.OnHttpServeListener {

    private HttpServerServiceConnection httpServerServiceConnection;
    private HttpServerService httpServerService;
    private ListViewAdapter listViewAdapter;
    private List<String> strings;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = (TextView) findViewById(address);
        listView = (ListView) findViewById(R.id.list_view);
        strings = new ArrayList<>();
        listViewAdapter = new ListViewAdapter(MainActivity.this, strings);
        listView.setAdapter(listViewAdapter);
        String address = MacAddressUtil.getWIFILocalIpAdress(MainActivity.this);
        textView.setText(address + ":" + Constants.PORT);
        httpServerServiceConnection = new HttpServerServiceConnection(MainActivity.this);
        Intent intent = new Intent(MainActivity.this, HttpServerService.class);
        bindService(intent, httpServerServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        httpServerService.stop();
        unbindService(httpServerServiceConnection);
    }

    /**
     * 初始化菜单
     *
     * @param menu 菜单的资源id
     * @return true表示有菜单初始化
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /**
     * 当某一个菜单被选中之后的回调
     *
     * @param item 选中的某一项菜单
     * @return true表示该事件被处理了
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.wipe_data:
                showWipeDataDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public Response onHttpServer(IHTTPSession session) {
        switch (session.getMethod()) {
            case POST:
                return doPost(session);
            case GET:
                return doGet(session);
            default:
                return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, "404 Not Found");
        }
    }

    @Override
    public Response onHttpServer(String uri, Method method, Map<String, String> headers, Map<String, String> parms, Map<String, String> files) {
        switch (method) {
            case POST:
                return doPost(uri, method, headers, parms, files);
            case GET:
                return doGet(uri, method, headers, parms, files);
            default:
                return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, "404 Not Found");
        }
    }

    private void showWipeDataDialog() {
        new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.wipe_data)
                .setMessage(R.string.wipe_data_message)
                .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        strings.clear();
                        listViewAdapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton(R.string.cancel, null)
                .show();
    }

    public void getHttpServerService() {
        httpServerService = httpServerServiceConnection.getHttpServerService();
        httpServerService.setOnHttpServerListener(MainActivity.this);

        httpServerService.start();
    }

    private Response doPost(String uri, Method method, Map<String, String> headers, Map<String, String> parms, Map<String, String> files) {
        return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, "404 Not Found");
    }

    private Response doGet(String uri, Method method, Map<String, String> headers, Map<String, String> parms, Map<String, String> files) {
        return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, "404 Not Found");
    }

    private Response doPost(IHTTPSession session) {

        Map<String, String> files = new HashMap<>();
        String queryParameterString = null;
        String remoteIpAddress = session.getRemoteIpAddress();

        try {
                /*这句尤为重要就是将将body的数据写入files中，大家可以看看parseBody具体实现，倒现在我也不明白为啥这样写。*/
            session.parseBody(files);
                /*看就是这里，POST请教的body数据可以完整读出*/
            queryParameterString = session.getQueryParameterString();
                /*这里是从header里面获取客户端的IP地址。NanoHttpd的header包含的东西不止是HTTP heaer的内容*/
        } catch (IOException | NanoHTTPD.ResponseException e) {
            e.printStackTrace();
        }
        final String info = "Method:POST    " + remoteIpAddress + "\nBody:\n" + queryParameterString;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (strings.size() >= 30) {
                    strings.clear();
                }
                strings.add(info);
                listViewAdapter.notifyDataSetChanged();
                listView.setSelection(strings.size() - 1);
            }
        });
        String uri = session.getUri().substring(1);
        if (uri.isEmpty()) {
            return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, "default uri");
        }
        switch (uri) {
            case HttpConstants.URI_SCAN:
                return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, "scan uri");
            default:
                return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, "404 Not Found");
        }
    }

    private Response doGet(IHTTPSession session) {
        Map<String, List<String>> parameters = session.getParameters();
        Set<Map.Entry<String, List<String>>> entries = parameters.entrySet();
        Iterator<Map.Entry<String, List<String>>> iterator = entries.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            Map.Entry<String, List<String>> next = iterator.next();
            List<String> value = next.getValue();
            StringBuilder stringBuilder1 = new StringBuilder();
            for (String aValue : value) {
                stringBuilder1.append(aValue);
            }
            stringBuilder.append(next.getKey()).append("=").append(stringBuilder1).append("\n");
        }
        String remoteIpAddress = session.getRemoteIpAddress();
        String s = stringBuilder.toString();
        final String info = "Method:GET    " + remoteIpAddress + "\nParams:\n" + s;
        LogUtil.w("MainActivity", "doGet:params = " + info);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
        if (strings.size() >= 30) {
            strings.clear();
        }
        strings.add(info);
                listViewAdapter.notifyDataSetChanged();
                listView.setSelection(strings.size() - 1);
            }
        });
        String uri = session.getUri().substring(1);
        if (uri.isEmpty()) {
            return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, "default uri");
        }
        switch (uri) {
            case HttpConstants.URI_SCAN:
                return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, "scan uri");
            default:
                return newFixedLengthResponse(Response.Status.NOT_FOUND, NanoHTTPD.MIME_HTML, "404 Not Found");
        }
    }
}
