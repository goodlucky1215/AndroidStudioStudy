package com.example.ktfcmpushnotice

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService: FirebaseMessagingService() {
    //토큰이 변경될 때 마다 여기서 서버에 변경을 해줘야 한다.
    //실제 라이브 서버를 운영할 때는 onNewToken을 오버라이드해서 토큰이 갱신 될 때마다,
    //서버에다가 해당 토큰을 갱신해 주는 역할을 한다.
    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        createNotificationChannel()
        val title = remoteMessage.data["title"]
        val message = remoteMessage.data["message"]
        var notifaicationBuilder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_active_24)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        NotificationManagerCompat.from(this)
            .notify(1,notifaicationBuilder.build())
    }

    //채널 만들어 주기 완성
    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //NotificationManager.IMPORTANCE_DEFAULT채널 중요도 설정해줌.
            var channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
            //만들어진 채널을 Notification매니저에 추가해줌.
            channel.description = CHANNEL_DESCRIPTION
            (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                .createNotificationChannel(channel)
        }
    }

    companion object{
        private const val CHANNEL_NAME = "Nice Jiny"
        private const val CHANNEL_DESCRIPTION = "Yo!!!I'm wonderful~~~"
        private const val CHANNEL_ID = "Channel id"
    }
}