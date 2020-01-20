package nao.toyama.mvrxicecream.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import nao.toyama.mvrxicecream.app.databinding.ActivityMainBinding
import nao.toyama.mvrxicecream.app.fragments.PhotoListFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, PhotoListFragment())
            .commit()
    }
}
