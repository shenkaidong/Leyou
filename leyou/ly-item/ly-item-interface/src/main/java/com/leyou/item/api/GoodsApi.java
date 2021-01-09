package com.leyou.item.api;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import com.leyou.item.pojo.SpuDetail;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface GoodsApi {

        /**
         * 分页查询
         * @param page
         * @param rows
         * @param saleable
         * @param key
         * @return
         */
        @GetMapping("/spu/page")
        PageResult<Spu> querySpuByPage(
                @RequestParam(value = "page", defaultValue = "1") Integer page,
                @RequestParam(value = "rows", defaultValue = "5") Integer rows,
                @RequestParam(value = "saleable", required = false) Boolean saleable,
                @RequestParam(value = "key", required = false) String key
        );

        @GetMapping("/spu/detail/{id}")
        SpuDetail queryDetailById(@PathVariable("id") Long spuId);

        /**
         * 根据spu查询下面的所有sku
         * @param spuId
         * @return
         */
        @GetMapping("/sku/list")
        List<Sku> querySkuBySpuId(@RequestParam("id") Long spuId);

        @GetMapping("spu/{id}")
        Spu querySpuById(@PathVariable("id") Long id);
    }


