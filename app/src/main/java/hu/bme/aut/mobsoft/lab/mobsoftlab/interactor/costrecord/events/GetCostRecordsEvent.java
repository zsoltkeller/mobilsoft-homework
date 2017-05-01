package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by zsolt on 2017. 05. 01..
 */

public class GetCostRecordsEvent {
    private int code;
    private List<CostRecord> costRecords;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetCostRecordsEvent() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<CostRecord> getCostRecords() {
        return costRecords;
    }

    public void setCostRecords(List<CostRecord> costRecords) {
        this.costRecords = costRecords;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
