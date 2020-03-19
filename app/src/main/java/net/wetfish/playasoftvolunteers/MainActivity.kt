package net.wetfish.playasoftvolunteers

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

/**
 * Created by ${Michael} on 9/6/2019.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        @Suppress("UNUSED_VARIABLE")
//        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//
//        // Navigation Initialization, tie it to the ActionBar of the activity
//        val navController = this.findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(navController.graph)
//        binding.setupWithNavController(binding.toolbar, navController, appBarConfiguration)

        setContentView(R.layout.activity_main)

        checkConnectivity()
    }

    /**
     * Let the navigation controller handle Fragment Back-Stack
     */
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }

    /**
     * Check the network
     */
    private fun checkConnectivity() {
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
        if (!isConnected) {
            Toast.makeText(this, "Check network connection", Toast.LENGTH_SHORT).show()
        }
    }
}