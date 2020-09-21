package com.lxf.jdk.concurrent.multiThread;

import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap内部分了若干个小的HashMap,默认为16
 * 根据表项的hashcode，决定将该表项插入到哪一段中，只要插入的表项的不同，那么多线程环境下可以做到真正的并行
 * @author 15652
 *
 */
public class ConcurrentHashMapDemo {
	
	public static void main(String[] args) {
		ConcurrentHashMap chm = new ConcurrentHashMap();
		chm.size();//分段求和
		chm.put("1", 1);
		
		Hashtable ht = new Hashtable();
		ht.size();//同步方法，因为多线程时，此线程拿到的count++可能被污染
	}

}
