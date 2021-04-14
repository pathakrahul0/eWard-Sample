package com.eward.ui.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.eward.adapter.UserAdapter
import com.eward.databinding.ActivityMainBinding
import com.eward.interfaces.OnItemClicks
import com.eward.model.UserDetails
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private var userAdapter: UserAdapter? = null
    private var userList = ArrayList<UserDetails>()
    private var userIds = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)


        userAdapter = UserAdapter(userList, object : OnItemClicks {
            override fun onItemClick(position: Int) {
                if (userIds.contains(userList[position].id))
                    userIds.remove(userList[position].id)
                else userIds.add(userList[position].id!!)

                binding.base.let {
                    Snackbar.make(
                        this@MainActivity,
                        it,
                        "$userIds",
                        Snackbar.LENGTH_LONG
                    ).show()
                }

                Log.d("User Ids", "$userIds")
            }
        })
        binding.rvUser.adapter = userAdapter
        binding.swipeContainer.setOnRefreshListener {
            try {
                viewModel.getEmployees()
            } catch (e: Exception) {
                Log.i("Error", "Something error")
            }
        }

        viewModel.userList.observe({ lifecycle }) {
            userList.clear()
            userList.addAll(it.data!!)
            userAdapter?.notifyDataSetChanged()
            binding.swipeContainer.isRefreshing = false
        }

    }


}