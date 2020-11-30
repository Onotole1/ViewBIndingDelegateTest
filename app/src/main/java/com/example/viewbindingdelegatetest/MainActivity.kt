package com.example.viewbindingdelegatetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.viewbindingdelegatetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragment = BindingFragment()

        supportFragmentManager.commit {
            add(R.id.container, fragment)
        }

        binding.attach.setOnClickListener {
            supportFragmentManager.commit {
                attach(fragment)
            }
        }
        binding.detach.setOnClickListener {
            supportFragmentManager.commit {
                detach(fragment)
            }
        }
    }
}