package hu.bme.aut.mobsoft.lab.mobsoftlab;

/**
 * Created by Mobsoft on 2017. 05. 12..
 */

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

public class TestHelper {

    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        MobSoftApplication application = (MobSoftApplication) RuntimeEnvironment.application;
        MobSoftApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.setInjector(injector);
    }
}

