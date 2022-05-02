package com.example.myapplication

    import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val fragmentManager: FragmentManager = supportFragmentManager

        val datas = mutableListOf<String>()
        for (i in 1..2) {
            datas.add("item $i")
        }

        binding.viewpager.adapter = MyPagerAdapter(datas, this, fragmentManager)
        binding.viewpager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        toggle = ActionBarDrawerToggle(
            this,
            binding.drawer,
            R.string.drawer_opened,
            R.string.drawer_closed
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item : MenuItem) : Boolean {
        if (toggle.onOptionsItemSelected(item)) {return true}
        return super.onOptionsItemSelected(item)
    }
}