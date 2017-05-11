package hu.bme.aut.mobsoft.lab.mobsoftlab.ui.login;

/**
 * Created by mobsoft on 2017. 03. 31..
 */

public interface LoginScreen {
    void showSuccessfulLogin(String text);
    void showErrorLogin(String text);
    void showMessage(String text);
}
