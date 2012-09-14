package com.oasis.tmsv5.facade.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.ClientContext;
import com.oasis.tmsv5.common.util.tree.TreeNode;
import com.oasis.tmsv5.common.vo.menuItem.MenuItemVO;
import com.oasis.tmsv5.common.vo.security.CheckedPremissionTreeVO;
import com.oasis.tmsv5.service.menuItem.MenuItemComponent;

@RemotingDestination
@Service
public class MenuItemFacade {

	@Autowired
	private MenuItemComponent menuItemService;

	/**
	 * 获取菜单树
	 */
	public TreeNode getMenuItemTree(ClientContext clientContext) {
		return menuItemService.getMenuItem4Current();
	}

	public CheckedPremissionTreeVO getMenuItemTree4Premission(
			ClientContext clientContext, Long roleId) {
		return menuItemService.getMenuItemTree4Premission(roleId);
	}

	public TreeNode getMenuItemTreeWithPremission(ClientContext clientContext) {
		return menuItemService.getMenuItemTreeWithPremission();
	}

	public void create(ClientContext clientContext, MenuItemVO vo) {
		menuItemService.create(vo);
	}

	public MenuItemVO update(ClientContext clientContext, MenuItemVO vo) {
		return menuItemService.update(vo);
	}

	public MenuItemVO find(ClientContext clientContext, Long id) {
		return menuItemService.find(id);
	}

}
