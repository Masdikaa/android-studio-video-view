package com.masdika.videoviewapp

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.masdika.videoviewapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mediaController: MediaController? = null
    private val videoUrl: String = "https://youtu.be/IjN3FWoXHjQ"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener {

            mediaController = MediaController(this)
            mediaController!!.setAnchorView(binding.videoView)
            val onlineUrl = Uri.parse("android.resource://$packageName/${R.raw.sample}")

            binding.videoView.setMediaController(mediaController)
            binding.videoView.setVideoURI(onlineUrl)
            binding.videoView.requestFocus()
            binding.videoView.start()

        }

    }

//    private fun playVideo() {
//        if (mediaController == null) {
//            mediaController = MediaController(this)
//            mediaController!!.setAnchorView(this.binding.videoView)
//        }
//        binding.videoView!!.setMediaController(mediaController)
//        binding.videoView!!.setVideoURI(Uri.parse(videoUrl))
//
//        binding.videoView!!.requestFocus()
//        binding.videoView!!.pause()
//        binding.videoView!!.setOnCompletionListener {
//            Toast.makeText(this, "Video Selesai", Toast.LENGTH_SHORT).show()
//        }
//        binding.videoView!!.setOnErrorListener { mediaPlayer, i, i2 ->
//            Toast.makeText(applicationContext, "Eror", Toast.LENGTH_SHORT).show()
//            false
//        }
//    }
}