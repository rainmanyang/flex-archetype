package com.oasis.wolfburg.dao.bill;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.oasis.tmsv5.dao.BaseDAO;
import com.oasis.tmsv5.dao.SqlSessionHolder;
import com.oasis.tmsv5.util.exception.QueryException;
import com.oasis.wolfburg.common.so.bill.PaymentItemSO;
import com.oasis.wolfburg.common.vo.bill.PaymentItemReportVO;
import com.oasis.wolfburg.model.bill.PaymentItem;
@Repository
public class PaymentItemDAOImpl extends BaseDAO<PaymentItem> implements PaymentItemDAO{
	
	private static final Log logger = LogFactory.getLog(PaymentItemDAOImpl.class);
	
	private static final String ST_SELECT_PAGELIST_REPORT = ".selectPageList4Report";   
	
	private static final String ST_SELECT_COUNT_REPORT = ".selectCount4Report";
	
	private static final String ST_SELECT_LIST_REPORT = ".selectPaymentItem4Report";
	
	private static final String ST_UPDATE_FLAG = ".updateFlag";
	
	

	public List<PaymentItem> getPaginatedList(PaymentItemSO so) {
		return super.getPaginatedList(so);
	}

	public int getPaginatedListCount(PaymentItemSO so) {
		return super.getPaginatedListCount(so);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<PaymentItem> getPaginatedList4Report(PaymentItemSO so) {
		
		Long startTime = System.currentTimeMillis();
        try {
            RowBounds rowBounds = new RowBounds((so.getPageNumber() - 1) * so.getObjectsPerPage(), so.getObjectsPerPage());
            List<PaymentItem> retList = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(getStatementNamespace() + ST_SELECT_PAGELIST_REPORT, so, rowBounds);

            return retList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("One page record loading took " + (System.currentTimeMillis() - startTime));
        }
	}

	public int getPaginatedListCount4Report(PaymentItemSO so) {
		Long startTime = System.currentTimeMillis();
        try {
            List<?> retList = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(getStatementNamespace() + ST_SELECT_COUNT_REPORT, so);
            return retList.size() > 0 ? (Integer) retList.get(0) : 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("Total record count loading took " + (System.currentTimeMillis() - startTime));
        }

	}
	/**
	 * 关帐
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentItemReportVO> getPaymentItemList4Report(PaymentItemSO so){
		Long startTime = System.currentTimeMillis();
        try {
            List<PaymentItemReportVO> retList = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(getStatementNamespace() + ST_SELECT_LIST_REPORT, so);
            return retList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("Record loading took " + (System.currentTimeMillis() - startTime));
        }
	}
	/**
	 * 导出
	 * @param so
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<PaymentItem> getPaymentItemList4Excel(PaymentItemSO so){
		Long startTime = System.currentTimeMillis();
        try {
            List<PaymentItem> retList = SqlSessionHolder.getSession(ExecutorType.REUSE).selectList(getStatementNamespace() + ST_SELECT_PAGELIST_REPORT, so);
            return retList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new QueryException(e);
        } finally {
            logger.debug("One page record loading took " + (System.currentTimeMillis() - startTime));
        }
	}
	
	public void updateFlag(String flag,Date billDateBegin,Date billDateEnd){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", flag);
		map.put("billDateBegin", billDateBegin);
		map.put("billDateEnd", billDateEnd);
		super.getSession().update(getStatementNamespace()+ST_UPDATE_FLAG, map);
	}
	
}
