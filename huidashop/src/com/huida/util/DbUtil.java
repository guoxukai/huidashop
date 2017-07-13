package com.huida.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtil {
	
	//静态的连接池数据源，只有一份
	private static ComboPooledDataSource dataSouce = new ComboPooledDataSource();
	
	//从连接池里面拿到一个conncection 返回
	public static Connection getConnection() throws SQLException{
		return dataSouce.getConnection();
	}
	
}
