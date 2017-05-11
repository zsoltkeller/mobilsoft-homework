package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.category.CategoryInteractor;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.CostRecordInteractor;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.user.UserInteractor;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

@Module
public class InteractorModule {

    @Provides
    public CostRecordInteractor costRecordInteractor() {
        return new CostRecordInteractor();
    }

    @Provides
    public CategoryInteractor categoryInteractor() {
        return new CategoryInteractor();
    }

    @Provides
    public UserInteractor userInteractor() {
        return new UserInteractor();
    }
}
