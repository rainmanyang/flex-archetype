package com.oasis.tmsv5.dao.base;

import java.util.List;

import com.oasis.tmsv5.common.enums.type.PredefinedCodeType;
import com.oasis.tmsv5.dao.DAO;
import com.oasis.tmsv5.model.base.PredefinedCode;
import com.oasis.wolfburg.common.so.predefinedCode.PredefinedCodeSO;

public interface PredefinedCodeDAO extends DAO<PredefinedCode> {

    PredefinedCode getCachePredefinedCodeByCode(String code);
    
    List<PredefinedCode> getCachePredefinedCodesByType(PredefinedCodeType type);
    
    List<PredefinedCode> getPredefinedCodesByType(PredefinedCodeType type);

    boolean hasPredefinedCodeByTypeAndValue(PredefinedCodeType type,String value);
    
    List<PredefinedCode> queryPredefinedCodes(PredefinedCodeSO so);
}
