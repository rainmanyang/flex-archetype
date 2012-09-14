package com.oasis.wolfburg.facade.route;

import java.util.ArrayList;
import java.util.List;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.service.role.RoleService;
import com.oasis.tmsv5.common.so.security.RolePremissionSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.security.RolePremissionVO;

@RemotingDestination
@Service
public class StopServiceFacade {
	
//	@Autowired
	private RoleService roleService;
	
	public RolePremissionVO createRole(ClientContext clientContext,RolePremissionVO rpvo){
		return roleService.createRole(clientContext, rpvo);
	}
	
	public PageList<RolePremissionVO> getPageList(ClientContext clientContext,RolePremissionSO so){
		return roleService.getPageList(clientContext, so);
	}
	
	public void remove(ClientContext clientContext,List<?> ids){
		/**
		 * blazeDs将array转换为flex.messaging.io.ArrayCollection
		 * 需要手工转换为jdk的arrayList
		 */
	    List<Long> ids_t = new ArrayList<Long>();
		for(Object id:ids) {
		    if (id!= null){
		        Integer id_i = (Integer)id;
		        Long id_l = Long.valueOf(id_i.toString());
		        ids_t.add(id_l);
		    }
		    continue;
		}
	    roleService.remove(clientContext, ids_t);
	}
	
	public RolePremissionVO update(ClientContext clientContext,RolePremissionVO rpvo){
		return roleService.update(clientContext,rpvo);
	}
	
	public List<Role> getAllRole(ClientContext clientContext){
	    return roleService.getAllRole(clientContext);
	}
}
