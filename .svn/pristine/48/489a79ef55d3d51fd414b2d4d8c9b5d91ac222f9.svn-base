package cn.almsound.www.almhttpserverlibrary;

import fi.iki.elonen.NanoHTTPD.Response;

/**
 * Created by jacke on 2017/2/22 0022.
 * HttpServerStatus
 */

public class HttpServerStatus implements Response.IStatus {
    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public int getRequestStatus() {
        return 0;
    }

    /*这类就是要自定义一些返回值，我在这里定义了700。都属于自定义*/
    public enum Status implements Response.IStatus {
        SWITCH_PROTOCOL(101, "Switching Protocols"),
        NOT_USE_POST(700, "not use post"),
        DEFAULT_URI(102, "not use post");

        private final int requestStatus;
        private final String description;

        Status(int requestStatus, String description) {
            this.requestStatus = requestStatus;
            this.description = description;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public int getRequestStatus() {
            return requestStatus;
        }
    }
}
