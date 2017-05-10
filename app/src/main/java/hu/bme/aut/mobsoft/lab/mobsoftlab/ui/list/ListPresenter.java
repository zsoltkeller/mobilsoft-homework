package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.list;

import android.util.Log;

import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.CostRecordInteractor;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.GetCostRecordsEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.RemoveCostRecordEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class ListPresenter extends Presenter<ListScreen> {

    @Inject
    CostRecordInteractor costRecordInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(ListScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getCostRecords() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                costRecordInteractor.getCostRecords(new Date());
            }
        });
    }

    public void ongetCostRecordsEvent(GetCostRecordsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading costrecords", event.getThrowable());
        } else {
            if (screen != null) {
                screen.listCostRecords(event.getCostRecords());
            }
        }
    }

    public void removeCostRecord(final CostRecord costRecord) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                costRecordInteractor.removeCostRecord(costRecord);
            }
        });
    }

    public void oneRemoveCostRecordEvent(RemoveCostRecordEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading costrecords", event.getThrowable());
        } else {
            if (screen != null) {
                screen.costRecordDeleted(event.getCostRecord());
            }
        }
    }
}
