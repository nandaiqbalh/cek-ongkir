package com.nandaiqbalh.cekongkir.presentation.ui.onboarding.fragment

import android.R.anim.fade_in
import android.R.anim.fade_out
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.nandaiqbalh.cekongkir.databinding.FragmentOnboardingThreeBinding
import com.nandaiqbalh.cekongkir.presentation.ui.home.MainActivity
import com.nandaiqbalh.cekongkir.presentation.ui.onboarding.OnboardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardingThreeFragment : Fragment() {

	private val viewModel: OnboardingViewModel by activityViewModels()

	private var _binding: FragmentOnboardingThreeBinding? = null
	private val binding get() = _binding!!

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentOnboardingThreeBinding.inflate(inflater, container, false)

		onClickListener()

		return binding.root
	}

	private fun onClickListener(){
		binding.btnNext.setOnClickListener {
			startActivity(Intent(requireContext(), MainActivity::class.java))
			activity?.overridePendingTransition(fade_in, fade_out);
			activity?.finish()

			// set status on boarding
			viewModel.setStatusOnboarding(true)
		}

	}
}