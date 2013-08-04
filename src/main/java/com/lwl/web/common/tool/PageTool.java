package com.lwl.web.common.tool;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageTool {

    @Autowired
    private HttpServletRequest request;

    public String paging(int page) {
        StringBuffer buffer = request.getRequestURL();

        String queryString = request.getQueryString();

        if (queryString != null) {
            buffer.append('?').append(queryString);
        }

        String url = buffer.toString();

        try {
            url = new String(url.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //ignore...
        }

        Pattern pattern = Pattern.compile("(.*[\\?&]?page=)(\\d*)([&#]?.*)");
        Matcher m = pattern.matcher(url);
        if (!m.matches()) {
            return url + (url.indexOf('?') == -1 ? '?' : '&') + "page=" + page;
        } else {
            return m.replaceAll("$1" + page + "$3");
        }
    }
}
