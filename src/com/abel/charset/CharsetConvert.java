package com.abel.charset;

import java.io.UnsupportedEncodingException;

/**
 * Created by fpschina on 15-6-3.
 */
public class CharsetConvert {
    public static String convert(String str) {
        String result = null;

        try {
            result = new String(str.getBytes("GBK"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return result;
    }
}
