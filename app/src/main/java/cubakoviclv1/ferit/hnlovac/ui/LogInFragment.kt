package cubakoviclv1.ferit.hnlovac.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.FragmentTransaction
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.ordercheaper.UI.PhoneAuthFragment


class LogInFragment : Fragment() {

    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    private lateinit var googleSignInClient: GoogleSignInClient

    private companion object {
        private const val RC_SIGN_IN = 100
        private const val TAG = "GOOGLE_SIGN_IN_TAG"
    }


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
        val navigationView =  getActivity()?.findViewById<NavigationView>(R.id.navView);
        val btn_google_login = v.findViewById<Button>(R.id.btn_google_login)
        val btn_phone_login = v.findViewById<Button>(R.id.btn_phone_login)

        btn_phone_login.setOnClickListener {
            val phoneAuthFragment = PhoneAuthFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, PhoneAuthFragment())
            transaction.commit()
        }

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


        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(requireActivity(), googleSignInOptions)


        btn_google_login.setOnClickListener() {
            Log.d(TAG, "onCreate: begin Google SignIn")
            val intent = googleSignInClient.signInIntent
            startActivityForResult(intent,RC_SIGN_IN)
        }

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

        val user = auth.currentUser

        if(user != null) {
            val settingsFragment = ProfileFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, ProfileFragment())
            transaction.commit()
        }

        return v
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == RC_SIGN_IN) {
            Log.d(TAG, "onActivityResult: Google SignIn intent result")
            val accountTask = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = accountTask.result
                firebaseAuthWithGoogleAccount(account)
            } catch (e: Exception) {
                Log.d(TAG, "onActivityResult: ${e.message}")
            }
        }
    }

    private fun firebaseAuthWithGoogleAccount(account: GoogleSignInAccount?) {
        Log.d(TAG, "firebaseAuthWithGoogleAccount: begin firebase auth with google account")
        val credential = GoogleAuthProvider.getCredential(account!!.idToken, null)
        auth.signInWithCredential(credential)
            .addOnSuccessListener { authResult ->
                Log.d(TAG, "firebaseAuthWithGoogleAccount: LoggedIn successful")

                val firebaseUser = auth.currentUser
                val  uid = firebaseUser!!.uid
                val email = firebaseUser.email

                Log.d(TAG, "firebaseAuthWithGoogleAccount: Uid: $uid")
                Log.d(TAG, "firebaseAuthWithGoogleAccount: Email: $email")

                if(authResult.additionalUserInfo!!.isNewUser) {
                    Log.d(TAG, "firebaseAuthWithGoogleAccount: Account created... \n$email")
                    Toast.makeText(requireContext(), "Account created... \n$email", Toast.LENGTH_SHORT).show()
                } else {
                    Log.d(TAG, "firebaseAuthWithGoogleAccount: Existing user... \$email")
                    Toast.makeText(requireContext(), "Logged In... \n$email", Toast.LENGTH_SHORT).show()
                }
                val fragmentAccountSettings = ProfileFragment()
                val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_layout, ProfileFragment())
                transaction.commit()

            }
            .addOnFailureListener {
                    e ->
                Log.d(TAG, "firebaseAuthWithGoogleAccount: Login Failed due to ${e.message}")
                Toast.makeText(requireContext(), "Login Failed due to ${e.message}", Toast.LENGTH_SHORT).show()

            }
    }
}