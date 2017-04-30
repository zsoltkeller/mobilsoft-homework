package hu.bme.aut.mobsoft.lab.mobsoftlab;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.CostRecordInteractor;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.RepositoryModule;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.UIModule;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.add.AddActivity;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.details.DetailsActivity;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.list.ListActivity;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.login.LoginActivity;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.main.MainActivity;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.statistics.StatisticsActivity;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class})
public interface MobSoftApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(ListActivity listActivity);
    void inject(DetailsActivity detailsActivity);
    void inject(AddActivity addActivity);
    void inject(StatisticsActivity statisticsActivity);

    void inject(MobSoftApplication app);
    void inject(CostRecordInteractor favouritesInteractor);
}
