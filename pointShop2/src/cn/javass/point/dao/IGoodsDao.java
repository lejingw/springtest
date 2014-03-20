package cn.javass.point.dao;

import java.util.List;

import cn.javass.commons.dao.IBaseDao;
import cn.javass.point.model.GoodsModel;

/**
 * 商品模型对象的DAO接口
 * @author Zhang Kaitao
 *
 */
public interface IGoodsDao extends IBaseDao<GoodsModel, Integer> {
    
    /** 分页查询所有已发布的商品*/
    List<GoodsModel> listAllPublished(int pn);

    /** 统计所有已发布的商品记录数*/
    int countAllPublished();
}
