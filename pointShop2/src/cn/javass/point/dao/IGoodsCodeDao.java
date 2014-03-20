package cn.javass.point.dao;

import java.util.List;

import cn.javass.commons.dao.IBaseDao;
import cn.javass.point.exception.NotCodeException;
import cn.javass.point.model.GoodsCodeModel;

/**
 * 商品兑换码模型对象的DAO接口
 * @author Zhang Kaitao
 *
 */
public interface IGoodsCodeDao extends IBaseDao<GoodsCodeModel, Integer> {
    
    /** 统计商品ID统计该商品的兑换码记录数*/
    public int countAllByGoods(int goodsId);
    
    
    /** 根据商品ID查询该商品的兑换码列表*/
    public List<GoodsCodeModel> listAllByGoods(int pn, int goodsId);

    /** 获取一个还没有交易的商品兑换码 */
    public GoodsCodeModel getOneNotExchanged(int goodsId) throws NotCodeException;
    
}
