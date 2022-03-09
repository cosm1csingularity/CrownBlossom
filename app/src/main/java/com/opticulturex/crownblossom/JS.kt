package com.opticulturex.crownblossom

import android.content.Context
import com.opticulturex.crownblossom.Constants.Campaign1
import com.opticulturex.crownblossom.Constants.Deeplink1
import com.orhanobut.hawk.Hawk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class JS(val context: Context) {
    private var jsoup: String? = "null"
    private val hawk : String? = Hawk.get(Campaign1)
    private val hawkAppLink: String? = Hawk.get(Deeplink1)

    private var forJsoupSetNaming: String = Constants.FilterUrl + Constants.subber1 + hawk
    private var forJsoupSetAppLnk: String = Constants.FilterUrl + Constants.subber1 + hawkAppLink
    suspend fun getDocSecretKey(): String?{
        withContext(Dispatchers.IO){
            if(hawk!=null) {
                val doc = Jsoup.connect(forJsoupSetNaming).get()
                jsoup = doc.text().toString()
            } else {
                val doc = Jsoup.connect(forJsoupSetAppLnk).get()
                jsoup = doc.text().toString()
            }
        }
        return jsoup
    }
}