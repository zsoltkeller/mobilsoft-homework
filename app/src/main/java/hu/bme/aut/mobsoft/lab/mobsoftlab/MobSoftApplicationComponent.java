package hu.bme.aut.mobsoft.lab.mobsoftlab;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.UIModule;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.main.MainActivity;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Singleton
@Component(modules = {UIModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);

}
