package com.oasis.test.truck;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.enums.status.TruckRunningStatus;
import com.oasis.wolfburg.common.enums.status.TruckStatus;
import com.oasis.wolfburg.common.enums.type.TruckType;
import com.oasis.wolfburg.common.so.truck.TruckSO;
import com.oasis.wolfburg.common.vo.attachment.AttachmentVO;
import com.oasis.wolfburg.common.vo.insure.InsureVO;
import com.oasis.wolfburg.common.vo.truck.ContractRouteVO;
import com.oasis.wolfburg.common.vo.truck.TruckVO;
import com.oasis.wolfburg.service.truck.TruckComponent;

public class TruckServiceTest extends SpringBaseTest {

	@Autowired
	private TruckComponent service;

	@Test
	public void createAllTruckInfo() {
		List<InsureVO> insuerList = new ArrayList<InsureVO>();
		InsureVO insureVO = getInsureVO();
		insuerList.add(insureVO);
		InsureVO insureVO1 = getInsureVO();
		insuerList.add(insureVO1);
		
		TruckVO truckVO = getVO();
		truckVO.setInsureList(insuerList);
		truckVO.setCardCode(truckVO.getCardCode()+super.CODE);
		truckVO.setAttachmentList(new ArrayList<AttachmentVO>());
		service.createAllTruckInfo(truckVO);
	}
	
	@Test
	public void updateAllTruckInfo() throws Exception  {
		List<InsureVO> insuerList = new ArrayList<InsureVO>();
		InsureVO insureVO = getInsureVO();
		insuerList.add(insureVO);
		InsureVO insureVO1 = getInsureVO();
		insuerList.add(insureVO1);
		TruckSO so = new TruckSO();
		so.setLicensePlate("licensePlate");
		PageList<TruckVO> page = service.getPageList(so);
		TruckVO truckVO = page.getList().get(0);
		truckVO.setInsureList(insuerList);
		truckVO.setCardCode(truckVO.getCardCode()+super.CODE);
		truckVO.setAttachmentList(new ArrayList<AttachmentVO>());
		if (page.getFullListSize() > 0) {
			service.updateAllTruckInfo(truckVO);
		} else {
			throw new Exception("getPageList() error!");
		}
	}
	
	@Test
	public void getPageList() {
		TruckSO so = new TruckSO();
		so.setLicensePlate("licensePlate");
		PageList<TruckVO> page = service.getPageList(so);
		Assert.notNull(page.getPages());
	}
	
	@Test
	public void listContractRoute() {
		TruckSO so = new TruckSO();
		so.setLicensePlate("licensePlate");
		PageList<TruckVO> page = service.getPageList(so);
		Long truckId = page.getList().get(0).getId();
		Assert.notNull(service.listContractRoute(truckId));
	}
	
	@Test
	public void deleteContractRoute() throws Exception  {
		TruckSO so = new TruckSO();
		so.setLicensePlate("licensePlate");
		PageList<TruckVO> page = service.getPageList(so);
		Long truckId = page.getList().get(0).getId();
		if (page.getFullListSize() > 0) {
			ContractRouteVO contractRouteVO = new ContractRouteVO();
			contractRouteVO.setRouteId(1L);
			contractRouteVO.setTruckId(truckId);
			service.deleteContractRoute(contractRouteVO);
		} else {
			throw new Exception("getPageList() error!");
		}

	}
	
	@Test
	public void deleteTruck()  throws Exception {
		TruckSO so = new TruckSO();
		so.setLicensePlate("licensePlate");
		PageList<TruckVO> page = service.getPageList(so);
		if (page.getFullListSize() > 0) {
			Long id = page.getList().get(0).getId();
			service.deleteTruck(id);
		} else {
			throw new Exception("getPageList() error!");
		}
	}
	
	private InsureVO getInsureVO(){
		InsureVO vo = new InsureVO();
	    vo.setId(1L);
		vo.setInsurer("insurer");
		vo.setInsureCode("insureCode");
		vo.setLicensePlate("licensePlate");
		vo.setTruckId(2L);
		vo.setInsureFrom(new Date()) ;
		vo.setInsureTo(new Date());
	    return vo;
	}

	private TruckVO getVO() {
		TruckVO vo = new TruckVO();
		vo.setId(1L);
		vo.setLicensePlate("licensePlate");
		vo.setTruckType(TruckType.T4_2M);
		vo.setTruckLength("truckLength");
		vo.setTruckWidth("truckWidth");
		vo.setTruckHeight("truckHeight");
		vo.setLoadVolume("loadVolume");
		vo.setLoadWeight("loadWeight");
		vo.setStatus(TruckStatus.ENABLE);
		vo.setContactPerson("contractPerson");
		vo.setContactPhone1("contractPhone");
		vo.setGps("gps");
		vo.setCardCode("cardCode");
		vo.setCarrierId(1L);
		vo.setOwnerName("ownerName");
		vo.setOwnerAddress("ownerAddress");
		vo.setOwnerPhone("ownerPhone");
		vo.setEmptyWeight("emptyWeight");
		vo.setMaxWeight("maxWeight");
		vo.setTotalWeight("totalWeight");
		vo.setBrand("brand");
		vo.setVin("vin");
		vo.setEngineCode("engineCode");
		vo.setTruckCode("truckCode");
		vo.setLicenseDate(new Date());
		vo.setInspectionDate(new Date());
		vo.setInspectionDur(1);
		vo.setDiscardDate(new Date());
		vo.setPermissionOrg("permisstionOrg");
		vo.setLocation("location");
		vo.setCity("city");
		vo.setTruckLevel("LOW");
		vo.setDirver1Id(1L);
		vo.setDriver1Name("driver1Name");
		vo.setDriver1Phone("driver1Phone");
		vo.setDirver2Id(1L);
		vo.setDriver2Name("driver2Name");
		vo.setDriver2Phone("driver2Phone");
		vo.setRunningStatus(TruckRunningStatus.FREE);
		vo.setTrailerCode("trailerCode");
		vo.setContractNumber("contractNumber");
		vo.setContractDate(new Date());
		vo.setContractDateFrom(new Date());
		vo.setContractDateTo(new Date());
		vo.setInsureCodes("insureCodes");
		return vo;
	}
}
