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
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import cubakoviclv1.ferit.hnlovac.R
import java.util.*
import cubakoviclv1.ferit.hnlovac.db.UserData as UserData


class RegisterFragment: Fragment() {


    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    lateinit var fStore: FirebaseFirestore
    lateinit var documentReference: DocumentReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_register, container, false)
        val tv_login = v.findViewById<TextView>(R.id.tv_login)
        val btn_register = v.findViewById<Button>(R.id.btn_register)
        val et_firstname = v.findViewById<EditText>(R.id.et_firstname)
        val et_lastname = v.findViewById<EditText>(R.id.et_lastaname)
        val et_email = v.findViewById<EditText>(R.id.et_email)
        val et_password = v.findViewById<EditText>(R.id.et_password)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        fStore = FirebaseFirestore.getInstance()
        databaseReference = database!!.reference.child("user")

        fun register() {
            btn_register.setOnClickListener {
                if (TextUtils.isEmpty(et_firstname.text.toString())) {
                    et_firstname.setError("Molimo vas unesite vaše ime!")
                    return@setOnClickListener
                } else if (TextUtils.isEmpty(et_lastname.text.toString())) {
                    et_email.setError("Molimo vas unesite vaše prezime!!")
                    return@setOnClickListener
                } else if (TextUtils.isEmpty(et_email.text.toString())) {
                    et_email.setError("Molimo vas unesite vaš email!")
                    return@setOnClickListener
                } else if (TextUtils.isEmpty(et_password.text.toString())) {
                    et_password.setError("Molimo vas unesite vašu lozinku!")
                    return@setOnClickListener
                }

                auth.createUserWithEmailAndPassword(et_email.text.toString(), et_password.text.toString())
                    .addOnCompleteListener() {
                        if (it.isSuccessful) {
                            val currentUser = auth.currentUser
                            val currentUserDb = databaseReference?.child(currentUser?.uid!!)
                            currentUserDb?.child(("firstname"))?.setValue(et_firstname.text.toString())
                            currentUserDb?.child(("lastname"))?.setValue(et_lastname.text.toString())
                            currentUserDb?.child(("email"))?.setValue(et_email.text.toString())
                            currentUserDb?.child(("password"))?.setValue(et_password.text.toString())

                            val setUserData = UserData(et_firstname.text.toString(), et_lastname.text.toString())

                            documentReference = fStore.collection("users").document(currentUser?.uid!!)
                            val user: MutableMap<String, Any> = HashMap<String, Any>()
                            user.put("Personal Information", setUserData)
                            documentReference.set(user)

                            Toast.makeText(requireActivity(), "Registracija je uspješna!", Toast.LENGTH_LONG).show()

                            val profileFragment = ProfileFragment()
                            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
                            transaction.replace(R.id.frame_layout, ProfileFragment())
                            transaction.commit()

                        } else if (it.isCanceled) {
                            Toast.makeText(requireActivity(), "Registracije je neuspješna, pokušajte ponovno!", Toast.LENGTH_LONG).show()
                        }
                    }


            }
        }

        register()

        tv_login.setOnClickListener() {
            val loginFragment = LogInFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, LogInFragment())
            transaction.commit()
        }
        return v
    }
}