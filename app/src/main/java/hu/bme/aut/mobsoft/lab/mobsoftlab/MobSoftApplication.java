package hu.bme.aut.mobsoft.lab.mobsoftlab;

import android.app.Application;

import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.UIModule;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class MobSoftApplication extends Application {

    public static MobSoftApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerMobSoftApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
