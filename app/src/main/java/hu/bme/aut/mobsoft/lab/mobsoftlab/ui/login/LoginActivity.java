package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.R;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class LoginActivity  extends AppCompatActivity implements LoginScreen, View.OnClickListener{

    @Inject
    LoginPresenter loginPresenter;


    private EditText userName;
    private EditText password;
    private Button loginBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobSoftApplication.injector.inject(this);

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        loginPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        loginPresenter.detachScreen();
        super.onStop();
    }

    @Override
    public void showSuccessfulLogin(String text){

    }

    @Override
    public void showErrorLogin(String text){

    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        loginPresenter.login(userName.getText().toString(), password.getText().toString());
    }

}
