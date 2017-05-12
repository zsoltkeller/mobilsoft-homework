package hu.bme.aut.mobsoft.lab.mobsoftlab.network.costrecord;


import hu.bme.aut.mobsoft.lab.mobsoftlab.model.CostRecord;
import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CostrecordApi {
  
  /**
   * Gets all costrecord from the database
   * 
   * @return Call<List<CostRecord>>
   */
  
  @GET("costrecord")
  Call<List<CostRecord>> getCostRecords();
    

  
  /**
   * Add a new costrecord to the database
   * 
   * @param body CostRecord object that needs to be added to the database
   * @return Call<Void>
   */
  
  @POST("costrecord")
  Call<Void> addCostRecord(
    @Body CostRecord body
  );

  
  /**
   * Find costrecord by ID
   * Returns a single CostRecord
   * @param costRecordId ID of CostRecord to return
   * @return Call<CostRecord>
   */
  
  @GET("costrecord/{costRecordId}")
  Call<CostRecord> getCostRecordById(
    @Path("costRecordId") Long costRecordId
  );

  
  /**
   * Add a new costrecord to the database
   * 
   * @param body CostRecord object that needs to be added to the database
   * @return Call<Void>
   */
  
  @PUT("costrecord/{costRecordId}")
  Call<Void> updateCostRecord(
    @Body CostRecord body
  );

  
  /**
   * Deletes a CostRecord
   * 
   * @param costRecordId CostRecord id to delete
   * @param apiKey 
   * @return Call<Void>
   */
  
  @DELETE("costrecord/{costRecordId}")
  Call<Void> deleteCostRecord(
    @Path("costRecordId") Long costRecordId, @Header("api_key") String apiKey
  );

  
}
