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
import com.nandaiqbalh.cekongkir.databinding.FragmentOnboardingTwoBinding
import com.nandaiqbalh.cekongkir.presentation.ui.home.HomeActivity
import com.nandaiqbalh.cekongkir.presentation.ui.onboarding.OnboardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingTwoFragment : Fragment() {

	private val viewModel: OnboardingViewModel by activityViewModels()

	private var _binding: FragmentOnboardingTwoBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentOnboardingTwoBinding.inflate(inflater, container, false)

		onClickListener()

		return binding.root
	}

	private fun onClickListener(){
		binding.btnNext.setOnClickListener {
			findNavController().navigate(R.id.action_onboardingTwoFragment_to_onboardingThreeFragment)
		}

		binding.btnSkip.setOnClickListener {
			startActivity(Intent(requireContext(), HomeActivity::class.java))
			activity?.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			activity?.finish()

			// set status on boarding
			viewModel.setStatusOnboarding(true)
		}
	}

}