package pin.upgame.emotions

import android.content.Intent
import android.graphics.PointF
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.SCROLL_STATE_IDLE
import pin.upgame.emotions.databinding.ActivitySlotsBinding
import pin.upgame.emotions.slots.Items_RVAdapter
import pin.upgame.emotions.slots.RecycleItemDecoration


class PlaySlotsActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySlotsBinding
    private var score = 1500
    private var bet = 50
    private lateinit var adapter1: Items_RVAdapter
    private lateinit var adapter2: Items_RVAdapter
    private lateinit var adapter3: Items_RVAdapter
    private lateinit var recycler1: RecyclerView
    private lateinit var recycler2: RecyclerView
    private lateinit var recycler3: RecyclerView
    private val list = listOf(
        R.drawable.apple,
        R.drawable.banana,
        R.drawable.orange,
        R.drawable.star,
        R.drawable.strawberry,
    )
    private var answer1 = 0
    private var answer2 = 0
    private var answer3 = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySlotsBinding.inflate(layoutInflater)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(binding.root)

        setPlayButtons()
        setAdapter()
        setRecViews()
    }

    private fun setAdapter() {
        adapter1 = Items_RVAdapter()
        adapter1.update(list)

        adapter2 = Items_RVAdapter()
        adapter2.update(list)

        adapter3 = Items_RVAdapter()
        adapter3.update(list)
    }

    //
    private fun setRecViews() {
        val itemDecoration = RecycleItemDecoration(22)

        recycler1 = binding.recView1

        recycler1.layoutManager = object : LinearLayoutManager(this) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }

            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recycler1.setHasFixedSize(true)
        recycler1.addItemDecoration(itemDecoration)
        val snapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recycler1)


        recycler1.adapter = adapter1

        recycler2 = binding.recView2

        recycler2.layoutManager = object : LinearLayoutManager(this) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }

            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recycler2.setHasFixedSize(true)
        recycler2.addItemDecoration(itemDecoration)
        recycler2.adapter = adapter2
        snapHelper.attachToRecyclerView(recycler2)

        recycler3 = binding.recView3

        recycler3.layoutManager = object : LinearLayoutManager(this) {
            override fun canScrollHorizontally(): Boolean {
                return false
            }

            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        recycler3.setHasFixedSize(true)
        recycler3.addItemDecoration(itemDecoration)
        snapHelper.attachToRecyclerView(recycler2)


        recycler3.adapter = adapter3
    }

    private fun setPlayButtons() {
        binding.buttonImageHome.setOnClickListener {
            startActivity(Intent(this, MainPageActivity::class.java))
        }
        binding.buttonImageMinus.setOnClickListener {
            changeBet(50, "minus")
        }
        binding.buttonImageSpin.setOnClickListener {
            startSpin()
        }
        binding.buttonImagePlus.setOnClickListener {
            changeBet(50, "plus")
        }
    }

    private fun changeBet(i: Int, s: String) {
        when (s) {
            "plus" -> {
                if (bet + i <= score) {
                    bet += i
                } else {
                    Toast.makeText(this, "You can't put any more", Toast.LENGTH_LONG).show()
                }
            }
            "minus" -> {
                if (bet - i > 0) {
                    bet -= i
                } else {
                    Toast.makeText(this, "You can't put less", Toast.LENGTH_LONG).show()
                }
            }
        }
        binding.textBet.text = "$bet"
    }

    private fun startSpin() {
        if (score - bet > 0) {
            score -= bet
            binding.textScore.text = "$score"
            createItemsLinLayout(recycler1, adapter1)
            createItemsLinLayout(recycler2, adapter2)
            createItemsLinLayout(recycler3, adapter3)
            answer1 = 0
            answer2 = 0
            answer3 = 0
        }
    }

    private fun checkAnswers(answer1: Int, answer2: Int, answer3: Int) {
        if (answer1 != 0 && answer2 != 0 && answer3 != 0) {
            if (answer1 == answer2 && answer2 == answer3) {
                score += (bet * 3)
            } else if (answer1 == answer2 || answer1 == answer3 ||
                answer2 == answer3
            ) {
                score += (bet * 2)
            }
            binding.textScore.text = "$score"
        }
    }

    private fun createItemsLinLayout(recyclerView: RecyclerView, adapter: Items_RVAdapter): Int {
        adapter.update(listOf())
        val locList = mutableListOf<Int>()
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        for (i in list) {
            locList.add(i)
        }
        adapter.update(locList.toList())
        return myScroll(recyclerView, adapter)
    }

    private fun myScroll(recyclerView: RecyclerView, adapter: Items_RVAdapter): Int {
        recyclerView.removeOnScrollListener(onScrollListener)
        recyclerView.addOnScrollListener(onScrollListener)
        val randomInListIndices = (recyclerView.adapter as Items_RVAdapter).itemList.indices.random()
//        val random = (0..(recyclerView.adapter as Items_RVAdapter).itemList.size).random()
        Log.d(
            "lalala",
            "$recyclerView, $randomInListIndices, ${(recyclerView.adapter as Items_RVAdapter).itemList[randomInListIndices]}"
        )
        recyclerView.smoothScrollToPosition(randomInListIndices)
        return (recyclerView.adapter as Items_RVAdapter).itemList[randomInListIndices]
    }

    private var onScrollListener: RecyclerView.OnScrollListener =
        object : RecyclerView.OnScrollListener() {
            private var lastDy = 0
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                when (newState) {
                    SCROLL_STATE_IDLE -> {                   //we reached the target position
                        recyclerView.removeOnScrollListener(this)
                        val lm = recyclerView.layoutManager as LinearLayoutManager?
                        val pos =
                            if (lastDy > 0) lm!!.findLastVisibleItemPosition() else lm!!.findFirstVisibleItemPosition()
                        recyclerView.smoothScrollToPosition(pos)
                        when(recyclerView) {
                            recycler1 -> {
                                answer1 = createAnswer(recyclerView)
                            }
                            recycler2 -> {
                                answer2 = createAnswer(recyclerView)
                            }
                            recycler3 -> {
                                answer3 = createAnswer(recyclerView)
                            }
                        }
                        checkAnswers(answer1, answer2, answer3)
                    }
                }
            }
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                lastDy = dy
            }
        }

    private fun createAnswer(recyclerView: RecyclerView): Int {
        (recyclerView.adapter as Items_RVAdapter).update(listOf())
        var centerImage = 0
        val locList = mutableListOf<Int>()
        val lList = list.shuffled()
        for (i in 0..2) {
            Log.d("ans images", "${lList[i]}, $recyclerView")
            locList.add(lList[i])
            if (i == 1) {
                centerImage = lList[i]
            }
        }
        (recyclerView.adapter as Items_RVAdapter).update(locList.toList())
        return centerImage
    }
}