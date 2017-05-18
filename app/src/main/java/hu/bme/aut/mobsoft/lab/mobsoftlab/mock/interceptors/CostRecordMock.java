package hu.bme.aut.mobsoft.lab.mobsoftlab.mock.interceptors;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import hu.bme.aut.mobsoft.lab.mobsoftlab.network.NetworkConfig;
import hu.bme.aut.mobsoft.lab.mobsoftlab.repository.MemoryRepository;
import hu.bme.aut.mobsoft.lab.mobsoftlab.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.aut.mobsoft.lab.mobsoftlab.mock.interceptors.MockHelper.bodyToString;
import static hu.bme.aut.mobsoft.lab.mobsoftlab.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by Mobsoft on 2017. 05. 12..
 */

public class CostRecordMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString = "";
        int responseCode;
        Headers headers = request.headers();

        MemoryRepository memoryRepository = new MemoryRepository();
        memoryRepository.open(null);
        String path = uri.getPath();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "costrecord") && request.method().equals("POST")) {
            CostRecord cr = GsonHelper.getGson().fromJson(bodyToString(request), CostRecord.class);
            memoryRepository.addCostRecord(cr);
            responseCode = 200;

        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "costrecord") && request.method().equals("Get")) {
            responseString = GsonHelper.getGson().toJson(memoryRepository.getCostRecords(new Date()));
            responseCode = 200;

        }else if (path.matches("^" + (NetworkConfig.ENDPOINT_PREFIX + "matches").replace("/", "\\/") + "([0-9]+)")  && request.method().equals("Get")) {
            memoryRepository.open(null);
            Long id = null;
            responseString = GsonHelper.getGson().toJson(memoryRepository.getCostRecordsById(id));
            responseCode = 200;

        }else if (path.matches("^" + (NetworkConfig.ENDPOINT_PREFIX + "matches").replace("/", "\\/") + "([0-9]+)")  && request.method().equals("PUT")) {
            CostRecord cr = GsonHelper.getGson().fromJson(bodyToString(request), CostRecord.class);
            List<CostRecord> update = new ArrayList<CostRecord>();
            update.add(cr);
            memoryRepository.updateCostRecord(update);

            responseString = GsonHelper.getGson().toJson(memoryRepository.getCostRecords(new Date()));
            responseCode = 200;

        }else if (path.matches("^" + (NetworkConfig.ENDPOINT_PREFIX + "matches").replace("/", "\\/") + "([0-9]+)")  && request.method().equals("DELETE")) {
            CostRecord cr = GsonHelper.getGson().fromJson(bodyToString(request), CostRecord.class);
            memoryRepository.removeCostRecord(cr);
            responseCode = 200;

        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
