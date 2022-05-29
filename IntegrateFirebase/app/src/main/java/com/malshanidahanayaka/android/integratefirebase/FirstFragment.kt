package com.malshanidahanayaka.android.integratefirebase

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.firestore.FirebaseFirestore
import com.malshanidahanayaka.android.integratefirebase.databinding.FragmentFirstBinding
import com.malshanidahanayaka.android.integratefirebase.model.User


class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    var db = FirebaseFirestore.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addUser.setOnClickListener {
            //get insert data
            var firstName = binding.firstName.text.toString()
            var lastName = binding.lastName.text.toString()
            var age = binding.ageValue.text.toString()


            var user = User(firstName,lastName,age)
            db.collection("users").document().set(user)

            binding.firstName.setText(" ")
            binding.ageValue.setText(" ")
            binding.lastName.setText(" ")

        }

        binding.allUsersButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


    }








    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}