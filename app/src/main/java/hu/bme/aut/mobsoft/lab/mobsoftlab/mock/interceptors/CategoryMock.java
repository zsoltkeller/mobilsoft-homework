package hu.bme.aut.mobsoft.lab.mobsoftlab.mock.interceptors;

import android.net.Uri;

import java.util.Date;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.Category;
import hu.bme.aut.mobsoft.lab.mobsoftlab.network.NetworkConfig;
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

public class CategoryMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString = "";
        int responseCode;
        Headers headers = request.headers();

        MemoryRepository memoryRepository = new MemoryRepository();
        memoryRepository.open(null);

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "category") && request.method().equals("POST")) {
            Category c = GsonHelper.getGson().fromJson(bodyToString(request), Category.class);
            memoryRepository.addCategory(c);
            responseCode = 200;
        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "category") && request.method().equals("Get")) {
            responseString = GsonHelper.getGson().toJson(memoryRepository.getCategories());
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
