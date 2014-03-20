package cn.javass.point.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import cn.javass.commons.Constants;
import cn.javass.commons.pagination.Page;
import cn.javass.commons.pagination.PageUtil;
import cn.javass.commons.service.impl.BaseServiceImpl;
import cn.javass.point.dao.IGoodsDao;
import cn.javass.point.model.GoodsModel;
import cn.javass.point.service.IGoodsService;
@Service
public class GoodsServiceImpl extends BaseServiceImpl<GoodsModel, Integer> implements IGoodsService {

    @Override
    public Page<GoodsModel> listAllPublished(int pn) {
        int count = getGoodsDao().countAllPublished();
        List<GoodsModel> items = getGoodsDao().listAllPublished(pn);
        return PageUtil.getPage(count, pn, items, Constants.DEFAULT_PAGE_SIZE);
    }
    
    public IGoodsDao getGoodsDao() {
        return (IGoodsDao) getDao();
    }

    @Autowired @Required
    public void setGoodsDao(IGoodsDao dao) {
        setDao(dao);
    }
    
}
