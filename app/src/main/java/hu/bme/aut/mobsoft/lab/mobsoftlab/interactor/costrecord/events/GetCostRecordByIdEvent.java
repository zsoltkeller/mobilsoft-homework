package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.costrecord.events;

import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;

/**
 * Created by zsolt on 2017. 05. 10..
 */

public class GetCostRecordByIdEvent {
    private int code;
    private CostRecord costRecord;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetCostRecordByIdEvent() {
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
