package hu.bme.aut.mobsoft.lab.mobsoftlab;

/**
 * Created by Mobsoft on 2017. 05. 12..
 */

import android.content.Context;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.greenrobot.event.EventBus;

import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.UIModule;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.add.AddPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.details.DetailsPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.list.ListPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.login.LoginPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.statistics.StatisticsPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.utils.UiExecutor;

@Module
public class TestModule {

    private final UIModule UIModule;

    public TestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }


    @Provides
    public MainPresenter provideMainPresenter() {
        return UIModule.provideMainPresenter();
    }

    @Provides
    public AddPresenter provideAddPresenter() {
        return UIModule.provideAddPresenter();
    }
    @Provides
    public DetailsPresenter provideDetailsPresenter() {
        return UIModule.provideDetailsPresenter();
    }
    @Provides
    public ListPresenter provideListPresenter() {
        return UIModule.provideListPresenter();
    }
    @Provides
    public LoginPresenter provideLoginPresenter() {
        return UIModule.provideLoginPresenter();
    }
    @Provides
    public StatisticsPresenter provideStatisticsPresenter() {
        return UIModule.provideStatisticsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideNetworkExecutor() {
        return new UiExecutor();
    }


}