package com.oasis.wolfburg.service.price;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ErrorDispHelper;
import com.oasis.tmsv5.util.exception.ValidationException;
import com.oasis.wolfburg.common.enums.status.PriceStatus;
import com.oasis.wolfburg.common.so.price.PriceSO;
import com.oasis.wolfburg.common.vo.price.PriceVO;
import com.oasis.wolfburg.dao.price.PriceDAO;
import com.oasis.wolfburg.model.price.Price;

@Service
public class PriceComponent extends BaseComponent {
    @Autowired
    private PriceDAO priceDAO;

    public PageList<PriceVO> getPageList(PriceSO so) {
        int count = priceDAO.getPaginatedListCount(so);
        List<Price> priceList = priceDAO.getPaginatedList(so);
        List<PriceVO> list = getDozer().convertList(priceList, PriceVO.class);
        PageList<PriceVO> pageList = new PageList<PriceVO>(so);
        pageList.setFullListSize(count);
        pageList.setList(list);
        return pageList;
    }

    public PriceVO load(Long id) {
        Price price = priceDAO.find(id);
        return super.getDozer().convert(price, PriceVO.class);
    }

    public void createPrice(PriceVO vo) {
		if(vo.getId() != null){
			/**
			 * 复制过来的数据,需重设版本号
			 */
			vo.setVersion(0);
		}
        Price price = super.getDozer().convert(vo, Price.class);
        this.checkDuplicate(price);

        price.setEffectiveStart(price.getPeriodStart());
        price.setEffectiveEnd(price.getPeriodEnd());
        price.setStatus(PriceStatus.EFFECTIVE);
        Long id = priceDAO.insert(price);
        this.updateCode(id);
    }

    private void updateCode(Long id) {
        Price price = priceDAO.find(id);
        
        String code = id.toString();
        code = StringUtils.leftPad(code, 3, "0");
        price.setCode("prc" + code);
        priceDAO.update(price);
    }

    public void update(PriceVO vo) {
        Price price = super.getDozer().convert(vo, Price.class);
        price.setEffectiveEnd(price.getPeriodEnd());
        priceDAO.update(price);
    }

    public void editPrice(PriceVO vo) {
        Date date = Calendar.getInstance().getTime();
        /**
         * 操作原费率本
         */
        Long id = vo.getId();
        Price oldPrice = priceDAO.find(id);
        oldPrice.setStatus(PriceStatus.FAILURE);
        priceDAO.update(oldPrice);

        Date periodEnd = oldPrice.getPeriodEnd();
        Price newPrice = super.getDozer().convert(vo, Price.class);
        newPrice.setId(null);
        /*
         * newPrice.setPeriodStart(date); newPrice.setPeriodEnd(periodEnd);
         */
        newPrice.setEffectiveStart(date);
        newPrice.setEffectiveEnd(periodEnd);
        newPrice.setVersion(oldPrice.getVersion() + 1);
        checkDuplicate(newPrice);
        Long newId = priceDAO.insert(newPrice);
        this.updateCode(newId);
    }

    public void updateStatus(List<Long> ids) {
        priceDAO.updateStatus(ids);
    }

    private void checkDuplicate(Price price) {
        Map<String, String> errors = new HashMap<String, String>();
        int cnt = priceDAO.checkDuplicate(price);
        if (cnt > 0) {
            errors.put("routeName", ErrorDispHelper.getInstance().getValue("PRICE_ERROR"));
            throw new ValidationException(errors);
        }
    }

    public void delay(List<Long> ids, int days) {
        priceDAO.delay(ids, days);
    }
}