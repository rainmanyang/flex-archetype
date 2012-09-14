package com.oasis.tmsv5.service.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.base.PredefinedCodeVO;
import com.oasis.tmsv5.common.enums.type.PredefinedCodeType;
import com.oasis.tmsv5.dao.base.PredefinedCodeDAO;
import com.oasis.tmsv5.model.base.PredefinedCode;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ErrorDispHelper;
import com.oasis.tmsv5.util.exception.ValidationException;
import com.oasis.wolfburg.common.so.predefinedCode.PredefinedCodeSO;

@Service
public class PredefinedCodeComponent extends BaseComponent {
	
	@Autowired
	private PredefinedCodeDAO predefinedCodeDAO;
	
	public List<PredefinedCodeVO> getPredefinedCodesByType(){
		List<PredefinedCode> list = predefinedCodeDAO.getPredefinedCodesByType(PredefinedCodeType.RECEIVABLE_BILL);
		List<PredefinedCodeVO> result = getDozer().convertList(list, PredefinedCodeVO.class);
		return result;
	}
	
	public PredefinedCodeVO getPredefinedCodesByCode(String code){
		PredefinedCode predefinedCode = predefinedCodeDAO.getCachePredefinedCodeByCode(code);
		return getDozer().convert(predefinedCode, PredefinedCodeVO.class);
	}
	
	public List<PredefinedCodeVO> queryPredefinedCodes(PredefinedCodeSO so){
		List<PredefinedCode> list = predefinedCodeDAO.queryPredefinedCodes(so);
		List<PredefinedCodeVO> result = getDozer().convertList(list, PredefinedCodeVO.class);
		return result;
	}
	
	public void create(PredefinedCodeVO vo){
		checkBrand(vo.getValue());
		PredefinedCode predefinedCode = super.getDozer().convert(vo, PredefinedCode.class);
		Long id = predefinedCodeDAO.insert(predefinedCode);
		
		predefinedCode.setId(id);
		String code = id.toString();
		code = StringUtils.leftPad(code, 3, "0");
		predefinedCode.setCode("prd"+code);
		predefinedCodeDAO.update(predefinedCode);
	}
	/**
	 * 
	 * reviewer:中文
	 */
	private void checkBrand(String brand){
		Map<String, String> errors = new HashMap<String, String>();
		boolean flag = predefinedCodeDAO.hasPredefinedCodeByTypeAndValue(PredefinedCodeType.TRUCK_BRAND, brand);
		if(flag){
			errors.put("val", ErrorDispHelper.getInstance().getValue("BRAND_ERROR"));
            throw new ValidationException(errors);
		}
	}
}