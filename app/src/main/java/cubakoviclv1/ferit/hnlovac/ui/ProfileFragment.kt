package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import android.text.Editable
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import cubakoviclv1.ferit.hnlovac.R

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
        val tv_email = v.findViewById<TextView>(R.id.tv_email)
        val tv_userID = v.findViewById<TextView>(R.id.tv_userID)
        val navigationView =  getActivity()?.findViewById<NavigationView>(R.id.navView);
        val headerView = navigationView?.getHeaderView(0)

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database!!.reference.child("profile")
        fStore = FirebaseFirestore.getInstance()

        val user = auth.currentUser

        tv_userID.text = Editable.Factory.getInstance().newEditable("UserID:  " + user?.uid)
        tv_email.text = Editable.Factory.getInstance().newEditable("Email:  " + user?.email)


        return v
    }
    }

