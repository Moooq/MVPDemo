package com.moq.mvpdemo.biz;

/**
 * Created by moq.
 */

public interface IUserBiz {
	void login(String username, String password, OnLoginListener onLoginListener);
}
