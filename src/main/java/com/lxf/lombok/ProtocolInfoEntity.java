package com.lxf.lombok;

import lombok.Data;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/3/8 13:26
 * @Version 1.0
 **/
//@RequiredArgsConstructor(staticName = "of")//结合@NonNull，确定构造
//@Accessors(chain = true)//支持链式调用
@Data
//@Builder//builder模式
//@NoArgsConstructor//无参构造
public class ProtocolInfoEntity {
//    @NonNull
    private Integer Protocolid;
    private Integer type;
    private String content;
}
