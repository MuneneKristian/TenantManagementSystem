package com.example.tenantmanagementsystem

data class Tenant(
    val name: String,
    val phone: String,
    val rent: String
) {
    fun summary(): String {
        return "Tenant Details\n\nName: $name\nPhone: $phone\nRent Paid: KSh $rent"
    }
}