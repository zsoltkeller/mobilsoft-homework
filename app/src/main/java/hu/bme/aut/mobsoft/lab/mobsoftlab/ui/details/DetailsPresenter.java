package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.details;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.CostRecordInteractor;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.GetCostRecordByIdEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class DetailsPresenter  extends Presenter<DetailsScreen> {
    @Inject
    CostRecordInteractor costRecordInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(DetailsScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getCostRecordDetails(final Long id){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                costRecordInteractor.getCostRecordById(id);
            }
        });
    }

    public void onCostRecordDetailsGetEvent(GetCostRecordByIdEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showCostRecordDetails(event.getCostRecord());
            }
        }
    }

}