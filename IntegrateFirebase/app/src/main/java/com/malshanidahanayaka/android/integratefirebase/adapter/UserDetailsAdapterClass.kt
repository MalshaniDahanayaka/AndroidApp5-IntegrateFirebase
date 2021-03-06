package com.malshanidahanayaka.android.integratefirebase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.malshanidahanayaka.android.integratefirebase.R
import com.malshanidahanayaka.android.integratefirebase.model.User

class UserListAdapter(private val users: List<User>, private val findNavController: NavController): RecyclerView.Adapter<CustomViewHolder>(){



    //number of Items
    override fun getItemCount(): Int {
        return users.count()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.recycler_view_user_view,parent,false)
        return CustomViewHolder(cellForRow,findNavController)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {

        holder.firstName.text  = users.elementAt(position).firstName
        holder.lastName.text = users.elementAt(position).lastName
        holder.age.text = users.elementAt(position).age



    }
}

class CustomViewHolder(val view: View, private val findNavController: NavController): RecyclerView.ViewHolder(view){
    val firstName: TextView =    itemView.findViewById(R.id.first_name_value)
    val lastName: TextView = itemView.findViewById(R.id.last_name_value)
    val age: TextView = itemView.findViewById(R.id.std_age_value)



    init{
//        view.setOnClickListener{
//            findNavController.navigate(R.id.action_nav_home_to_about_course, Bundle().apply {
//                putString("course",courseID.text.toString())
//            })
//
//
////            val intent = Intent(view.context, HomeFragment::class.java)
////            intent.putExtra("course_id",courseID.text)
////            view.context.startActivity(intent)
//
//        }




    }
}