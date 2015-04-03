package com.huie.app.activity;

import com.android.volley.Request;
import com.huie.app.utils.RequestManager;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public abstract class BaseActivity extends FragmentActivity implements OnClickListener {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		loadUI();
		initViews();
		initData();
		// 强制指定为竖屏
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	}
	
	/**
	 * 加载本activity对应的布局
	 */
	public abstract void loadUI();

	/**
	 * 初始化组件.在initData()方法前执行
	 */
	public abstract void initViews();

	/**
	 * 初始化数据。在initViews()方法后执行
	 */
	public abstract void initData();
	
	
	/**
	 * 点击事件的处理
	 */
	public void onClick(View v) {
	}
	
	/**
	 * 设置v是否可见
	 * 
	 * @param targetView
	 *            ：目标组件
	 * @param isVisible
	 *            ：是否可见。true就是visible，false就是gone
	 */
	public void setVisible(View targetView, boolean isVisible) {
		if (targetView != null) {
			if (isVisible) {
				targetView.setVisibility(View.VISIBLE);
			} else {
				targetView.setVisibility(View.GONE);
			}
		}
	}

	/**
	 * 得到TextView中的文字
	 * 
	 * @return
	 */
	public String getTextViewValue(TextView tv) {
		if (tv == null)
			return null;
		return tv.getText().toString();
	}
	
	protected void executeRequest(Request request) {
		RequestManager.addRequest(request, this);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		RequestManager.cancelAll(this);
	}
	
}
