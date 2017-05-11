package hu.bme.aut.mobsoft.lab.mobsoftlab.interactor.user.events;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.model.User;

/**
 * Created by zsolt on 2017. 05. 12..
 */

public class LoginEvent {
    private int code;
    private User user;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public LoginEvent() {
    }

    public LoginEvent(int code, User user, Throwable throwable) {
        this.code = code;
        this.user = user;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
