package net.wetfish.playasoftvolunteers.ui

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import net.wetfish.playasoftvolunteers.R

/**
 * Created by ${Michael} on 9/6/2019.
 */
class MainActivity : AppCompatActivity() {

    // Navigation Controller
    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Navigation Initialization, tie it to the ActionBar of the activity
        navigationController = findNavController(R.id.navigationHostFragament)
        NavigationUI.setupActionBarWithNavController(this, navigationController)

        checkConnectivity()
    }

    /**
     * Let the navigation controller handle Fragment Back-Stack
     */
    override fun onSupportNavigateUp() = navigationController.navigateUp()

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