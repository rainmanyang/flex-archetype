package com.oasis.test.role;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.so.security.RolePremissionSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.vo.menuItem.MenuItemVO;
import com.oasis.tmsv5.common.vo.security.RolePremissionVO;
import com.oasis.tmsv5.service.role.RoleComponent;

public class RoleServiceTest extends SpringBaseTest {
	@Autowired
	private RoleComponent roleComponent;
	
	@Test
	public void createRole(){
		RolePremissionVO rpvo = new RolePremissionVO();
		rpvo.setName("test"+CODE);
		rpvo.setDescription("AV");
		rpvo.setPremission(this.getMenuItemList());
		roleComponent.createRole(rpvo);
		System.out.println("create Role");
	}
	
	@Test
	public void getPageList(){
		//this.applicationContext
		RolePremissionSO so = this.getSO();
		so.setDescription("");
		PageList<RolePremissionVO> page = roleComponent.getPageList(so);
		System.out.println("role getPageList"+page.getFullListSize());
	}
	
	@Test
	public void remove(){
		List<Long> list = new ArrayList<Long>();
		list.add(73640L);
		list.add(73630L);
		roleComponent.remove(list);
		System.out.println("role remove");
	}
	
	//@Test
	public void update(){
		RolePremissionVO rpvo = new RolePremissionVO();
		rpvo.setId(new Long("73630"));
		rpvo.setDescription("AV");
		rpvo.setLockVersion(2);
		rpvo.setPremission(this.getMenuItemList());
		roleComponent.update(rpvo);
		System.out.println("role udpate");
	}
	
	@Test
	public void testGetPageList(){
	    RolePremissionSO so = new RolePremissionSO();
	    so.setName("");
	    so.setDescription("");
	    PageList<RolePremissionVO> list = roleComponent.getPageList(so);
	    System.out.println("role testGetPageList"+list.getFullListSize());
	    System.out.println("getRoleList");
	}
	
	
	private Set<MenuItemVO> getMenuItemList(){
		List<MenuItemVO> list = new ArrayList<MenuItemVO>();
		Long id = 101L;
		for(int i=0;i<3;i++){
			MenuItemVO mi = new MenuItemVO();
			mi.setId(id+i);
			list.add(mi);
		}
		Set<MenuItemVO> set = new HashSet<MenuItemVO>();
		set.addAll(list);
		return set;
	}
	
	private RolePremissionSO getSO(){
		RolePremissionSO so = new RolePremissionSO();
		so.setName("a");
		return so;
	}
}
