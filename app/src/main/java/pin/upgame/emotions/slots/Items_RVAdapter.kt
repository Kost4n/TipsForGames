package pin.upgame.emotions.slots

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import pin.upgame.emotions.R

class Items_RVAdapter: RecyclerView.Adapter<Items_RVAdapter.MyViewHolder>() {
    var itemList = listOf<Int>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val imageBG = itemView.findViewById<ImageView>(R.id.image_fruit)
        fun bind(image: Int, position: Int) {
            imageBG.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.my_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(itemList[position], position)

    fun update(items: List<Int>) {
        itemList = items
        notifyDataSetChanged()
    }
}

class RecycleItemDecoration(
    private val spaceHeight: Int
): RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View,
                                parent: RecyclerView, state: RecyclerView.State) {
        outRect.top = spaceHeight
        outRect.bottom = spaceHeight
    }
}