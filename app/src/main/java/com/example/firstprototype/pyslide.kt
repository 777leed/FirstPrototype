package com.example.firstprototype

import android.os.Bundle
import android.widget.TableLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import br.com.phs.tablayout.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class pyslide : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_pyslide)
        setUpTabs ()
    }
        private fun setUpTabs () {
            val viewPager=findViewById<ViewPager>(R.id.viewPager)
            val tabs=findViewById<TabLayout>(R.id.tabs)
            val adapter = ViewPagerAdapter(supportFragmentManager)
            adapter.addFragment (py1(),"library")
            adapter.addFragment (fytb(),"Videos")
            viewPager.adapter = adapter
            tabs.setupWithViewPager(viewPager)
            tabs.getTabAt(0)!!.setIcon(R.drawable.online_library)
            tabs.getTabAt(1)!!.setIcon (R.drawable.video_marketing)
        }

}