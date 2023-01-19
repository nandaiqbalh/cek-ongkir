package com.nandaiqbalh.cekongkir.presentation.ui.onboarding.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nandaiqbalh.cekongkir.R
import com.nandaiqbalh.cekongkir.databinding.FragmentOnboardingOneBinding
import com.nandaiqbalh.cekongkir.presentation.ui.home.MainActivity
import com.nandaiqbalh.cekongkir.presentation.ui.onboarding.OnboardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingOneFragment : Fragment() {

	private val viewModel: OnboardingViewModel by activityViewModels()

	private var _binding: FragmentOnboardingOneBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentOnboardingOneBinding.inflate(inflater, container, false)

		onClickListener()

		return binding.root
	}

	private fun onClickListener(){
		binding.btnNext.setOnClickListener {
			findNavController().navigate(R.id.action_onboardingOneFragment_to_onboardingTwoFragment)
		}

		binding.btnSkip.setOnClickListener {
			startActivity(Intent(requireContext(), MainActivity::class.java))
			activity?.finish()
			activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

			// set status on boarding
			viewModel.setStatusOnboarding(true)
		}
	}

}