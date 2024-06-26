package otus.gpb.homework.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import otus.gpb.homework.Task2

class MainActivity : AppCompatActivity() {
    private lateinit var buttonOpenA: Button
    private lateinit var buttonOpen2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonOpenA = findViewById(R.id.buttonOpenFragmentA)
        buttonOpen2 = findViewById(R.id.buttonOpenTask2)

        buttonOpenA.setOnClickListener{
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, FragmentA())
                .addToBackStack("My")
                .commit()
            buttonOpenA.visibility = View.GONE
            buttonOpen2.visibility = View.GONE
        }

        buttonOpen2.setOnClickListener{
            val intent = Intent(this, Task2::class.java)
            startActivity(intent)
        }

        supportFragmentManager.addOnBackStackChangedListener {
            val count = supportFragmentManager.backStackEntryCount
            if (count == 0) {
                buttonOpenA.visibility = View.VISIBLE
                buttonOpen2.visibility = View.VISIBLE
            }
        }
    }

}