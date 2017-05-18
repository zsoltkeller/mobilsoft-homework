package hu.bme.aut.mobsoft.lab.mobsoftlab.mock;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.lab.mobsoftlab.network.NetworkModule;
import hu.bme.aut.mobsoft.lab.mobsoftlab.network.category.CategoryApi;
import hu.bme.aut.mobsoft.lab.mobsoftlab.network.costrecord.CostrecordApi;
import hu.bme.aut.mobsoft.lab.mobsoftlab.network.user.UserApi;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

@Module
public class MockNetworkModule {
    private NetworkModule networkModule = new NetworkModule();

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return networkModule.provideOkHttpClientBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {

        builder.interceptors().add(3, new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                return MockHttpServer.call(request);
            }
        });

        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return networkModule.provideRetrofit(client);
    }

    @Provides
    @Singleton
    public CostrecordApi provideCostrecordApi(Retrofit retrofit) {
        return networkModule.provideCostrecordApi(retrofit);
    }

    @Provides
    @Singleton
    public CategoryApi provideCategoryApi(Retrofit retrofit) {
        return networkModule.provideCategoryApi(retrofit);
    }

    @Provides
    @Singleton
    public UserApi provideUserApi(Retrofit retrofit) {
        return networkModule.provideUserApi(retrofit);
    }
}
