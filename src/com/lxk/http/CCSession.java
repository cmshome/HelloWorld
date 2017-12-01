package com.lxk.http;

import com.google.common.collect.Maps;

import java.net.InetAddress;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CCSession {

	public final static String TOCKEN = "Tocken";
	
	private static Map<String, CCSession> sessions;
	/** 清理任务的间隔时间（分钟） */
	private static final int clearTime = 1;
	/** 超时时间（分钟）*/
	private static int timeOut;

	private long activeTime;
	
	private InetAddress remoteAddress;
	
	private Map<String, Object> properties;
	
	private String tocken;
	
	public CCSession() {
		this.activeTime = System.currentTimeMillis();
		this.properties = Maps.newHashMap();
	}
	
	public Object getProperty(String key) {
		return this.properties.get(key);
	}
	
	public void setProperty(String key, Object value) {
		this.properties.put(key, value);
	}
	
	public InetAddress getRemoteAddress() {
		return this.remoteAddress;
	}
	
	/**
	 * 启动Session的任务，线程不安全
	 * @param timeOut
	 * 			超时时间，分钟
	 */
	public static void startService(int timeOut) {
		sessions = Maps.newConcurrentMap();
		CCSession.timeOut = timeOut;
		// 启动一个线程，定期处理数据
		ScheduledExecutorService scheduledExecutorService = 
				Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			
			@Override
			public void run() {
				long time = System.currentTimeMillis() - CCSession.timeOut * 60000;
				for (Entry<String, CCSession> entry : sessions.entrySet()) {
					if (entry.getValue().activeTime < time) {
						sessions.remove(entry.getKey());
					}
				}
			}
		}, clearTime, clearTime, TimeUnit.MINUTES);
	}
	
	/**
	 * 根据票据获取Session对象
	 * @param tocken
	 * @return
	 */
	public static CCSession getSession(String tocken) {
		if (tocken == null) {
			return null;
		}
		return sessions.get(tocken);
	}
	
	/**
	 * 创建一个Session对象，票据是重新生成的
	 * @return
	 */
	public static CCSession createSession(InetAddress remoteAddress, String tocken) {
		CCSession session = new CCSession();
		session.tocken = tocken;
		session.remoteAddress = remoteAddress;
		sessions.put(tocken, session);
		return session;
	}
	
	public static void removeSession(String tocken) {
		sessions.remove(tocken);
	}

	public String getTocken() {
		return tocken;
	}

	public void updateTime() {
		this.activeTime = System.currentTimeMillis();
	}
}
