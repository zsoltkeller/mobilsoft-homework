package hu.bme.aut.mobsoft.lab.mobsoftlab.repository;

/**
 * Created by Mobsoft on 2017. 05. 12..
 */


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TestRepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }
}