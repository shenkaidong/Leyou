package com.leyou.item.mapper;

import com.leyou.common.mapper.BaseMapper;
import com.leyou.item.pojo.Stock;


//我们写一个接口, 继承这三个接口, 以后要实现就只用实现我们自己的接口.
//这里有两个InsertListMapper. 这两个InsertListMapper其中一个必须要求要Id, 而不能是其他的名字. 另一个可以自定义
public interface StockMapper extends BaseMapper<Stock> {
}
