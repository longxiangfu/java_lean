package com.lxf.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import redis.clients.jedis.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Redis配置
 */
@ComponentScan(value = {"com.lxf.utils"})
public class JedisConfig {

//    @Value("${AES.KEY}")
//    private String aesKey;

//    @Value("${redis.host}")
//    private String host;
//
//    @Value("${redis.password}")
//    private String password;
//
//    @Value("${redis.timeout}")
//    private Integer timeout;
//
//    @Value("${redis.port}")
//    private Integer port;
//
//    @Value("${redis.jedis.pool.min-idle}")
//    private Integer minIdle;
//
//    @Value("${redis.jedis.pool.max-idle}")
//    private Integer maxIdle;
//
//    @Value("${redis.jedis.pool.max-active}")
//    private Integer maxTotal;
//
//    @Value("${redis.jedis.pool.max-wait}")
//    private Long maxWaitMillis;

    /*
     * JedisPool
     */
//    @Bean //此处返回的是一个Spring的配置Bean，与xml的<bean>等价
//    public JedisPool getJedisPool() {
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
////        jedisPoolConfig.setMaxIdle(maxIdle);
////        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
////        jedisPoolConfig.setMinIdle(minIdle);
////        jedisPoolConfig.setMaxTotal(maxTotal);
//        jedisPoolConfig.setTestOnCreate(true);
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "43.138.16.37", 6379, 1000, "sgHuBbGNJeEfPnph");
//        return jedisPool;
//    }


    /*
     * JedisSentinelPool
     */
//    @Bean
//    public JedisSentinelPool jedisSentinelPool() {
//        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//        Set<String> sentinels = new HashSet<>();
//        sentinels.add("43.138.16.37:26379");
//        sentinels.add("43.138.16.37:26380");
//        sentinels.add("43.138.16.37:26381");
//        JedisSentinelPool jedisSentinelPool = new JedisSentinelPool("mymaster", sentinels, poolConfig, 1000);
//        return jedisSentinelPool;
//    }


    /*
     * jedisClusterPool
     */
    @Bean
    public JedisCluster jedisCluster() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        Set<HostAndPort> clusters = new HashSet<>();
        clusters.add(new HostAndPort("43.138.16.37", 8001));
        clusters.add(new HostAndPort("43.138.16.37", 8002));
        clusters.add(new HostAndPort("43.138.16.37", 8003));
        clusters.add(new HostAndPort("43.138.16.37", 8004));
        clusters.add(new HostAndPort("43.138.16.37", 8005));
        clusters.add(new HostAndPort("43.138.16.37", 8006));
        JedisCluster jedisCluster = new JedisCluster(clusters, 6000, 5000, 1, poolConfig);
        return jedisCluster;
    }

   /* @Autowired
    private RedisConnectionFactory factory;

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(factory);
        return redisTemplate;
    }

    @Bean
    public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForHash();
    }

    @Bean
    public ValueOperations<String, String> valueOperations(RedisTemplate<String, String> redisTemplate) {
        return redisTemplate.opsForValue();
    }

    @Bean
    public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForList();
    }

    @Bean
    public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForSet();
    }

    @Bean
    public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
        return redisTemplate.opsForZSet();
    }*/
}
