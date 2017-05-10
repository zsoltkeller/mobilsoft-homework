package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.add;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface AddScreen {
    void showMessage(String text);

    void costRecordSuccessfullyAdded();
    void showCategories(List<Category> categories);
    void categoryAdded(Category category);
}
