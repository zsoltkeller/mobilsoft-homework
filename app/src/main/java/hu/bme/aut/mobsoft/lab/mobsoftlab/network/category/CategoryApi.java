package hu.bme.aut.mobsoft.lab.mobsoftlab.network.category;

import hu.bme.aut.mobsoft.lab.mobsoftlab.network.model.Category;


import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CategoryApi {
  
  /**
   * Gets all category from the database
   * 
   * @return Call<List<Category>>
   */
  
  @GET("category")
  Call<List<Category>> getCategories();
    

  
  /**
   * Add a new category to the database
   * 
   * @param body Category object that needs to be added to the database
   * @return Call<Void>
   */
  
  @POST("category")
  Call<Void> addCategory(
    @Body Category body
  );

  
}
