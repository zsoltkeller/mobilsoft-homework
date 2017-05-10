package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import de.greenrobot.event.EventBus;
import hu.bme.aut.mobsoft.lab.mobsoftlab.MobSoftApplication;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.AddCostRecordEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.GetCostRecordByIdEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.GetCostRecordsEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events.RemoveCostRecordEvent;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.Repository;

/**
 * Created by mobsoft on 2017. 04. 28..
 */

public class CostRecordInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    public CostRecordInteractor() {
        MobSoftApplication.injector.inject(this);
    }

    public void getCostRecords(Date date) {
        GetCostRecordsEvent event = new GetCostRecordsEvent();
        try {
            List<CostRecord> costRecords = repository.getCostRecords(date);
            event.setCostRecords(costRecords);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getCostRecordById(Long id) {
        GetCostRecordByIdEvent event = new GetCostRecordByIdEvent();
        try {
            CostRecord costRecord = repository.getCostRecordsById(id);
            event.setCostRecord(costRecord);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void addCostRecord(CostRecord costRecord) {
        AddCostRecordEvent event = new AddCostRecordEvent();
        event.setCostRecord(costRecord);
        try {
            repository.addCostRecord(costRecord);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updateCostRecords(List<CostRecord> costRecords) {
        try {
            repository.updateCostRecord(costRecords);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeCostRecord(CostRecord costRecord) {

        RemoveCostRecordEvent event = new RemoveCostRecordEvent();
        event.setCostRecord(costRecord);
        try {
            repository.removeCostRecord(costRecord);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

}
