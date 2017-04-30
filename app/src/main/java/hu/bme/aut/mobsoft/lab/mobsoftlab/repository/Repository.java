package hu.bme.aut.mobsoft.lab.mobsoftlab.repository;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

import android.content.Context;

import java.util.List;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

public interface Repository {

    void open(Context context);

    void close();

    List<CostRecord> getCostRecords();

    void addCostRecord(CostRecord costRecords);

    void updateCostRecord(CostRecord costRecord);

    void removeCostRecord(CostRecord costRecord);

    boolean isInDB(CostRecord costRecord);
}