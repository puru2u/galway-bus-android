package com.surrus.galwaybus.domain.interactor

import com.surrus.galwaybus.domain.repository.GalwayBusRepository
import com.surrus.galwaybus.model.Location


open class GetNearestBusStopsUseCase constructor(private val galwayRepository: GalwayBusRepository) {

    suspend fun getNearestBusStops(location: Location) = galwayRepository.getNearestBusStops(location)

}