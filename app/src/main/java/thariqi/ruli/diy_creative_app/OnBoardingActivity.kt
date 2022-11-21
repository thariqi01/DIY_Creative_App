package thariqi.ruli.diy_creative_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var onBoardingItemAdapter: OnBoardingItemAdapter
    private lateinit var indicatorsContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        supportActionBar?.hide()
        setOnBoardingItem()
        setupIndicators()
        setCurrentIndicators(0)
    }

    private fun setOnBoardingItem() {
        onBoardingItemAdapter = OnBoardingItemAdapter(
            listOf(
                OnBoardingItem(
                    imageOnBoarding = R.drawable.amico,
                    titleOnBoarding = "Cari",
                    descOnBoarding = "Gunakan fitur search untuk menemukan informasi dan tutorial kerajinan tangan sesuai dengan yang anda inginkan."
                ),
                OnBoardingItem(
                    imageOnBoarding = R.drawable.amico2,
                    titleOnBoarding = "Berkreasi",
                    descOnBoarding = "Aplikasi ini membantu anda untuk berkreasi, belajar, dan mengembangkan skill dalam bidang kreatif kerajinan tangan."
                ),
                OnBoardingItem(
                    imageOnBoarding = R.drawable.amico3,
                    titleOnBoarding = "Komunitas",
                    descOnBoarding = "Tersedia fitur komunitas untuk mengumpulkan orang-orang yang menyukai pada bidang kerajinan tangan untuk berinteraksi."
                ),
                OnBoardingItem(
                    imageOnBoarding = R.drawable.amico4,
                    titleOnBoarding = "Market",
                    descOnBoarding = "Anda dapat melakukan jual  beli kerajinan tangan yang telah anda buat dan yang dibuat oleh pengguna lain pada fitur market."
                )
            )
        )
        val onBoardingViewPager: ViewPager2 = findViewById(R.id.onBoardingViewPager)
        onBoardingViewPager.adapter = onBoardingItemAdapter
        onBoardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    setCurrentIndicators(position)
                }
            }
        )
        (onBoardingViewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

        findViewById<Button>(R.id.button).setOnClickListener {
//            if (onBoardingViewPager.currentItem + 1 < onBoardingItemAdapter.itemCount) {
//                onBoardingViewPager.currentItem += 1
//            }else {
                navigateToRegisterActivity()
//            }
        }
    }

    private fun navigateToRegisterActivity() {
        startActivity(Intent(applicationContext, RegisterActivity::class.java))
        finish()
    }

    private fun setupIndicators() {
        indicatorsContainer = findViewById(R.id.onBoardingIndicators)
        val indicators = arrayOfNulls<ImageView>(onBoardingItemAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(15,0,15,0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let {
                it.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                it.layoutParams = layoutParams
                indicatorsContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicators(position: Int) {
        val childCount = indicatorsContainer.childCount
        for(i in 0 until childCount) {
            val imageView = indicatorsContainer.getChildAt(i) as ImageView
            if(i == position) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            }else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

}