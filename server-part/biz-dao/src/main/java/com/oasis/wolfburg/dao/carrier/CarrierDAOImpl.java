package com.oasis.wolfburg.dao.carrier;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.wolfburg.common.so.carrier.CarrierSO;
import com.oasis.wolfburg.model.carrier.Carrier;

@Repository
public class CarrierDAOImpl extends BaseDAO<Carrier> implements CarrierDAO {
	
    private static final String CHECK_DUPLICATION = ".checkDuplication";
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Carrier> checkDuplication(CarrierSO carrierSO) {
        return getSession().selectList(getStatementNamespace() + CHECK_DUPLICATION, carrierSO);
    }

    @Override
    public List<Carrier> getPaginatedList(CarrierSO carrierSO) {
        return super.getPaginatedList(carrierSO);
    }

    @Override
    public int getPaginatedListCount(CarrierSO carrierSO) {
        return super.getPaginatedListCount(carrierSO);
    }

}
