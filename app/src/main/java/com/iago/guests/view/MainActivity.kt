package com.iago.guests.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.iago.guests.R
import com.iago.guests.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  
  private lateinit var appBarConfiguration: AppBarConfiguration
  private lateinit var binding: ActivityMainBinding
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
    
    setSupportActionBar(binding.appBarMain.toolbar)
    
    binding.appBarMain.fab.setOnClickListener { view ->
      startActivity(Intent(this, GuestFormActivity::class.java))
    }
    setupNavigation()
  }
  
  /*override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.main, menu)
    return true
  }
  
  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if (item.itemId == R.id.action_settings) {
    
    }
    return super.onOptionsItemSelected(item)
  }
 */
  
  override fun onSupportNavigateUp(): Boolean {
    val navController = findNavController(R.id.nav_host_fragment_content_main)
    return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
  }
  
  private fun setupNavigation() {
    val drawerLayout: DrawerLayout = binding.drawerLayout
    val navView: NavigationView = binding.navView
    val navController = findNavController(R.id.nav_host_fragment_content_main)
    appBarConfiguration = AppBarConfiguration(
      setOf(
        R.id.nav_all_guests, R.id.nav_presents, R.id.nav_absents
      ), drawerLayout
    )
    setupActionBarWithNavController(navController, appBarConfiguration)
    navView.setupWithNavController(navController)
  }
}