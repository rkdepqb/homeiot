package com.example.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.Gravity
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recycleview_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_navi.setOnClickListener{
            layout_drawer.openDrawer(GravityCompat.START)
        }

        naviView.setNavigationItemSelectedListener (this)

        val arrayList = ArrayList<Model>()

        arrayList.add(Model("Ledcontroll", "you can controll the led", R.drawable.led))
        arrayList.add(Model("Temperature", "Show Current temperature", R.drawable.temper))
        arrayList.add(Model("Humidity", "Show Current Humidity", R.drawable.humity))
        arrayList.add(Model("Dust", "Show current dust", R.drawable.dust))
        arrayList.add(Model("Gas", "Show current gdhsas", R.drawable.gas))
        arrayList.add(Model("Connect", "Connect your home device", R.drawable.wifi))

        val myAdapter = MyAdapter(arrayList, this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when    (item.itemId){
            R.id.access -> Toast.makeText(applicationContext, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일", Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext, "메세지", Toast.LENGTH_SHORT).show()

        }
        layout_drawer.closeDrawers()
        return false
    }
}