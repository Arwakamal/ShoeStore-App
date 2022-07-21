package com.udacity.shoestore

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Layout
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeList : Fragment() {

    private lateinit var binding: FragmentShoeListBinding
    private lateinit var viewModel: ShoeViewModel
    private var  parent: Layout? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)

        binding.floatingactionbtn.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeList_to_shoeDetail)
        }

        viewModel= ViewModelProvider(requireActivity()).get(ShoeViewModel::class.java)
        binding.shoeViewModel =viewModel
        binding.shoeList=this
        binding.lifecycleOwner = this
       binding.parent

       // requireActivity().actionBar?.setDisplayHomeAsUpEnabled(false)

        viewModel.ShoeList.observe(viewLifecycleOwner, androidx.lifecycle.Observer { it->
            for (i in it.indices){
                val shoe=it[i]
                AddNewShoe(shoe)
            }
        })
        return binding.root

    }

    private fun AddNewShoe(shoe: Shoe) {
        val inflater= context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val i = inflater.inflate(R.layout.fragment_shoe, null)
        val name: TextView = i.findViewById(R.id.shoeName)
        val size:TextView = i.findViewById(R.id.shoeSize)
        val description:TextView = i.findViewById(R.id.shoeDescribtion)
        name.text = shoe.name
        size.text = shoe.size.toString()
        description.text = shoe.description
       // parent!!.addView(i)

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

       super.onCreateOptionsMenu(menu,inflater)
        inflater.inflate(R.menu.main_menu,menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout_menu-> logout();

        }
        return super.onOptionsItemSelected(item)
    }

    private fun logout() {
        val intent = Intent(context, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}