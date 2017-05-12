package hu.bme.aut.mobsoft.lab.mobsoftlab.mock.interceptors;

import android.net.Uri;

import java.util.Date;

import hu.bme.aut.mobsoft.lab.mobsoftlab.network.NetworkConfig;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.MemoryRepository;
import hu.bme.aut.mobsoft.lab.mobsoftlab.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.aut.mobsoft.lab.mobsoftlab.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by Mobsoft on 2017. 05. 12..
 */

public class CostRecordMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Costrecord") && request.method().equals("POST")) {
            responseString = "";
            responseCode = 200;
        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "Costrecord") && request.method().equals("Get")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            //TODO: date paraméter
            responseString = GsonHelper.getGson().toJson(memoryRepository.getCostRecords(new Date()));
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
