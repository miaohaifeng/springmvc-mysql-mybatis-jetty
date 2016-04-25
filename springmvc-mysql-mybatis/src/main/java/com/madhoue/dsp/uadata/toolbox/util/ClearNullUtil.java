package com.madhoue.dsp.uadata.toolbox.util;

import java.util.Iterator;
import java.util.Map;

/**
 * 清除空值
 */
public class ClearNullUtil {

	/**
	 * 清除map中的NUll和空
	 * 
	 * @param mapParam
	 */
	public static void mapClear(Map<String, Object> mapParam) {
		Iterator<String> ii = mapParam.keySet().iterator();
		while (ii.hasNext()) {
			String param = ii.next();
			Object obj = mapParam.get(param);
			if (obj == null) {
				ii.remove();
				continue;
			}
			if (obj.toString().equals("")){
				ii.remove();
				continue;
			}
		}
	}
}
