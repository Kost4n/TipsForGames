package pin.upgame.emotions

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.preference.PreferenceManager
import android.view.View
import android.view.Window
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import pin.upgame.emotions.databinding.ActivityMainpageBinding

class MainPageActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

       val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)

        if (isFirstRun) {
            val view = layoutInflater.inflate(R.layout.frame_bonus, null)
            setContentView(view)
            view.findViewById<ImageView>(R.id.gift_close).setOnClickListener { v ->
                v.visibility = View.GONE
                view.findViewById<ImageView>(R.id.gift_open).visibility = View.VISIBLE
                view.findViewById<ImageView>(R.id.gift_open_cap).visibility = View.VISIBLE
                view.findViewById<ImageView>(R.id.bonus_score).visibility = View.VISIBLE
                view.findViewById<ImageView>(R.id.bonus_text).visibility = View.VISIBLE
                startTimer()
                val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
                sharedPreferences.edit().putBoolean("isFirstRun", false).apply()
            }
        } else {
            setBindingView()
        }
    }

    private fun startTimer() {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                setBindingView()
            }
        }.start()

    }

    private fun setBindingView() {
        binding = ActivityMainpageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setButtonsMain()
    }

    private fun setButtonsMain() {
        binding.imagePlayGame.setOnClickListener {
            startActivity(myIntentMain("play"))
        }
        binding.buttonImagePlay.setOnClickListener {
            startActivity(myIntentMain("play"))
        }
        binding.storyHistory.setOnClickListener {
            startStory("history")
        }
        binding.storyFacts.setOnClickListener {
            startStory("facts")
        }
        binding.storyDice.setOnClickListener {
            startStory("tips")
        }
        /* TODO add image polit*/
    }

    private fun startStory(story: String) {
        startActivity(
            Intent(this, StoryActivity::class.java)
                .putExtra("story", story)
        )
    }

    private fun myIntentMain(clas: String): Intent {
        val mi = when(clas) {
            "main" -> Intent(this, MainPageActivity::class.java)
            "play" -> Intent(this, PlaySlotsActivity::class.java)
            else -> {
                Intent(this, MainPageActivity::class.java)
            }
        }
        return mi
    }
}



