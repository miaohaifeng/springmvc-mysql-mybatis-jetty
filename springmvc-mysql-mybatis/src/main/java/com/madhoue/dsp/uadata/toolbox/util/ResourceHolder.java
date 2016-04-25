package com.madhoue.dsp.uadata.toolbox.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class ResourceHolder {
    private static Logger logger = LoggerFactory.getLogger(ResourceHolder.class.getClass());
    public static ResourceBundle resource = null;

    static {
        String path = "/services/data/dspuadata/conf/global.properties";
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(path));
            resource = new PropertyResourceBundle(in);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("errorMessage:{},{}", new Object[]{e.getCause(), e.getStackTrace()});
        }
    }

    public static String getValue(String key) {
        return resource.getString(key);
    }


}
