package com.practise.util;

import com.practise.dto.SampleDTO;

public class Util {
	
	
	/**
	 * Compare two elements
	 * 
	 * @param obj1
	 * @param obj2
	 * @return
	 */
	public static int compare(Object obj1, Object obj2) {
		if (obj1 instanceof String) {
			return ((String) obj1).compareTo((String) obj2);
		} else if (obj1 instanceof Integer) {
			return ((Integer) obj1).compareTo((Integer) obj2);
		}else if (obj1 instanceof SampleDTO) {
			return ((SampleDTO) obj1).compareTo((SampleDTO) obj2);
		} else {
			return 0;
		}
	}

}
