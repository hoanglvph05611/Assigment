package com.example.lvhco.assigment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText edUserName;
    private EditText edPassword;
    private CheckBox chkRememberPass;
    private Button btnLogin;
    private Button btnCancel;
    String strUser, strPass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUserName = (EditText) findViewById(R.id.edUserName);
        edPassword = (EditText) findViewById(R.id.edPassword);
        chkRememberPass = (CheckBox) findViewById(R.id.chkRememberPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strUser = edUserName.getText().toString();
                strPass = edPassword.getText().toString();
                if (strUser.isEmpty()||strPass.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Tên đăng nhập và mật khẩu không được bỏ trống",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(Login.this,ManHinhChinh.class);
                    startActivity(intent);
                }
            }
        });
    }
}
