package com.surrus.galwaybus.remote

import com.surrus.galwaybus.model.BusRoute
import com.surrus.galwaybus.model.BusStop
import com.surrus.galwaybus.model.Bus
import com.surrus.galwaybus.model.GetBusListForRouteResponse
import com.surrus.galwaybus.model.GetDeparturesResponse
import com.surrus.galwaybus.model.GetStopsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query



interface GalwayBusService {

    @GET("routes.json")
    fun getBusRoutes(): Deferred<Response<LinkedHashMap<String, BusRoute>>>

    @GET("routes/{route_id}.json")
    fun getStops(@Path("route_id") routeId: String) : Deferred<Response<GetStopsResponse>>

    @GET("stops.json")
    fun getAllStops() : Deferred<Response<List<BusStop>>>

    @GET("stops/nearby.json")
    fun getNearestStops(@Query("latitude") latitude: Double, @Query("longitude") longitude: Double) : Deferred<Response<List<BusStop>>>

    @GET("stops/{stop_ref}.json")
    fun getDepartures(@Path("stop_ref") stopRef: String) : Deferred<Response<GetDeparturesResponse>>

    @GET("schedules.json")
    fun getSchedules() : Deferred<Response<LinkedHashMap<String, List<Map<String, String>>>>>


    @GET("bus/{route_id}.json")
    fun getBusListForRoute(@Path("route_id") routeId: String) : Deferred<Response<GetBusListForRouteResponse>>


}