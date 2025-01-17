package com.lxf.jdk.concurrent.multiThread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 1、基本操作 get\set\remove
 * 2、线程安全，实现线程隔离，ThreadLocal为每个线程提供了独立的变量副本，那么针对变量的操作都是在线程内操作的，
 *    所以是线程安全的
 *  Thread ref -> Thread -> ThreadLocalMap -> Entry<ThreadLocal, value>
 */
public class ThreadLocalDemo1 {
	private static ArrayList arrayList = new ArrayList<>();
	private String a;

	public static Connection main(String[] args) throws SQLException {
		ThreadLocal<Connection> conn = new ThreadLocal<>();
		//get
		Connection con = conn.get();
		if(con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("url", "user", "password");
				//set
				conn.set(con);
			}catch(ClassNotFoundException e) {
				//释放局部变量，以免内存溢出
				conn.remove();
			}
			
		}
		return con;

	}

}
