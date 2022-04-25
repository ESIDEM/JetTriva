package com.xtremepixel.jettriva.data

 data class ResultWrapper<T, Boolean, E: Exception>(
     var data: T? = null,
     var loading: Boolean? = null,
     var e: E? = null
 )