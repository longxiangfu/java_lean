package com.lxf.config;

public class Config {

  public static final String REDIS_PREFIX = "CLUB_OPEN_";
  public static final String SYSTEM = "SSPWEB";

  public static final String CACHE_KEY_ADLIST = "ADLIST_CHANNEL_CODE_%s";
  public static final String CACHE_KEY_ADID = "ADID_CODE_%s";
  public static final Integer TIMEOUT_REDIS = 300; //5 minute

  public static final String SPLIT = String.valueOf((char) '\1');

  public static final String REQCNTKEY = "REQCNT";
  public static final String IMPCNTKEY = "IMPCNT";

  public static final String FAILURE = "FAIL";

  public static final String LOCK_PREFIX = "sspweb_prefix";
}
