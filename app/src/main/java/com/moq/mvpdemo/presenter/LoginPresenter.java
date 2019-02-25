package com.moq.mvpdemo.presenter;

import android.os.Handler;
import android.util.Log;

import com.moq.mvpdemo.bean.User;
import com.moq.mvpdemo.biz.IUserBiz;
import com.moq.mvpdemo.biz.OnLoginListener;
import com.moq.mvpdemo.biz.UserBiz;
import com.moq.mvpdemo.view.ILoginView;

/**
 * Created by moq.
 */

public class LoginPresenter {
	private IUserBiz userBiz;
	private ILoginView loginView;

	public LoginPresenter(ILoginView loginView) {
		this.userBiz = new UserBiz();
		this.loginView = loginView;
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
		};
	};

	public void login(){
		userBiz.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
			@Override
			public void loginSuccess(final User user) {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						Log.d("LoginPresenter", "login successful");
						loginView.hideLoading();
						loginView.toMainActivity(user);
					}
				});
			}

			@Override
			public void loginFailed() {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						Log.d("LoginPresenter", "login failed");
						loginView.hideLoading();
						loginView.showFailedError();
					}
				});
			}
		});
	}

	public void clear(){
		loginView.clearUserName();
		loginView.clearPassword();
	}
}
