package com.lwl.web.common.pipeline;

import static com.alibaba.citrus.turbine.util.TurbineUtil.getTurbineRunData;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.citrus.service.pipeline.PipelineContext;
import com.alibaba.citrus.service.pipeline.support.AbstractValve;
import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.TurbineRunDataInternal;

/**
 * 将包含v_param参数的请求参数直接放入context中
 * @author Administrator
 *
 *
 * 烦点：通过request获取完整的访问url
 */
public class PutToContextValve extends AbstractValve {

    @Resource
    private HttpServletRequest request;

    @Resource
    private HttpSession session;

    /**
     * 将公用元素（session,referer）放入context中，或者将制定元素，元素名为v_param的值
     */
    public void invoke(PipelineContext pipelineContext) throws Exception {

        TurbineRunDataInternal rundata = (TurbineRunDataInternal) getTurbineRunData(request);
        Context context = rundata.getContext();

        //将v_param属性对于值属性，放入context中
        String[] keys = rundata.getParameters().getStrings("v_param");

        if (keys != null) {
            for (int i = 0; i < keys.length; i++) {
                String key = keys[i];
                String value = rundata.getParameters().getString(key);

                context.put(key, value);
            }
        }

        //如果登录，将登录id、userName、areaId放入
        Long userId = (Long)session.getAttribute("userId");
        String userName = (String)session.getAttribute("userName");
        if (userId != null && userName != null) {
            context.put("userId", userId);
            context.put("userName", userName);
        }


        pipelineContext.invokeNext();
    }

}