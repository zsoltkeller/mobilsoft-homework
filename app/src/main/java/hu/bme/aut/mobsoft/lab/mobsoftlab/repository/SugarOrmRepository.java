package hu.bme.aut.mobsoft.lab.mobsoftlab.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by mobsoft on 2017. 04. 28..
 */


public class SugarOrmRepository implements Repository {


    @Override
    public void open(Context context) {
        SugarContext.init(context);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<CostRecord> getCostRecords() {
        return SugarRecord.listAll(CostRecord.class);
    }

    @Override
    public void addCostRecord(CostRecord costRecords) {
        SugarRecord.saveInTx(costRecords);
    }

    @Override
    public void updateCostRecord(CostRecord costRecord) {
        //TODO: implement
    }

    @Override
    public void removeCostRecord(CostRecord costRecord) {
        SugarRecord.deleteInTx(costRecord);
    }

    @Override
    public boolean isInDB(CostRecord costRecord) {
        return false;
    }
}
