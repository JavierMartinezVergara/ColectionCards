package com.javiermtz.colectioncards.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.javiermtz.colectioncards.R
import com.javiermtz.colectioncards.databinding.ActivityCardsBinding
import com.javiermtz.colectioncards.presentation.ListType.Grid
import com.javiermtz.colectioncards.presentation.ListType.List
import com.javiermtz.colectioncards.presentation.cardscreen.CardsViewModel
import com.javiermtz.colectioncards.presentation.userscreen.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CardsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCardsBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private val viewModel: CardsViewModel by viewModels()
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCardsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBar.toolbar)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_user,
                R.id.nav_cards
            ),
            binding.drawerLayout
        )
        setupActionBarWithNavController(navController = navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        binding.appBar.content.bottomNavView.setOnItemSelectedListener { menu ->
            when (menu.itemId) {
                R.id.nav_cards -> {
                    viewModel.setState(List)
                    Toast.makeText(this, "List", Toast.LENGTH_LONG).show()
                }
                R.id.nav_user -> {
                    viewModel.setState(Grid)
                    Toast.makeText(this, "Grid", Toast.LENGTH_LONG).show()
                }
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

sealed class ListType {
    object List : ListType()
    object Grid : ListType()
}
