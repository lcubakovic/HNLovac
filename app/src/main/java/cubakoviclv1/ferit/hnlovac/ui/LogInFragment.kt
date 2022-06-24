package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import cubakoviclv1.ferit.hnlovac.R


class LogInFragment : Fragment() {

    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_log_in, container, false)
        val tv_register_now = v.findViewById<TextView>(R.id.tv_register_now)
        val et_email = v.findViewById<EditText>(R.id.et_email)
        val et_password = v.findViewById<EditText>(R.id.et_password)
        val btn_login = v.findViewById<Button>(R.id.btn_login)
        val tv_forgot_pass = v.findViewById<TextView>(R.id.tv_forgot_pass)
        val tv_email_header = v.findViewById<TextView>(R.id.tv_email_header)
        val navigationView =  getActivity()?.findViewById<NavigationView>(R.id.navView);

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database!!.reference.child("profile")

        val currentUser = auth.currentUser
        if(currentUser != null) {
            val profileFragment = ProfileFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, ProfileFragment())
            transaction.commit()
        }

        fun login() {
            btn_login.setOnClickListener {
                if (TextUtils.isEmpty(et_email.text.toString())) {
                    et_email.setError("Molimo vas unesite vaš email!")
                    return@setOnClickListener
                } else if (TextUtils.isEmpty(et_password.text.toString())) {
                    et_password.setError("Molimo vas unesite vašu lozinku!")
                    return@setOnClickListener
                }
                    auth.signInWithEmailAndPassword(et_email.text.toString(), et_password.text.toString())
                        .addOnCompleteListener {
                            if (it.isSuccessful) {
                                btn_login.setOnClickListener() {
                                    val profileFragment = ProfileFragment()
                                    val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
                                    transaction.replace(R.id.frame_layout, ProfileFragment())
                                    transaction.commit()
                                }
                            } else {
                                Toast.makeText(requireActivity(), "Prijava nije uspjela, pokušajte ponovno!", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }

            login()

        tv_forgot_pass.setOnClickListener() {
            val forgottenPasswordFragment = ForgottenPasswordFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, ForgottenPasswordFragment())
            transaction.commit()
        }

        tv_register_now.setOnClickListener() {
            val registerFragment = RegisterFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, RegisterFragment())
            transaction.commit()
        }

        return v
    }
}


