package com.huie.app;





import com.huie.app.utils.RequestManager;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	public static MyApplication mInstance = null;
	private Context context = null;
	@Override
	public void onCreate() {
		super.onCreate();
		
		mInstance = this;
		context = this;
		
		RequestManager.init(this);
		
		
	}
	
	public static MyApplication getInstance() {
		if (null == mInstance) {
			mInstance = new MyApplication();
		}
		return mInstance;
	}
}	
