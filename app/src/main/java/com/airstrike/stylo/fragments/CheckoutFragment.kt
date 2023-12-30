package com.airstrike.stylo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airstrike.stylo.R
import com.airstrike.stylo.adapters.AddressesAdapter
import com.airstrike.stylo.listeners.AddressChangeListener
import com.airstrike.stylo.listeners.AddressSelectionListener
import com.airstrike.stylo.models.Address


class CheckoutFragment : Fragment(), AddressChangeListener{

    private lateinit var shippingAddressesRv : RecyclerView
    private lateinit var billingAddressesRv : RecyclerView
    private lateinit var selectedShippingAddress : Address
    private val addresses = mutableListOf<Address>(
        Address(
            id = "1",
            firstName = "Ana",
            lastName = "Horvat",
            streetName = "Trg Bana Jelačića",
            streetNumber = "15",
            additionalStreetInfo = "Apartment 3",
            postalCode = "10000",
            city = "Zagreb",
            country = "HR",
            phone = "+385912345678",
    ),Address(
            id = "2",
            firstName = "Marko",
            lastName = "Kovačić",
            streetName = "Primorska ulica",
            streetNumber = "23",
            additionalStreetInfo = "",
            postalCode = "51000",
            city = "Rijeka",
            country = "HR",
            phone = "+385987654321",
        ),Address(
            id = "3",
            firstName = "Ivana",
            lastName = "Babić",
            streetName = "Ulica Kralja Tomislava",
            streetNumber = "8",
            additionalStreetInfo = "Floor 2",
            postalCode = "32000",
            city = "Vukovar",
            country = "HR",
            phone = "+385998877665",
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        shippingAddressesRv = view.findViewById(R.id.shipping_address_rv)
        billingAddressesRv = view.findViewById(R.id.billing_address_rv)


        shippingAddressesRv.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        shippingAddressesRv.adapter = AddressesAdapter(addresses,object : AddressSelectionListener{
            override fun notifyAddressSelectionChanged(address: Address) {
                selectedShippingAddress = address
            }
        },this)
    }

    override fun notifyAddressAddition(address: Address) {
        addresses.add(0,address)
    }

    override fun notifyAddressUpdate(oldAddress: Address, newAddress: Address) {
        val index = addresses.indexOf(oldAddress)
        addresses.remove(oldAddress)
        addresses.add(index,newAddress)
    }


}