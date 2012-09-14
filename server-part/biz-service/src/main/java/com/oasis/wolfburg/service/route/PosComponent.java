package com.oasis.wolfburg.service.route;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.util.exception.ValidationException;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ErrorDispHelper;
import com.oasis.wolfburg.common.so.route.PosSO;
import com.oasis.wolfburg.common.vo.client.WSPOS;
import com.oasis.wolfburg.common.vo.route.PosVO;
import com.oasis.wolfburg.common.vo.route.PosViewVO;
import com.oasis.wolfburg.dao.route.PosDAO;
import com.oasis.wolfburg.model.route.POS;

@Service
public class PosComponent extends BaseComponent {

    @Autowired
    private PosDAO posDAO;

    public Long createPos(PosVO posVO) {
        validate(posVO);
        POS pos = super.getDozer().convert(posVO, POS.class);
        Long id = posDAO.insert(pos);
        return id;
    }

    public int deletePos(Long id) {
        return posDAO.delete(id);
    }

    public void update(PosViewVO pos) {
        validate(dozer.convert(pos, PosVO.class));
        posDAO.update(super.getDozer().convert(pos, POS.class));
    }

    public void removeByIds(List<Long> ids) {
        posDAO.deleteByIds(ids);
    }

    public PageList<PosViewVO> getPageList(PosSO so) {
        List<POS> posList = posDAO.getPaginatedList(so);
        List<PosViewVO> list = super.getDozer().convertList(posList, PosViewVO.class);
        int cnt = posDAO.getPaginatedListCount(so);
        PageList<PosViewVO> page = new PageList<PosViewVO>();
        page.setList(list);
        page.setFullListSize(cnt);
        return page;
    }

    public PosVO find(Long id) {
        POS po = posDAO.find(id);
        return super.getDozer().convert(po, PosVO.class);
    }

    public PosViewVO findView(Long id) {
        return posDAO.findView(id);
    }

    private void validate(PosVO vo) {
        POS pos = posDAO.checkDuplication(vo.getName(),vo.getCode(),vo.getId());
            if (pos != null) {
                Map<String, String> error = new HashMap<String, String>();
                if (vo.getName().equals(pos.getName())) {
                    error.put("nameCn", ErrorDispHelper.getInstance().getValue("POS_NAME_ERROR"));
                }
                if (vo.getCode().equals(pos.getCode())) {
                    error.put("code", ErrorDispHelper.getInstance().getValue("POS_CODE_ERROR"));
                }
                if (error.keySet().size() > 0) {
                    throw new ValidationException(error);
                }
            }
    }


    public List<WSPOS> getWSPOSByAccount(Long accountId) {
        List<POS> list = posDAO.getPOSByAccount(accountId);
        List<WSPOS> retList = dozer.convertList(list, WSPOS.class);
        return retList;
    }

}