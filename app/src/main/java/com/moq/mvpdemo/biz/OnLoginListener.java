package com.moq.mvpdemo.biz;

import com.moq.mvpdemo.bean.User;

/**
 * Created by moq.
 */

public interface OnLoginListener {
	void loginSuccess(User user);
	void loginFailed();
}
