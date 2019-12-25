package com.t.s.search.es.controller;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t.s.commont.utils.SnowFlake;
import com.t.s.dao.IBaseGoodsDao;
import com.t.s.model.BaseGoods;

@RestController
@RequestMapping("goods")
public class GoodsController {
    
    /**
     * Desc:数据库操作入库
     * Info:<功能详细描述>
     * @param goodName
     * @param goodPrice
     * @param goodStore
     * @return
     * @author tanshen@qding.me
     * Date:2019年12月17日 下午12:12:46
     */
    @GetMapping("save")
    public String save(@Param("goodName") String goodName, @Param("goodPrice") String goodPrice,
        @Param("goodStore") Integer goodStore) {
        BaseGoods entity = new BaseGoods();
        entity.setId(SnowFlake.createSnowFlake().nextIdString());
        entity.setGoodName(goodName);
        entity.setGoodPrice(new BigDecimal(goodPrice));
        entity.setGoodStore(goodStore);
        iBaseGoodsDao.save(entity);
        return "success";
    }
    
    @Autowired
    private IBaseGoodsDao iBaseGoodsDao;
    
}
