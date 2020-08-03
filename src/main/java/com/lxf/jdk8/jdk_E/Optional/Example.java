package com.lxf.jdk8.jdk_E.Optional;


import java.util.Optional;

public class Example {
	
	/*
	 * Optional应该只用于返回类型，不能用于参数和属性
	 */
//	private Optional<?> convertedValue;
//	public final Object encode(final Optional<?> value) {
//		return encode(value, null);
//	}
 	
	/*
	 * 不应该简单的调用get()
	 */
//	final Optional<Key> key = mapper.getConverters().decode(keyClass, dbObject, mappedField);
//	if(key.isPresent()) {
//		proxiedMap.put(key.get(), value);//也有可能导致空指针
//	}else {
//		proxiedMap.put(createNewKey(), value);
//	}//原始的方式
//
//	final Optional<Key> key = mapper.getConverters().decode(keyClass, dbObject, mappedField);
//	proxiedMap.put(key.orElse(createNewKey()), value);//比较优雅的方式
//
//	final Optional<Key> key = mapper.getConverters().decode(keyClass, dbObject, mappedField);
//	proxiedMap.put(key.orElseGet(() -> createNewKey()), value);//最优雅的方式，和上面的情况一样，
																//只不过可以调用Supplier接口的实现，
																//使用Lamada表达式获得更好的性能
	
	
	/*
	 * 使用流式风格
	 */
//	return Stream.of(wordsInmessage)
//			.distinct()
//			.map(String::toLowerCase)
//			.map(WORD_TO_MOOD::get)
//			.filter(mood -> mood != null)
//			.distinct()
//			.map(Mood::name)
//			.collect(Collectors.joining(","));
	/*
	 * 使用方法引用
	 */
//	toCall.keySet().stream
//		.filter(Objects::nonMull)
//		.forEach(name -> toCall.put(name, getValue(name, mapper)));
	/*
	 * 对元素进行迭代时，使用Stream API
	 */
//	return persistenceFields.stram()
//			.filter(mf -> mf.getAnnotations().containsKey(Clazz))
//			.collect(toList());
	/*
	 * 遍历数组时，使用for循环，对数组来说，for循环的性能最好
	 */
}
