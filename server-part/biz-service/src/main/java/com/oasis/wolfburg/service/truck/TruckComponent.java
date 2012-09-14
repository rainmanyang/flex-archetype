package com.oasis.wolfburg.service.truck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.base.Constants;
import com.oasis.tmsv5.common.enums.type.AssociateTable;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.dao.asso.AssociateDAO;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ErrorDispHelper;
import com.oasis.tmsv5.util.exception.ValidationException;
import com.oasis.wolfburg.common.enums.status.AttachmentAssocTable;
import com.oasis.wolfburg.common.enums.status.TruckRunningStatus;
import com.oasis.wolfburg.common.enums.status.TruckStatus;
import com.oasis.wolfburg.common.enums.type.TruckResourceType;
import com.oasis.wolfburg.common.so.truck.TruckSO;
import com.oasis.wolfburg.common.vo.client.TruckLocation;
import com.oasis.wolfburg.common.vo.driver.DriverVO;
import com.oasis.wolfburg.common.vo.insure.InsureVO;
import com.oasis.wolfburg.common.vo.route.RouteVO;
import com.oasis.wolfburg.common.vo.truck.ContractRouteVO;
import com.oasis.wolfburg.common.vo.truck.TruckVO;
import com.oasis.wolfburg.dao.driver.DriverDAO;
import com.oasis.wolfburg.dao.insure.InsureDAO;
import com.oasis.wolfburg.dao.truck.ContractRouteDAO;
import com.oasis.wolfburg.dao.truck.TruckDAO;
import com.oasis.wolfburg.dao.truck.TruckStatusRecordDAO;
import com.oasis.wolfburg.model.driver.Driver;
import com.oasis.wolfburg.model.insure.Insure;
import com.oasis.wolfburg.model.route.Route;
import com.oasis.wolfburg.model.truck.ContractRoute;
import com.oasis.wolfburg.model.truck.Truck;
import com.oasis.wolfburg.model.truck.TruckStatusRecord;
import com.oasis.wolfburg.service.attachmentHelper.AttachmentHelper;

@Service
public class TruckComponent extends BaseComponent {

    @Autowired
    private TruckDAO truckDAO;

    @Autowired
    private ContractRouteDAO contractRouteDAO;

    @Autowired
    private TruckStatusRecordDAO truckStatusRecordDAO;

    @Autowired
    private InsureDAO insureDAO;
    
    @Autowired
    private DriverDAO driverDAO;
    
    @Autowired
	private AttachmentHelper attachmentHelper;
    
    @Autowired
    private AssociateDAO associateDAO;
    

    public TruckVO findTruck(Long truckId) {
        Truck truck = truckDAO.find(truckId);
        TruckVO truckVO = super.getDozer().convert(truck, TruckVO.class);
        
        List<Route> routeList = contractRouteDAO.listContractRoute4truckId(truck.getId());
        List<RouteVO> contractRouteList = super.getDozer().convertList(routeList, RouteVO.class);
        truckVO.setContractRouteList(contractRouteList);
        
        List<Long> driverIdList = new ArrayList<Long>(); 
        if (truck.getDirver1Id() != null) {
        	driverIdList.add(truck.getDirver1Id());
        }
        if (truck.getDirver2Id() != null){
        	driverIdList.add(truck.getDirver2Id());
        }
        List<Driver> usedDriverList = driverDAO.getListByIds(driverIdList);
        List<DriverVO> driverList = super.getDozer().convertList(usedDriverList, DriverVO.class);
        truckVO.setDriverList(driverList);
        
        List<Insure> insureList = insureDAO.getListByFKId(truckId);
        List<InsureVO> insureVOList =  getDozer().convertList(insureList, InsureVO.class);
        truckVO.setInsureList(insureVOList);
        
        truckVO.setAttachmentList(attachmentHelper.getList(truckId, AttachmentAssocTable.TRUCK));
        return truckVO;
    }

    public Long createAllTruckInfo(TruckVO truckVO) {
    	Truck truck = super.getDozer().convert(truckVO, Truck.class);
        validatIfCanCreate(truck);
        validateIdCard(truck);
        
        if (truck.getResourceType() == null) {
        	truck.setResourceType(TruckResourceType.TEMP);
        }
        if (truck.getRunningStatus() == null) {
        	truck.setRunningStatus(TruckRunningStatus.FREE);
        }
        if (truck.getStatus() == null) {
        	truck.setStatus(TruckStatus.ENABLE);
        }
        
        /**
         * 把司机信息保存至车辆
         */
        List<DriverVO> list = truckVO.getDriverList();
        for(int k=0;k<list.size()&&k<2;k++){
        	DriverVO driver = list.get(k);
        	if(k == 0){
        		truck.setDirver1Id(driver.getId());
        		truck.setDriver1Name(driver.getName());
        		truck.setDriver1Phone(driver.getMobilePhone());
        	}else{
        		truck.setDirver2Id(driver.getId());
        		truck.setDriver2Name(driver.getName());
        		truck.setDriver2Phone(driver.getMobilePhone());
        	}
        }
        
        Long id = truckDAO.insert(truck);
        truck = truckDAO.find(id);
        
        TruckStatusRecord truckStatusRecord = 
        	TruckStatusRecordHelper.logStatusRecored(truck, TruckStatusRecordHelper.TRUCK_CREATED, null);
        truckStatusRecordDAO.insert(truckStatusRecord);
        
        /**
         * 保险信息
         */
        if (truckVO.getInsureList().size() > 0) {
        	for (InsureVO insureVO: truckVO.getInsureList()) {
        		insureVO.setTruckId(id);
        		insureVO.setLicensePlate(truckVO.getLicensePlate());
        		Insure insure = super.getDozer().convert(insureVO, Insure.class);
        		insureDAO.insert(insure);
        	}
        }
        
        /**
         * 合同线路
         */
        List<Long> routeIds = new ArrayList<Long>();
        if (truckVO.getContractRouteList().size() > 0) {
        	for (RouteVO routeVO: truckVO.getContractRouteList()) {
        		routeIds.add(routeVO.getId());
        	}
        	associateDAO.batchInsert(AssociateTable.TRUCK_ROUTE, id, routeIds);
        }
        
        attachmentHelper.insert(truckVO.getAttachmentList(), id, AttachmentAssocTable.TRUCK);
        
        return id;
    }
    
    public TruckVO updateAllTruckInfo(TruckVO truckVO) {
    	Long id = truckVO.getId();
    	Truck truck = super.getDozer().convert(truckVO, Truck.class);
    	validateIdCard(truck);
    	
    	/**
    	 * 更新保险信息,只有两条数据
    	 */
    	List<InsureVO> insureVOList = truckVO.getInsureList();
    	List<Insure> insureList = insureDAO.getListByFKId(id);
    	for(int k=0;k<2;k++){
    		InsureVO insureVO = insureVOList.get(k);
    		Insure insure = insureList.get(k);
    		insure.setInsurer(insureVO.getInsurer());
    		insure.setInsureCode(insureVO.getInsureCode());
    		insure.setInsureFrom(insureVO.getInsureFrom());
    		insure.setInsureTo(insureVO.getInsureTo());
    		insureDAO.update(insure);
    	}
    	
    	associateDAO.deleteByAssoc(AssociateTable.TRUCK_ROUTE, id);
    	List<Long> routeIds = new ArrayList<Long>();
        if (truckVO.getContractRouteList().size() > 0) {
        	for (RouteVO routeVO: truckVO.getContractRouteList()) {
        		routeIds.add(routeVO.getId());
        	}
        	associateDAO.batchInsert(AssociateTable.TRUCK_ROUTE, id, routeIds);
        }
        
        
        /**
    	 * 对已有的司机信息先删除,再填加
    	 */
        truck.setDirver1Id(Constants.DATABASE_KEY_NULL_VALUE);
		truck.setDirver2Id(Constants.DATABASE_KEY_NULL_VALUE);
		
        List<DriverVO> list = truckVO.getDriverList();
        for(int k=0;k<list.size()&&k<2;k++){
        	DriverVO driver = list.get(k);
        	String mobilePhone = driver.getMobilePhone() == null ? StringUtils.EMPTY:driver.getMobilePhone();
        	if(k == 0){
        		truck.setDirver1Id(driver.getId());
        		truck.setDriver1Name(driver.getName());
        		truck.setDriver1Phone(mobilePhone);
        	}else{
        		truck.setDirver2Id(driver.getId());
        		truck.setDriver2Name(driver.getName());
        		truck.setDriver2Phone(mobilePhone);
        	}
        }
        
    	truckDAO.update(truck);
    	
    	attachmentHelper.edit(truckVO.getAttachmentList(), id, AttachmentAssocTable.TRUCK);
    	
    	TruckStatusRecord truckStatusRecord = 
        	TruckStatusRecordHelper.logStatusRecored(truck, TruckStatusRecordHelper.TRUCK_UPDATED, null);
        truckStatusRecordDAO.insert(truckStatusRecord);
        
        return findTruck(truck.getId());
    }

    public void addContractRoute(ContractRouteVO contractRouteVO) {
        ContractRoute contractRoute = super.getDozer().convert(contractRouteVO, ContractRoute.class);
        contractRouteDAO.insert(contractRoute);
    }

    public void deleteContractRoute(ContractRouteVO contractRouteVO) {
        ContractRoute contractRoute = super.getDozer().convert(contractRouteVO, ContractRoute.class);
        contractRouteDAO.deleteContractRoute(contractRoute);
    }

    public PageList<RouteVO> listContractRoute(Long truckId) {
        TruckSO truckSO = new TruckSO();
        truckSO.setTruckId(truckId);
        List<Route> contractRouteList = contractRouteDAO.listContractRoute(truckSO);
        List<RouteVO> list = super.getDozer().convertList(contractRouteList, RouteVO.class);
        int cnt = contractRouteDAO.listContractRouteCount(truckSO);
        PageList<RouteVO> page = new PageList<RouteVO>();
        page.setList(list);
        page.setFullListSize(cnt);
        return page;
    }

    public int deleteTruck(Long id) {
        return truckDAO.delete(id);
    }

    public TruckVO updateTruckStatus(TruckVO truckVO, String desc) {
    	Truck truck = truckDAO.find(truckVO.getId());
    	truck.setStatus(truckVO.getStatus());
        truckDAO.update(truck);

        TruckStatusRecord truckStatusRecord = 
        	TruckStatusRecordHelper.logStatusRecored(truck, TruckStatusRecordHelper.TRUCK_STATUS_UPDATED, desc);
        truckStatusRecordDAO.insert(truckStatusRecord);
        
        truckVO = super.getDozer().convert(truck, TruckVO.class);
        return truckVO;
    }

    public TruckVO updateRunningStatus(TruckVO truckVO, String desc) {
    	Truck truck = truckDAO.find(truckVO.getId());
    	truck.setRunningStatus(truckVO.getRunningStatus());
        truckDAO.update(truck);

        TruckStatusRecord truckStatusRecord = 
        	TruckStatusRecordHelper.logStatusRecored(truck, TruckStatusRecordHelper.RUNNING_STATUS_UPDATED, desc);
        truckStatusRecordDAO.insert(truckStatusRecord);
        
        truckVO = super.getDozer().convert(truck, TruckVO.class);
        return truckVO;
    }

    public TruckVO updateResourceType(TruckVO truckVO, String desc) {
    	Truck truck = truckDAO.find(truckVO.getId());
    	truck.setResourceType(truckVO.getResourceType());
        truckDAO.update(truck);

        TruckStatusRecord truckStatusRecord = 
        	TruckStatusRecordHelper.logStatusRecored(truck, TruckStatusRecordHelper.RESOURCE_TYPE_UPDATED, desc);
        truckStatusRecordDAO.insert(truckStatusRecord);
        
        truckVO = super.getDozer().convert(truck, TruckVO.class);
        return truckVO;
    }

    public PageList<TruckVO> getPageList(TruckSO truckSO) {
        List<Truck> truckList = truckDAO.getPaginatedList(truckSO);
        List<TruckVO> list = super.getDozer().convertList(truckList, TruckVO.class);
        int cnt = truckDAO.getPaginatedListCount(truckSO);
        PageList<TruckVO> page = new PageList<TruckVO>();
        page.setList(list);
        page.setFullListSize(cnt);
        return page;
    }

    private void validatIfCanCreate(Truck truck) {
    	Map<String, String> error = new HashMap<String, String>();
    	int cnt = truckDAO.checkDuplication(truck);
    	if(cnt > 0){
    		error.put("licensePlate", ErrorDispHelper.getInstance().getValue("TRUCK_ERROR"));
    		throw new ValidationException(error);
    	}
    }

    public List<TruckLocation> updateLocation(List<TruckLocation> truckLocationList) { 
        List<TruckLocation> retList=new ArrayList<TruckLocation>();
        for(TruckLocation truckLocation:truckLocationList){
            Truck truck = truckDAO.getTruckByLicensePlate(truckLocation.getTruckCode());
            if (truck == null) {
                truckLocation.setMessage("can't find Truck.");
                truckLocation.setExecFlag(-2);
                retList.add(truckLocation);
                continue;
            }
            truck.setLocation(truckLocation.getLocation());
            if (truckLocation.getUpdatedTime() != null) {
                truck.setUpdatedTime(truckLocation.getUpdatedTime());
            }
            truck.setCity(truckLocation.getCity());
            truckDAO.update(truck);
        }        
       return retList;

    }
    
	public void batchUpdateTruckStatus(List<Long> truckIdList,TruckStatus truckStatus){
		TruckSO truckSO = new TruckSO();
		truckSO.setTruckIdList(truckIdList);
		List<Truck> truckList = truckDAO.getPaginatedList(truckSO);
		switch (truckStatus) {
			case BREAK_DOWN:{
				for (Truck truck : truckList) {
					if (TruckStatus.ENABLE.equals(truck.getStatus())) {
						truck.setStatus(TruckStatus.BREAK_DOWN);
						truckDAO.update(truck);
					}
				}
				break;
			}
			case CLOSED:{
				for (Truck truck : truckList) {
					if (TruckStatus.ENABLE.equals(truck.getStatus()) || TruckStatus.BREAK_DOWN.equals(truck.getStatus())
							|| TruckStatus.PONISHED.equals(truck.getStatus())) {
						truck.setStatus(TruckStatus.CLOSED);
						truckDAO.update(truck);
					}
				}
				break;
			}
			case ENABLE:{
				for (Truck truck : truckList) {
					if (TruckStatus.PONISHED.equals(truck.getStatus()) || TruckStatus.ENABLE.equals(truck.getStatus()) ||
							TruckStatus.CLOSED.equals(truck.getStatus())) {
						truck.setStatus(TruckStatus.ENABLE);
						truckDAO.update(truck);
					}
				}
				break;
			}
			case PONISHED:{
				for (Truck truck : truckList) {
					if (TruckStatus.ENABLE.equals(truck.getStatus())) {
						truck.setStatus(TruckStatus.PONISHED);
						truckDAO.update(truck);
					}
				}
			}
			default:{
				break;
			}
	    }
	}

	private void validateIdCard(Truck truck) {
    	Map<String, String> error = new HashMap<String, String>();
    	int cnt = truckDAO.checkIdCard(truck);
    	if(cnt > 0){
    		/**
    		 * reviewer:去掉中文
    		 */
    		error.put("cardCode", ErrorDispHelper.getInstance().getValue("TRUCK_CARD_ERROR"));
    		throw new ValidationException(error);
    	}
    }
}
