package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeDetail : Fragment() {


    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.shoeViewModel =viewModel
        binding.ShoeDetail=Shoe("","","","")

        binding.lifecycleOwner = this

        return binding.root
    }
    fun nextButton(shoe: Shoe){
        if(shoe.name.isNullOrEmpty()||shoe.company.isNullOrEmpty()||
                shoe.size.toString().isNullOrEmpty()||shoe.description.isNullOrEmpty())
            Toast.makeText(context,"ENTER ALL DATA",Toast.LENGTH_SHORT).show()
        else{
            viewModel.AddNewShoe(Shoe(shoe.name,shoe.company,shoe.size.toString(),shoe.description))

            binding.nextBtn.findNavController().navigate(R.id.action_shoeDetail_to_shoeList)



        }
    }

    fun cancelButton(){
        binding.cancelBtn.findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
    }
}
