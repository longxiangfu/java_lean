package com.lxf.web.action.jpa;

import com.lxf.web.dao.UserRepository;
import com.lxf.web.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserRepository userRepository;


    @GetMapping("/saveAll")
    public void saveAll(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("lxf"+ i);
            user.setPassWord("abc" + i);
//            user.setEmail("1565267514" + i + "@qq.com");
            list.add(user);
        }
        //执行多个sql语句，不是批量插入
        userRepository.saveAll(list);
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
    public List<User> findByUserNameLike(String userName){
        List<User> userList = userRepository.findByUserNameLike(userName);
        return userList;
    }

    @GetMapping("/findFirstByUserNameLike")
    public User findFirstByUserNameLike(String userName){
        User user = userRepository.findFirstByUserNameLike(userName);
        return user;
    }

    @GetMapping("/findTop2ByUserNameLike")
    public List<User> findTop2ByUserNameLike(String userName){
        List<User> userList = userRepository.findTop2ByUserNameLike(userName);
        return userList;
    }

    @GetMapping("/findByUserNameLikePageAndSort")
    public List<User> findByUserNameLikePageAndSort(String userName){
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        PageRequest pageRequest = PageRequest.of(1, 10, sort);
        List<User> userList = userRepository.findByUserNameLike(userName, pageRequest);
        return userList;
    }

    @GetMapping("/findById")
    public User findById(String id){
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }


}
