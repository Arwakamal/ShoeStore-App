package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomBinding

class Welcome : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentWelcomBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcom, container, false)

        binding.nextBtn.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_welcome3_to_instruction2)
        }
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        requireActivity().actionBar?.setDisplayHomeAsUpEnabled(false)

        return binding.root
    }
}
