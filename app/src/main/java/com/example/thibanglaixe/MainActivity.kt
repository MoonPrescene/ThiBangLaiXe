package com.example.thibanglaixe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.thibanglaixe.databinding.ActivityMainBinding
import com.example.thibanglaixe.extension.BottomNavigationBehavior
import com.example.thibanglaixe.ui.fragments.GPLXFragment
import com.example.thibanglaixe.ui.fragments.InformationFragment
import com.example.thibanglaixe.ui.fragments.TrainingFragment



class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    private val gplxFragment = GPLXFragment()
    private val trainingFragment = TrainingFragment()
    private val informationFragment = InformationFragment()
    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this, R.layout.activity_main)

      //  setCurrentFragment(gplxFragment)


        //Way 1: using Navcontroller
        navController = findNavController(R.id.nav_fragment)
        binding.apply {
            bottomNavigationView.setupWithNavController(
                navController
            )
        }
       navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.testFragment -> {
                    hideBottomNavView()
                }
                R.id.GPLX_Fragment-> {
                    showBottomNavView()
                }
                R.id.pictureFragment->{
                    hideBottomNavView()
                }
                R.id.tipFragment->{
                    hideBottomNavView()
                }
            }
        }

        //Way 2: not using Navcontroller
//        binding.bottomNavigationView.setOnItemSelectedListener{
////            when(it.itemId){
////                R.id.gplx_navigation_action->{
////                    title = "GPLX"
////                    setCurrentFragment(gplxFragment)
////                }
////                R.id.training_navigation_action->setCurrentFragment(trainingFragment)
////                R.id.information_navigation_action->setCurrentFragment(informationFragment)
////            }
////            return@setOnItemSelectedListener true
//        }
    }


    //  private fun setCurrentFragment(fragment: Fragment) {
  //      supportFragmentManager.beginTransaction().apply {
  //          replace(R.id.nav_fragment, fragment)
    //         commit()
   //     }
   // }

    private fun hideBottomNavView(){
        binding.bottomNavigationView.visibility = View.GONE
    }

    private fun showBottomNavView(){
        binding.bottomNavigationView.visibility = View.VISIBLE
    }

}