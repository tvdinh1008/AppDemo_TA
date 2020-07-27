# AppDemo_TA

//sử dụng git trên android studio->VCC->commit sau đó: VCC->git->Push

Recoginze Text

B1.Thêm một số thư viện
    
    //image crop library
    implementation 'com.theartofdev.edmodo:android-image-cropper:2.7.+'
    //image to text google libarary
    implementation 'com.google.android.gms:play-services-vision:20.0.0'

B2.

B3.

Translate

B1. Download google-services.json
  
  Nếu sử dụng google-services.json cũ thì sửa chỗ "package_name": "com.example.appdemo_ta"
  
  sau đó copy paste vào \LaptrinhAndroid\AppDemo_TA\app\google-services.json
  
  Hướng dẫn theo: https://firebase.google.com/docs/android/setup
  
B2. Sử dụng translate theo hướng dẫn
  
  https://firebase.google.com/docs/ml-kit/android/translate-text

Mở rộng có thể sử dụng thư viện này để phát hiện ngôn ngữ : https://firebase.google.com/docs/ml-kit/android/identify-languages
