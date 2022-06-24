package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import cubakoviclv1.ferit.hnlovac.R

class ForgottenPasswordFragment: Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_forgotten_password, container, false)

        lateinit var auth: FirebaseAuth
        var databaseReference: DatabaseReference? = null
        var database: FirebaseDatabase? = null
        val btn_submit = v.findViewById<Button>(R.id.btn_submit)
        val et_forgot_email = v.findViewById<EditText>(R.id.et_forgot_email)
        val tv_back = v.findViewById<TextView>(R.id.tv_back)

        btn_submit.setOnClickListener {
            val email: String = et_forgot_email.text.toString()
            if (TextUtils.isEmpty(et_forgot_email.text.toString())) {
                et_forgot_email.setError("Please enter your email!")
                return@setOnClickListener
            } else {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                        .addOnCompleteListener{task ->
                            if(task.isSuccessful) {
                                Toast.makeText(requireActivity(), "Email za oporavak je poslan na vašu adresu!", Toast.LENGTH_LONG).show()
                            } else {
                                Toast.makeText(requireActivity(),  task.exception!!.message.toString(), Toast.LENGTH_LONG).show()
                            }
                        }
            }
        }

        tv_back.setOnClickListener() {
            val logInFragment = LogInFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, LogInFragment())
            transaction.commit()
        }


        return v
    }
}