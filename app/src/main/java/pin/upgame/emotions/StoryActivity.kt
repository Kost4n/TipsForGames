package pin.upgame.emotions

import android.content.Intent
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import pin.upgame.emotions.databinding.ActivityStoryBinding

class StoryActivity: AppCompatActivity() {
    private lateinit var binding: ActivityStoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoryBinding.inflate(layoutInflater)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)

        val story = intent.extras?.getString("story")

        setStory(story!!)
        setButtonsStory()

        setContentView(binding.root)
    }

    private fun setButtonsStory() {
        binding.buttonImageHome.setOnClickListener {
            startActivity(myIntentStory("main"))
        }
        binding.buttonImagePlay.setOnClickListener {
            startActivity(myIntentStory("play"))
        }

        /* TODO add image polit */
    }

    private fun myIntentStory(clas: String): Intent {
        val mi = when(clas) {
            "main" -> Intent(this, MainPageActivity::class.java)
            "play" -> Intent(this, PlaySlotsActivity::class.java)
            else -> {Intent(this, MainPageActivity::class.java)}
        }
        return mi
    }

    private fun setStory(story: String) {
        when(story) {
            "history" -> {
                binding.imageStoryTitle.setImageResource(R.drawable.title_story_history)
                val text = "A casino is a place where people gather to try their luck and enjoy gambling. His story began much earlier than many might have expected.\n" +
                        "\n" +
                        "Let's go back to the times of Ancient China. There, in distant provinces, groups of people gathered to play various games of chance. They used dice, cards and other objects to determine their luck. It was a simple and fun way to pass the time and get the adrenaline pumping.\n" +
                        "\n" +
                        "Over time, gambling has spread throughout the world. Their popularity grew, and various forms of gambling establishments emerged in different countries. So, in Italy, special houses appeared where you could bet on cards, dominoes and other games. The first real casinos appeared in France, where people could gather and enjoy the excitement.\n" +
                        "However, the most famous place where the casino acquired its modern form was Las Vegas, the gambling capital of the world. At the beginning of the 20th century, Las Vegas was a small desert town, but with the legalization of gambling, it became a center of entertainment culture. Glittering casinos, huge hotels and show programs attracted tourists from all over the world. This place has become a symbol of the gambling industry."
                binding.textStory.text = text
            }
            "tips" -> {
                binding.imageStoryTitle.setImageResource(R.drawable.title_story_tips_dice)
                val text = "Familiarize yourself with the rules: Before you play, make sure you fully understand the rules of the dice game you choose. Learn how points are calculated, which combinations are winning and what bets you can make.\n" +
                        "\n" +
                        "Manage your bankroll: Set a budget for the game and stick to it. Never bet more than you can afford to lose. Set limits on your bets and stick to them.\n" +
                        "\n" +
                        "Learn Strategies: Some craps games, such as Craps, have specific strategies that can help you achieve big wins or reduce the risk of losses. Learn these strategies and apply them when playing.\n" +
                        "\n" +
                        "Be realistic: Dice games are based on chance and no one can guarantee consistent wins. Be realistic in your expectations and don't rely solely on luck. It's important to play for fun and enjoy the process.\n" +
                        "\n" +
                        "Set Time Limits: Playing dice can be fun and it's easy to lose track of time. Set play time limits to avoid excessive fatigue or loss of control.\n" +
                        "Don't try to win it all back: If you have a bad experience and lost some bets, don't try to win it all back right away. Take a break, relax and make betting decisions based on common sense, not emotions.\n" +
                        "\n" +
                        "Enjoy the game: The main thing is to enjoy the game and the process of rolling the dice. Smile, enjoy the excitement and communication with other players. Remember that craps are pure entertainment and winning is an added bonus.\n" +
                        "\n" +
                        "Good luck with your future dice games! \uD83C\uDFB2\uD83C\uDF40"
                binding.textStory.text = text
            }
            "facts" -> {
                binding.imageStoryTitle.setImageResource(R.drawable.title_story_facts)
                val text = "The oldest casino: The oldest casino in the world is located in Italy and is called \"Ridotto\". It was opened in 1638 and still continues to receive visitors.\n" +
                        "\n" +
                        "Largest Casino: The largest casino in the world is located in Macau, China and is called the Venetian Casino. Its area is more than 51,000 square meters.\n" +
                        "\n" +
                        "Casino Bans: Casinos are still banned in some countries. For example, in Japan, casinos were banned until 2018, while in Singapore, casinos were only introduced in 2005.\n" +
                        "\n" +
                        "Record winnings: Many people achieve huge winnings in casinos. The biggest casino win was recorded in Las Vegas, when one lucky person won over \$39 million on the Megabucks slot machine.\n" +
                        "Special Rules: Some casinos have strange rules or rituals. For example, in some Asian casinos it is usually considered unlucky if someone touches a player's shoulder while playing.\n" +
                        "\n" +
                        "Online Casinos: With the development of the internet and technology, online casinos have become popular where people can gamble right from their home. Online casinos offer a wide selection of games and the convenience of playing at any time.\n" +
                        "\n" +
                        "Casino Effect: Some studies have shown that casino environments and lighting can affect players' mood. Bright lighting and noise can create a feeling of excitement and stimulate gambling behavior.\n" +
                        "\n" +
                        "I hope you enjoyed these interesting casino facts! \uD83C\uDFB0\uD83D\uDE03"
                binding.textStory.text = text
            }
        }
    }
}