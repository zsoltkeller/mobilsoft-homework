package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.statistics;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.CostRecordInteractor;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.GetCostRecordsEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.Presenter;

import static hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class StatisticsPresenter extends Presenter<StatisticsScreen> {

    @Inject
    CostRecordInteractor costRecordInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(StatisticsScreen screen) {
        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getCostRecords() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                costRecordInteractor.getCostRecords();
            }
        });
    }

    public void onEventMainThread(GetCostRecordsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                for(CostRecord t : event.getCostRecords()){
                    screen.showMessage(t.getName());
                }
            }
        }
    }
}
