package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.R;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class ListActivity extends AppCompatActivity implements ListScreen{

    @Inject
    ListPresenter listPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        listPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        listPresenter.detachScreen();
    }
}
