package com.devatacreative.ayohealthy.activity.auth

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.view.View
import com.devatacreative.ayohealthy.R
import com.devatacreative.ayohealthy.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initComponent()
    }

    private fun initComponent() {
        val termsStringBuilder = StringBuilder()
        val spannableStringBuilder = SpannableStringBuilder()
        val text1 = "Kebijakan pemakaian"
        val termsText = SpannableString(text1)
        termsText.setSpan(StyleSpan(Typeface.BOLD),1, termsText.lastIndex,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        termsText.setSpan(ForegroundColorSpan(resources.getColor(R.color.primary_green)),1, termsText.lastIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        val privacyPolicyText = "Kebijakan Privasi"
        termsStringBuilder.append("Dengan menekan tombol Daftar diatas, kamu menyetujui $termsText dan $privacyPolicyText yang berlaku")
        binding.registerAgreementText.text = termsStringBuilder
        binding.registerAgreementText.visibility = View.INVISIBLE
        binding.registerBackBtn.setOnClickListener {
            finish()
        }
    }
}