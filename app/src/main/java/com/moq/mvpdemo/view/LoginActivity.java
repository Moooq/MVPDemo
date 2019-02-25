package com.moq.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.moq.mvpdemo.R;
import com.moq.mvpdemo.bean.User;
import com.moq.mvpdemo.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILoginView, View.OnClickListener {

	private EditText et_username;
	private EditText et_password;
	private Button btn_login;
	private Button btn_clear;

	private LoginPresenter mLoginPresenter = new LoginPresenter(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		et_username = (EditText) findViewById(R.id.et_username);
		et_password = (EditText) findViewById(R.id.et_password);
		btn_login = (Button) findViewById(R.id.btn_login);
		btn_clear = (Button) findViewById(R.id.btn_clear);

		btn_clear.setOnClickListener(this);
		btn_login.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.btn_login:
				mLoginPresenter.login();
				break;
			case R.id.btn_clear:
				mLoginPresenter.clear();
				break;
		}
	}

	@Override
	public String getUserName() {
		return et_username.getText().toString();
	}

	@Override
	public String getPassword() {
		return et_password.getText().toString();
	}

	@Override
	public void clearUserName() {
		et_username.setText("");
	}

	@Override
	public void clearPassword() {
		et_password.setText("");
	}

	@Override
	public void toMainActivity(User user) {
		Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT);
	}

	@Override
	public void showFailedError() {
		Toast.makeText(this,"Login Failed",Toast.LENGTH_SHORT);
	}

	@Override
	public void showLoading() {

	}

	@Override
	public void hideLoading() {

	}


}
