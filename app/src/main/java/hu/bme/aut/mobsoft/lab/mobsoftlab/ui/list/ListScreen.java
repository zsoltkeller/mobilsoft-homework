package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.list;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface ListScreen {
    void showMessage(String text);
    void listCostRecords(List<CostRecord> costRecords);
    void costRecordDeleted(CostRecord costRecord);
}
