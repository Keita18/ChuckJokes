package com.example.chuckle_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.chuckle_app.ui.main.ListViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.drawer_header.view.*

lateinit var listViewModelFactory: ListViewModelFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //set action bar title
        supportActionBar?.title = "Jokes"

        //init listViewModelFactory
        val appComponent = (application as ChuckleApplication).applicationComponent
        val getRandomJokeUseCase = appComponent.getGetRandomJokeUseCase()
        listViewModelFactory = ListViewModelFactory(getRandomJokeUseCase)

        //init navigation controller
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        NavigationUI.setupWithNavController(navigation_drawer, navController)

        //init navigation drawer header layout
        val navHeader = navigation_drawer.getHeaderView(0)

        val glide = appComponent.getGlide()
        val url = "https://thispersondoesnotexist.com/image"
        glide
            .load(url)
            .override(80, 80)
            .centerCrop()
            .placeholder(R.drawable.ic_web)
            .error(R.drawable.ic_web)
            .into(navHeader.avatar)

    }

}