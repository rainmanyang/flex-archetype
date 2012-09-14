package com.oasis.tmsv5.dao.asso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.common.enums.type.AssociateTable;
import com.oasis.tmsv5.dao.SqlSessionHolder;

@Repository
public class AssociateDAOImpl implements AssociateDAO{
	private static final String NAMESPACE = "com.oasis.tmsv5.dao.asso.AssociateDAO";

	private static final String INSERT_SQL = ".insert";

	private static final String DELETE_SQL = ".deleteByAssoc";
	
	private static final String DELETE_IDS_SQL = ".deleteByAssocIds";
	
	private static final String SELECT_SQL = ".selectList";
	
	protected SqlSession getSession() {
        return SqlSessionHolder.getSession();
    }
	
	public void batchInsert(AssociateTable table, Long assocCol, List<Long> inverseCols) {
		String insertField = table.getAssocCol() + "," + table.getInverseCol();
		for(Long id:inverseCols){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("table", table.getTableName());
			map.put("insertField", insertField);
			map.put("assocCol", assocCol);
			map.put("inverseCol", id);
			this.getSession().insert(NAMESPACE+INSERT_SQL, map);
		}
	}

	public int deleteByAssoc(AssociateTable table, Long id) {
		String clause = table.getAssocCol()+"="+id;
		Map<String,String> map = new HashMap<String,String>();
		map.put("table", table.getTableName());
		map.put("clause", clause);
		return this.getSession().delete(NAMESPACE+DELETE_SQL, map);
	}
	
	public int deleteByAssocIds(AssociateTable table, List<Long> ids){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("table", table.getTableName());
		map.put("assocCol", table.getAssocCol());
		map.put("ids", ids);
		return this.getSession().delete(NAMESPACE+DELETE_IDS_SQL, map);
	}
	
	public List<?> selectListByAssoc(AssociateTable table, Long id){
		String cols = table.getAssocCol()+" as assocCol,"+table.getInverseCol()+" as inverseCol";
		String clause = table.getAssocCol()+"="+id;
		Map<String,String> map = new HashMap<String,String>();
		map.put("table", table.getTableName());
		map.put("cols", cols);
		map.put("clause", clause);
		
		return this.getSession().selectList(NAMESPACE+SELECT_SQL, map);
	}
}
