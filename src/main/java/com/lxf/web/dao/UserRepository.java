//package com.lxf.web.dao;
//
//import com.lxf.web.model.User;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface UserRepository extends JpaRepository<User, String> , JpaSpecificationExecutor {
//
//    //按方法名查询的使用场景：1、查询参数少，一般少于3个  2、查询参数不为null,为null的话不会报错，只是查不出数据
//    //不符合的场景，使用JpaSpecificationExecutor
//    /**
//     * 普通的查询
//     * @param passWord
//     * @return
//     */
//    User findByPassWord(String passWord);
//
//    /**
//     * 返回值用Optional接收
//     * @param email
//     * @return
//     */
//    Optional<User> findByEmail(String email);
//
//
//    /**
//     * 返回list
//     * @param userName
//     * @return
//     */
//    List<User> findByUserNameLike(String userName);
//
//    /**
//     * 限制查询结果 first
//     * @param userName
//     * @return
//     */
//    User findFirstByUserNameLike(String userName);
//
//
//    /**
//     * 限制查询结果 top
//     * @param userName
//     * @return
//     */
//    List<User> findTop2ByUserNameLike(String userName);
//
//
//    /**
//     * 限制查询结果 pageable  sort
//     * @param userName
//     * @param pageable
//     * @return
//     */
//    List<User> findByUserNameLike(String userName, Pageable pageable);
//
//
//    /**
//     * 自定义查询
//     * @param id
//     * @return
//     */
//    @Query("select u from User u where u.id =:id")
//    Optional<User> findById(@Param("id") String id);
//
//
//    @Transactional(rollbackFor = Exception.class)
//    @Modifying(clearAutomatically = true)
//    @Query("update User u set u.userName =:userName where u.id =:id")
//    int updateDynamic(@Param("userName") String userName, @Param("id") Long id);
//
//}
