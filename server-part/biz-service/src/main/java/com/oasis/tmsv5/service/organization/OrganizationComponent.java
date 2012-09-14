package com.oasis.tmsv5.service.organization;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oasis.tmsv5.common.base.Constants;
import com.oasis.tmsv5.common.enums.status.CommonStatus;
import com.oasis.tmsv5.common.so.security.OrganizationSO;
import com.oasis.tmsv5.common.util.page.PageList;
import com.oasis.tmsv5.common.util.tree.FlatTreeNode;
import com.oasis.tmsv5.common.util.tree.TreeNode;
import com.oasis.tmsv5.common.util.tree.TreeUtil;
import com.oasis.tmsv5.common.vo.orgnization.OrganizationVO;
import com.oasis.tmsv5.dao.organization.OrganizationDAO;
import com.oasis.tmsv5.model.organization.Organization;
import com.oasis.tmsv5.service.BaseComponent;
import com.oasis.tmsv5.service.helper.ErrorDispHelper;
import com.oasis.tmsv5.util.exception.ValidationException;
import com.oasis.tmsv5.util.tools.LogMessageUtil;

@Service
public class OrganizationComponent extends BaseComponent {

    private static final Log logger = LogFactory.getLog(OrganizationComponent.class);

    @Autowired
    private OrganizationDAO organizationDAO;

    public void createOrganization(OrganizationVO orgvo) {
        Map<String, String> error = validat(orgvo);
        if (error != null) {
            throw new ValidationException(error);
        }
        buildOrg(orgvo);
        Organization org = super.getDozer().convert(orgvo, Organization.class);
        organizationDAO.insert(org);
    }

    private void buildOrg(OrganizationVO vo) {
        Organization parent = organizationDAO.find(vo.getParentId());
        vo.setTreePath(parent.getTreePath() + Constants.VERTICAL_LINE + vo.getCode());
        vo.setNamePath(parent.getNamePath() + Constants.VERTICAL_LINE + vo.getName());
        vo.setStatus(CommonStatus.ACTIVE);
    }

    public PageList<OrganizationVO> getPageList(OrganizationSO so) {
        List<Organization> orgList = organizationDAO.getPaginatedList(so);
        List<OrganizationVO> list = super.getDozer().convertList(orgList, OrganizationVO.class);
        int cnt = organizationDAO.getPaginatedListCount(so);
        PageList<OrganizationVO> page = new PageList<OrganizationVO>();
        page.setList(list);
        page.setFullListSize(cnt);
        return page;
    }

    public OrganizationVO update(OrganizationVO orgvo) {

        Map<String, String> error = validat(orgvo);
        if (error != null) {
            throw new ValidationException(error);
        }
        Organization org = super.getDozer().convert(orgvo, Organization.class);
        organizationDAO.update(org);
        return orgvo;
    }

    private Map<String, String> validat(OrganizationVO vo) {
        OrganizationSO so = new OrganizationSO();
        Map<String, Object> searchMap = new HashMap<String, Object>();
        searchMap.put("name", vo.getName());
        searchMap.put("code", vo.getCode());
        Organization orgs = organizationDAO.checkDuplication(searchMap);
        if (orgs != null) {
            Map<String, String> error = new HashMap<String, String>();
            if (so.getName().equals(orgs.getName())) {
                error.put("nameCN", ErrorDispHelper.getInstance().getValue("ORGANIZATION_NAME_ERROR"));
            }
            if (so.getCode().equals(orgs.getCode())) {
                error.put("code", ErrorDispHelper.getInstance().getValue("ORGANIZATION_CODE_ERROR"));
            }
            return error;

        }
        return null;
    }

    public OrganizationVO view(Long id) {
        OrganizationVO orgvo = find(id);
        return orgvo;
    }

    // TODO
    public void remove(Long id) {
        organizationDAO.delete(id);
    }

    public TreeNode getOrgTree(String condition) {
        Organization root = organizationDAO.getRootOrganization();
        List<Organization> allOrg = organizationDAO.getAllOrganizations(condition);
        if (!condition.isEmpty()) {
            // 查找节点的的所有祖先节点
            allOrg = findLostNodes(allOrg);
        } else {
            if (!allOrg.contains(root)) {
                allOrg.add(root);
            }
        }
        return buildTree(root, allOrg);
    }

    private List<Organization> findLostNodes(List<Organization> child) {
        Set<Organization> allNodes = new HashSet<Organization>();
        Queue<Organization> childNodes = new LinkedList<Organization>(child);
        while (childNodes.size() > 0) {
            Organization org = childNodes.poll();
            allNodes.add(org);
            if (org.getId() != 60000) {
                Organization parent = organizationDAO.find(org.getParentId());
                childNodes.offer(parent);
            }
        }
        return new ArrayList<Organization>(allNodes);
    }

    public OrganizationVO find(Long id) {
        return getDozer().convert(organizationDAO.find(id), OrganizationVO.class);
    }

    private TreeNode buildTree(Organization root, List<Organization> organizations) {
        List<FlatTreeNode> flatTreeNodeList = new ArrayList<FlatTreeNode>(organizations.size() + 1);
        FlatTreeNode flatTreeNode;

        for (Organization organization : organizations) {

            OrganizationVO vo = new OrganizationVO();
            try {
                BeanUtils.copyProperties(vo, organization);
            } catch (IllegalAccessException e) {
                logger.error(LogMessageUtil.printStack(e));
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                logger.error(LogMessageUtil.printStack(e));
                e.printStackTrace();
            }

            flatTreeNode = new FlatTreeNode(organization.getId().toString(), organization.getName(), organization.getParentId()
                    + StringUtils.EMPTY, vo);
            flatTreeNodeList.add(flatTreeNode);
        }

        TreeNode menuItemTreeNodes = TreeUtil.buildTreeFromFlatTreeNodeList(root.getId().toString(), flatTreeNodeList, null);
        return menuItemTreeNodes;
    }
}
