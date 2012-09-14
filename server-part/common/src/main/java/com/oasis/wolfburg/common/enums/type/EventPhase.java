package com.oasis.wolfburg.common.enums.type;

public enum EventPhase {
    /**
     * 进港
     */
    INBOUND(0),
    /**
     * 离港
     */
    OUTBOUND(1),
    /**
     * 指派车辆
     */
    ASSIGNVECHICLE(2),
    /**
     * 更换车辆
     */
    CHANGEVECHICLE(3),
    /**
     * 发布
     */
    PUBLISH(4),
    /**
     * 打卡
     */
    PUNCH(5),
    /**
     * 终止
     */
    TERMINATE(6),
    /**
     * 途中
     */
    ENROUTE(7),

    /**
     * 取消派车
     */
    CANCEL(8),

    /**
     * 登录
     */
    LOGIN(9),
    /**
     * 打卡
     */
    PRINTCARD(10),
    /**
     * 登出
     */
    LOGOUT(11),

    /**
     * 创建
     */
    CREATE(12),

    /**
     * 没有费率
     */
    NO_PRICE(13),

    /**
     * 没有费率
     */
    STILL_NO_PRICE(14),

    /**
     * 扫描码处理异常
     */
    SCANCODE_PROCESS_ERROR(15),

    /**
     * 没有费率
     */
    PAY_NO_PRICE(16),

    /**
     * 没有费率
     */
    FEE_NO_PRICE(17),

    /**
     * 调整扫描时间
     */
    ADDJUST_TIME(18),

    /**
     * 备注
     */
    REMARK(19),

    /**
     * 调整经停站点
     */
    ADJUST_STOP(20),
    
    /**
     * 密码错误
     */
    ERROR_PASSWORD(21),
    
    /**
     * 模块跟踪
     */
    OPEN_MODULE(22),
    
    /**
     * 客户端登录
     */
    CLIENT_LOGIN(23);
    
    private int value;

    private EventPhase(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }

}
