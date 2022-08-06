package cubakoviclv1.ferit.hnlovac.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.databinding.ActivityMainBinding
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navView : NavigationView
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = findViewById(R.id.drawerLayout)
        navView = findViewById(R.id.navView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction().add(R.id.frame_layout, LiveFragment()).commit()


        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> replaceFragment(LiveFragment(), it.title.toString())
                R.id.navFixtures -> replaceFragment(FinishedMatchesFragment(), it.title.toString())
                R.id.navStandings -> replaceFragment(StandingsFragment(), it.title.toString())
                R.id.nav_login -> {
                    auth = FirebaseAuth.getInstance()
                    auth.currentUser
                    replaceFragment(LogInFragment(), it.title.toString())
                }
                R.id.nav_activity -> replaceFragment(ActivityFragment(), it.title.toString())
                R.id.nav_logout -> {
                    auth = FirebaseAuth.getInstance()
                    auth.signOut()
                    replaceFragment(LogInFragment(), it.title.toString())
                }
                R.id.navScorers -> replaceFragment(TopScorersFragment(), it.title.toString())
                R.id.navNews -> replaceFragment(HNL_NewsFragment(), it.title.toString())
                R.id.navSchedule -> replaceFragment(ScheduleFragment(), it.title.toString())
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment, title: String) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            auth = FirebaseAuth.getInstance()
            val currentUser = auth.currentUser
            if(currentUser == null) {
                navView.menu.findItem(R.id.nav_login).setVisible(true)
                navView.menu.findItem(R.id.nav_logout).setVisible(false)
                navView.menu.findItem(R.id.nav_activity).setVisible(false)
            } else {
                navView.menu.findItem(R.id.nav_login).setVisible(false)
                navView.menu.findItem(R.id.nav_logout).setVisible(true)
                navView.menu.findItem(R.id.nav_activity).setVisible(true)
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
