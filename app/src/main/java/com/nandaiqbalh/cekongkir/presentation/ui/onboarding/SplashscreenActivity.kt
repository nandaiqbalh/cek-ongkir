package com.nandaiqbalh.cekongkir.presentation.ui.onboarding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nandaiqbalh.cekongkir.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashscreenActivity : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		supportActionBar?.hide()
		setContentView(R.layout.activity_splashscreen)
	}
}