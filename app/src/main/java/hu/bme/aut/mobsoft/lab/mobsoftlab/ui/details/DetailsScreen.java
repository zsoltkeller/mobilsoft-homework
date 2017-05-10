package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.details;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface DetailsScreen {
    void showMessage(String text);
    void showCostRecordDetails(CostRecord costRecord);
}
