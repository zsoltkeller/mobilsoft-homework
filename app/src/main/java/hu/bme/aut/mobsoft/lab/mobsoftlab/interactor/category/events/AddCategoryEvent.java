package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.category.events;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by zsolt on 2017. 05. 01..
 */

public class AddCategoryEvent {
    private int code;
    private Category category;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public AddCategoryEvent() {
    }

    public AddCategoryEvent(int code, Category category, Throwable throwable) {
        this.code = code;
        this.category = category;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
