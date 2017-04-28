package hu.bme.aut.mobsoft.lab.mobsoftlab.repository;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MemoryRepository implements Repository {
    private static final long MINUTE = 60 * 1000;

    public static List<CostRecord> costRecords;

    @Override
    public void open(Context context) {
        CostRecord cost1 = new CostRecord(1L,"cost one", "categry1", 2400, new Date(), "comment");
        CostRecord cost2 = new CostRecord(2L,"cost two", "categry2", 4400, new Date(), "comment2");

        costRecords = new ArrayList<>();
        costRecords.add(cost1);
        costRecords.add(cost2);
    }

    @Override
    public void close() {

    }

    @Override
    public List<CostRecord> getCostRecords() {
        return costRecords;
    }

    @Override
    public void addCostRecord(CostRecord costRecord) {
        costRecords.add(costRecord);
    }

    @Override
    public void updateCostRecord(CostRecord costRecord) {
        //TODO: implement
    }

    @Override
    public void removeCostRecord(CostRecord costRecord) {
        costRecords.remove(costRecord);
    }

    @Override
    public boolean isInDB(CostRecord costRecord) {
        return costRecords.contains(costRecord);
    }
}
