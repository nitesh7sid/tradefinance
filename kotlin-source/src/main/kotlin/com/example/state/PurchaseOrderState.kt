package com.example.state

/**
 *  Created by Nitesh Solanki
 */

import com.example.datastructures.TradeFinanceDataStructures
import net.corda.core.contracts.LinearState
import net.corda.core.contracts.StateRef
import net.corda.core.contracts.UniqueIdentifier
import net.corda.core.crypto.SecureHash
import net.corda.core.identity.Party
import net.corda.core.serialization.CordaSerializable
import java.time.LocalDate
import java.util.ArrayList

data class PurchaseOrderState(
        val buyer: Party,
        val seller: Party,
        val props: PurchaseOrderProperties,
        val invoiceAssigned: Boolean

):LinearState{

    override val participants = listOf(buyer, seller)
    override val linearId = UniqueIdentifier(props.purchaseOrdeID)

}

@CordaSerializable
data class PurchaseOrderProperties(
        val purchaseOrdeID: String,
        val seller: TradeFinanceDataStructures.Company,
        val buyer: TradeFinanceDataStructures.Company,
        val purchaseOrderDate: LocalDate,
        val purchaseOrderAttachmentHash: SecureHash,
        val purchaseOrderStateReference: StateRef?,
        val goods: List<TradeFinanceDataStructures.Item> = ArrayList()) {

    init {
        require(goods.isNotEmpty()) { "there must be goods assigned to the PO"}
    }
}