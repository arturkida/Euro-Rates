package com.arturkida.eurorates.repository

class Resource<T>(val data: T?,
                  val error: Throwable? = null)