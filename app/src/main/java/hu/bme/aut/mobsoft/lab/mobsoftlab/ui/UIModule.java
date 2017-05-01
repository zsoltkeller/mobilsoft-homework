package hu.bme.aut.mobsoft.lab.mobsoftlab.ui;

import android.content.Context;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.add.AddPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.details.DetailsPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.list.ListPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.login.LoginPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.statistics.StatisticsPresenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public ListPresenter provideListPresenter() {
        return new ListPresenter();
    }

    @Provides
    @Singleton
    public DetailsPresenter provideDetailsPresenter() {
        return new DetailsPresenter();
    }

    @Provides
    @Singleton
    public AddPresenter provideAddPresenter() {
        return new AddPresenter();
    }

    @Provides
    @Singleton
    public StatisticsPresenter provideStatisticsPresenter() {
        return new StatisticsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }
}
