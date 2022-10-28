package com.javiermtz.colectioncards.presentation

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.javiermtz.colectioncards.R
import com.javiermtz.colectioncards.databinding.ActivityCardsBinding
import com.javiermtz.colectioncards.presentation.ListType.Grid
import com.javiermtz.colectioncards.presentation.ListType.List
import com.javiermtz.colectioncards.presentation.ShowBottom.Hide
import com.javiermtz.colectioncards.presentation.ShowBottom.Show
import com.javiermtz.colectioncards.presentation.cardscreen.CardsViewModel
import com.javiermtz.colectioncards.presentation.detailcard.DetailCardFragment
import com.javiermtz.colectioncards.presentation.userscreen.UserFragment
import com.javiermtz.colectioncards.presentation.userscreen.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CardsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
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
                R.id.nav_cards,
                R.id.nav_fav
            ),
            binding.drawerLayout
        )
        setupActionBarWithNavController(navController = navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        binding.navView.setNavigationItemSelectedListener(this)
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

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.showBottonNav.collectLatest { showBottomNav ->
                        when (showBottomNav) {
                            Hide -> binding.appBar.content.bottomNavView.visibility = View.GONE
                            Show -> binding.appBar.content.bottomNavView.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
    }

    override fun onBackPressed() {
        val navHost =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment

        navHost.childFragmentManager.primaryNavigationFragment?.let { fragment ->
            when (fragment) {
                is UserFragment, is DetailCardFragment -> {
                    viewModel.showBottonNav(Show)
                    navHost.navController.popBackStack()
                }
                else -> super.onBackPressed()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController
        when (item.itemId) {
            R.id.nav_user -> {
                navController.navigate(R.id.nav_user)
                viewModel.showBottonNav(Hide)
            }
            R.id.nav_fav -> {
                navController.navigate(R.id.nav_fav)
            }
        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}

sealed class ListType {
    object List : ListType()
    object Grid : ListType()
}

sealed class ShowBottom {
    object Show : ShowBottom()
    object Hide : ShowBottom()
}
