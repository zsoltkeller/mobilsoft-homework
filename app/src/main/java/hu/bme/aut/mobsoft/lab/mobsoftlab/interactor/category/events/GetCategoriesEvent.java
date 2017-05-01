package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.category.events;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;

/**
 * Created by zsolt on 2017. 05. 01..
 */

public class GetCategoriesEvent {

    private int code;
    private List<Category> categories;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetCategoriesEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
