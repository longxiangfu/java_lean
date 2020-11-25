package com.lxf.jdk.other;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/**
 * 检查类重复工具类
 */
@Slf4j
public class Duplicate {

    public static void checkDuplicateClass(Class cls) {
        checkDuplicate(cls.getName().replace('.', '/') + ".class");
    }

    public static void checkDuplicate(String path) {
        try {
            // 在ClassPath搜文件
            Enumeration urls = Thread.currentThread().getContextClassLoader().getResources(path);
            Set files = new HashSet();
            while (urls.hasMoreElements()) {
                URL url = (URL) urls.nextElement();
                if (url != null) {
                    String file = url.getFile();
                    if (file != null && file.length() > 0) {
                        files.add(file);
                    }
                }
            }
            // 如果有多个，就表示重复
            if (files.size() > 1) {
                log.error("Duplicate class " + path + " in " + files.size() + " jar " + files);
            }
        } catch (Throwable e) { // 防御性容错
            log.error(e.getMessage(), e);
        }
    }


    public static void main(String[] args) {
        Duplicate.checkDuplicateClass(SpringApplication.class);
    }


}
