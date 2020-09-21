package com.lxf.jdk.jdk_E;

//import static org.hamcrest.CoreMatchers.startsWith;

//import java.lang.annotation.Annotation;
//import java.time.Clock;
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.Month;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.time.format.FormatStyle;
//import java.time.temporal.ChronoField;
//import java.time.temporal.ChronoUnit;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

//import java.util.Comparator;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Locale;
//import java.util.Map.Entry;
//import java.util.Objects;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//import java.util.function.Predicate;
//import java.util.function.Supplier;
//import java.util.stream.Collector;

//import org.springframework.stereotype.Component;
//import com.jayway.jsonpath.internal.function.numeric.Min;
//
//import ch.qos.logback.classic.net.SyslogAppender;

/**
 * java8新特性
 * 4、reactor反应式编程
 * @author Administrator
 *
 */
public class PropertiesNew {
	static int outerStaticNum;
	int outerNum;

	/**
	 * Lambd表达式
	 */
	public static void demo() {//////////////////////////////////////
		List<String> list = Arrays.asList("1","2","3","0");
		//1、排序
		list.stream().sorted((str1, str2) -> str1.compareTo(str2)).forEach(string -> System.out.print(string+" "));
		//2、过滤
		list.stream().filter(string -> string.concat("0").equals("20")).forEach(string -> System.out.println("过滤："+string));
		//3、匹配
		System.out.println("匹配："+list.stream().allMatch(stri -> stri.matches("2")));
		
		//4、map - reduce计数
		System.out.println("计数："+list.stream().map(key -> 1).reduce((sum,val) -> sum+val).get());
		//5、map - reduce加和
		System.out.println("规约："+list.stream().map(key -> Integer.parseInt(key)).reduce((sum,val) -> sum+val).get());
		//6、统计
		System.out.println("统计："+list.stream().mapToInt(item -> Integer.parseInt(item)).summaryStatistics().getSum());
		//Map 操作:list->map
		User user1 = new User();
		user1.setUsername("darren1");
		user1.setAge(1);
		user1.setSex("M");
		User user2 = new User();
		user2.setUsername("darren2");
		user2.setAge(2);
		user2.setSex("F");
		List<User> users1 = new ArrayList<>();
		users1.add(user1);
		users1.add(user2);
		//List >> Map
		Map<String,User> userMap = users1.stream().collect(Collectors.toMap(User::getUsername, Function.identity()));
		if(userMap.containsKey("darren1")) {
			System.out.println("darren1 in Map");
		}
		//Map >> List
		List<User> listValues = new ArrayList<User>(userMap.values());
		listValues.stream().forEach(System.out::println);
		List<String> listKeys = new ArrayList<String>(userMap.keySet());
		listKeys.stream().forEach(System.out::println);
	}
	/**
	 * 接口的默认方法
	 * 1、定义了接口Formula,该接口中除了抽象方法之外，还包括默认的非抽象方法；
	 * 2、该接口的实现类可以直接使用接口默认的非抽象方法
	 */
	public static void demo1() {
		Formula formula = new Formula() {
			@Override
			public double calculate(int a) {
				return sqrt(a);
			}
			
		};
		
		System.out.println(formula.calculate(100));
		System.out.println(formula.sqrt(16));
	}
	/**
	 * lambda表达式的基本语法
	 */
	public static void demo2() {
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		//完整的表达式
//		Collections.sort(names,(String a, String b) -> {
//			return b.compareTo(a);
//		});
		Collections.sort(names, (String a, String b) -> {
			return b.compareTo(a);
		});
		//当lambda表达式只包含一条语句时，可以省略大括号、return和语句结尾的分号
//		Collections.sort(names,(String a,String b) -> b.compareTo(b));
		Collections.sort(names, (String a, String b) -> b.compareTo(a));
		//参数类型省略。–绝大多数情况，编译器都可以从上下文环境中推断出lambda表达式的参数类型
//		Collections.sort(names,(a, b) -> b.compareTo(a));	
		Collections.sort(names, (a, b) -> b.compareTo(a));
		//当lambda表达式的参数个数只有一个，可以省略小括号
//		Collections.sort(names, c -> System.out.println(c));
//		Collections.sort(names, a -> System.out.println(c));
		System.out.println(names.toString());
		
	}
	/**
	 * 函数式接口
	 * 1、Lambda表达式对应的是函数式接口；
	 * 2、函数式接口：只包含一个抽象方法的接口（除了继承自超类的方法、默认方法、静态方法除外）；
	 * 3、函数式接口需要添加注解@FunctionalInterface;（其实只要满足条件的接口都可以成为函数式接口）
	 * 4、Lambda表达式对应的接口如果没有指定该注解，表达式也不会报错(只要符合只有一个抽象方法实现的接口就是函数式接口，
	 * 不过加上注解是好的编程习惯)
	 */
	public static void demo3() {
//		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
//		System.out.println(converter.convert("123"));
		Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
		System.out.println(converter.convert("123"));
		
	}
	/**
	 * Lambda表达式就是为了实现函数式接口中的抽象方法的（也可以访问默认方法）;每一个该类型的lambda表达式都会被匹配到这个抽象方法
	 * Lambda表达式用静态方法引用、对象方法引用和构造函数引用来表示
	 * java8允许使用::关键字来传递方法或构造函数引用
	 */
	public static void demo4() {
		//Lambda表达式用静态放方法引用表示
//		Converter<String, Integer> converter = Integer::valueOf;
//		System.out.println(converter.convert("123"));
		Converter<String, Integer> converter = Integer::valueOf;
		System.out.println(converter.convert("123"));
		//Lambda表达式用对象方法引用表示
//		Converter<String,Boolean> converter1 = "Lambda"::startsWith;
//		Boolean converted = converter1.convert("L");
//		System.out.println(converted);
		Converter<String, Boolean> converter1 = "Lamada"::startsWith;
		System.out.println(converter.convert("L"));
		//Lambda表达式用构造函数引用表示
//		PersonFactory<Person> personFactory = Person::new;
//		System.out.println(personFactory.create("1", "longxiangfu", "M").getName());
		PersonFactory<Person> personFactory = Person::new;
		System.out.println(personFactory.create("1", "longxiangfu", "M"));
	}
	/**
	 * Lambda作用域
	 * 1、访问局部变量，该变量隐含为final的
	 * 2、访问实例变量和静态变量
	 */
	public static void demo5() {
		final int num = 1;
		Converter<String,Integer> converter = from -> Integer.valueOf(from + num);
		System.out.println(converter.convert("123"));
//		num = 3;局部变量默认是final的，不能被改变
		
		Converter<String,Integer> converter1 = from ->{
			outerStaticNum = 45;
			return Integer.valueOf(from + outerStaticNum);
		};
		System.out.println(converter1.convert("123"));
		
		PropertiesNew lambda = new PropertiesNew();
		Converter<String,Integer> converter2 = from ->{
			lambda.outerNum = 45;
			return Integer.valueOf(from + lambda.outerNum);
		};
		System.out.println(converter2.convert("123"));
	}
	/**
	 * Lambda作用域
	 * 3、利用Lambda表达式访问接口的默认方法，该接口必须是函数式接口，即接口加了注解
	 */
	public static void demo6() {
//		/*
//		 * Predicate接口:判断
//		 */
//		Predicate<String> predicate = s ->s.length() >0;
//		Predicate<String> predicate1 = s ->s.length() <=0;
//		System.out.println(predicate.test("foo"));
//		System.out.println(predicate1.test("foo"));
//		//非
//		System.out.println(predicate.negate().test("foo"));
//		//与
//		System.out.println(predicate.and(predicate1).test("foo"));//1
//		System.out.println(predicate.test("foo") && predicate1.test("foo"));//2：相当于式1
//		System.out.println(predicate.test("foo") && predicate1.test(""));//3：式2的扩展
//		//或
//		System.out.println(predicate.or(predicate1).test("foo"));
//		//默认静态方法isEqual():判断对象是否相等
//		System.out.println(Predicate.isEqual("foo").test("foo1"));
//		
//		/*
//		 * Function接口：映射
//		 */
//		Function<String, Integer> toInteger = Integer::valueOf;
//		System.out.println(toInteger.apply("123")+" 类型："+toInteger.apply("123").getClass());
//		Function<String, String> backToString = toInteger.andThen(String::valueOf);//第一个方法的返回值作为第二个方法的入参
//		System.out.println(backToString.apply("123")+" 类型："+backToString.apply("123").getClass());
//		Function<Integer, Integer> backToInteger = toInteger.compose(String::valueOf);//第二个方法的返回值作为第一个方法的入参
//		System.out.println(backToInteger.apply(123)+" 类型："+backToInteger.apply(123).getClass());
//		
//		/*
//		 * Supplier接口:没有入参，返回一个任意泛型的值
//		 */
//		Supplier<Person> personSupplier = Person::new;
//		System.out.println(personSupplier.get());
//		
//		/*
//		 * Consumer接口:接受一个参数，不返回结果
//		 */
//		Consumer<Person> greeter = p ->System.out.println("Hello!"+p.getName());
//		Consumer<Person> greeter1 = p ->System.out.println("你好!"+p.getName());
//		greeter.accept(new Person("1","longxiangfu","M"));
//		greeter.andThen(greeter1).accept(new Person("2","longxiangfu","M"));//Consumer.andThen()提供链式操作
//		
//        /*
//         * Comparator接口：比较
//         */
//		Comparator<Person> compatator = (p1, p2) -> p1.getName().compareTo(p2.getName());
//		Person p1 = new Person("3","longxiangfu","M");
//		Person p2 = new Person("4","chenting","F");
//		System.out.println(compatator.compare(p1, p2));
//		System.out.println(compatator.reversed().compare(p1, p2));
		
		/*
		 * Optional接口:防止空指针异常的辅助类型，该接口不是函数式接口
		 */
		Optional<String> optional = Optional.of("bam");
		System.out.println(optional.isPresent());//若传入参数不为null,则返回true
		System.out.println(optional.get());//传入的参数不为null,这返回该参数；若为null,抛异常
		System.out.println(optional.orElse("fallback"));//传入的参数不为null,这返回该参数；否则返回指定参数
		Consumer<String> consumer = str ->System.out.println("我接收了一个参数："+str);
		optional.ifPresent(consumer);//若入参不为null,则将入参传给Comsumer
		//optional.ifPresent(str ->System.out.println("我接收了一个参数："+str));
		
//		/*
//		 * Stream接口:中间操作返回Stream本身，最终操作返回一特定类型的计算结果，这样可以将多个操作依次串起来
//		 * 分为串行流Collection.stream()和并行流Collection.parallelStream()
//		 */
//		int max = 10;//1000000
//		List<String> values = new ArrayList<String>();
//		for(int i = 0;i < max;i++) {
//			UUID uuid = UUID.randomUUID();
//			values.add(uuid.toString());
//		}
//		
//		//串行(并行)排序
//		long t0 = System.nanoTime();//纳秒；基于的时间点是随机的，但是对于同一个JVM里，不同地方使用到的基点时间是一样的
////		long t2 = System.currentTimeMillis();//毫秒；系统当前时间和1970-01-01之前间隔时间的毫秒数，用于计算代码执行消耗的时间 ，也可以和Date类方便的转换
//		long count = values.stream().sorted().count();//970ms
////		long count = values.parallelStream().sorted().count();//607ms
//		long t1 = System.nanoTime();
//		long mills = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
//		System.out.println(String.format("sequential sort took:%d ms", mills));
//		
//		/*
//		 * Filter过滤
//		 */
//		List<String> stringCollection = new ArrayList<>();
//		stringCollection.add("ddd2");
//		stringCollection.add("aaa2");
//		stringCollection.add("bbb1");
//		stringCollection.add("aaa1");
//		stringCollection.add("bbb3");
//		stringCollection.add("ccc");
//		stringCollection.add("bbb2");
//		stringCollection.add("ddd1");
//		stringCollection.stream().filter(s -> s.startsWith("a")).forEach(System.out::println);
//		
//		/*
//		 * Sort排序
//		 */
//		stringCollection.stream().sorted().filter(s -> s.startsWith("a")).forEach(System.out::println);
//		System.out.println(stringCollection);//排序不影响原来的集合
//        stringCollection.stream().sorted((str1,str2) -> str1.compareTo(str2)).forEach(System.out::println);
//        
//	    /*
//	     * Map映射
//	     */
//        stringCollection.stream().map(String::toUpperCase).sorted().forEach(System.out::println);
//        
//        /*
//         * Math匹配
//         */
//        boolean anyStartsWithA = stringCollection.stream().anyMatch(s -> s.startsWith("a"));
//        System.out.println(anyStartsWithA);
//        boolean allStartsWithA = stringCollection.stream().allMatch(s -> s.startsWith("a"));
//        System.out.println(allStartsWithA);
//        boolean noneStartsWithA = stringCollection.stream().noneMatch(s -> s.startsWith("z"));
//        System.out.println(noneStartsWithA);
//        
//        /*
//         * Reduce规约
//         */
//        Optional<String> reduced = stringCollection.stream().sorted().reduce((s1,s2) -> s1+"#"+s2);
//        reduced.ifPresent(System.out::println);
//        
//        /*
//         * Map类型：Map类型不支持Stream(java.util.Collection的子类，List或者Set支持)，
//         * 但Map类型提供了一些有用的方法来处理日常任务
//         */
//        //1、putIfAbsent(K key,V value)
//        Map<Integer,String> map = new HashMap<>();
//        map.put(7, "777");
//        for(int i = 0;i <10;i++) {
//        	map.putIfAbsent(i, "val"+i);//如果某key对应有确切的valus,则返回该value,否则返回传入的value
//        }
//        System.out.println(map.toString());
//        //2、computeIfPresent()：如果有的话，则执行
//        map.computeIfPresent(3, (num,val) -> val + num);
//        System.out.println(map.get(3));//val33
//        map.computeIfPresent(9, (num,val) -> null);
//        System.out.println(map.containsKey(9));//false
//        //3、computeIfAbsent()：如果缺少的话，则执行
//        map.computeIfAbsent(23, num -> "val" + num);
//        System.out.println(map.containsKey(23));//true
//        map.computeIfAbsent(3, num -> "bam");
//        System.out.println(map.get(3));//val33
//        //4、remove()
//        map.remove(3,"val3");
//        System.out.println(map.get(3));//val33
//        map.remove(3, "val33");
//        System.out.println(map.get(3));//null
//        //getOrDefault()
//        System.out.println(map.getOrDefault(42, "not found"));
//        //merge()
//        map.merge(9, "val9", (value,newValue) -> value.concat(newValue));
//        System.out.println(map.get(9));
//        map.merge(9, "concat", (value,newValue) -> value.concat(newValue));
//        System.out.println(map.get(9));
//        
//    }
//	/**
//	 * dataAPI
//	 */
//	public static void demo7() {
////		Clock clock = Clock.systemDefaultZone();
////		System.out.println(clock);//SystemClock[Asia/Shanghai]
////		System.out.println(clock.millis());//1510819384601
////		Instant instant = clock.instant();
////		Date legacyDate = Date.from(instant);
////		System.out.println(legacyDate);//Thu Nov 16 16:03:04 CST 2017
//		
//		System.out.println(ZoneId.getAvailableZoneIds());
//		ZoneId zone1 = ZoneId.of("Asia/Shanghai");//ZoneRules[currentStandardOffset=+08:00]
//		System.out.println(zone1.getRules());
//		ZoneId zone2 = ZoneId.of("Brazil/East");
//		System.out.println(zone2.getRules());
//		
//		LocalTime now1 = LocalTime.now(zone1);
//		LocalTime now2 = LocalTime.now(zone2);
//		System.out.println(now1.isBefore(now2));//false
//		long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
//		long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);
//		System.out.println(hoursBetween);//-10
//		System.out.println(minutesBetween);//-600
//		LocalTime late = LocalTime.of(23, 59, 59);//23:59:59
//		System.out.println(late);
//		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);
//		LocalTime leetTime = LocalTime.parse("13:37",germanFormatter);
//		System.out.println(leetTime);//13:37
//		
//		LocalDate today = LocalDate.now();
//		LocalDate tommorow = today.plus(1,ChronoUnit.DAYS);
//		System.out.println(tommorow.minusDays(2));
//		LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
//		System.out.println(independenceDay.getDayOfWeek());
//		DateTimeFormatter getmanFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.GERMAN);
//		LocalDate xmas = LocalDate.parse("24.12.2014",getmanFormatter);
//		System.out.println(xmas);// 2014-12-24
//		
//		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
//		System.out.println(sylvester.getDayOfWeek());// WEDNESDAY
//		System.out.println(sylvester.getMonth());// DECEMBER
//		long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
//		System.out.println(minuteOfDay);// 1439
//		Instant instant = sylvester.atZone(ZoneId.systemDefault()).toInstant();
//		System.out.println(ZoneId.systemDefault());
//		Date legacyDate = Date.from(instant);
//		System.out.println(legacyDate);// Wed Dec 31 23:59:59 CET 2014
	}
		
	public static void main(String[] args) {
//		demo();
//		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo5();
		demo6();
//		demo7();

	}

}
