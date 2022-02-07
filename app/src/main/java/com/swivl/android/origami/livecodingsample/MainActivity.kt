package com.swivl.android.origami.livecodingsample

import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.swivl.android.origami.livecodingsample.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.fab.setOnClickListener { view ->
            calculateSelected()
        }
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch (Dispatchers.Main){
            DataKeeper.fetchData()
            updateUI()
        }
    }

    private fun updateUI(){
        val adapter = DataAdapter(DataKeeper.data, DataKeeper.isChecked)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    private fun calculateSelected(){
        var number = 0
        for (entry in DataKeeper.isChecked) {
            if (entry.value) number += 1
        }
        Toast.makeText(this, "$number", Toast.LENGTH_SHORT).show()
    }
}