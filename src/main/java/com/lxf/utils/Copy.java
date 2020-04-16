package com.lxf.utils;


import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author shin
 */
public class Copy {


  /**
   * 将一个list的可复制元素全部复制到指定的类型list
   *
   * @param sources
   * @param clazz
   * @param <T>
   * @return
   */
  public static <T> List<T> copyList(List<?> sources, Class<T> clazz) {
    if (CollectionUtils.isEmpty(sources)) {
      return new ArrayList<T>(0);
    }
    List<T> result = new ArrayList<T>(sources.size());
    for (Object source : sources) {
      T target = null;
      try {
        target = clazz.newInstance();
      } catch (InstantiationException | IllegalAccessException e) {
        e.printStackTrace();
        return new ArrayList<T>(0);
      }

      try {
        PropertyUtils.copyProperties(target, source);
//            	BeanUtils.copyProperties(target, source);
      } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        e.printStackTrace();
        return new ArrayList<T>(0);
      }
      result.add(target);
    }
    return result;
  }

  /**
   * 生成一个指定类型，并复制
   *
   * @param source
   * @param clazz
   * @param <T>
   * @return
   */
  public static <T> T copy(Object source, Class<T> clazz) {
    if (source == null) {
      return null;
    }
    T target = null;
    try {
      target = clazz.newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
      return null;
    }
    try {
      PropertyUtils.copyProperties(target, source);
//        	BeanUtils.copyProperties(target, source);
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      e.printStackTrace();
      return null;
    }
    return target;
  }
}
