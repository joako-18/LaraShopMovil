package com.esaudiaz.larashopmovil.core.network

object NetworkConfig {
    private const val EC2_IP = "34.193.30.74"
    private const val PORT = "8000"

    const val BASE_URL = "http://$EC2_IP:$PORT/v1/"

    const val CONNECT_TIMEOUT = 30L
    const val READ_TIMEOUT = 30L
    const val WRITE_TIMEOUT = 30L
}