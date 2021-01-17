package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    CATEGORY_NOT_FOND(404,"商品分类没有查到"),
    SPEC_GROUP_NOT_FOND(404,"商品规格组不存在"),
    SPEC_PARAM_NOT_FOND(404,"商品规格参数不存在"),
    GOODS_NOT_FOND(404,"商品不存在"),
    BRAND_NOT_FOUND(404,"品牌不存在"),
    GOODS_DETAIL_NOT_FOND(404,"商品详情不存在"),
    GOODS_SKU_NOT_FOND(404,"商品SKU不存在"),
    GOODS_STOCK_NOT_FOND(404,"商品库存不存在"),
    BRAND_SAVE_ERROR(500,"新增品牌失败"),
    CATEGORY_BRAND_SAVE_ERROR(500,"新增品牌分类失败"),
    GOODS_SAVE_ERROR(500,"新增品牌分类失败"),
    UPLOAD_FILE_ERROR(500,"文件上传失败"),
    GOODS_UPDATE_ERROR(500,"商品更新失败"),
    GOODS_ID_CANNOT_BE_NULL(404,"商品id不能为空"),
    INVALID_FILE_TYPE(400, "无效的文件类型"),
    INVALID_USER_DATA_TYPE(400,"无效的用户数据类型"),
    INVALID_VERIFY_CODE(400,"无效的验证码"),
    INVALID_USERNAME_PASSWORD(400,"无效的用户名或密码"),
    CREATE_TOKEN_ERROR(500,"用户凭证生成失败"),
    UNAUTHORIZED(403,"未授权"),
    CART_NOT_FOUND(404,"购物车未找到"),
    WX_PAY_ORDER_FAIL(500,"微信支付订单失败"),
    INVALID_SIGN_ERROR(500,"无效的SIGN错误"),
    INVALID_ORDER_PARAM(500,"无效的订单参数"),
    UPDATE_ORDER_STATUS_ERROR(404,"更新订单状态错误"),
    CREATE_ORDER_ERROR(500,"创建订单失败"),
    ORDER_NOT_FOUND(404,"购物车未找到"),
    ORDER_DETAIL_NOT_FOUND(404,"订单细节没有找到"),
    ORDER_STATUS_NOT_FOUND(404,"订单状态没有找到"),
    ORDER_STATUS_ERROR(500,"订单状态错误"),
    STOCK_NOT_ENOUGH(500,"库存不足"),
    GOODS_SKU_NOT_FOUND(404,"商品SKU没有找到"),
    GOODS_STOCK_NOT_FOUND(404,"商品库存没有找到");

    //相当于对象, private static final ExceptionEnums ff = new ExceptionEnums(500."价格不能为空");
    //枚举, 是指具有固定实例个数的类(对象是提前创建好的, 默认都是私有的,别人不许用, 只允许自己用)
    //最后一个对象后面, 一定要跟上一个分号. 而且枚举必须定义在这个类的最前面, 在他之前不能有其他的东西了.

    private int code;
    private String msg;
}
