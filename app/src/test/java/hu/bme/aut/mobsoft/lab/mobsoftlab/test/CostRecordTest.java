package hu.bme.aut.mobsoft.lab.mobsoftlab.test;

/**
 * Created by Mobsoft on 2017. 05. 12..
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.annotation.Config;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.BuildConfig;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.MemoryRepository;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.main.MainScreen;
import hu.bme.aut.mobsoft.lab.mobsoftlab.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.mobsoft.lab.mobsoftlab.TestHelper.setTestInjector;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CostRecordTest {

    private MainPresenter mainPresenter;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainPresenter = new MainPresenter();
    }

    @Test
    public void addCategory() {
        MainScreen mainScreen = mock(MainScreen.class);
        mainPresenter.attachScreen(mainScreen);
        //mainPresenter.getFavourites();

        Category cat = new Category();
        cat.setName("Test");
        MemoryRepository repo = new MemoryRepository();

        repo.addCategory(cat);

        assert repo.isInDB(cat);
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
