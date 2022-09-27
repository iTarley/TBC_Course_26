package com.example.tbc_course_26.ui.main.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_course_26.domain.model.User
import com.example.tbc_course_26.databinding.RecyclerItemBinding


typealias onClick = (user: User) -> Unit

class UsersRecycler : ListAdapter<User, UsersRecycler.ViewHolder>(DiffCallBack()) {


    lateinit var onClick: onClick


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            RecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }


    class DiffCallBack : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.uid == newItem.uid
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }

    inner class ViewHolder(private val binding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var currentUser: User
        fun bind() {
            currentUser = getItem(adapterPosition)
            binding.apply {
                binding.name.text = currentUser.firstName
                binding.last.text = currentUser.lastName
                root.setOnClickListener {
                    onClick(
                        currentUser
                    )
                }
            }



        }
    }


}




