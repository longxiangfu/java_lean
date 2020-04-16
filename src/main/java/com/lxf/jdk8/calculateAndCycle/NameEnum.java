package com.lxf.jdk8.calculateAndCycle;

public enum NameEnum {
    LONG_XIANG_FU("1", "LONGXIANGFU"),
    CHEN_TING("2", "CHENTING");

    ;

    private String code;
    private String msg;

    NameEnum(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public static NameEnum getByCode(String code){
        for (NameEnum nameEnum : NameEnum.values()) {
            if (code.equals(nameEnum.code)) {
                return nameEnum;
            }
        }
        return null;
    }


}
