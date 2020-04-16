//package com.lxf.reactorDemo.learn3;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import javax.validation.Valid;
//import java.util.Date;
//
//@RestController
//@Api(tags = "Mogo练习3")
//public class TweetController {
//
//    @Autowired
//    private TweetRepository tweetRepository;
//
//
//    //通过接受Get请求，返回Flux类型的Tweet对象流
//    @ApiOperation("获取所有tweet")
//    @GetMapping("/tweets")
//    public Flux<Tweet> getAllTweets(){
//        return tweetRepository.findAll();
//    }
//
//    //通过接受POST请求，新增一个Tweet对象
//    @ApiOperation("新建")
//    @PostMapping("/tweet")
//    public Mono<Tweet> createTweet(@ApiParam(name = "tweet", value = "推特") @Valid @RequestBody Tweet tweet){
//        return tweetRepository.save(tweet);
//    }
//
//    //通过id查找Tweet
//    @ApiOperation("通过id查找")
//    @GetMapping("/tweet/{id}")
//    public Mono<ResponseEntity<Tweet>> getTweetById(@ApiParam(name = "id",value="推特id",required = true) @PathVariable String id) {
//        return tweetRepository.findById(id)
//                .map(savedTweet -> ResponseEntity.ok(savedTweet))
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }
//
//    //通过id更新Tweet，使用到SpringMVC的相关注解
//    @ApiOperation("通过id更新")
//    @PutMapping("/tweet/{id}")
//    public Mono<ResponseEntity<Tweet>> updateTweet(@ApiParam(name = "id", value = "推特id") @PathVariable(value = "id") String tweetId,
//                                                   @ApiParam(name = "tweet", value = "推特") @Valid @RequestBody Tweet tweet){
//        return tweetRepository.findById(tweetId)
//                .flatMap(existingTweet -> {
//                    existingTweet.setText(tweet.getText());
//                    existingTweet.setCreateAt(new Date());
//                    return tweetRepository.save(existingTweet);
//                })
//                .map(updatedTweet -> new ResponseEntity<>(updatedTweet, HttpStatus.OK))
//                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//
//    }
//
////    //通过id删除tweet
////    @ApiOperation("通过id删除")
////    @DeleteMapping("/tweets/{id}")
////    public Mono<ResponseEntity<Void>> deleteTweet(@ApiParam(name = "id", value = "推特id") @PathVariable(value = "id") String tweetId){
////        return tweetRepository.findById(tweetId)
////                .flatMap(existingTweet ->
////                        tweetRepository.delete(existingTweet)
////                                .then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
////                )
////                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
////    }
//
//
//
//    // 基于反应式流发送微博至客户端
//    @ApiOperation("获取所有（SSE方式）")
//    @GetMapping(value = "/stream/tweets", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public Flux<Tweet> streamAllTweets() {
//        return tweetRepository.findAll();
//    }
//
//
//
//}
