package com.lwl.web.common.pipeline;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.support.AbstractValve;

/**
 * 对action操作进行csrf校验
 *
 * @author wb-liweilin
 *
 */
public class AutoLoginValve extends AbstractValve {

    @Resource
    private HttpSession session;

    public void invoke(PipelineContext pipelineContext) throws Exception {
        if ((Integer)session.getAttribute("autoLogin") != null && (Integer)session.getAttribute("autoLogin") == 1 && session.getAttribute("userId") == null) {
            session.setAttribute("userId", session.getAttribute("autoUserId"));
            session.setAttribute("userName", session.getAttribute("autoUserName"));
            session.setAttribute("userType", session.getAttribute("autoUserType"));
        }

        pipelineContext.invokeNext();

    }

}
