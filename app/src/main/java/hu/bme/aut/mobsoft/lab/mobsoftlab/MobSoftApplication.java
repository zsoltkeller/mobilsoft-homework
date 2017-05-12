package hu.bme.aut.mobsoft.lab.mobsoftlab;

import android.app.Application;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.Repository;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.UIModule;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Inject
    Repository repository;

    public void setInjector(MobSoftApplicationComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
        repository.open(getApplicationContext());
    }

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerMobSoftApplicationComponent.builder().uIModule(new UIModule(this)).build();
        injector.inject(this);
        repository.open(getApplicationContext());
    }
}
