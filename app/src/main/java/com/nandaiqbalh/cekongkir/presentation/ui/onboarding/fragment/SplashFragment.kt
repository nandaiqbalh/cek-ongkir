package com.nandaiqbalh.cekongkir.presentation.ui.onboarding.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.nandaiqbalh.cekongkir.R
import com.nandaiqbalh.cekongkir.presentation.ui.home.MainActivity
import com.nandaiqbalh.cekongkir.presentation.ui.onboarding.OnboardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

	private val viewModel: OnboardingViewModel by activityViewModels()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val view = inflater.inflate(R.layout.fragment_splash, container, false)

		loadingScreen()

		return view
	}

	private fun loadingScreen() {
		Handler(Looper.getMainLooper()).postDelayed(this::isTheFirstTime, 3000)
	}


	private fun isTheFirstTime(){

		lifecycleScope.launchWhenCreated {
			viewModel.getStatusOnboarding().observe(viewLifecycleOwner) {
				if (it == false) {
					findNavController().navigate(R.id.action_splashFragment_to_onboardingOneFragment)
				} else {
					startActivity(Intent(requireContext(), MainActivity::class.java))
					activity?.overridePendingTransition(
						android.R.anim.fade_in,
						android.R.anim.fade_out
					);
					activity?.finish()
				}
			}
		}


	}

}