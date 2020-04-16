package com.lxf.lombok;//package com.xxce.file.entity;

/**
 * @Description
 * @Author Administrator
 * @DATE 2019/3/18 16:06
 * @Version 1.0
 **/
public class ExeTest {
    public static void main(String[] args) {
//        ProtocolInfoEntity.builder().Protocolid(1).type(1).content("");//builder模式
//
//        ProtocolInfoEntity p = ProtocolInfoEntity.of(1);//@RequiredArgsConstructor(staticName = "of")//结合@NonNull，确定构造
//        ProtocolInfoEntity.of(1).setType(1).setContent("");//@Accessors(chain = true) 支持链式调用

        ProtocolInfoEntity protocolInfoEntity = new ProtocolInfoEntity();

    }
}
