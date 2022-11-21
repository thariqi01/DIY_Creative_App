package thariqi.ruli.diy_creative_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnBoardingItemAdapter(private val onBoardingItem: List<OnBoardingItem>) : RecyclerView.Adapter<OnBoardingItemAdapter.OnBoardingItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingItemViewHolder {
        return OnBoardingItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.onboarding_item_container, parent, false)
        )
    }

    override fun onBindViewHolder(holder: OnBoardingItemViewHolder, position: Int) {
        holder.bind(onBoardingItem[position])
    }

    override fun getItemCount(): Int {
        return onBoardingItem.size
    }

    inner class OnBoardingItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageOnBoarding: ImageView = view.findViewById(R.id.imageOnBoarding)
        private val titleOnBoarding: TextView = view.findViewById(R.id.titleOnBoarding)
        private val descOnBoarding: TextView = view.findViewById(R.id.descOnBoarding)

        fun bind(onBoardingItem: OnBoardingItem) {
            imageOnBoarding.setImageResource(onBoardingItem.imageOnBoarding)
            titleOnBoarding.text = onBoardingItem.titleOnBoarding
            descOnBoarding.text = onBoardingItem.descOnBoarding
        }
    }

}