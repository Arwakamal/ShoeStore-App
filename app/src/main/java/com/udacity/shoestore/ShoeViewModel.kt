package com.udacity.shoestore

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel :ViewModel(){


    private val _ShoeList = MutableLiveData<MutableList<Shoe>>()
    val ShoeList: LiveData<MutableList<Shoe>>
        get() = _ShoeList


   // private val realShoeList = ArrayList<Shoe>()
   fun AddNewShoe(shoe: Shoe){
       if(ShoeList.value.isNullOrEmpty()){
           _ShoeList.value= mutableListOf(shoe)
           Log.i("i","FIRSTTIME")}
       else {
           _ShoeList.value!!.add(shoe)
           Log.i("i","SECONDTIME")}
   }
}


