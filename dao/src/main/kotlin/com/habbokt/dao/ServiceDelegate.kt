package com.habbokt.dao

import javax.inject.Qualifier

/**
 * @author Jordan Abraham
 */
@Qualifier
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class ServiceDelegate