package com.lwl.web.admin.module.screen;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.google.gson.Gson;
import com.lwl.dal.jsonobject.TreeNode;

public class QuiLeft extends BaseScreen {

    public void execute(Navigator nav, TurbineRunData rundata, Context context) throws Exception {

        rundata.setLayoutEnabled(false);

        List<TreeNode> treeNodes = new ArrayList<TreeNode>();

        TreeNode treeNode1 = new TreeNode(1l, 0l, "数据管理");
        treeNode1.setOpen(true);

        TreeNode treeNode11 = new TreeNode(1l, "用户表", getTurbineURIBroker("adminModule").setTarget("tableDetail.vm").addQueryData("tableName", "t_user").render(), "frmright");
        treeNodes.add(treeNode1);
        treeNodes.add(treeNode11);

        TreeNode treeNode12 = new TreeNode(1l, "订单表", getTurbineURIBroker("adminModule").setTarget("tableDetail.vm").addQueryData("tableName", "t_order").render(), "frmright");
        treeNodes.add(treeNode12);
        context.put("treeNodesJson", new Gson().toJson(treeNodes));
    }
}
