//package com.lxf.reactorDemo.learn4;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.data.mongodb.core.query.Update;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * springboot集成mongodb练习
// */
//@RestController
//@RequestMapping("/mongodbController")
//@Api(tags = "Mogo练习4")
//public class MongodbController {
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    /**表名*/
//    private static final String collectionName = "user";
//
//    /**
//     * 描述：新增
//     * @author maochengyuan
//     * @created 2018/9/1 20:17
//     * @param user
//     * @return ResultObject
//     */
//    @PostMapping(value = "/insert")
//    @ResponseBody
//    @ApiOperation("新增")
//    public String insert(@ApiParam(name = "user", value = "用户") @RequestBody User user) {
//        this.mongoTemplate.insert(user);
//        return "插入成功";
//    }
//
//
//    /**
//     * 描述：批量新增
//     * @author maochengyuan
//     * @created 2018/9/1 20:17
//     * @return ResultObject
//     */
//    @ApiOperation("批量新增")
//    @PostMapping(value = "/insertBatch")
//    @ResponseBody
//    public String insertBatch() throws Exception {
//        List<User> list = new ArrayList<>();
//        User user1 = new User();
//        user1.setId("1");
//        user1.setAge(10);
//        User user2 = new User();
//        user2.setId("2");
//        user2.setAge(100);
//        list.add(user1);
//        list.add(user2);
//        this.mongoTemplate.insert(list, User.class);
//        return "批量插入成功";
//    }
//
//    /**
//     * 描述：删除
//     * @author maochengyuan
//     * @created 2018/9/1 20:17
//     * @param id
//     * @return ResultObject
//     */
//    @PostMapping("/delete")
//    @ResponseBody
//    @ApiOperation("删除")
//    public String delete(@ApiParam(name = "id", value = "用户id") @RequestParam("id") String id) {
//        Query query = Query.query(Criteria.where("_id").is(id));
//        this.mongoTemplate.remove(query, collectionName);
//        return "删除成功";
//    }
//
//    /**
//     * 描述：修改
//     * @author maochengyuan
//     * @created 2018/9/1 20:17
//     * @param user
//     * @return ResultObject
//     */
//    @PostMapping(value = "/update")
//    @ResponseBody
//    @ApiOperation("修改")
//    public String update(@ApiParam(name = "user", value = "用户") @RequestBody User user) {
//        Query query = Query.query(Criteria.where("id").is(user.getId()));
//        Update update = new Update();
//        update.set("age", user.getAge());
//        update.set("name", user.getName());
//        update.set("email", user.getEmail());
////        this.mongoTemplate.updateFirst(query, update, collectionName);//这个方法不管用
//        mongoTemplate.updateFirst(query, update, User.class);
//        return "修改成功";
//    }
//
//
//    /**
//     * 描述：动态修改--条件、内容
//     * 批量更新用where.in
//     * @author maochengyuan
//     * @created 2018/9/1 20:17
//     * @param user
//     * @return ResultObject
//     */
//    @ApiOperation("动态修改")
//    @PostMapping(value = "/updateDynamicCondition")
//    @ResponseBody
//    public String updateDynamicCondition(@ApiParam(name = "user", value = "用户") @RequestBody User user) {
//        //入参校验
//
//        //动态条件
//        Criteria c1 = null;
//        Criteria c2 = null;
//            List<Criteria> list = new ArrayList<>();
//            if(user.getAge() != null){
//                c1 = Criteria.where("age").is(user.getAge());
//                list.add(c1);
//            }
//            if ((user.getName() != null)) {
//                c2 = Criteria.where("name").regex(user.getName());
//                list.add(c2);
//        }
//        Criteria[] arr = new Criteria[list.size()];
//        arr = list.toArray(arr);
//        Criteria criteria = new Criteria().andOperator(arr);
//        Query query = new Query(criteria);
//
//        //动态内容
//        Update update = new Update();
//        if ((user.getEmail() != null)) {
//            update.set("email", user.getEmail());
//        }
//        if ((user.getDataStatus() != null)) {
//            update.set("dataStatus", user.getDataStatus());
//        }
//
//        mongoTemplate.updateFirst(query, update, User.class);
//        return "修改成功";
//    }
//
//    /**
//     * 描述：查询
//     * @author maochengyuan
//     * @created 2018/9/1 20:17
//     * @param
//     * @return ResultObject
//     */
//    @PostMapping("/query")
//    @ResponseBody
//    @ApiOperation("查询")
//    public List<User> query() {
//        Criteria criteria = Criteria.where("dataStatus").is(1);
//        Query query = Query.query(criteria);
//        List<User> users = this.mongoTemplate.find(query, User.class);
//        return users;
//    }
//
//
//    /**
//     * 描述：动态查询
//     * 批量查询用where.in
//     * @author maochengyuan
//     * @created 2018/9/1 20:17
//     * @param
//     * @return ResultObject
//     */
//    @PostMapping("/queryDynamic")
//    @ResponseBody
//    @ApiOperation("动态查询")
//    public List<User> queryDynamic(
//                @ApiParam(name = "user", value = "用户") @RequestBody User user,
//                @ApiParam(name = "pageSize", value = "每页数据大小") @RequestParam Integer pageSize,
//                @ApiParam(name = "pageNo", value = "用户") @RequestParam Integer pageNo
//            ) {
//
//        Criteria c1 = null;
//        Criteria c2 = null;
//        List<Criteria> list = new ArrayList<>();
//
//        if(user.getAge() != null){
//            c1 = Criteria.where("age").is(50);
//            list.add(c1);
//        }
//        if ((user.getName() != null)) {
//            c2 = Criteria.where("name").regex(".*lxf.*");
//            list.add(c2);
//        }
//
//        Criteria[] arr = new Criteria[list.size()];
//        arr = list.toArray(arr);
//        Criteria criteria = new Criteria().andOperator(arr);
//        Query query = new Query(criteria);
//        //分页
//        query.skip((pageNo - 1) * pageSize);
//        query.limit(pageSize);
//
//        //统计
//        long count = mongoTemplate.count(query, User.class);
//        //动态查询
//        return this.mongoTemplate.find(query, User.class);
//    }
//
//}