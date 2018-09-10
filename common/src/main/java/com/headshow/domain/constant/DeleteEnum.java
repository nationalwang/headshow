package com.headshow.domain.constant;

/**
 * @author linlangleo
 * @desc 系统删除状态枚举
 * @date 2018-09-02 11:52
 **/
public enum DeleteEnum {
    /**删除标记 */
    DISABLE("DISABLE", "已删除"),
    ENABLE("ENABLE", "未删除"),

    SHOW("YES", "显示"),
    NOTSHOW("NO", "不显示"),

    ISMEUN("MENU", "显示"),
    NOMEUN("BTN", "不显示"),

    ISUSE("ISUSE", "启用"),
    NOUSE("NOUSE", "停用");

    private String status;
    private String message;

    DeleteEnum(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
