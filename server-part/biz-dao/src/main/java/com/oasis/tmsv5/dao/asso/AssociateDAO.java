package com.oasis.tmsv5.dao.asso;

import java.util.List;

import com.oasis.tmsv5.common.enums.type.AssociateTable;

public interface AssociateDAO {
	void batchInsert(AssociateTable table, Long assocCol, List<Long> inverseCols);
	
	int  deleteByAssoc(AssociateTable table, Long id);
	
	int deleteByAssocIds(AssociateTable table, List<Long> ids);
	
	List<?> selectListByAssoc(AssociateTable table, Long id);
}
