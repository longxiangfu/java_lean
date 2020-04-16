package com.lxf.web.action.transaction;

import com.lxf.web.service.transaction.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * 1、数据库存储引擎是Innodb时，才支持事务
 * 2、service中方法是public时，才支持事务
 * 3、RuntimeException和Error可以回滚事务，检查异常不能回滚事务（IoException\SqlException）
 * 4、service中一个没有加@Transactional的方法，调用另一个有@Transactional修饰的方法时，事务是不生效的。
 * 原因：通过调用堆栈，发现CglibAopProxy的方法intercept(),其中有这样块代码：方法拦截器列表如果为空，则直接反射调用目标方法，
 * 否则调用代理方法
 * 可以在整个类上加上注解，那么类中所有方法都会加事务
 */
@Slf4j
//@CrossOrigin 解决跨域
@RestController
@RequestMapping("/test/transaction")
public class TransactionController implements InitializingBean, DisposableBean, InstantiationAwareBeanPostProcessor, BeanNameAware,
        BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware, EmbeddedValueResolverAware, ApplicationContextAware,
    ResourceLoaderAware, MessageSourceAware, ApplicationEventPublisherAware {

    @Resource
    TransactionService service;


    @GetMapping("/deleteAllAndAddOne")
    public void deleteAllAndAddOne() throws SQLException {
        service.deleteAllAndAddOne();
    }

    @GetMapping("/deleteAllAndAddOneTransactional")
    public void deleteAllAndAddOneTransactional() throws SQLException {
        service.deleteAllAndAddOneTransactional();
    }

    @GetMapping("/selectAll")
    public void selectAll(){
        service.selectAll();
    }


    public void initMethod(){
        System.out.println("TransactionController 初始化 init");
    }

    /**
     * Bean的自定义初始化方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("TransactionController 初始化 afterProperrtiesSet");
    }

    /**
     * Bean的自定义销毁方法
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("TransactionController 销毁");
    }

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public void setBeanName(String name) {

    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    @Override
    public void setEnvironment(Environment environment) {

    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }

    @Override
    public void setMessageSource(MessageSource messageSource) {

    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }
}
