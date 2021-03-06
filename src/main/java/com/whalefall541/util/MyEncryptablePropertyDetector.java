package com.whalefall541.util;

import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyDetector;

/**
 * code from <br>https://www.cnblogs.com/pythoncd/articles/11437585.html<br/>
 * EncryptablePropertyResolver
 */
public class MyEncryptablePropertyDetector implements EncryptablePropertyDetector {
    public static final String encodePasswordPrefix = "{decry}";

    public MyEncryptablePropertyDetector() {
        super();
    }

    //如果属性的字符开头为"{decry}",返回true ，表明属性是加密过的
    @Override
    public boolean isEncrypted(String s) {
        if (s != null) {
            return s.startsWith(encodePasswordPrefix);
        }
        return false;
    }

    //该方法告诉工具，如何将自定义前缀去除
    @Override
    public String unwrapEncryptedValue(String s) {
        return s.substring(encodePasswordPrefix.length());
    }

}