package com.arturkida.eurorates.idlingresource

class EspressoIdlingResource {

    companion object {
        val RESOURCE = "GLOBAL"

        val countingIdlingResource = SimpleCountingIdlingResource(RESOURCE)

        fun increment() = countingIdlingResource.increment()

        fun decrement() = countingIdlingResource.decrement()
    }
}