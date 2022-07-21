package com.udacity.shoestore

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetail : Fragment() {


    private lateinit var binding: FragmentShoeDetailBinding
    private lateinit var viewModel: ShoeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)

        binding.shoeViewModel =viewModel
        binding.ShoeDetail=this
        binding.lifecycleOwner = this

        return binding.root
    }
    fun nextButton(){
        if( binding.enteryourshoeName.text.toString().isEmpty()|| binding.editTextcompanyName.text.toString().isEmpty()||
                binding.editTextshoeSize.text.toString().isEmpty()|| binding.editTextshoeDescribtion.text.toString().isEmpty())
            Toast.makeText(context,"PLEASE ENTER ALL DETAILS",Toast.LENGTH_LONG).show()
            else{
                val NewShoe:Shoe= Shoe(binding.enteryourshoeName.text.toString(), binding.editTextshoeSize.text.toString().toDouble(),
                        binding.editTextcompanyName.text.toString(), binding.editTextshoeDescribtion.text.toString())
                viewModel.AddNewShoe(NewShoe)
           //     Log.i("new","${viewModel.ShoeList.value}")
                binding.nextBtn.findNavController().navigate(R.id.action_shoeDetail_to_shoeList)


            }
    }

    fun cancelButton(){
        binding.cancelBtn.findNavController().navigate(R.id.action_shoeDetail_to_shoeList)
    }
}
