package com.example.datastructures

import net.corda.core.serialization.CordaSerializable

object TradeFinanceDataStructures {

    @CordaSerializable
    data class Company(
            val name: String,
            val address: String,
            val phone: String?,
            val email: String?
    )

    @CordaSerializable
    data class Item(
            val itemName: String,
            val itemCode: String,
            val itemDescription: String,
            val quanity: Int,
            val unitPrice: Double,
            val totalPrice: Double
    ){
        init{

            require (quanity>0){"qunaity should be a positive number"}
        }
    }

}