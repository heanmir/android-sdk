package cloud.shoplive.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import cloud.shoplive.sdk.ShopLive
import cloud.shoplive.sdk.ShopLiveUser
import cloud.shoplive.sdk.ShopLiveUserGender

class MainActivity : AppCompatActivity() {
    private val campaignKey = "{CAMPAIGN_KEY}"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = ShopLiveUser().apply {
            userId = "{USER_ID}"
            userName = "{USER_NAME}"
            gender = ShopLiveUserGender.Male
            age = 25
        }
        ShopLive.setUser(user)
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            ShopLive.play(campaignKey)
        }
    }
}