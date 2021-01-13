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
    INVALID_USERNAME_PASSWORD(400,"无效的用户名或密码")
    //相当于对象, private static final ExceptionEnums ff = new ExceptionEnums(500."价格不能为空");
    //枚举, 是指具有固定实例个数的类(对象是提前创建好的, 默认都是私有的,别人不许用, 只允许自己用)
    //最后一个对象后面, 一定要跟上一个分号. 而且枚举必须定义在这个类的最前面, 在他之前不能有其他的东西了.
    ;
    private int code;
    private String msg;
}
