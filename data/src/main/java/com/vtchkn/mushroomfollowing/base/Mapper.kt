package com.vtchkn.mushroomfollowing.base

/**
 * Base class for model mappers. It provides helper methods that facilitate
 * retrieving of models from outer layers
 *
 * @param <Source> the view model input type
 * @param <Destination> the domain model output type
 */
abstract class Mapper<out Destination, in Source> {

    abstract fun executeMapping(type: Source?): Destination?

}