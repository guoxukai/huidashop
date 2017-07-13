package com.huida.util;

import java.util.UUID;

public class Guid {

	public static String guid(){
		return  UUID.randomUUID().toString().replaceAll("-", "");
	}
}
