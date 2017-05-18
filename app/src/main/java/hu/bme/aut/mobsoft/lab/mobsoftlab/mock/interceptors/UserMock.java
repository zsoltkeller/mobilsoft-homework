package hu.bme.aut.mobsoft.lab.mobsoftlab.mock.interceptors;

import android.net.Uri;

import java.util.Date;

import hu.bme.aut.mobsoft.lab.mobsoftlab.network.NetworkConfig;
import hu.bme.aut.mobsoft.lab.mobsoftlab.network.model.User;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.MemoryRepository;
import hu.bme.aut.mobsoft.lab.mobsoftlab.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.aut.mobsoft.lab.mobsoftlab.mock.interceptors.MockHelper.bodyToString;
import static hu.bme.aut.mobsoft.lab.mobsoftlab.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by zsolt on 2017. 05. 14..
 */

public class UserMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString = "";
        int responseCode;
        Headers headers = request.headers();

        MemoryRepository memoryRepository = new MemoryRepository();
        memoryRepository.open(null);

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "user") && request.method().equals("POST")) {
            String requestStr = bodyToString(request);
            User user = GsonHelper.getGson().fromJson(requestStr, User.class);
            responseString = "";
            try{
                memoryRepository.login(user.getName(), user.getPassword());
                responseCode = 200;
            } catch (RuntimeException e) {
                responseCode = 400;
            }
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
