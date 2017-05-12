package hu.bme.aut.mobsoft.lab.mobsoftlab.mock;

import hu.bme.aut.mobsoft.lab.mobsoftlab.mock.interceptors.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Mobsoft on 2017. 05. 12..
 */

public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }
}
