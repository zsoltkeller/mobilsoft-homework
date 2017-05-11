package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.user;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.GetCostRecordsEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.user.events.LoginEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.User;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.Repository;

/**
 * Created by zsolt on 2017. 05. 12..
 */

public class UserInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public UserInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void login(String userName, String password) {
        LoginEvent event = new LoginEvent();
        try {
            User user = repository.login(userName, password);
            event.setUser(user);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }
}
