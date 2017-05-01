package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.add;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.R;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class AddActivity extends AppCompatActivity implements AddScreen{

    @Inject
    AddPresenter addPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        addPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}