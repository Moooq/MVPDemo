package com.moq.mvpdemo.biz;

import com.moq.mvpdemo.bean.User;

/**
 * Created by moq.
 */

public class UserBiz implements IUserBiz{
	@Override
	public void login(final String username, final String password, final OnLoginListener onLoginListener) {
		new Thread(){
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if ("username".equals(username)&&"password".equals(password)){
					User user = new User();
					user.setPassword(password);
					user.setUsername(username);
					onLoginListener.loginSuccess(user);
				}else{
					onLoginListener.loginFailed();
				}
			}
		}.start();
	}
}
