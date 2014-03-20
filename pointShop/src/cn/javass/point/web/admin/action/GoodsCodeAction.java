package cn.javass.point.web.admin.action;

import cn.javass.commons.web.action.BaseAction;
import cn.javass.point.model.GoodsCodeModel;
import cn.javass.point.service.IGoodsCodeService;
import cn.javass.point.service.IGoodsService;

public class GoodsCodeAction extends BaseAction {
    
    public String list() {
        getValueStack().set(MODEL, goodsService.get(goodsId));
        getValueStack().set(PAGE, goodsCodeService.listAllByGoods(getPn(), goodsId));
        return LIST;
    }
    
    public String doAdd() {
        getValueStack().set(MODEL, goodsService.get(goodsId));
        return ADD;
    }
    
    public String add() {
        String[] codes = splitCodes();
        goodsCodeService.save(goodsId, codes);
        return list();
    }
    
    private String[] splitCodes() {
        if(codes == null) {
            return new String[0];
        }
        return codes.split("\r");
    }

//    public String doDelete() {
//        if(id == -1) {
//            return ERROR;
//        }
//        GoodsCodeModel model = goodsCodeService.get(id);
//        getValueStack().set(MODEL, model);
//        return DELETE;
//    }
//    public String delete() {
//        goodsCodeService.delete(id);
//        return list();
//    }
    
    //-----------------------
    //字段驱动数据填充
    //-----------------------
    private int id = -1;
    private int goodsId = -1;
    private String codes;
    private GoodsCodeModel goodsCode;
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    public void setGoodsCode(GoodsCodeModel goodsCode) {
        this.goodsCode = goodsCode;
    }
    
    public GoodsCodeModel getGoodsCode() {
        return goodsCode;
    }
    
    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
    public void setCodes(String codes) {
        this.codes = codes;
    }
    
    //-----------------------
    //依赖注入
    //-----------------------
    
    private IGoodsCodeService goodsCodeService;
    private IGoodsService goodsService;
    public void setGoodsCodeService(IGoodsCodeService goodsCodeService) {
        this.goodsCodeService = goodsCodeService;
    }
    public void setGoodsService(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }
    
}
