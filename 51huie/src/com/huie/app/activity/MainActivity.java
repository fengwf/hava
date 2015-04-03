package com.huie.app.activity;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.huie.app.R;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;

public class MainActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		query();
	}

	

	@Override
	public void loadUI() {
		// TODO Auto-generated method stub
		setContentView(R.layout.activity_main);
	}

	@Override
	public void initViews() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	/**
	 * 点击事件的处理
	 */
	public void onClick(View v) {

	}
	
	private void query() {
		String url = "http://192.168.1.109:8082/api/products";
		//http://192.168.1.109:8082/api/products
		executeRequest(new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String responseStr) {

				List<Map<String, Object>> result = JSON.parseObject(
						responseStr,
						new TypeReference<List<Map<String, Object>>>() {
						});
				System.out.println(result);
				
			}

		}, new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError arg0) {

			}
		}));
	}

}
