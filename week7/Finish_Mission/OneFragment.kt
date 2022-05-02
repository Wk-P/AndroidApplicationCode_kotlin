package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class OneFragment : Fragment() {
    override fun onCreateView(
        inflater : LayoutInflater,
        container : ViewGroup?,
        saveInstanceState : Bundle?
    ) : View? {
        return inflater.inflate(R.layout.fragment_bind, container, false)
    }
}