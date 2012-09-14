package com.oasis.wolfburg.facade.route;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.wolfburg.common.service.route.PosService;
import com.oasis.wolfburg.common.so.route.PosSO;
import com.oasis.wolfburg.common.vo.route.PosVO;
import com.oasis.wolfburg.common.vo.route.PosViewVO;

@RemotingDestination
@Service
public class PosServiceFacade {

//    @Autowired
    private PosService posService;
    
    public void create(ClientContext clientContext, PosVO posvo) {
        posService.create(clientContext, posvo);
    }

    public void delete(ClientContext clientContext, Long id) {
        posService.delete(clientContext, id);
    }

    public PageList<PosViewVO> getPageList(ClientContext clientContext, PosSO so) {
        return posService.getPageList(clientContext, so);
    }

    public void update(ClientContext clientContext, PosViewVO posVO) {
        posService.update(clientContext, posVO);
    }

    public void remove(ClientContext clientContext, List<Long> ids) {
        posService.remove(clientContext, ids);
    }
    
    public PosVO find(ClientContext clientContext, Long id){
        return posService.find(clientContext, id);
    }
    
    public PosViewVO findView(ClientContext clientContext,Long id){
        return posService.findView(clientContext, id);
    }
    
}
