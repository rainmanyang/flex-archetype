package com.oasis.tmsv5.dao.nzone;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.common.so.zone.NaturalZoneSO;
import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.tmsv5.model.naturalzone.NaturalZone;

@Repository
public class NaturalZoneDAOImpl extends BaseDAO<NaturalZone> implements
		NaturalZoneDAO {
	private static final String ST_BY_ORG = ".getNzonesByOrgId";
	
	private static final String GET_ROOT_NZONE = ".getRootNZone";
	
	private static final String GET_NZONE_BY_ORG = ".getNzoneByOrg";
	
	private static final String GET_NZONE_BY_PARENT = ".getNzoneByParent";
	
	private static final String ST_SELECT_PAGELIST = ".selectPageList";

	public List<NaturalZone> getPaginatedList(NaturalZoneSO so) {
		return super.getPaginatedList(so);
	}

	public int getPaginatedListCount(NaturalZoneSO so) {
		return super.getPaginatedListCount(so);
	}

	@SuppressWarnings("unchecked")
	public List<NaturalZone> getNzonesByOrgId(Long orgId) {
		return super.getSession().selectList(getStatementNamespace()+ST_BY_ORG, orgId);
	}

    @Override
    public NaturalZone getRootNZone() {
        return (NaturalZone)super.getSession().selectOne(getStatementNamespace()+GET_ROOT_NZONE);
    }
    
    @SuppressWarnings("unchecked")
    public List<NaturalZone> getNaturalZoneBySO(NaturalZoneSO so){
        return super.getSession().selectList(getStatementNamespace() + ST_SELECT_PAGELIST, so);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NaturalZone> getCheckNzoneByOrg(Long id) {
       return super.getSession().selectList(getStatementNamespace()+GET_NZONE_BY_ORG, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<NaturalZone> getNZoneByParent(Long id) {
        return super.getSession().selectList(getStatementNamespace()+GET_NZONE_BY_PARENT,id);
    }
    
    
    
}
