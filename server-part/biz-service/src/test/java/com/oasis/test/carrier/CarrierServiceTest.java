package com.oasis.test.carrier;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.CarrierStatus;
import com.oasis.wolfburg.common.enums.type.CarrierType;
import com.oasis.wolfburg.common.enums.type.LicenseType;
import com.oasis.wolfburg.common.enums.type.PayWay;
import com.oasis.wolfburg.common.so.carrier.CarrierSO;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;
import com.oasis.wolfburg.common.vo.carrier.CarrierVO;
import com.oasis.wolfburg.service.carrier.CarrierComponent;

public class CarrierServiceTest extends SpringBaseTest {
	@Autowired
	private CarrierComponent service;
	
	@Test
	public void create(){
		CarrierVO carrier = getVO();
		carrier.setId(null);
		carrier.setParentCompanyId(0L);
		carrier.setAttachmentList(new ArrayList<AttachmentVO>());
		service.createCarrier(carrier);
	}
	
	@Test
	public void update() throws Exception {
		CarrierSO so = new CarrierSO();
	    //so.setCarrierName("杭州");
		PageList<CarrierVO> page = service.getPageList(so);
		if (page.getFullListSize() > 0) {
			CarrierVO vo = service.findCarrier(page.getList().get(0).getId());
			vo.setCarrierName(vo.getCarrierName()+"杭州");
			vo.setCarrierCode(vo.getCarrierCode()+"杭州");
			vo.setAttachmentList(new ArrayList<AttachmentVO>());
			service.updateCarrier(vo);
		} else {
			throw new Exception("getPageList() error!");
		}
	}
	
	@Test
	public void getPageList(){
		CarrierSO so = new CarrierSO();
	    so.setCarrierName("carrierName");
	    PageList<CarrierVO> page= service.getPageList(so);
	    Assert.notNull(page.getPages());
	}
	
//	@Test
//	public void deleteCarrier()  throws Exception {
//		CarrierSO so = new CarrierSO();
//	    so.setCarrierName("carrierName");
//		PageList<CarrierVO> page = service.getPageList(so);
//		if (page.getFullListSize() > 0) {
//			Long id = page.getList().get(0).getId();
//			service.deleteCarrier(id);
//		} else {
//			throw new Exception("getPageList() error!");
//		}
//	}
	
	@Test
	public void batchUpdateCarrierStatus()  throws Exception {
		List<Long> idList = new ArrayList<Long>();
		idList.add(60800L);
		service.batchUpdateCarrierStatus(idList, CarrierStatus.ACTIVED);
	}
	
//	@Test
//	public void removeByIds() throws Exception  {
//		CarrierSO so = new CarrierSO();
//	    so.setCarrierName("carrierName");
//		PageList<CarrierVO> page = service.getPageList(so);
//		if (page.getFullListSize() > 0) {
//			List<Long> carrierIds = new ArrayList<Long> ();
//			for (CarrierVO carrierVO : page.getList()) {
//				carrierIds.add(carrierVO.getId());
//			}
//			service.removeByIds(carrierIds);
//		} else {
//			throw new Exception("getPageList() error!");
//		}
//		
//	}
	
	private CarrierVO getVO(){
		CarrierVO vo = new CarrierVO();
	    vo.setId(1L);
	    vo.setCarrierCode("carrierCode");
	    vo.setCarrierName("carrierName");
		vo.setCarrierShortName("carrierShortName");
		vo.setStatus(CarrierStatus.NEW);
		vo.setCarrierType(CarrierType.COMPANY);
		vo.setLicenseType(LicenseType.LICENSE) ;
		vo.setLicenseCode("licenseCode");
		vo.setGuarantee("guarantee");
		vo.setContactPerson("contactPerson") ;
		vo.setContactAddress("contactAddress");
		vo.setContactPhone("contactPhone") ;
		vo.setContactMobile("contactMobile");
		vo.setContactFX("contactFX") ;
		vo.setContactEmail("contactEmail");
		vo.setContactQQ("contactQQ") ;
		vo.setInvoice(Boolean.TRUE);
		vo.setApAge(1) ;
		vo.setBank("bank");
		vo.setBankAccount("bankAccount") ;
		vo.setRemark("remark");
		vo.setPayWay(PayWay.CASH) ;
	    return vo;
	}
	
}
