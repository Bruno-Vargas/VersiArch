package versignassi.com.versiarch.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_user.*
import versignassi.com.versiarch.R
import versignassi.com.versiarch.services.AuthService

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun loginLoginBtnClicked(view:View){
        if(loginEmailTxt.text.toString() != null && loginPasswordTxt.text.toString() != null)
        {
            println(loginEmailTxt.text.toString())
            println(loginPasswordTxt.text.toString())
            AuthService.loginUser(this, loginEmailTxt.text.toString(), loginPasswordTxt.text.toString()) { loginSuccess ->
                if(loginSuccess){
                    println("deu bom" + AuthService.userEmail)
                    println("deu bom" + AuthService.authToken)
                } else {
                    println("deu ruim")
                }
            }
        }
    }
    fun loginCreateuserBtnClicked(view: View){

        val createUserIntent = Intent(this, UserActivity::class.java)
        startActivity(createUserIntent)
    }

}
