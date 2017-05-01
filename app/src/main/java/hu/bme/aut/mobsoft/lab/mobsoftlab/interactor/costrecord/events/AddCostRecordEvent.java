package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by zsolt on 2017. 05. 01..
 */

public class AddCostRecordEvent {
    private int code;
    private CostRecord costRecord;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public AddCostRecordEvent() {
    }

    public AddCostRecordEvent(int code, CostRecord costRecord, Throwable throwable) {
        this.code = code;
        this.costRecord = costRecord;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CostRecord getCostRecord() {
        return costRecord;
    }

    public void setCostRecord(CostRecord costRecord) {
        this.costRecord = costRecord;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
