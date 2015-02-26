package com.fastgood.dsl.util;

import java.util.List;

public class ArrayListUtil {
	
	@SuppressWarnings("rawtypes")
	public static boolean isBlank(List list) {
		if(list == null || list.size()==0) return true;
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isNotBlank(List list) {
		if(list == null || list.size()==0) return false;
		return true;
	}
	
}
