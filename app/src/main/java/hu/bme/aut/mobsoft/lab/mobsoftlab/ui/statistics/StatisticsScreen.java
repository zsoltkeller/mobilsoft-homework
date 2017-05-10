package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.statistics;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface StatisticsScreen {
    void showMessage(String text);
    void costRecordListReady(List<CostRecord> costRecordList);
}
