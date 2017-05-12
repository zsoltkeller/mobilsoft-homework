package hu.bme.aut.mobsoft.lab.mobsoftlab;

/**
 * Created by Mobsoft on 2017. 05. 12..
 */

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.InteractorModule;
import hu.bme.aut.mobsoft.lab.mobsoftlab.mock.MockNetworkModule;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.TestRepositoryModule;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends MobSoftApplicationComponent {
}
