package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.R;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class DetailsActivity extends AppCompatActivity implements DetailsScreen{

    @Inject
    DetailsPresenter deatilsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        deatilsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        deatilsPresenter.detachScreen();
    }
    @Override
    public void showMessage(String text){

    }

    @Override
    public void showCostRecordDetails(CostRecord costRecord){

    }
}