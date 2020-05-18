package versignassi.com.versiarch.Controller

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_user.*
import versignassi.com.versiarch.R
import versignassi.com.versiarch.services.AuthService
import versignassi.com.versiarch.services.UserDataService
import kotlin.random.Random

class UserActivity : AppCompatActivity() {

    var userAvatar = "profileDefault"
    var avatarColor = "[o.5,0.5,0.5,1]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
    }


    fun generateUserAvatar(view:View) {
        val random = Random
        val color = random.nextInt(2)
        val avatar = random.nextInt(28)

        if(color == 0){
            userAvatar = "light$avatar"

        } else {
            userAvatar = "dark$avatar"
        }

        val resourceId = resources.getIdentifier(userAvatar, "drawable", packageName)
        createAvatarImageView.setImageResource(resourceId)

    }

    fun generateBackgroundColor(view: View){
        val random = Random
        val r = random.nextInt(255)
        val g = random.nextInt(255)
        val b = random.nextInt(255)

        createAvatarImageView.setBackgroundColor(Color.rgb(r,g,b))

        val savedR = r.toDouble()/255
        val savedG = g.toDouble()/255
        val savedB = b.toDouble()/255

        avatarColor = "[$savedR,$savedG,$savedB]"
        println(avatarColor)
    }

    fun createUserClicked(view:View){


        if(createEmailTxt.text.toString() != null && createPasswordTxt.text.toString() != null)
        {
            var  email = createEmailTxt.text.toString()
            var  password = createPasswordTxt.text.toString()
            var  userName = creteUserNameTxt.text.toString()


            println()
            println()
            AuthService.registerUser(this, email, password) {registerSuccess ->
                if(registerSuccess){
                    AuthService.loginUser(this,email,password){loginSuccess ->
                        if(loginSuccess) {
                            AuthService.createUser(this,userName , email, userAvatar,avatarColor){createSuccess ->
                                if (createSuccess){
                                    println(UserDataService.avatarColor)
                                    println(UserDataService.id)
                                    finish()
                                }
                            }
                        }
                    }
                } else {
                    println("deu ruim")
                }
            }
        }
    }
}
