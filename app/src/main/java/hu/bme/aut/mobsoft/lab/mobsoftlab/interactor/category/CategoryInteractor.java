package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.category;

import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.category.events.GetCategoriesEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.Repository;

/**
 * Created by zsolt on 2017. 05. 01..
 */

public class CategoryInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public CategoryInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getCategories() {
        GetCategoriesEvent event = new GetCategoriesEvent();
        try {
            List<Category> categories = repository.getCategories();
            event.setCategories(categories);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void addCategory(Category category) {

        repository.addCategory(category);
    }

}
