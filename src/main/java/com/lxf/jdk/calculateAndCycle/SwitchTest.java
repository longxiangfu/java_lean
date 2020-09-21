package com.lxf.jdk.calculateAndCycle;


import static com.lxf.jdk.calculateAndCycle.NameEnum.LONG_XIANG_FU;

public class SwitchTest {
    public static void main(String[] args) {
        //switch...case(),case中可以是byte\char\short\int 对应的包装类  枚举   String
        int i = 1;
        switch (i){
            case 1:
                System.out.println("=1");
                break;
            case 2:
                System.out.println("=2");
                break;
            default:
                System.out.println("默认值");
                break;
        }

        String name = "龙相甫";
        switch (name){
            case "龙相甫":
                System.out.println("龙相甫");
                break;
            default:
                System.out.println("默认");
        }

        switch (NameEnum.getByCode("1")){
            case LONG_XIANG_FU:
                System.out.println(LONG_XIANG_FU.getMsg());
                break;
            default:
                System.out.println("默认");
        }


    }

}
