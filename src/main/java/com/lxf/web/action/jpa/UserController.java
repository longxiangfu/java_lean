package com.lxf.web.action.jpa;

import com.lxf.web.dao.ExtRepository;
import com.lxf.web.dao.UserRepository;
import com.lxf.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    UserRepository userRepository;

    @Resource
    ExtRepository<User> extRepository;


    @GetMapping("/saveAll")
    public void saveAll(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("lxf"+ i);
            user.setPassWord("abc" + i);
            user.setEmail("1565267514" + i + "@qq.com");
            list.add(user);
        }
        //执行多个sql语句，不是批量插入
        userRepository.saveAll(list);

        //实现批量插入
        extRepository.batchSave(list);
    }


    @GetMapping("/findByPassWord")
    public User findByPassWord(String passWord){
        User user = userRepository.findByPassWord(passWord);
        return user;
    }

    @GetMapping("/findByEmail")
    public void findByEmail(String email){
        userRepository.findByEmail(email).ifPresent( e -> {
            System.out.println(e);
        });
    }

    @GetMapping("/findByUserNameLike")
    public void findByUserNameLike(String userName){
        List<User> userList = userRepository.findByUserNameLike(userName + "%");
        logger.info(Arrays.toString(userList.toArray()));
    }

    @GetMapping("/findFirstByUserNameLike")
    public User findFirstByUserNameLike(String userName){
        User user = userRepository.findFirstByUserNameLike(userName + "%");
        return user;
    }

    @GetMapping("/findTop2ByUserNameLike")
    public void findTop2ByUserNameLike(String userName){
        List<User> userList = userRepository.findTop2ByUserNameLike(userName + "%");
        logger.info(Arrays.toString(userList.toArray()));
    }

    @GetMapping("/findByUserNameLikePageAndSort")
    public void findByUserNameLikePageAndSort(String userName){
        PageRequest pageRequest = PageRequest.of(0, 5, Sort.Direction.DESC, "id");
        List<User> userList = userRepository.findByUserNameLike(userName + "%", pageRequest);
        logger.info(Arrays.toString(userList.toArray()));
    }

    @GetMapping("/findById")
    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        user.ifPresent(e -> System.out.println("名字：" + e.getUserName()));
        boolean isPresent = user.isPresent();
        user.orElse(new User());
        user.orElseGet(() -> new User());
        Optional.empty();
        return user.get();
    }


    /**
     * Specification查询
     */
    @GetMapping("/findAll")
    public void findAll(){
        User user = new User();
        user.setUserName("lxf0");
        user.setEmail("1565267515@qq.com");
        Specification<User> specification = (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(user.getUserName())) {
                predicates.add(criteriaBuilder.equal(root.get("userName"), user.getUserName()));
            }
            if (!StringUtils.isEmpty(user.getEmail())) {
                predicates.add(criteriaBuilder.equal(root.get("email"), user.getEmail()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
        Page<User> page = userRepository.findAll(specification, PageRequest.of(1, 5, Sort.Direction.DESC, "id"));
        List<User> list = page.getContent();
        logger.info(Arrays.toString(list.toArray()));
    }


    /**
     * 1、批量、动态、条件更新因为mysql本身支持，像mybatis的批量sql也是循环执行的，可用一下方法代替
     * 2、简单的更新可以用@Modify写sql语句
     * 3、循环更新效率低，耗时
     */
    @GetMapping("/batchUpdate")
    public void batchUpdate(){
        List<User> all = userRepository.findAll();
        for (User user : all) {
            user.setPassWord("123456");
        }
        //批量，需要在实体上添加注解@DynamicUpdate，表示只修改有改动的字段
        extRepository.batchUpdate(all);

//        //循环效率差，耗时
//        for (User user : all) {
//            user.setPassWord("111111");
//            userRepository.save(user);
//        }

    }


    @PostMapping("/update")
    public void update(){
        userRepository.updateDynamic("hehe", (long)1);
    }


}
