package com.oasis.wolfburg.service.carrier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ErrorDispHelper;
import com.oasis.wolfburg.common.so.carrier.ParentCompanySO;
import com.oasis.wolfburg.common.vo.carrier.ParentCompanyVO;
import com.oasis.wolfburg.dao.carrier.ParentCompanyDAO;
import com.oasis.wolfburg.model.carrier.ParentCompany;
@Service
public class ParentCompanyComponent extends BaseComponent {

	@Autowired
	private ParentCompanyDAO parentCompanyDAO;
	
	public ParentCompanyVO findParentCompany(Long parentCompanyId){
		ParentCompany parentCompany = parentCompanyDAO.find(parentCompanyId);
		ParentCompanyVO parentCompanyVO = super.getDozer().convert(parentCompany, ParentCompanyVO.class);
		return parentCompanyVO;
	}
	
	public ParentCompanyVO viewParentCompany(Long parentCompanyId){
		ParentCompany parentCompany = parentCompanyDAO.find(parentCompanyId);
		ParentCompanyVO parentCompanyVO = super.getDozer().convert(parentCompany, ParentCompanyVO.class);
		return parentCompanyVO;
	}
	
	public Long createParentCompany(ParentCompanyVO parentCompanyVO) {
		Long id = 0L;
		Map<String, String> error = validatIfCanCreate(parentCompanyVO);
		if (error == null) {
			ParentCompany parentCompany = super.getDozer().convert(parentCompanyVO, ParentCompany.class);
			id = parentCompanyDAO.insert(parentCompany);
		}
		
		return id;
	}

	public int deleteParentCompany(Long id) {
		return parentCompanyDAO.delete(id);
	}

	public void updateParentCompany(ParentCompanyVO parentCompanyVO) {
		parentCompanyDAO.update(super.getDozer().convert(parentCompanyVO, ParentCompany.class));
	}

	public void removeByIds(List<Long> insureIds) {
		parentCompanyDAO.deleteByIds(insureIds);
	}

	public PageList<ParentCompanyVO> getPageList(ParentCompanySO parentCompanySO) {
		List<ParentCompany> parentCompanyeList = parentCompanyDAO.getPaginatedList(parentCompanySO);
		List<ParentCompanyVO> list = super.getDozer().convertList(parentCompanyeList,ParentCompanyVO.class);
		int cnt = parentCompanyDAO.getPaginatedListCount(parentCompanySO);
		PageList<ParentCompanyVO> page = new PageList<ParentCompanyVO>();
		page.setList(list);
		page.setFullListSize(cnt);
		return page;
	}
	
	private Map<String, String> validatIfCanCreate(ParentCompanyVO parentCompanyVO) {
		ParentCompanySO parentCompanySO = new ParentCompanySO();
		parentCompanySO.setCompanyName(parentCompanyVO.getCompanyName());
		List<ParentCompany> parentCompanyList = parentCompanyDAO.checkDuplication(parentCompanySO);
		if (parentCompanyList.size() > 0) {
			ParentCompany parentCompany = parentCompanyList.get(0);
			Map<String, String> error = new HashMap<String, String>();
			if (parentCompanySO.getCompanyName().equals(parentCompany.getCompanyName())) {
				error.put("companyName", ErrorDispHelper.getInstance().getValue("PARENTCOMPANY_ERROR"));
			}
			if (error.keySet().size() > 0) {
				return error;
			}
		}
		return null;
	}
}
