package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.statistics;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.R;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class StatisticsActivity extends AppCompatActivity implements StatisticsScreen {

    @Inject
    StatisticsPresenter statisticsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobSoftApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        statisticsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        statisticsPresenter.detachScreen();
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void costRecordListReady(List<CostRecord> costRecordList){

    }
}
