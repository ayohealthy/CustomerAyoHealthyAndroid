package com.devatacreative.ayohealthy.utils

import android.content.Context
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.Toast
import com.airbnb.lottie.LottieAnimationView
import com.google.android.gms.common.util.JsonUtils
import com.kazakago.cryptore.CipherAlgorithm
import com.kazakago.cryptore.Cryptore
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.lang.Exception
import java.nio.charset.Charset

class GlobalHelper {
    private val cryptoreAES: Cryptore by lazy {
        val builder = Cryptore.Builder(alias = "AES", type = CipherAlgorithm.AES)
//        builder.blockMode = BlockMode.CBC //If Needed.
//        builder.encryptionPadding = EncryptionPadding.PKCS7 //If Needed.
        builder.build()
    }

    fun stringEncryptor(plainText: String, context: Context): String {
        try {
            val textToByte = plainText.toByteArray()
            val encryptResult = cryptoreAES.encrypt(textToByte)
            val encodedString = Base64.encodeToString(encryptResult.bytes, Base64.DEFAULT)
            Toast.makeText(context, "encoded : $encodedString", Toast.LENGTH_LONG).show()
            Log.d("Encoded : ", encodedString)
            return encodedString
        } catch (e: Exception){
            e.printStackTrace()
            Toast.makeText(context, e.localizedMessage, Toast.LENGTH_LONG).show()
        }
        return ""
    }

    private fun getGoogleCredentialsJson(context: Context): String{
        var jsonResult: String
        try {
            val inputStream: InputStream = context.assets.open("credentials.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            jsonResult = String(buffer, Charset.defaultCharset())
        }catch (e: IOException){
            e.printStackTrace()
            return ""
        }

        return jsonResult
    }
    fun getGoogleJson(context: Context){
        
    }
    fun showLoading(layout: View?, view: LottieAnimationView, state: Boolean){
        if (state){
            layout?.visibility = View.VISIBLE
            view.visibility = View.VISIBLE
        } else {
            layout?.visibility = View.INVISIBLE
            view.visibility = View.INVISIBLE
        }
    }


}