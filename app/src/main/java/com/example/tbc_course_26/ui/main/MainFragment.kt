package com.example.tbc_course_26.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.tbc_course_26.domain.model.User
import com.example.tbc_course_26.databinding.FragmentMainBinding
import com.example.tbc_course_26.ui.main.adapter.UsersRecycler
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy {
        UsersRecycler()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listeners()
        setUpAdapter()


    }

    private fun setUpAdapter() {
        binding.mainRecycler.adapter = adapter
        showUsers()
    }

    private fun listeners() {

        binding.saveBtn.setOnClickListener {
            insertUser()
        }

        adapter.onClick = {
            deleteUser(it)
        }

    }

    private fun deleteUser(user:User) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.deleteUser(user)
        }
    }


    private fun showUsers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getUser().collect {
                adapter.submitList(it)
            }
        }

    }

    private fun insertUser() {
        viewLifecycleOwner.lifecycleScope.launch {

            if (binding.lastNameEditText.text.toString()
                    .isNotEmpty() && binding.nameEditText.text.toString().isNotEmpty()
            ) {
                viewModel.addUser(
                    User(
                        id = null,
                        binding.nameEditText.text.toString(),
                        binding.lastNameEditText.text.toString()
                    )
                )
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}