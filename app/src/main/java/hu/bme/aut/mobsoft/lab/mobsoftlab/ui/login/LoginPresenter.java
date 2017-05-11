package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.login;

import android.util.Log;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.user.UserInteractor;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.user.events.LoginEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    UserInteractor userInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void login(final String userName, final String password) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                userInteractor.login(userName, password);
            }
        });
    }

    public void onloginEvent(LoginEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading costrecords", event.getThrowable());
        } else {
            if (screen != null) {
                if(event.getUser() != null){
                    screen.showSuccessfulLogin("Success");
                }
                else{

                }
                screen.showErrorLogin("Error");
            }
        }
    }
}
