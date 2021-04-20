package cloud.shoplive.sample

import android.app.Application
import android.content.Intent
import android.widget.Toast
import cloud.shoplive.sdk.*

class BaseApplication: Application() {

    private val shopLiveAccessKey = "{ACCESS_KEY}"

    override fun onCreate() {
        super.onCreate()

        ShopLive.init(this)
        ShopLive.setAccessKey(shopLiveAccessKey)
        ShopLive.setHandler(object : ShopLiveHandler {
            override fun handleNavigation(url: String) {
                // shoplive 에서 클릭한 이벤트 처리
                Toast.makeText(this@BaseApplication, "navigation : $url", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@BaseApplication, NavigationActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("url", url)
                startActivity(intent)
            }

            override fun handleDownloadCoupon(couponId: String, callback: ShopLiveHandlerCallback) {
                // shoplive 에서 쿠폰 클릭 후 다운 로드 처리
                Toast.makeText(this@BaseApplication, "coupon id : $couponId", Toast.LENGTH_SHORT).show()

                // 쿠폰 다운로드시 완료 콜백 호출이 필요
                callback.complete()
            }
        })
    }
}