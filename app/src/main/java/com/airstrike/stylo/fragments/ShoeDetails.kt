package com.airstrike.stylo.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.airstrike.stylo.R
import com.airstrike.stylo.adapters.ImagePagerAdapter
import com.airstrike.stylo.adapters.ShoeColorsAdapter
import com.airstrike.stylo.adapters.ShoeSizesAdapter
import com.airstrike.stylo.models.ShoeSize


class ShoeDetails : Fragment() {

    private lateinit var imageViewPager: ViewPager2
    private lateinit var colorsRecyclerView: RecyclerView
    private lateinit var sizesRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shoe_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        imageViewPager = view.findViewById(R.id.picturesViewPager)
        colorsRecyclerView =  view.findViewById(R.id.details_color_selector_layout)
        val imageURls = arrayListOf<String>(
            "https://4611f7eebf8e380ba0cf-39d37efa03734d3c9cf6bef1463deb23.ssl.cf3.rackcdn.com/6-4FCpXPVr.jpg"
            ,"https://4611f7eebf8e380ba0cf-39d37efa03734d3c9cf6bef1463deb23.ssl.cf3.rackcdn.com/HQ4324_4_900_900px-OlqkB8CQ.jpg"
            ,"https://4611f7eebf8e380ba0cf-39d37efa03734d3c9cf6bef1463deb23.ssl.cf3.rackcdn.com/HQ4324_1_900_900px-wi_vtOCF.jpg"
            ,"https://4611f7eebf8e380ba0cf-39d37efa03734d3c9cf6bef1463deb23.ssl.cf3.rackcdn.com/HQ4324_3_900_900px-fDX_pfa-.jpg")
        val adapter = ImagePagerAdapter(imageURls)
        imageViewPager.adapter = adapter

        val colors = arrayListOf<com.airstrike.stylo.models.Color>(
            com.airstrike.stylo.models.Color("Green","#32a852"),
            com.airstrike.stylo.models.Color("Green" ,"#7c30ba"),
            com.airstrike.stylo.models.Color("Green","#8f716d"),
            com.airstrike.stylo.models.Color("Green","#aad413"),
            com.airstrike.stylo.models.Color("Green","#32a852"),
            com.airstrike.stylo.models.Color("Green" ,"#7c30ba"),
            com.airstrike.stylo.models.Color("Green","#8f716d"),
            com.airstrike.stylo.models.Color("Green","#aad413")
        )
        loadColorPicker(colors)

        var sizes = arrayListOf<ShoeSize>(
            ShoeSize(36,1),
            ShoeSize(37 ,2),
            ShoeSize(48 ,8),
            ShoeSize(42,0),
            ShoeSize(43,11) ,
            ShoeSize(38,3),
            ShoeSize(39,4),
            ShoeSize(41,5),
        )
        loadSizesPicker(sizes)
    }
    private fun loadColorPicker(colors : ArrayList<com.airstrike.stylo.models.Color>)
    {
        colorsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        colorsRecyclerView.adapter = ShoeColorsAdapter(colors)
    }

    private fun loadSizesPicker(sizes : ArrayList<ShoeSize>)
    {

        sizes.removeIf{it.quantity <= 0}
        sizes.sortBy {it.value}
        sizesRecyclerView = requireView().findViewById(R.id.details_size_selector_layout)
        sizesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        sizesRecyclerView.adapter = ShoeSizesAdapter(sizes)

    }

}