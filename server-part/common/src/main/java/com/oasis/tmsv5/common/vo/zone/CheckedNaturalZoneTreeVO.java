package com.oasis.tmsv5.common.vo.zone;

import java.util.List;

import com.oasis.tmsv5.common.util.tree.TreeNode;
import com.oasis.tmsv5.common.vo.BaseVO;

public class CheckedNaturalZoneTreeVO extends BaseVO {

    /**
     * 
     */
    private static final long serialVersionUID = 8727386538280515943L;

    public CheckedNaturalZoneTreeVO() {
    }

    private TreeNode nZoneTree;

    private List<NaturalZoneVO> checkedNzone;

    public TreeNode getnZoneTree() {
        return nZoneTree;
    }

    public void setnZoneTree(TreeNode nZoneTree) {
        this.nZoneTree = nZoneTree;
    }

    public List<NaturalZoneVO> getCheckedNzone() {
        return checkedNzone;
    }

    public void setCheckedNzone(List<NaturalZoneVO> checkedNzone) {
        this.checkedNzone = checkedNzone;
    }

}
