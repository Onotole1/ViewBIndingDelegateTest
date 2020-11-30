package com.example.viewbindingdelegatetest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.viewbindingdelegatetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private companion object {
        const val TAG = "TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragment = (supportFragmentManager.findFragmentByTag(TAG) as? BindingFragment)
            ?: BindingFragment().apply {
                retainInstance = true
                supportFragmentManager.commit {
                    add(R.id.container, this@apply, TAG)
                }
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