package com.udacity.shoestore

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentLogInBinding


class LogIn : Fragment() {
    private lateinit var binding:FragmentLogInBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_log_in, container, false)

        binding.loginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_logIn_to_welcome3)

        }

        binding.createAccount.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_logIn_to_welcome3)
        }
        // Inflate the layout for this fragment
        setHasOptionsMenu(true)
        requireActivity().actionBar?.setDisplayHomeAsUpEnabled(false)
        binding.logIn=this

        binding.lifecycleOwner = this


        return binding.root
    }


}

