package com.oasis.wolfburg.common.service.route;

import java.util.List;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.so.route.PosSO;
import com.oasis.wolfburg.common.vo.route.PosVO;
import com.oasis.wolfburg.common.vo.route.PosViewVO;

public interface PosService {

    void create(ClientContext clientContext,PosVO posVO);

    void delete(ClientContext clientContext,Long Id);
    
    PageList<PosViewVO> getPageList(ClientContext clientContext,PosSO so);
    
    void update(ClientContext clientContext,PosViewVO posVO);
    
    void remove(ClientContext clientContext,List<Long> ids);
    
    PosVO find(ClientContext clientContext,Long id);
    
    PosViewVO findView(ClientContext clientContext,Long id);
    
}
