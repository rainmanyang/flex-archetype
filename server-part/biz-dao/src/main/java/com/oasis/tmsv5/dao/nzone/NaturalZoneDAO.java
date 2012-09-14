package com.oasis.tmsv5.dao.nzone;

import java.util.List;

import com.oasis.tmsv5.common.so.zone.NaturalZoneSO;
import com.oasis.tmsv5.dao.DAO;
import com.oasis.tmsv5.model.naturalzone.NaturalZone;

public interface NaturalZoneDAO extends DAO<NaturalZone> {
	List<NaturalZone> getPaginatedList(NaturalZoneSO so);
	
	int getPaginatedListCount(NaturalZoneSO so);
	
	List<NaturalZone> getNzonesByOrgId(Long orgId);
	
	NaturalZone getRootNZone();
	
   List<NaturalZone> getNaturalZoneBySO(NaturalZoneSO so);
   
   List<NaturalZone> getCheckNzoneByOrg(Long id);
   
   List<NaturalZone> getNZoneByParent(Long id);
   
   
   
}
