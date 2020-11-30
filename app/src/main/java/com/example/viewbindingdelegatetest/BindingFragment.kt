package com.example.viewbindingdelegatetest

import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.viewbindingdelegatetest.databinding.FragmentBindingBinding

class BindingFragment : Fragment(R.layout.fragment_binding) {

    init {
        viewBinding {
            FragmentBindingBinding.bind(it).apply {
                button.setOnClickListener {
                    Toast.makeText(requireContext(), "Lol", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}