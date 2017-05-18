package hu.bme.aut.mobsoft.lab.mobsoftlab.network.user;


import hu.bme.aut.mobsoft.lab.mobsoftlab.network.model.User;
import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserApi {
  
  /**
   * Logs user into the system
   * 
   * @param user The user info as JSON.
   * @return Call<String>
   */
  
  @POST("user/login")
  Call<String> loginUser(
    @Body User user
  );

  
}
