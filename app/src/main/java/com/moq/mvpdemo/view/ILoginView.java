package com.moq.mvpdemo.view;

import com.moq.mvpdemo.bean.User;

/**
 * Created by moqian.
 */

public interface ILoginView {
	String getUserName();
	String getPassword();
	void clearUserName();
	void clearPassword();
	void toMainActivity(User user);
	void showFailedError();
	void showLoading();
	void hideLoading();
}
