package com.dy.review.sendget;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final String INTERFACE_HOST = "https://api.qiniu.com";

    public static void main(String[] args) {
        // 直接将参数添加到 URL 中
        String url = "/cdn/ip-check?ip=180.101.136.232";
        String method = "GET";
        String response = invokeInterface(url, method);

        System.out.println(response);
    }

    public static String invokeInterface(String url, String method) {
        // 不再使用 body
        HttpResponse httpResponse = HttpRequest.get(INTERFACE_HOST + url)
                .header("Accept-Charset", CharsetUtil.UTF_8)
                .addHeaders(getHeaderMap())
                .execute();

        // 获取响应数据, 并格式化返回
        String body = httpResponse.body();
        return JSONUtil.formatJsonStr(body);
    }

    private static Map<String, String> getHeaderMap() {
        HashMap<String, String> map = new HashMap<>();
        // 修正 Authorization 头中的格式
        map.put("Authorization", "QBox csDTU1_DaU7OQYvfmrAkNAgHkNwWNXEI_L0eBFJT:bdwxBhql3VcWMx-RSNmraMIt-4Y=");
        // 对于 GET 请求，可以移除 Content-Type
        return map;
    }
}
