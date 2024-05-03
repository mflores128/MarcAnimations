package campalans.m8.marcanimations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import campalans.m8.marcanimations.databinding.ActivitySplashScreenBinding
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen


class SplashScreen : AppCompatActivity() {
    private lateinit var ballbinding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = LayoutInflater.from(this)
        ballbinding= ActivitySplashScreenBinding.inflate(inflater)
        val view = ballbinding.root
        setContentView(view)


        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition{false}
        val bounceAnimation: Animation =AnimationUtils.loadAnimation(this,R.anim.bola_animacio)
        ballbinding.ballView.startAnimation(bounceAnimation)

        ballbinding.ballView.setOnClickListener{
            val handler= Handler(Looper.getMainLooper())
            val fadeAnimation: Animation = AnimationUtils.loadAnimation(this,R.anim.fade_out)
            ballbinding.root.startAnimation(fadeAnimation)

            handler.postDelayed({
                loadMain()
            }, 2000)
        }
    }
    private fun loadMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}