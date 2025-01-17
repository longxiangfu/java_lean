package com.lxf.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类, 继承org.apache.commons.lang3.StringUtils类
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {

  private static final char SEPARATOR = '_';
  private static final String CHARSET_NAME = "UTF-8";
  private static final String[] ALPHABET = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
  private static final String[] NUMBER = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

  /**
   * 转换为字节数组
   *
   * @param str
   * @return
   */
  public static byte[] getBytes(String str) {
    if (str != null) {
      try {
        return str.getBytes(CHARSET_NAME);
      } catch (UnsupportedEncodingException e) {
        return null;
      }
    } else {
      return null;
    }
  }

  /**
   * @param strings
   * @return String
   * @throws
   * @Description 将字符串数组拼接成字符串
   * @Author 王琳
   * @Date 2016-3-21
   */
  public static String buildStringArray(String... strings) {
    if (strings == null || strings.length == 0) {
      return "";
    }
    StringBuffer sb = new StringBuffer();
    for (String string : strings) {
      sb.append(string).append(" ");
    }
    return sb.toString().trim();
  }

  /**
   * 是否是手机号
   *
   * @param mobile
   * @return
   */
  public static boolean isMobile(String mobile) {
    try {
      Pattern p = Pattern.compile("^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$");
      Matcher m = p.matcher(mobile);
      return m.matches();
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * 转换为字节数组
   *
   * @param
   * @return
   */
  public static String toString(byte[] bytes) {
    try {
      return new String(bytes, CHARSET_NAME);
    } catch (UnsupportedEncodingException e) {
      return EMPTY;
    }
  }

  /**
   * 是否包含字符串
   *
   * @param str  验证字符串
   * @param strs 字符串组
   * @return 包含返回true
   */
  public static boolean inString(String str, String... strs) {
    if (str != null) {
      for (String s : strs) {
        if (str.equals(trim(s))) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * 替换掉HTML标签方法
   */
  public static String replaceHtml(String html) {
    if (isBlank(html)) {
      return "";
    }
    String regEx = "<.+?>";
    Pattern p = Pattern.compile(regEx);
    Matcher m = p.matcher(html);
    String s = m.replaceAll("");
    return s;
  }

  /**
   * 替换为手机识别的HTML，去掉样式及属性，保留回车。
   *
   * @param html
   * @return
   */
  public static String replaceMobileHtml(String html) {
    if (html == null) {
      return "";
    }
    return html.replaceAll("<([a-z]+?)\\s+?.*?>", "<$1>");
  }

  /**
   * 替换为手机识别的HTML，去掉样式及属性，保留回车。
   *
   * @param txt
   * @return
   */
//	public static String toHtml(String txt) {
//		if (txt == null) {
//			return "";
//		}
//		return replace(replace(Encodes.escapeHtml(txt), "\n", "<br/>"), "\t", "&nbsp; &nbsp; ");
//	}

  /**
   * 缩略字符串（不区分中英文字符）
   *
   * @param str    目标字符串
   * @param length 截取长度
   * @return
   */
  public static String abbr(String str, int length) {
    if (str == null) {
      return "";
    }
    try {
      StringBuilder sb = new StringBuilder();
      int currentLength = 0;
      for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
        currentLength += String.valueOf(c).getBytes("GBK").length;
        if (currentLength <= length - 3) {
          sb.append(c);
        } else {
          sb.append("...");
          break;
        }
      }
      return sb.toString();
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return "";
  }

  public static String abbr2(String param, int length) {
    if (param == null) {
      return "";
    }
    StringBuffer result = new StringBuffer();
    int n = 0;
    char temp;
    boolean isCode = false; // 是不是HTML代码
    boolean isHTML = false; // 是不是HTML特殊字符,如&nbsp;
    for (int i = 0; i < param.length(); i++) {
      temp = param.charAt(i);
      if (temp == '<') {
        isCode = true;
      } else if (temp == '&') {
        isHTML = true;
      } else if (temp == '>' && isCode) {
        n = n - 1;
        isCode = false;
      } else if (temp == ';' && isHTML) {
        isHTML = false;
      }
      try {
        if (!isCode && !isHTML) {
          n += String.valueOf(temp).getBytes("GBK").length;
        }
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }

      if (n <= length - 3) {
        result.append(temp);
      } else {
        result.append("...");
        break;
      }
    }
    // 取出截取字符串中的HTML标记
    String temp_result = result.toString().replaceAll("(>)[^<>]*(<?)", "$1$2");
    // 去掉不需要结素标记的HTML标记
    temp_result = temp_result.replaceAll("</?(AREA|BASE|BASEFONT|BODY|BR|COL|COLGROUP|DD|DT|FRAME|HEAD|HR|HTML|IMG|INPUT|ISINDEX|LI|LINK|META|OPTION|P|PARAM|TBODY|TD|TFOOT|TH|THEAD|TR|area|base|basefont|body|br|col|colgroup|dd|dt|frame|head|hr|html|img|input|isindex|li|link|meta|option|p|param|tbody|td|tfoot|th|thead|tr)[^<>]*/?>", "");
    // 去掉成对的HTML标记
    temp_result = temp_result.replaceAll("<([a-zA-Z]+)[^<>]*>(.*?)</\\1>", "$2");
    // 用正则表达式取出标记
    Pattern p = Pattern.compile("<([a-zA-Z]+)[^<>]*>");
    Matcher m = p.matcher(temp_result);
    List<String> endHTML = Lists.newArrayList();
    while (m.find()) {
      endHTML.add(m.group(1));
    }
    // 补全不成对的HTML标记
    for (int i = endHTML.size() - 1; i >= 0; i--) {
      result.append("</");
      result.append(endHTML.get(i));
      result.append(">");
    }
    return result.toString();
  }

  public static String getNewOrderNO() {
    Date date = new Date();
    Random r = new Random();
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 5; i++) {
      sb.append(r.nextInt(10));
    }
    String dNo = DateUtils.formatDate(date, "yyyyMMddHHmmssSSS") + sb.toString();
    return dNo;
  }

  /**
   * 转换为Double类型
   */
  public static Double toDouble(Object val) {
    if (val == null) {
      return 0D;
    }
    try {
      return Double.valueOf(trim(val.toString()));
    } catch (Exception e) {
      return 0D;
    }
  }

  // 生成随机验证码
  public static String randomValidCode() {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 4; i++) {
      sb.append(RandomUtils.nextInt(10, 0));
    }
    return sb.toString();
  }

  /**
   * 转换为Float类型
   */
  public static Float toFloat(Object val) {
    return toDouble(val).floatValue();
  }

  /**
   * 转换为Long类型
   */
  public static Long toLong(Object val) {
    return toDouble(val).longValue();
  }

  /**
   * 转换为Integer类型
   */
  public static Integer toInteger(Object val) {
    return toLong(val).intValue();
  }

  /**
   * 转换为String类型
   */
  public static String toString(Object val) {
    return val == null ? "" : val.toString();
  }


  /**
   * 获得用户远程地址
   */
  public static String getRemoteAddr(HttpServletRequest request) {
    String remoteAddr = request.getHeader("X-Real-IP");
    if (isNotBlank(remoteAddr)) {
      remoteAddr = request.getHeader("X-Forwarded-For");
    } else if (isNotBlank(remoteAddr)) {
      remoteAddr = request.getHeader("Proxy-Client-IP");
    } else if (isNotBlank(remoteAddr)) {
      remoteAddr = request.getHeader("WL-Proxy-Client-IP");
    }
    return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
  }

  /**
   * 驼峰命名法工具
   *
   * @return toCamelCase(" hello_world ") == "helloWorld" toCapitalizeCamelCase("hello_world") == "HelloWorld" toUnderScoreCase("helloWorld") = "hello_world"
   */
  public static String toCamelCase(String s) {
    if (s == null) {
      return null;
    }

    s = s.toLowerCase();

    StringBuilder sb = new StringBuilder(s.length());
    boolean upperCase = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == SEPARATOR) {
        upperCase = true;
      } else if (upperCase) {
        sb.append(Character.toUpperCase(c));
        upperCase = false;
      } else {
        sb.append(c);
      }
    }

    return sb.toString();
  }

  /**
   * 驼峰命名法工具
   *
   * @return toCamelCase(" hello_world ") == "helloWorld" toCapitalizeCamelCase("hello_world") == "HelloWorld" toUnderScoreCase("helloWorld") = "hello_world"
   */
  public static String toCapitalizeCamelCase(String s) {
    if (s == null) {
      return null;
    }
    s = toCamelCase(s);
    return s.substring(0, 1).toUpperCase() + s.substring(1);
  }

  /**
   * 驼峰命名法工具
   *
   * @return toCamelCase(" hello_world ") == "helloWorld" toCapitalizeCamelCase("hello_world") == "HelloWorld" toUnderScoreCase("helloWorld") = "hello_world"
   */
  public static String toUnderScoreCase(String s) {
    if (s == null) {
      return null;
    }

    StringBuilder sb = new StringBuilder();
    boolean upperCase = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      boolean nextUpperCase = true;

      if (i < (s.length() - 1)) {
        nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
      }

      if ((i > 0) && Character.isUpperCase(c)) {
        if (!upperCase || !nextUpperCase) {
          sb.append(SEPARATOR);
        }
        upperCase = true;
      } else {
        upperCase = false;
      }

      sb.append(Character.toLowerCase(c));
    }

    return sb.toString();
  }

  /**
   * 转换为JS获取对象值，生成三目运算返回结果
   *
   * @param objectString 对象串 例如：row.user.id 返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
   */
  public static String jsGetVal(String objectString) {
    StringBuilder result = new StringBuilder();
    StringBuilder val = new StringBuilder();
    String[] vals = split(objectString, ".");
    for (int i = 0; i < vals.length; i++) {
      val.append("." + vals[i]);
      result.append("!" + (val.substring(1)) + "?'':");
    }
    result.append(val.substring(1));
    return result.toString();
  }

  /**
   * 字符串是否为空，null或空字符串时返回true,其他情况返回false
   */
  public static boolean isEmpty(String str) {
    return str == null || str.length() == 0;
  }

  /**
   * 字符串是否为空，null或空字符串时返回true,其他情况返回false
   */
  public static boolean isEmpty(Object str) {
    return str == null || str.toString().length() == 0;
  }

  /**
   * 字符串是否不为空，null或空字符串时返回false,其他情况返回true
   */
  public static boolean isNotEmpty(String str) {
    return !StringUtils.isEmpty(str);
  }

  /**
   * 获取四位随机数
   */
  public static String getRandom() {
    DecimalFormat df = new DecimalFormat("000");
    int i = RandomUtils.nextInt(1000, 0);
    return df.format(i);
  }

  /**
   * 生成随机字符数字组合(重复率率高)
   */
  public static String getStringRandom(int length) {
    String randomStr = "";
    Random random = new Random();
    for (int i = 0; i < length; i++) {
      String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
      if ("char".equalsIgnoreCase(charOrNum)) {
        int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
        randomStr += (char) (random.nextInt(26) + temp);
      } else if ("num".equalsIgnoreCase(charOrNum)) {
        randomStr += String.valueOf(random.nextInt(10));
      }
    }
    return randomStr.toUpperCase();
  }

  /**
   * 获取八位UUID(重复率极低)
   */
  public static String getShortUuid() {
    StringBuffer stringBuffer = new StringBuffer();
    String uuid = UUID.randomUUID().toString().replace("-", "");
    for (int i = 0; i < 8; i++) {
      String str = uuid.substring(i * 4, i * 4 + 4);
      int strInteger = Integer.parseInt(str, 16);
      stringBuffer.append(ALPHABET[strInteger % 0x3E]);
    }
    return stringBuffer.toString();
  }

  /**
   * 获取八位随机数
   */
  public static String getSignCode() {
    StringBuffer shortBuffer = new StringBuffer();
    String uuid = UUID.randomUUID().toString().replace("-", "");
    for (int i = 0; i < 8; i++) {
      String str = uuid.substring(i * 4, i * 4 + 4);
      int x = Integer.parseInt(str, 16);
      shortBuffer.append(NUMBER[x % 0x0a]);
    }
    return shortBuffer.toString();

  }

  /**
   * 判断是否是数字字符串
   **/
  public static boolean isNumeric(String str) {
    if (StringUtils.isEmpty(str)) {
      return false;
    }
    Pattern pattern = Pattern.compile("[0-9]*");
    Matcher isNum = pattern.matcher(str);
    if (!isNum.matches()) {
      return false;
    }
    return true;
  }

  // 只能判断部分CJK字符（CJK统一汉字）
  public static boolean isChineseByREG(String str) {
    if (str == null) {
      return false;
    }
    Pattern pattern = Pattern.compile("[\\u4E00-\\u9FBF]+");
    return pattern.matcher(str.trim()).find();
  }

  public static String defaultBlank(Object str) {
    return str == null ? "" : str.toString();
  }

  /**
   * 替换 ' "
   */
  public static String replaceSqlEscape(String r) {
    String res = "";
    if (StringUtils.isNotBlank(r)) {
      res = r.replaceAll("'", "\\\\\'").replaceAll("\"", "\\\\\"");
    }
    return res;
  }

  /**
   * 产生空格
   */
  public static String blank(int k) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < k; i++) {
      sb.append(" ");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(isMobile("16601235896"));
    System.out.println("k" + blank(3) + "k");
  }

}
