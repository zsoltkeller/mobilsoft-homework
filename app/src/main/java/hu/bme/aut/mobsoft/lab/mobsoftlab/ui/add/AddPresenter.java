package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.add;

import android.util.Log;

import java.util.Date;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.category.CategoryInteractor;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.category.events.AddCategoryEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.category.events.GetCategoriesEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.CostRecordInteractor;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.AddCostRecordEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.GetCostRecordsEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public class AddPresenter extends Presenter<AddScreen> {

    @Inject
    CostRecordInteractor costRecordInteractor;

    @Inject
    CategoryInteractor categoryInteractor;

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(AddScreen screen) {
        super.attachScreen(screen);
        MobSoftApplication.injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void addCostRecord(Long id, String name, Category category, double cost, Date date, String comment){
        final CostRecord cr = new CostRecord(id, name, category,cost,date,comment);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                costRecordInteractor.addCostRecord(cr);
            }
        });
    }

    public void onCostRecordAdded(AddCostRecordEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.costRecordSuccessfullyAdded();
            }
        }
    }

    public void getCategories(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryInteractor.getCategories();
            }
        });
    }

    public void onGetCategoriesEvent(GetCategoriesEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.showCategories(event.getCategories());
            }
        }
    }



    public void addNewCategory(Long id, String name){
        final Category cat = new Category(id, name);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                categoryInteractor.addCategory(cat);
            }
        });
    }

    public void onAddNewCategoryEvent(AddCategoryEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage("error");
            }
            Log.e("Networking", "Error reading favourites", event.getThrowable());
        } else {
            if (screen != null) {
                screen.categoryAdded(event.getCategory());
            }
        }
    }
}
