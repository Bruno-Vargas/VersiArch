package versignassi.com.versiarch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import versignassi.com.versiarch.ui.UserActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginLoginBtnClicked(view:View){

    }
    fun loginCreateuserBtnClicked(view: View){

        val createUserIntent = Intent(this, UserActivity::class.java)
        startActivity(createUserIntent)
    }

}
