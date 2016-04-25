package com.madhoue.dsp.uadata.toolbox.json;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {

   private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     *  Object 转化 String
     * @param obj
     * @return
     */
    public static String writeValueAsString(Object obj){

        try {
            return objectMapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     * String 转化 bean
     * @param str
     * @param c
     * @param <T>
     * @return
     */
    public static <T> T readValue(String str, Class c){
        try {
            return (T)objectMapper.readValue(str, c);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
