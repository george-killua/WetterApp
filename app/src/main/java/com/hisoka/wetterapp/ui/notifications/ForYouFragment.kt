package com.hisoka.wetterapp.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hisoka.wetterapp.databinding.FragmentForYouBinding

class ForYouFragment : Fragment() {

				private lateinit var forYouViewModel : ForYouViewModel
				private var _binding : FragmentForYouBinding? = null

				// This property is only valid between onCreateView and
				// onDestroyView.
				private val binding get() = _binding!!

				override fun onCreateView(
												inflater : LayoutInflater,
												container : ViewGroup?,
												savedInstanceState : Bundle?
				) : View? {
								forYouViewModel =
												ViewModelProvider(this).get(ForYouViewModel::class.java)

								_binding = FragmentForYouBinding.inflate(inflater, container, false)
								val root : View = binding.root

								val textView : TextView = binding.textNotifications
								forYouViewModel.text.observe(viewLifecycleOwner, Observer {
												textView.text = it
								})
								return root
				}

				override fun onDestroyView() {
								super.onDestroyView()
								_binding = null
				}
}