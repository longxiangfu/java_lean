//package com.lxf.reactorDemo.learn3;
//
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import java.util.Date;
//import java.util.List;
//
//@Data
//public class Tweet {
//    @Id
//    private String id;
//
//    @NotBlank
//    @Size(max = 140)
//    private String text;
//
//    @NotNull
//    private Date createAt = new Date();
//
//    private List<TweetSbu> TweetSbus;
//
//    public Tweet() {
//
//    }
//}
