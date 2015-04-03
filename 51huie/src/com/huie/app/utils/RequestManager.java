package com.huie.app.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * 
 * @author wangfeng
 * 
 */
public class RequestManager {

	private static RequestQueue mRequestQueue; // 请求队列

	public static void init(Context context) {
		mRequestQueue = Volley.newRequestQueue(context);
	}

	public static RequestQueue getRequestQueue() {
		if (mRequestQueue != null) {
			return mRequestQueue;
		} else {
			throw new IllegalStateException("RequestQueue not initialized");
		}
	}

	/**
	 * 添加一个请求，
	 * @param request
	 * @param tag
	 */
	public static void addRequest(Request<?> request, Object tag) {
		if (tag != null) {
			request.setTag(tag);
		}
		mRequestQueue.add(request);
	}

	/**
	 * 取消当前的请求
	 * @param tag
	 */
	public static void cancelAll(Object tag) {
		mRequestQueue.cancelAll(tag);
	}
	/**
	 * 释放请求
	 */
	public static void release() {
		mRequestQueue = null;
	}
}
