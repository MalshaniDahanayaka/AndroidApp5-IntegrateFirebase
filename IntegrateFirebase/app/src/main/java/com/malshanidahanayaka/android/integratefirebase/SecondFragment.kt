package com.malshanidahanayaka.android.integratefirebase

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore
import com.malshanidahanayaka.android.integratefirebase.adapter.UserListAdapter
import com.malshanidahanayaka.android.integratefirebase.databinding.FragmentSecondBinding
import com.malshanidahanayaka.android.integratefirebase.model.User
import java.lang.Exception

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    var db = FirebaseFirestore.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }







    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db.collection("users").get().addOnCompleteListener{
            if(it.isSuccessful){

                var userList =  ArrayList<User>()

                it.result!!.forEach { q->
                    var firstName = q.get("firstName").toString()
                    var lastName = q.get("lastName").toString()
                    var age = q.get("age").toString()

                    var user:User = User(
                        firstName,
                        lastName,
                        age
                    )

                    userList.add(user)



                }
                try {
                    binding.recyclerViewStdList.layoutManager = LinearLayoutManager(view.context)
                    val recyclerViewstd:RecyclerView = binding.recyclerViewStdList
                    recyclerViewstd.adapter = UserListAdapter(userList!!, findNavController())
                }catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}