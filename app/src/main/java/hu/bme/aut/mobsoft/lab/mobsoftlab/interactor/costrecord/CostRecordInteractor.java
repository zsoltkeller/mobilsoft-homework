package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class CostRecordInteractor {

    @Inject
    Repository repository;

    public CostRecordInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getCostRecords() {
        //TODO: DATE SZŰRÉS
        List<CostRecord> costRecords = repository.getCostRecords(new Date());
    }

    public void addCostRecord(CostRecord costRecord) {

        repository.addCostRecord(costRecord);
    }

    public void updateCostRecords(List<CostRecord> costRecords) {
        try {
            repository.updateCostRecord(costRecords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeCostRecord(CostRecord costRecord) {

        repository.removeCostRecord(costRecord);
    }

}
