package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.category;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.Repository;

/**
 * Created by zsolt on 2017. 05. 01..
 */

public class CategoryInteractor {

    @Inject
    Repository repository;

    public CategoryInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getCategories() {
        List<Category> categories = repository.getCategories();
    }

    public void addCategory(Category category) {

        repository.addCategory(category);
    }

}
