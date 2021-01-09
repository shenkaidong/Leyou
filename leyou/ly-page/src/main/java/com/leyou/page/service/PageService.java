package com.leyou.page.service;

import com.leyou.item.pojo.*;
import com.leyou.page.client.BrandClient;
import com.leyou.page.client.CategoryClient;
import com.leyou.page.client.GoodsClient;
import com.leyou.page.client.SpecificationClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

@Slf4j
@Service
public class PageService {
    @Autowired
    private BrandClient brandClient;

    @Autowired
    private CategoryClient categoryClient;

    @Autowired
    private GoodsClient goodsClient;

    @Autowired
    private SpecificationClient specClient;

    @Autowired
    private TemplateEngine templateEngine;

    public Map<String, Object> loadModel(Long spuId){
        Map<String, Object> map = new HashMap<>();

        // 根据id查询spu对象
        Spu spu = this.goodsClient.querySpuById(spuId);

        // 查询spudetail
        SpuDetail spuDetail = this.goodsClient.queryDetailById(spuId);

        // 查询skus
        List<Sku> skus = spu.getSkus();

        // 查询分类
        List<Long> cids = Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3());
        List<Category> names = categoryClient.queryCategoryByIds(Arrays.asList(spu.getCid1(), spu.getCid2(), spu.getCid3()));
        List<Map<String, Object>> categories = new ArrayList<>();
        for (int i = 0; i < cids.size(); i++) {
            Map<String, Object> categoryMap = new HashMap<>();
            categoryMap.put("id", cids.get(i));
            categoryMap.put("name", names.get(i));
            categories.add(categoryMap);
        }

        // 查询品牌
        Brand brand = this.brandClient.queryBrandById(spu.getBrandId());

        // 查询规格参数组
        List<SpecGroup> groups = this.specClient.queryGroupByCid(spu.getCid3());

        // 查询特殊的规格参数
        List<SpecParam> params = this.specClient.queryParamList(null, spu.getCid3(), null);
        Map<Long, String> paramMap = new HashMap<>();
        params.forEach(param -> {
            paramMap.put(param.getId(), param.getName());
        });

        // 封装spu
        map.put("spu", spu);
        // 封装spuDetail
        map.put("spuDetail", spuDetail);
        // 封装sku集合
        map.put("skus", skus);
        // 分类
        map.put("categories", categories);
        // 品牌
        map.put("brand", brand);
        // 规格参数组
        map.put("groups", groups);
        // 查询特殊规格参数
        map.put("paramMap", paramMap);
        return map;
    }

    //这里没有实现. 因为代码和部署的nginx所在位置不同. 未来想要生成静态页. 可以把这个page部署在nginx目录下
        public void createHtml(Long spuId){
        // 上下文
            Context context = new Context();
            context.setVariables(loadModel(spuId));
        // 输出流
            File dest = new File("C:\\Users\\Shen\\Desktop\\leyou\\staticPage", spuId + ".html");
            if (dest.exists()){
                dest.delete();
            }

            //不用自己去释放流. 流会自动释放
            try(PrintWriter writer = new PrintWriter(dest,"UTF-8")){
                // 生成HTML
                templateEngine.process("item",context, writer);
            }catch (Exception e){
                log.error("[静态页服务]生成静态页异常",e);
            }


        }

    public void deleteHtml(Long spuId) {
        File dest = new File("C:\\Users\\Shen\\Desktop\\leyou\\staticPage", spuId + ".html");
        if(dest.exists()){
            dest.delete();
        }
    }
}
