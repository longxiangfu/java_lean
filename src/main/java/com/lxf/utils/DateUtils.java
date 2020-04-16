package com.lxf.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

  private static String[] parsePatterns = {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};
  private static Map<String, String> mapConste = null;

  static {
    mapConste = new HashMap<String, String>();
    mapConste.put("摩羯座", "12-22,01-19");
    mapConste.put("水瓶座", "01-20,02-18");
    mapConste.put("双鱼座", "02-19,03-20");
    mapConste.put("白羊座", "03-21,04-19");
    mapConste.put("金牛座", "04-20,05-20");
    mapConste.put("双子座", "05-21,06-21");
    mapConste.put("巨蟹座", "06-22,07-22");
    mapConste.put("狮子座", "07-23,08-22");
    mapConste.put("处女座", "08-23,09-22");
    mapConste.put("天秤座", "09-23,10-23");
    mapConste.put("天蝎座", "10-24,11-22");
    mapConste.put("射手座", "11-23,12-21");
  }

  /**
   * 得到当前日期字符串 格式（yyyy-MM-dd）
   */
  public static String getDate() {
    return getDate("yyyy-MM-dd");
  }

  /**
   * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
   */
  public static String getDate(String pattern) {
    return DateFormatUtils.format(new Date(), pattern);
  }

  /**
   * 字符串转换成日期
   */
  public static Date parse(String patternStr, String dateString) {
    try {
      return new SimpleDateFormat(patternStr).parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * 与当天日期比较大小
   */
  public static boolean compareCurrentDate(Date date) {
    return new Date().after(date);
  }

  /**
   * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
   */
  public static String formatDate(Date date, Object... pattern) {
    String formatDate = null;
    if (date != null) {
      try {
        if (pattern != null && pattern.length > 0) {
          formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
          formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
      } catch (Exception e) {
      }
    }
    return formatDate;
  }

  /**
   * 返回当天日期加上或减去（-1）指定天数的日期
   *
   * @param day
   * @return
   */
  public static Date getCurDateByDay(int day) {
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DAY_OF_MONTH, day);
    return c.getTime();
  }

  /**
   * 指定日期 加上天数后的日期
   *
   * @param day
   * @param date
   */
  public static Date addDayOnDate(Date date, int day) {
    if (date != null) {
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(date);
      calendar.add(Calendar.DATE, day);
      return calendar.getTime();
    }
    return null;
  }

  /**
   * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
   */
  public static String formatDateTime(Date date) {
    return formatDate(date, "yyyy-MM-dd HH:mm:ss");
  }

  /**
   * 得到当前时间字符串 格式（HH:mm:ss）
   */
  public static String getTime() {
    return formatDate(new Date(), "HH:mm:ss");
  }

  /**
   * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
   */
  public static String getDateTime() {
    return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
  }

  /**
   * 得到当前年份字符串 格式（yyyy）
   */
  public static String getYear() {
    return formatDate(new Date(), "yyyy");
  }

  /**
   * 得到当前月份字符串 格式（MM）
   */
  public static String getMonth() {
    return formatDate(new Date(), "MM");
  }

  /**
   * 得到当天字符串 格式（dd）
   */
  public static String getDay() {
    return formatDate(new Date(), "dd");
  }

  /**
   * 得到当前星期字符串 格式（E）星期几
   */
  public static String getWeek() {
    return formatDate(new Date(), "E");
  }

  /**
   * 得到指定日期星期字符串 格式（E）星期几
   */
  public static String getWeek(Date date) {
    return formatDate(date, "E");
  }

  /**
   * 得到指定日期星期(数字) 星期日 0
   */
  public static Integer getWeekNumber(Date date) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    return cal.get(Calendar.DAY_OF_WEEK) - 1;
  }

  /**
   * 日期型字符串转化为日期 格式 { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
   * "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
   */
  public static Date parseDate(Object str) {
    if (str == null || str.toString().equals("")) {
      return null;
    }
    try {
      return parseDate(str.toString(), parsePatterns);
    } catch (ParseException e) {
      return null;
    }
  }

  /**
   * 根据生日获取星座
   *
   * @param date
   * @return
   */
  public static String getConstellation(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    int month = calendar.get(Calendar.MONTH) + 1;
    int day = calendar.get(Calendar.DAY_OF_MONTH);
    int[] dayArr = new int[]{20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22};
    String[] constellationArr = new String[]{"摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};
    return day < dayArr[month - 1] ? constellationArr[month - 1] : constellationArr[month];
  }

  /**
   * 根据星座获取出生日期范围
   *
   * @param constellation
   * @return
   */
  public static String getConstellationDate(String constellation) {
    if (mapConste != null) {
      return mapConste.get(constellation);
    }
    //
    return "";
  }

  /**
   * 获取过去的天数
   *
   * @param date
   * @return
   */
  public static long pastDays(Date date) {
    long t = System.currentTimeMillis() - date.getTime();
    return t / (24 * 60 * 60 * 1000);
  }

  public static long pastDays(Date startDate, Date endDate) {
    long t = endDate.getTime() - startDate.getTime();
    return t / (24 * 60 * 60 * 1000);
  }

  /**
   * 获取过去的小时
   *
   * @param date
   * @return
   */
  public static long pastHour(Date date) {
    long t = System.currentTimeMillis() - date.getTime();
    return t / (60 * 60 * 1000);
  }

  /**
   * 获取过去的分钟
   *
   * @param date
   * @return
   */
  public static long pastMinutes(Date date) {
    long t = System.currentTimeMillis() - date.getTime();
    return t / (60 * 1000);
  }

  /**
   * 转换为时间（天,时:分:秒.毫秒）
   *
   * @param timeMillis
   * @return
   */
  public static String formatDateTime(long timeMillis) {
    long day = timeMillis / (24 * 60 * 60 * 1000);
    long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
    long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
    long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
    long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
    return (day > 0 ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
  }

  /**
   * 获取两个日期之间的天数
   *
   * @param before
   * @param after
   * @return
   */
  public static double getDistanceOfTwoDate(Date before, Date after) {
    long beforeTime = before.getTime();
    long afterTime = after.getTime();
    return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
  }

  /**
   * 时间差比较
   *
   * @param startDate
   * @param endDate
   * @return 差异的秒 数
   * @throws ParseException
   */
  public static long dateCompare(Date startDate, Date endDate) {
    return (startDate.getTime() - endDate.getTime()) / 1000;
  }

  /**
   * 获取本周第几天
   */
  public static long getDayOfWeek() {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date());
    return calendar.get(Calendar.DAY_OF_WEEK);
  }

  /**
   * 得到本周周一
   *
   * @return yyyy-MM-dd
   */
  public static String getMondayOfThisWeek() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar c = Calendar.getInstance();
    int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
    if (day_of_week == 0) {
      day_of_week = 7;
    }
    c.add(Calendar.DATE, -day_of_week + 1);
    return sdf.format(c.getTime());
  }

  /**
   * 获取本月第一天
   */
  public static String getFirstDayOfMonth() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    c.add(Calendar.MONTH, 0);
    c.set(Calendar.DAY_OF_MONTH, 1);
    return sdf.format(c.getTime());
  }

  /**
   * 获取本月最后一天
   */
  public static String getLastDayOfMonth() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Calendar c = Calendar.getInstance();
    c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
    return sdf.format(c.getTime());
  }

  /**
   * 比较时间
   *
   * @param date
   * @param anotherDate
   * @return 小与-1 等于0 大于 1
   */
  public static int compareToDate(Date date, Date anotherDate) {
    if (date == null) {
      return -2;
    }
    if (anotherDate == null) {
      return -3;
    }
    return date.compareTo(anotherDate);
  }

  /**
   * @方法说明: 获得N个月之后的时间 yyyy-MM-dd
   */
  public static String getFutureTime(Integer month) {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    c.setTime(new Date());
    c.add(Calendar.MONTH, month);
    Date d2 = c.getTime();
    return sdf.format(d2);
  }

  /**
   * @方法说明: 获取当前时间所在周的开始日期
   */
  public static Date getFirstDayOfWeek(Date date) {
    Calendar c = new GregorianCalendar();
    c.setFirstDayOfWeek(Calendar.MONDAY);
    c.setTime(date);
    c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
    return c.getTime();
  }

  /**
   * 判断是否是日期
   */
  public static boolean isDate(String str, String format) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    boolean dateflag = true;
    try {
      simpleDateFormat.parse(str);
    } catch (ParseException e) {
      dateflag = false;
    }
    return dateflag;
  }

  /**
   * 获取年龄
   *
   * @param dateOfBirth
   * @return
   */
  public static int getAge(Date dateOfBirth) {
    int age = 0;
    Calendar born = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    if (dateOfBirth != null) {
      now.setTime(new Date());
      born.setTime(dateOfBirth);
      if (born.after(now)) {
        throw new IllegalArgumentException("年龄不能超过当前日期");
      }
      age = now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
      int nowDayOfYear = now.get(Calendar.DAY_OF_YEAR);
      int bornDayOfYear = born.get(Calendar.DAY_OF_YEAR);
      if (nowDayOfYear < bornDayOfYear) {
        age -= 1;
      }
    }
    return age;
  }

  public static String parseLongTime(String longTime) {
    try {
      long time = Long.parseLong(longTime);
      String dateTime = formatDate(new Date(time), "yyyy-MM-dd HH:mm:ss");
      return dateTime;
    } catch (Exception e) {
      e.printStackTrace();
      return "";
    }
  }

  /**
   * 获取出生年
   *
   * @param age
   * @return
   */
  public static int getBirthYear(int age) {
    Calendar mycalendar = Calendar.getInstance();// 获取现在时间
    int nowDayOfYear = mycalendar.get(Calendar.YEAR);
    int birth = nowDayOfYear - age;
    return birth;
  }

  /***
   * 获取当天剩余的秒
   * @return
   */
  public static int secondsLeftToday() {
    Long secondsLeftToday = 86400 - DateUtils.getFragmentInSeconds(Calendar.getInstance(), Calendar.DATE);
    return secondsLeftToday.intValue();
  }

  public static void main(String[] args) {
    System.out.println(parseLongTime("1508478862000"));
  }

}
