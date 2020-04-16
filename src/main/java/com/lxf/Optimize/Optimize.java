package com.lxf.Optimize;

import com.lxf.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;


public class Optimize {
	   /**
	    * 对于ThreadLocal使用前或者使用后一定要先remove
	    */
	   private static final ThreadLocal<Object> TL = new ThreadLocal<Object>(){
	        /**
	         * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
	         */
	        @Override
	        protected Object initialValue()
	        {
	            System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
	            return null;
	        }
	    };
	    
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
//		/**
//		 * 尽量减少对变量的重复计算
//		 */
//		for(int i = 0; i<list.size(); i++) {
//			
//		}
//		for (int i = 0, length = list.size(); i<length; i++) {
//			
//		}
//		/**
//		 * 懒加载，在需要的时候再创建
//		 */
//		int i =0;
//		Integer num = 100;
//		if(i ==1) {
//			list.add(num);
//		}
//		
//		if(i ==1) {
//			Integer num1 = 100;
//			list.add(num1);
//		}
//		/**
//		 * 复制大数据量时，使用System.arrarcopy()
//		 */
//		int[] fun = {0,1,2,3,4,5,6};
//		System.arraycopy(fun, 0, fun, 3, 3);
//		System.out.println(fun[3]);
//		/**
//		 * 循环体内不要不断创建对象的引用
//		 */
//		int count = 2;
//		for(int j = 1; j <= count; j++) {
//			Object obj = new Object();
//		}
//		
//		Object obj = null;
//		for (int j = 1; j <= count; j++) {
//			obj = new Object();
//		}
//		/**
//		 * 随机访问时，用for循环；顺序访问时，用foreach,底层是Iterator
//		 */
//		if(list instanceof RandomAccess) {
//			for(int i1 = 0,length = list.size(); i1<length; i1++) {}
//		}else {
//			for(int i2 : list){}
//		}
//		/**
//		 * 使用线程池和连接池
//		 */
//		Executors.newFixedThreadPool(10);
//		Executors.newCachedThreadPool();
//		Executors.newScheduledThreadPool(10);
//		Executors.newSingleThreadExecutor();
//		/**
//		 * String.valueOf()方法底层调用了Integer.toString()方法，但是会在调用前做空判断
//		 * Integer.toString()方法就不说了，直接调用了
//		 * i + “”底层使用了StringBuilder实现，先用append方法拼接，再用toString()方法获取字符串
//		 * 三者对比下来，明显是2最快、1次之、3最慢
//		 */
//		int loopTime = 50000;
//		   Integer i = 0;
//		   long startTime = System.currentTimeMillis();
//		   for (int j = 0; j < loopTime; j++)
//		   {
//		       String str = String.valueOf(i);
//		   }    
//		   System.out.println("String.valueOf()：" + (System.currentTimeMillis() - startTime) + "ms");
//		   startTime = System.currentTimeMillis();
//		   for (int j = 0; j < loopTime; j++)
//		   {
//		       String str = i.toString();
//		   }    
//		   System.out.println("Integer.toString()：" + (System.currentTimeMillis() - startTime) + "ms");
//		   startTime = System.currentTimeMillis();
//		   for (int j = 0; j < loopTime; j++)
//		   {
//		       String str = i + "";
//		   }    
//		   System.out.println("i+：" + (System.currentTimeMillis() - startTime) + "ms");
		/**
		 * 最有效率的遍历map
		 */
//		   HashMap<String, String> hm = new HashMap<String, String>();
//		   hm.put("111", "222");
//		   Set<Map.Entry<String, String>> entrySet = hm.entrySet();
//		   Iterator<Map.Entry<String, String>> iter = entrySet.iterator();
//		   while(iter.hasNext()) {
//			   Map.Entry<String, String> entry = iter.next();
//			   System.out.println(entry.getKey()+" "+entry.getValue());
//		   }
		   /**
		    * 避免Random实例被多线程使用，虽然共享该实例是线程安全的，
		    * 但会因竞争同一seed 导致的性能下降，JDK7之后，可以使用ThreadLocalRandom来获取随机数
		    */
//		   System.out.println(ThreadLocalRandom.current().nextInt());//高并发
//		   
//		   //做成静态成员变量，但高并发时没有ThreadLocalRandom效率高
//		   //new Random()
//		   //new Random(long seed)
//		   Random random = new Random();
//		   random.nextInt();
//		   
//		   Math.random();//每次调用，都会生成一个Random对象
		   
		   /**
		    * StringBuilder：字符串拼接
		    * 下示例：初始化StringBuilder，初始时有字符串"This is a test"，并且有一定的预留空间，当追加并且空间不够的时候，容量自动扩充
		    * 也可以初始化时指定容量的大小
		    */
		   StringBuilder sb = new StringBuilder("This is a test");
		   for (int i =0; i < 10; i++) {
			   sb.append(i);
			   sb.append(" ");
		   }
		   System.out.println(sb.toString());
		   
		   /**
		    * +的使用场景：分行显示
		    */
		   String str = "a"
				   +"b"
				   +"c";
		   
		   /**
		    * 替换
		    * jdk1.9之前用StringUtils,效率更高
		    */
		   String name = "abcdefg";
		   String name1 = name.replace('a', '1');
		   System.out.println(name1);
		   String name2 = StringUtils.replace(name, "ab", "12");
		   System.out.println(name2);
		
		
		
		
		
		
		
		
		
	}

}
