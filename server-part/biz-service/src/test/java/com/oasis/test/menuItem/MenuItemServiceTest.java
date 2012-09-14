package com.oasis.test.menuItem;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.oasis.test.SpringBaseTest;
import com.oasis.tmsv5.common.util.tree.TreeNode;
import com.oasis.tmsv5.service.menuItem.MenuItemComponent;

public class MenuItemServiceTest extends SpringBaseTest {
    
    @Autowired
    private MenuItemComponent menuItemComponet;
    
    @Test
    public void testGetMenuItemTree(){
        
        //TreeNode treeNode = menuItemComponet.getMenuItemTree(60014L);
        
        //Assert.notNull(treeNode);
    }
}
