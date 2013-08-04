package com.lwl.web.common.tool;

import com.alibaba.citrus.turbine.util.ControlTool;

public class ControlCacheTool extends ControlTool {/*

	private final int DEFAULT_EXPIRE_TIME = 300;

	private String phth = "";

	private int expireTime = DEFAULT_EXPIRE_TIME;

	*//**
 * 通过设置参数刷新缓存
 *//*
	private boolean paramRefreshCache = false;

	@Resource
	private RedisManager redisManager;

	@Override
	public ControlTool setTemplate(String template) {
		phth = template;
		return super.setTemplate(template);
	}

	@Override
	public ControlTool setParameter(String name, Object value) {
		if (name != null) {
			phth += phth.indexOf('?') == -1 ? "?" : "&";
			phth += name + "=" + value;
		}
		return super.setParameter(name, value);
	}

	public ControlTool setParamRefreshCache(boolean paramRefreshCache) { // 秒为单位
		this.paramRefreshCache = paramRefreshCache;
		return this;
	}

	public ControlTool setExpireTime(int expireTime) { // 秒为单位
		this.expireTime = expireTime;
		return this;
	}

	@Override
	public String render() {
		try {
			long start = System.nanoTime();
			String re = (String)redisManager.get(phth);
			if (re == null || paramRefreshCache) {
				re = super.render();

				redisManager.set(phth, re, expireTime);
			}
			long end = System.nanoTime();
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&");
			System.out.println(end-start);
			System.out.println("&&&&&&&&&&&&&&&&&&&&&&");

			return re;
		} finally {
			expireTime = DEFAULT_EXPIRE_TIME;
			getControlParameters().clear();
		}
	}
*/}
