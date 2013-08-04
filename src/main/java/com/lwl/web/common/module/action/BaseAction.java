package com.lwl.web.common.module.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.citrus.service.uribroker.URIBrokerService;
import com.alibaba.citrus.service.uribroker.uri.URIBroker;
import com.alibaba.citrus.turbine.TurbineRunData;
import com.alibaba.citrus.turbine.uribroker.uri.TurbineURIBroker;
import com.alibaba.citrus.turbine.util.TurbineUtil;


public abstract class BaseAction {

    @Resource
    private URIBrokerService uriBrokerService;

    @Resource
    private HttpServletRequest request;


    /**
     * 转到用户校验出错页
     * @param message
     */
    protected void redirectToUserError(String message) {
        TurbineRunData rundata = TurbineUtil.getTurbineRunData(request);
        rundata.setRedirectLocation(getTurbineURIBroker("commonModule").setTarget("userError.vm").addQueryData("v_param", "message").addQueryData("message", message).render());
    }

    /**
     * 转到用户校验出错页
     * @param message
     */
    protected void redirectToUserError() {
        redirectToUserError("很抱歉，您访问的页面不存在!");
    }

    /**
     * 转到系统错误页面
     * @param message
     */
    protected void redirectToSystemError(String message) {
        TurbineRunData rundata = TurbineUtil.getTurbineRunData(request);
        rundata.setRedirectLocation(getTurbineURIBroker("commonModule").setTarget("systemError.vm").render());
    }

    /**
     * 转到提示信息页面
     * @param message
     */
    protected void redirectToTipInfo(String message) {
        TurbineRunData rundata = TurbineUtil.getTurbineRunData(request);
        rundata.setRedirectLocation(getTurbineURIBroker("commonModule").setTarget("info.vm").addQueryData("v_param", "message").addQueryData("message", message).render());
    }

    /**
     * 转到成功信息页面
     * @param message
     */
    protected void redirectToSuccess(String message) {
        TurbineRunData rundata = TurbineUtil.getTurbineRunData(request);
        rundata.setRedirectLocation(getTurbineURIBroker("commonModule").setTarget("success").addQueryData("v_param", "message").addQueryData("message", message).render());
    }

    //返回模块地址
    protected TurbineURIBroker getTurbineURIBroker(String turbineUriName) {
        return (TurbineURIBroker)uriBrokerService.getURIBroker(turbineUriName);
    }

    @SuppressWarnings("unchecked")
    protected <T extends URIBroker> T getURIBroker(String uriName) {
        return (T)uriBrokerService.getURIBroker(uriName);
    }
}
