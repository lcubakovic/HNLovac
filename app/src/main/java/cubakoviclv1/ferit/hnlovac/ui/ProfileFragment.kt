package cubakoviclv1.ferit.hnlovac.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.auth.User
import com.google.firebase.firestore.ktx.getField
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.db.LogInFragment
import cubakoviclv1.ferit.hnlovac.db.UserData

class ProfileFragment : Fragment() {

    lateinit var auth: FirebaseAuth
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    lateinit var fStore: FirebaseFirestore
    lateinit var documentReference: DocumentReference

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_profile, container, false)
        val btn_logout = v.findViewById<Button>(R.id.btn_logout)
        val tv_email = v.findViewById<TextView>(R.id.tv_email)
        val tv_userID = v.findViewById<TextView>(R.id.tv_userID)
        val navigationView =  getActivity()?.findViewById<NavigationView>(R.id.navView);
        val headerView = navigationView?.getHeaderView(0)
        val tv_email_header = headerView?.findViewById<TextView>(R.id.tv_email_header)
        val tv_name_header = headerView?.findViewById<TextView>(R.id.tv_name_header)


        navigationView?.menu?.findItem(R.id.nav_login)?.setVisible(false)
        navigationView?.menu?.findItem(R.id.nav_logout)?.setVisible(true)
        navigationView?.menu?.findItem(R.id.nav_activity)?.setVisible(true)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database!!.reference.child("profile")
        fStore = FirebaseFirestore.getInstance()

        val user = auth.currentUser

        tv_userID.text = Editable.Factory.getInstance().newEditable("UserID:  " + user?.uid)
        tv_email.text = Editable.Factory.getInstance().newEditable("Email:  " + user?.email)

        tv_email_header?.text = Editable.Factory.getInstance().newEditable(user?.email)
        tv_email_header?.visibility = View.VISIBLE

//        fun readFirestoreData() {
//            fStore.collection("users")
//                    .get()
//                    .addOnCompleteListener {
//                        val result: StringBuffer = StringBuffer()
//                        if (it.isSuccessful) {
//                            for (document in it.result) {
//                                result.append(document.data.get("firstname")).append(" ")
//                                        .append(document.data.get("lastname")).append(" ")
//                            }
//                            tv_name_header?.text = result
//                            tv_name_header?.visibility = View.VISIBLE
//                        }
//                    }
//            }
//
//        readFirestoreData()

        btn_logout.setOnClickListener {
            navigationView?.menu?.findItem(R.id.nav_login)?.setVisible(true)
            navigationView?.menu?.findItem(R.id.nav_logout)?.setVisible(false)
            navigationView?.menu?.findItem(R.id.nav_activity)?.setVisible(false)
            tv_email_header?.visibility = View.INVISIBLE
            auth.signOut()
            val logInFragment = LogInFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, LogInFragment())
            transaction.commit()
        }

            return v
        }
    }

