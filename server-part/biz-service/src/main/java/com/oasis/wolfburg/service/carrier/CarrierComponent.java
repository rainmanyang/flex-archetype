package com.oasis.wolfburg.service.carrier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ErrorDispHelper;
import com.oasis.tmsv5.util.exception.ValidationException;
import com.oasis.wolfburg.common.enums.status.AttachmentAssocTable;
import com.oasis.wolfburg.common.enums.status.CarrierStatus;
import com.oasis.wolfburg.common.so.carrier.CarrierSO;
import com.oasis.wolfburg.common.vo.carrier.CarrierVO;
import com.oasis.wolfburg.dao.carrier.CarrierDAO;
import com.oasis.wolfburg.dao.carrier.ParentCompanyDAO;
import com.oasis.wolfburg.model.carrier.Carrier;
import com.oasis.wolfburg.model.carrier.ParentCompany;
import com.oasis.wolfburg.service.attachmentHelper.AttachmentHelper;

@Service
public class CarrierComponent extends BaseComponent {

    @Autowired
    private CarrierDAO carrierDAO;

    @Autowired
    private ParentCompanyDAO parentCompanyDAO;

    @Autowired
    private AttachmentHelper attachmentHelper;

    public CarrierVO findCarrier(Long carrierId) {
        Carrier carrier = carrierDAO.find(carrierId);
        CarrierVO carrierVO = super.getDozer().convert(carrier, CarrierVO.class);

        carrierVO.setAttachmentList(attachmentHelper.getList(carrierId, AttachmentAssocTable.CARRIER));
        return carrierVO;
    }

    public CarrierVO viewCarrier(Long carrierId) {
        Carrier carrier = carrierDAO.find(carrierId);
        CarrierVO carrierVO = super.getDozer().convert(carrier, CarrierVO.class);
        return carrierVO;
    }

    public Long createCarrier(CarrierVO carrierVO) {
    	validatIfCanCoU(carrierVO);
        Carrier carrier = super.getDozer().convert(carrierVO, Carrier.class);
        if (carrierVO.getParentCompanyId() == 0 ) {
            ParentCompany parentCompany = new ParentCompany();
            parentCompany.setCompanyName(carrierVO.getParentCompanyName());
            Long parentCompanyId = parentCompanyDAO.insert(parentCompany);
            carrier.setParentCompanyId(parentCompanyId);
        }
        Long id = carrierDAO.insert(carrier);

        attachmentHelper.insert(carrierVO.getAttachmentList(), id, AttachmentAssocTable.CARRIER);

        return id;
    }

    public int deleteCarrier(Long id) {
        return carrierDAO.delete(id);
    }

    public CarrierVO updateCarrier(CarrierVO carrierVO) {
    	validatIfCanCoU(carrierVO);
        Carrier carrier = super.getDozer().convert(carrierVO, Carrier.class);
        
        if (carrier.getParentCompanyId() != null) {
            ParentCompany parentCompany = new ParentCompany();
            parentCompany.setCompanyName(carrierVO.getParentCompanyName());
            Long parentCompanyId = parentCompanyDAO.insert(parentCompany);
            carrier.setParentCompanyId(parentCompanyId);
        }
        carrier = carrierDAO.update(carrier);
        if (carrierVO.getAttachmentList() != null) {
        	attachmentHelper.edit(carrierVO.getAttachmentList(), carrierVO.getId(), AttachmentAssocTable.CARRIER);
        }
        
        carrierVO.setAttachmentList(attachmentHelper.getList(carrierVO.getId(), AttachmentAssocTable.CARRIER));
        carrierVO = super.getDozer().convert(carrier, CarrierVO.class);
        return carrierVO;
    }

    public void updateCarrierStatus(CarrierVO carrierVO) {
    	Carrier carrier = carrierDAO.find(carrierVO.getId());
    	carrier.setStatus(carrierVO.getStatus());
        carrierDAO.update(carrier);
    }

    public void batchUpdateCarrierStatus(List<Long> carrierIdList, CarrierStatus carrierStatus) {
        CarrierSO carrierSO = new CarrierSO();
        carrierSO.setCarrierIdList(carrierIdList);
        List<Carrier> carrierList = carrierDAO.getPaginatedList(carrierSO);
        switch (carrierStatus) {
        case ACTIVED: {
            for (Carrier carrier : carrierList) {
                if (CarrierStatus.NEW.equals(carrier.getStatus()) || CarrierStatus.FROZEN.equals(carrier.getStatus())) {
                    carrier.setStatus(CarrierStatus.ACTIVED);
                    carrierDAO.update(carrier);
                }
            }
            break;
        }
        case DISABLED: {
            for (Carrier carrier : carrierList) {
                if (CarrierStatus.NEW.equals(carrier.getStatus()) || CarrierStatus.FROZEN.equals(carrier.getStatus())) {
                    carrier.setStatus(CarrierStatus.DISABLED);
                    carrierDAO.update(carrier);
                }
            }
            break;
        }
        case FROZEN: {
            for (Carrier carrier : carrierList) {
                if (CarrierStatus.ACTIVED.equals(carrier.getStatus())) {
                    carrier.setStatus(CarrierStatus.FROZEN);
                    carrierDAO.update(carrier);
                }
            }
            break;
        }
        case NEW:
        default: {
            break;
        }
        }
    }

    public PageList<CarrierVO> getPageList(CarrierSO carrierSO) {
        List<Carrier> carrierList = carrierDAO.getPaginatedList(carrierSO);
        List<CarrierVO> list = super.getDozer().convertList(carrierList, CarrierVO.class);
        int cnt = carrierDAO.getPaginatedListCount(carrierSO);
        PageList<CarrierVO> page = new PageList<CarrierVO>();
        page.setList(list);
        page.setFullListSize(cnt);
        return page;
    }
    /**
     * 
     * reviewer:中文
     */
    private void validatIfCanCoU(CarrierVO carrierVO) {
        CarrierSO carrierSO = new CarrierSO();
        carrierSO.setCarrierName(carrierVO.getCarrierName());
        carrierSO.setCarrierCode(carrierVO.getCarrierCode());
        List<Carrier> carrierList = carrierDAO.checkDuplication(carrierSO);
        if (carrierList.size() > 0) {
            Map<String, String> error = new HashMap<String, String>();
            for (Carrier carrier : carrierList) {
                if (carrier.getCarrierName().equals(carrierVO.getCarrierName()) && !carrier.getId().equals(carrierVO.getId())) {
                    error.put("carrierName", ErrorDispHelper.getInstance().getValue("CARRIER_NAME_ERROR"));
                }
                if (carrier.getCarrierCode().equals(carrierVO.getCarrierCode()) && !carrier.getId().equals(carrierVO.getId())) {
                    error.put("carrierCode", ErrorDispHelper.getInstance().getValue("CARRIER_CODE_ERROR"));
                }
            }
            if (error.keySet().size() > 0) {
                throw new ValidationException(error);
            }
        }
    }

}
