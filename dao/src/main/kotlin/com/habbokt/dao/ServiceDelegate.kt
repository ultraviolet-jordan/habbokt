package com.habbokt.dao

import javax.inject.Qualifier

/**
 * @author Jordan Abraham
 */
@Qualifier
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class ServiceDelegate