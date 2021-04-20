# shoplive android sdk

## 설치 

project/build.gradle 파일에 다음과 같은 라인을 추가해 주세요.


```
allprojects {
    repositories { 
        ...
        maven { url 'https://shoplive.jfrog.io/artifactory/shoplive-sdk/' }
        ...
    }
}
```

app/build.gradle 파일에 다음과 같은 라인을 추가해 주세요.


```
android {
    defaultConfig {
        ...
        multiDexEnabled true
        ...
    }
}

dependencies {
    implementation 'cloud.shoplive:shoplive-sdk:0.0.6'
}
```

## 초기화

AndroidManifest.xml 에 등록한 Application 클래스 파일에 다음과 같은 코드를 추가해 주세요.

```Application class 
override fun onCreate() {
    super.onCreate()

    ShopLive.init(this)
    ShopLive.setAccessKey("{ACCESS_KEY}")
    ShopLive.setHandler(object : ShopLiveHandler {
        override fun handleNavigation(url: String) {
            // shoplive 에서 클릭한 이벤트 처리
            Toast.makeText(this@BaseApplication, "navigation : $url", Toast.LENGTH_SHORT).show()
        }

        override fun handleDownloadCoupon(couponId: String, callback: ShopLiveHandlerCallback) {
            // shoplive 에서 쿠폰 클릭 후 다운 로드 처리
            Toast.makeText(this@BaseApplication, "coupon id : $couponId", Toast.LENGTH_SHORT).show()

            // 쿠폰 다운로드시 완료 콜백 호출이 필요
            callback.complete()
        }
    })
}
```

## 유저 인증

사용자 인증은 일반 인증과 JWT 인증 방식이 있습니다.
 
#### 일반 인증 

일반 인증은 직접 사용자 정보를 입력하는 방식입니다.

```
val user = ShopLiveUser().apply {
    userId = "{USER_ID}"
    userName = "{USER_NAME}"
    gender = ShopLiveUserGender.Male
    age = 25
}
ShopLive.setUser(user)
```

#### JWT 인증

비밀키를 이용하여 서버에서 JWT를 만들어 인증하는 방식입니다.\
대부분의 상황에서 권장하는 방식입니다. [[인증 토큰 생성 가이드](https://shoplive.github.io/guide/guide/authorization.html#jwt-%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%8C%E1%85%B3%E1%86%BC)]


```
ShopLive.setAuthToken("{USER_JWT}")
```

## ShopLive play

```
ShopLive.play("{CAMPAIGN_KEY}")
```

