package cubakoviclv1.ferit.hnlovac.ui

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import cubakoviclv1.ferit.hnlovac.databinding.ActivityFavouriteBinding
import cubakoviclv1.ferit.hnlovac.data_classes.FavouriteLineup
import kotlinx.android.synthetic.main.activity_favourite.*
import java.util.HashMap

class FavouriteActivity: AppCompatActivity() {

    private lateinit var binding: ActivityFavouriteBinding
    var databaseReference: DatabaseReference? = null
    var database: FirebaseDatabase? = null
    lateinit var fStore: FirebaseFirestore
    lateinit var documentReference: DocumentReference
    lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityFavouriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")

        auth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()
        databaseReference = database!!.reference.child("postava")
        fStore = FirebaseFirestore.getInstance()

        btn_setData.setOnClickListener {


            if (name == "GNK Dinamo Zagreb") {
                btn_setData.setOnClickListener {
                    val currentUser = auth.currentUser
                    val currentUserDb = databaseReference?.child(currentUser?.uid!!)

                    if (TextUtils.isEmpty(et_gk.text.toString())) {
                        et_gk.setError("Molimo vas unesite ime/prezime golmana!")
                    }
                    else if(TextUtils.isEmpty(et_cb.text.toString()))
                    {
                        et_cb.setError("Molimo vas unesite ime/prezime stopera!")
                    }
                    else if(TextUtils.isEmpty(et_cb2.text.toString()))
                    {
                        et_cb2.setError("Molimo vas unesite ime/prezime stopera!")
                    }
                    else if(TextUtils.isEmpty(et_lb.text.toString()))
                    {
                        et_lb.setError("Molimo vas unesite ime/prezime lijevog beka!")
                    }
                    else if(TextUtils.isEmpty(et_rb.text.toString()))
                    {
                        et_rb.setError("Molimo vas unesite ime/prezime desnog beka!")
                    }
                    else if(TextUtils.isEmpty(et_cm.text.toString()))
                    {
                        et_cm.setError("Molimo vas unesite ime/prezime veznjaka!")
                    }
                    else if(TextUtils.isEmpty(et_cm2.text.toString()))
                    {
                        et_cm2.setError("Molimo vas unesite ime/prezime veznjaka!")
                    }
                    else if(TextUtils.isEmpty(et_cm3.text.toString()))
                    {
                        et_cm3.setError("Molimo vas unesite ime/prezime veznjaka!")
                    }
                    else if(TextUtils.isEmpty(et_cf.text.toString()))
                    {
                        et_cf.setError("Molimo vas unesite ime/prezime centarfora!")
                    }

                    else if(TextUtils.isEmpty(et_lw.text.toString()))
                    {
                        et_lw.setError("Molimo vas unesite ime/prezime lijevog krilnog napadača!")
                    }

                    else if(TextUtils.isEmpty(et_rw.text.toString()))
                    {
                        et_rw.setError("Molimo vas unesite ime/prezime desnog krilnog napadača!")
                    }
                    else  {
                        currentUserDb?.child(("golman"))?.setValue(et_gk.text.toString())
                        currentUserDb?.child(("stoper"))?.setValue(et_cb.text.toString())
                        currentUserDb?.child(("stoper2"))?.setValue(et_cb2.text.toString())
                        currentUserDb?.child(("lijevi_bek"))?.setValue(et_lb.text.toString())
                        currentUserDb?.child(("desni_bek"))?.setValue(et_rb.text.toString())
                        currentUserDb?.child(("veza"))?.setValue(et_cm.text.toString())
                        currentUserDb?.child(("veza1"))?.setValue(et_cm2.text.toString())
                        currentUserDb?.child(("veza2"))?.setValue(et_cm3.text.toString())
                        currentUserDb?.child(("lijevo_krilo"))?.setValue(et_lw.text.toString())
                        currentUserDb?.child(("desno_krilo"))?.setValue(et_rw.text.toString())
                        currentUserDb?.child(("napadac"))?.setValue(et_cf.text.toString())

                        val setLineupData = FavouriteLineup(
                            et_gk.text.toString(),
                            et_cb.text.toString(), et_cb2.text.toString(), et_lb.text.toString(),
                            et_rb.text.toString(), et_cm.text.toString(), et_cm2.text.toString(),
                            et_cm3.text.toString(), et_lw.text.toString(), et_rw.text.toString(),
                            et_cf.text.toString()
                        )

                        documentReference = fStore.collection("postava").document(currentUser?.uid!!)
                        val postava: MutableMap<String, Any> = HashMap<String, Any>()
                        postava.put("DINAMO", setLineupData)
                        documentReference.set(postava)

                        Toast.makeText(this, "Podaci su poslani, hvala!", Toast.LENGTH_LONG).show()
                    }

                }
            }

        }

        if (name == "NK Osijek") {
            btn_setData.setOnClickListener {
                val currentUser = auth.currentUser
                val currentUserDb = databaseReference?.child(currentUser?.uid!!)

                if (TextUtils.isEmpty(et_gk.text.toString())) {
                    et_gk.setError("Molimo vas unesite ime/prezime golmana!")
                }
                else if(TextUtils.isEmpty(et_cb.text.toString()))
                {
                    et_cb.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_cb2.text.toString()))
                {
                    et_cb2.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_lb.text.toString()))
                {
                    et_lb.setError("Molimo vas unesite ime/prezime lijevog beka!")
                }
                else if(TextUtils.isEmpty(et_rb.text.toString()))
                {
                    et_rb.setError("Molimo vas unesite ime/prezime desnog beka!")
                }
                else if(TextUtils.isEmpty(et_cm.text.toString()))
                {
                    et_cm.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm2.text.toString()))
                {
                    et_cm2.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm3.text.toString()))
                {
                    et_cm3.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cf.text.toString()))
                {
                    et_cf.setError("Molimo vas unesite ime/prezime centarfora!")
                }

                else if(TextUtils.isEmpty(et_lw.text.toString()))
                {
                    et_lw.setError("Molimo vas unesite ime/prezime lijevog krilnog napadača!")
                }

                else if(TextUtils.isEmpty(et_rw.text.toString()))
                {
                    et_rw.setError("Molimo vas unesite ime/prezime desnog krilnog napadača!")
                }
                else {
                    currentUserDb?.child(("golman"))?.setValue(et_gk.text.toString())
                    currentUserDb?.child(("stoper"))?.setValue(et_cb.text.toString())
                    currentUserDb?.child(("stoper2"))?.setValue(et_cb2.text.toString())
                    currentUserDb?.child(("lijevi_bek"))?.setValue(et_lb.text.toString())
                    currentUserDb?.child(("desni_bek"))?.setValue(et_rb.text.toString())
                    currentUserDb?.child(("veza"))?.setValue(et_cm.text.toString())
                    currentUserDb?.child(("veza1"))?.setValue(et_cm2.text.toString())
                    currentUserDb?.child(("veza2"))?.setValue(et_cm3.text.toString())
                    currentUserDb?.child(("lijevo_krilo"))?.setValue(et_lw.text.toString())
                    currentUserDb?.child(("desno_krilo"))?.setValue(et_rw.text.toString())
                    currentUserDb?.child(("napadac"))?.setValue(et_cf.text.toString())

                    val setLineupData = FavouriteLineup(
                        et_gk.text.toString(),
                        et_cb.text.toString(), et_cb2.text.toString(), et_lb.text.toString(),
                        et_rb.text.toString(), et_cm.text.toString(), et_cm2.text.toString(),
                        et_cm3.text.toString(), et_lw.text.toString(), et_rw.text.toString(),
                        et_cf.text.toString()
                    )

                    documentReference = fStore.collection("postava").document(currentUser?.uid!!)
                    val postava: MutableMap<String, Any> = HashMap<String, Any>()
                    postava.put("OSIJEK", setLineupData)
                    documentReference.set(postava)

                    Toast.makeText(this, "Podaci su poslani, hvala!", Toast.LENGTH_LONG).show()
                }

            }
        }


        if (name == "HNK Rijeka") {
            btn_setData.setOnClickListener {
                val currentUser = auth.currentUser
                val currentUserDb = databaseReference?.child(currentUser?.uid!!)

                if (TextUtils.isEmpty(et_gk.text.toString())) {
                    et_gk.setError("Molimo vas unesite ime/prezime golmana!")
                } else if (TextUtils.isEmpty(et_cb.text.toString())) {
                    et_cb.setError("Molimo vas unesite ime/prezime stopera!")
                } else if (TextUtils.isEmpty(et_cb2.text.toString())) {
                    et_cb2.setError("Molimo vas unesite ime/prezime stopera!")
                } else if (TextUtils.isEmpty(et_lb.text.toString())) {
                    et_lb.setError("Molimo vas unesite ime/prezime lijevog beka!")
                } else if (TextUtils.isEmpty(et_rb.text.toString())) {
                    et_rb.setError("Molimo vas unesite ime/prezime desnog beka!")
                } else if (TextUtils.isEmpty(et_cm.text.toString())) {
                    et_cm.setError("Molimo vas unesite ime/prezime veznjaka!")
                } else if (TextUtils.isEmpty(et_cm2.text.toString())) {
                    et_cm2.setError("Molimo vas unesite ime/prezime veznjaka!")
                } else if (TextUtils.isEmpty(et_cm3.text.toString())) {
                    et_cm3.setError("Molimo vas unesite ime/prezime veznjaka!")
                } else if (TextUtils.isEmpty(et_cf.text.toString())) {
                    et_cf.setError("Molimo vas unesite ime/prezime centarfora!")
                } else if (TextUtils.isEmpty(et_lw.text.toString())) {
                    et_lw.setError("Molimo vas unesite ime/prezime lijevog krilnog napadača!")
                } else if (TextUtils.isEmpty(et_rw.text.toString())) {
                    et_rw.setError("Molimo vas unesite ime/prezime desnog krilnog napadača!")
                } else {
                    currentUserDb?.child(("golman"))?.setValue(et_gk.text.toString())
                    currentUserDb?.child(("stoper"))?.setValue(et_cb.text.toString())
                    currentUserDb?.child(("stoper2"))?.setValue(et_cb2.text.toString())
                    currentUserDb?.child(("lijevi_bek"))?.setValue(et_lb.text.toString())
                    currentUserDb?.child(("desni_bek"))?.setValue(et_rb.text.toString())
                    currentUserDb?.child(("veza"))?.setValue(et_cm.text.toString())
                    currentUserDb?.child(("veza1"))?.setValue(et_cm2.text.toString())
                    currentUserDb?.child(("veza2"))?.setValue(et_cm3.text.toString())
                    currentUserDb?.child(("lijevo_krilo"))?.setValue(et_lw.text.toString())
                    currentUserDb?.child(("desno_krilo"))?.setValue(et_rw.text.toString())
                    currentUserDb?.child(("napadac"))?.setValue(et_cf.text.toString())

                    val setLineupData = FavouriteLineup(
                        et_gk.text.toString(),
                        et_cb.text.toString(), et_cb2.text.toString(), et_lb.text.toString(),
                        et_rb.text.toString(), et_cm.text.toString(), et_cm2.text.toString(),
                        et_cm3.text.toString(), et_lw.text.toString(), et_rw.text.toString(),
                        et_cf.text.toString()
                    )

                    documentReference = fStore.collection("postava").document(currentUser?.uid!!)
                    val postava: MutableMap<String, Any> = HashMap<String, Any>()
                    postava.put("RIJEKA", setLineupData)
                    documentReference.set(postava)

                    Toast.makeText(this, "Podaci su poslani, hvala!", Toast.LENGTH_LONG).show()
                }

            }
        }

        if (name == "NK Lokomotiva Zagreb") {
            btn_setData.setOnClickListener {
                val currentUser = auth.currentUser
                val currentUserDb = databaseReference?.child(currentUser?.uid!!)

                if (TextUtils.isEmpty(et_gk.text.toString())) {
                    et_gk.setError("Molimo vas unesite ime/prezime golmana!")
                }
                else if(TextUtils.isEmpty(et_cb.text.toString()))
                {
                    et_cb.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_cb2.text.toString()))
                {
                    et_cb2.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_lb.text.toString()))
                {
                    et_lb.setError("Molimo vas unesite ime/prezime lijevog beka!")
                }
                else if(TextUtils.isEmpty(et_rb.text.toString()))
                {
                    et_rb.setError("Molimo vas unesite ime/prezime desnog beka!")
                }
                else if(TextUtils.isEmpty(et_cm.text.toString()))
                {
                    et_cm.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm2.text.toString()))
                {
                    et_cm2.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm3.text.toString()))
                {
                    et_cm3.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cf.text.toString()))
                {
                    et_cf.setError("Molimo vas unesite ime/prezime centarfora!")
                }

                else if(TextUtils.isEmpty(et_lw.text.toString()))
                {
                    et_lw.setError("Molimo vas unesite ime/prezime lijevog krilnog napadača!")
                }

                else if(TextUtils.isEmpty(et_rw.text.toString()))
                {
                    et_rw.setError("Molimo vas unesite ime/prezime desnog krilnog napadača!")
                }
                else {
                    currentUserDb?.child(("golman"))?.setValue(et_gk.text.toString())
                    currentUserDb?.child(("stoper"))?.setValue(et_cb.text.toString())
                    currentUserDb?.child(("stoper2"))?.setValue(et_cb2.text.toString())
                    currentUserDb?.child(("lijevi_bek"))?.setValue(et_lb.text.toString())
                    currentUserDb?.child(("desni_bek"))?.setValue(et_rb.text.toString())
                    currentUserDb?.child(("veza"))?.setValue(et_cm.text.toString())
                    currentUserDb?.child(("veza1"))?.setValue(et_cm2.text.toString())
                    currentUserDb?.child(("veza2"))?.setValue(et_cm3.text.toString())
                    currentUserDb?.child(("lijevo_krilo"))?.setValue(et_lw.text.toString())
                    currentUserDb?.child(("desno_krilo"))?.setValue(et_rw.text.toString())
                    currentUserDb?.child(("napadac"))?.setValue(et_cf.text.toString())

                    val setLineupData = FavouriteLineup(
                        et_gk.text.toString(),
                        et_cb.text.toString(), et_cb2.text.toString(), et_lb.text.toString(),
                        et_rb.text.toString(), et_cm.text.toString(), et_cm2.text.toString(),
                        et_cm3.text.toString(), et_lw.text.toString(), et_rw.text.toString(),
                        et_cf.text.toString()
                    )

                    documentReference = fStore.collection("postava").document(currentUser?.uid!!)
                    val postava: MutableMap<String, Any> = HashMap<String, Any>()
                    postava.put("LOKOMOTIVA", setLineupData)
                    documentReference.set(postava)

                    Toast.makeText(this, "Podaci su poslani, hvala!", Toast.LENGTH_LONG).show()
                }
            }
        }

        if (name == "NK Gorica") {
            btn_setData.setOnClickListener {
                val currentUser = auth.currentUser
                val currentUserDb = databaseReference?.child(currentUser?.uid!!)

                if (TextUtils.isEmpty(et_gk.text.toString())) {
                    et_gk.setError("Molimo vas unesite ime/prezime golmana!")
                }
                else if(TextUtils.isEmpty(et_cb.text.toString()))
                {
                    et_cb.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_cb2.text.toString()))
                {
                    et_cb2.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_lb.text.toString()))
                {
                    et_lb.setError("Molimo vas unesite ime/prezime lijevog beka!")
                }
                else if(TextUtils.isEmpty(et_rb.text.toString()))
                {
                    et_rb.setError("Molimo vas unesite ime/prezime desnog beka!")
                }
                else if(TextUtils.isEmpty(et_cm.text.toString()))
                {
                    et_cm.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm2.text.toString()))
                {
                    et_cm2.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm3.text.toString()))
                {
                    et_cm3.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cf.text.toString()))
                {
                    et_cf.setError("Molimo vas unesite ime/prezime centarfora!")
                }

                else if(TextUtils.isEmpty(et_lw.text.toString()))
                {
                    et_lw.setError("Molimo vas unesite ime/prezime lijevog krilnog napadača!")
                }

                else if(TextUtils.isEmpty(et_rw.text.toString()))
                {
                    et_rw.setError("Molimo vas unesite ime/prezime desnog krilnog napadača!")
                }
                else {
                    currentUserDb?.child(("golman"))?.setValue(et_gk.text.toString())
                    currentUserDb?.child(("stoper"))?.setValue(et_cb.text.toString())
                    currentUserDb?.child(("stoper2"))?.setValue(et_cb2.text.toString())
                    currentUserDb?.child(("lijevi_bek"))?.setValue(et_lb.text.toString())
                    currentUserDb?.child(("desni_bek"))?.setValue(et_rb.text.toString())
                    currentUserDb?.child(("veza"))?.setValue(et_cm.text.toString())
                    currentUserDb?.child(("veza1"))?.setValue(et_cm2.text.toString())
                    currentUserDb?.child(("veza2"))?.setValue(et_cm3.text.toString())
                    currentUserDb?.child(("lijevo_krilo"))?.setValue(et_lw.text.toString())
                    currentUserDb?.child(("desno_krilo"))?.setValue(et_rw.text.toString())
                    currentUserDb?.child(("napadac"))?.setValue(et_cf.text.toString())

                    val setLineupData = FavouriteLineup(
                        et_gk.text.toString(),
                        et_cb.text.toString(), et_cb2.text.toString(), et_lb.text.toString(),
                        et_rb.text.toString(), et_cm.text.toString(), et_cm2.text.toString(),
                        et_cm3.text.toString(), et_lw.text.toString(), et_rw.text.toString(),
                        et_cf.text.toString()
                    )

                    documentReference = fStore.collection("postava").document(currentUser?.uid!!)
                    val postava: MutableMap<String, Any> = HashMap<String, Any>()
                    postava.put("GORICA", setLineupData)
                    documentReference.set(postava)

                    Toast.makeText(this, "Podaci su poslani, hvala!", Toast.LENGTH_LONG).show()
                }
            }
        }

        if (name == "NK Slaven Belupo") {
            btn_setData.setOnClickListener {
                val currentUser = auth.currentUser
                val currentUserDb = databaseReference?.child(currentUser?.uid!!)

                if (TextUtils.isEmpty(et_gk.text.toString())) {
                    et_gk.setError("Molimo vas unesite ime/prezime golmana!")
                }
                else if(TextUtils.isEmpty(et_cb.text.toString()))
                {
                    et_cb.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_cb2.text.toString()))
                {
                    et_cb2.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_lb.text.toString()))
                {
                    et_lb.setError("Molimo vas unesite ime/prezime lijevog beka!")
                }
                else if(TextUtils.isEmpty(et_rb.text.toString()))
                {
                    et_rb.setError("Molimo vas unesite ime/prezime desnog beka!")
                }
                else if(TextUtils.isEmpty(et_cm.text.toString()))
                {
                    et_cm.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm2.text.toString()))
                {
                    et_cm2.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm3.text.toString()))
                {
                    et_cm3.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cf.text.toString()))
                {
                    et_cf.setError("Molimo vas unesite ime/prezime centarfora!")
                }

                else if(TextUtils.isEmpty(et_lw.text.toString()))
                {
                    et_lw.setError("Molimo vas unesite ime/prezime lijevog krilnog napadača!")
                }

                else if(TextUtils.isEmpty(et_rw.text.toString()))
                {
                    et_rw.setError("Molimo vas unesite ime/prezime desnog krilnog napadača!")
                }
                else {
                    currentUserDb?.child(("golman"))?.setValue(et_gk.text.toString())
                    currentUserDb?.child(("stoper"))?.setValue(et_cb.text.toString())
                    currentUserDb?.child(("stoper2"))?.setValue(et_cb2.text.toString())
                    currentUserDb?.child(("lijevi_bek"))?.setValue(et_lb.text.toString())
                    currentUserDb?.child(("desni_bek"))?.setValue(et_rb.text.toString())
                    currentUserDb?.child(("veza"))?.setValue(et_cm.text.toString())
                    currentUserDb?.child(("veza1"))?.setValue(et_cm2.text.toString())
                    currentUserDb?.child(("veza2"))?.setValue(et_cm3.text.toString())
                    currentUserDb?.child(("lijevo_krilo"))?.setValue(et_lw.text.toString())
                    currentUserDb?.child(("desno_krilo"))?.setValue(et_rw.text.toString())
                    currentUserDb?.child(("napadac"))?.setValue(et_cf.text.toString())

                    val setLineupData = FavouriteLineup(
                        et_gk.text.toString(),
                        et_cb.text.toString(), et_cb2.text.toString(), et_lb.text.toString(),
                        et_rb.text.toString(), et_cm.text.toString(), et_cm2.text.toString(),
                        et_cm3.text.toString(), et_lw.text.toString(), et_rw.text.toString(),
                        et_cf.text.toString()
                    )

                    documentReference = fStore.collection("postava").document(currentUser?.uid!!)
                    val postava: MutableMap<String, Any> = HashMap<String, Any>()
                    postava.put("SLAVEN", setLineupData)
                    documentReference.set(postava)

                    Toast.makeText(this, "Podaci su poslani, hvala!", Toast.LENGTH_LONG).show()
                }
            }
        }

        if (name == "NK Istra 1961") {
            btn_setData.setOnClickListener {
                val currentUser = auth.currentUser
                val currentUserDb = databaseReference?.child(currentUser?.uid!!)

                if (TextUtils.isEmpty(et_gk.text.toString())) {
                    et_gk.setError("Molimo vas unesite ime/prezime golmana!")
                }
                else if(TextUtils.isEmpty(et_cb.text.toString()))
                {
                    et_cb.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_cb2.text.toString()))
                {
                    et_cb2.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_lb.text.toString()))
                {
                    et_lb.setError("Molimo vas unesite ime/prezime lijevog beka!")
                }
                else if(TextUtils.isEmpty(et_rb.text.toString()))
                {
                    et_rb.setError("Molimo vas unesite ime/prezime desnog beka!")
                }
                else if(TextUtils.isEmpty(et_cm.text.toString()))
                {
                    et_cm.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm2.text.toString()))
                {
                    et_cm2.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm3.text.toString()))
                {
                    et_cm3.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cf.text.toString()))
                {
                    et_cf.setError("Molimo vas unesite ime/prezime centarfora!")
                }

                else if(TextUtils.isEmpty(et_lw.text.toString()))
                {
                    et_lw.setError("Molimo vas unesite ime/prezime lijevog krilnog napadača!")
                }

                else if(TextUtils.isEmpty(et_rw.text.toString()))
                {
                    et_rw.setError("Molimo vas unesite ime/prezime desnog krilnog napadača!")
                }
                else {
                    currentUserDb?.child(("golman"))?.setValue(et_gk.text.toString())
                    currentUserDb?.child(("stoper"))?.setValue(et_cb.text.toString())
                    currentUserDb?.child(("stoper2"))?.setValue(et_cb2.text.toString())
                    currentUserDb?.child(("lijevi_bek"))?.setValue(et_lb.text.toString())
                    currentUserDb?.child(("desni_bek"))?.setValue(et_rb.text.toString())
                    currentUserDb?.child(("veza"))?.setValue(et_cm.text.toString())
                    currentUserDb?.child(("veza1"))?.setValue(et_cm2.text.toString())
                    currentUserDb?.child(("veza2"))?.setValue(et_cm3.text.toString())
                    currentUserDb?.child(("lijevo_krilo"))?.setValue(et_lw.text.toString())
                    currentUserDb?.child(("desno_krilo"))?.setValue(et_rw.text.toString())
                    currentUserDb?.child(("napadac"))?.setValue(et_cf.text.toString())

                    val setLineupData = FavouriteLineup(
                        et_gk.text.toString(),
                        et_cb.text.toString(), et_cb2.text.toString(), et_lb.text.toString(),
                        et_rb.text.toString(), et_cm.text.toString(), et_cm2.text.toString(),
                        et_cm3.text.toString(), et_lw.text.toString(), et_rw.text.toString(),
                        et_cf.text.toString()
                    )

                    documentReference = fStore.collection("postava").document(currentUser?.uid!!)
                    val postava: MutableMap<String, Any> = HashMap<String, Any>()
                    postava.put("ISTRA", setLineupData)
                    documentReference.set(postava)

                    Toast.makeText(this, "Podaci su poslani, hvala!", Toast.LENGTH_LONG).show()
                }
            }
        }

        if (name == "HNK Šibenik") {
            btn_setData.setOnClickListener {
                val currentUser = auth.currentUser
                val currentUserDb = databaseReference?.child(currentUser?.uid!!)

                if (TextUtils.isEmpty(et_gk.text.toString())) {
                    et_gk.setError("Molimo vas unesite ime/prezime golmana!")
                }
                else if(TextUtils.isEmpty(et_cb.text.toString()))
                {
                    et_cb.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_cb2.text.toString()))
                {
                    et_cb2.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_lb.text.toString()))
                {
                    et_lb.setError("Molimo vas unesite ime/prezime lijevog beka!")
                }
                else if(TextUtils.isEmpty(et_rb.text.toString()))
                {
                    et_rb.setError("Molimo vas unesite ime/prezime desnog beka!")
                }
                else if(TextUtils.isEmpty(et_cm.text.toString()))
                {
                    et_cm.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm2.text.toString()))
                {
                    et_cm2.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm3.text.toString()))
                {
                    et_cm3.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cf.text.toString()))
                {
                    et_cf.setError("Molimo vas unesite ime/prezime centarfora!")
                }

                else if(TextUtils.isEmpty(et_lw.text.toString()))
                {
                    et_lw.setError("Molimo vas unesite ime/prezime lijevog krilnog napadača!")
                }

                else if(TextUtils.isEmpty(et_rw.text.toString()))
                {
                    et_rw.setError("Molimo vas unesite ime/prezime desnog krilnog napadača!")
                }
                else {
                    currentUserDb?.child(("golman"))?.setValue(et_gk.text.toString())
                    currentUserDb?.child(("stoper"))?.setValue(et_cb.text.toString())
                    currentUserDb?.child(("stoper2"))?.setValue(et_cb2.text.toString())
                    currentUserDb?.child(("lijevi_bek"))?.setValue(et_lb.text.toString())
                    currentUserDb?.child(("desni_bek"))?.setValue(et_rb.text.toString())
                    currentUserDb?.child(("veza"))?.setValue(et_cm.text.toString())
                    currentUserDb?.child(("veza1"))?.setValue(et_cm2.text.toString())
                    currentUserDb?.child(("veza2"))?.setValue(et_cm3.text.toString())
                    currentUserDb?.child(("lijevo_krilo"))?.setValue(et_lw.text.toString())
                    currentUserDb?.child(("desno_krilo"))?.setValue(et_rw.text.toString())
                    currentUserDb?.child(("napadac"))?.setValue(et_cf.text.toString())

                    val setLineupData = FavouriteLineup(
                        et_gk.text.toString(),
                        et_cb.text.toString(), et_cb2.text.toString(), et_lb.text.toString(),
                        et_rb.text.toString(), et_cm.text.toString(), et_cm2.text.toString(),
                        et_cm3.text.toString(), et_lw.text.toString(), et_rw.text.toString(),
                        et_cf.text.toString()
                    )

                    documentReference = fStore.collection("postava").document(currentUser?.uid!!)
                    val postava: MutableMap<String, Any> = HashMap<String, Any>()
                    postava.put("SIBENIK", setLineupData)
                    documentReference.set(postava)

                    Toast.makeText(this, "Podaci su poslani, hvala!", Toast.LENGTH_LONG).show()
                }
            }
        }

        if (name == "NK Hrvatski Dragovoljac") {
            btn_setData.setOnClickListener {
                val currentUser = auth.currentUser
                val currentUserDb = databaseReference?.child(currentUser?.uid!!)

                if (TextUtils.isEmpty(et_gk.text.toString())) {
                    et_gk.setError("Molimo vas unesite ime/prezime golmana!")
                }
                else if(TextUtils.isEmpty(et_cb.text.toString()))
                {
                    et_cb.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_cb2.text.toString()))
                {
                    et_cb2.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_lb.text.toString()))
                {
                    et_lb.setError("Molimo vas unesite ime/prezime lijevog beka!")
                }
                else if(TextUtils.isEmpty(et_rb.text.toString()))
                {
                    et_rb.setError("Molimo vas unesite ime/prezime desnog beka!")
                }
                else if(TextUtils.isEmpty(et_cm.text.toString()))
                {
                    et_cm.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm2.text.toString()))
                {
                    et_cm2.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm3.text.toString()))
                {
                    et_cm3.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cf.text.toString()))
                {
                    et_cf.setError("Molimo vas unesite ime/prezime centarfora!")
                }

                else if(TextUtils.isEmpty(et_lw.text.toString()))
                {
                    et_lw.setError("Molimo vas unesite ime/prezime lijevog krilnog napadača!")
                }

                else if(TextUtils.isEmpty(et_rw.text.toString()))
                {
                    et_rw.setError("Molimo vas unesite ime/prezime desnog krilnog napadača!")
                }
                else {
                    currentUserDb?.child(("golman"))?.setValue(et_gk.text.toString())
                    currentUserDb?.child(("stoper"))?.setValue(et_cb.text.toString())
                    currentUserDb?.child(("stoper2"))?.setValue(et_cb2.text.toString())
                    currentUserDb?.child(("lijevi_bek"))?.setValue(et_lb.text.toString())
                    currentUserDb?.child(("desni_bek"))?.setValue(et_rb.text.toString())
                    currentUserDb?.child(("veza"))?.setValue(et_cm.text.toString())
                    currentUserDb?.child(("veza1"))?.setValue(et_cm2.text.toString())
                    currentUserDb?.child(("veza2"))?.setValue(et_cm3.text.toString())
                    currentUserDb?.child(("lijevo_krilo"))?.setValue(et_lw.text.toString())
                    currentUserDb?.child(("desno_krilo"))?.setValue(et_rw.text.toString())
                    currentUserDb?.child(("napadac"))?.setValue(et_cf.text.toString())

                    val setLineupData = FavouriteLineup(
                        et_gk.text.toString(),
                        et_cb.text.toString(), et_cb2.text.toString(), et_lb.text.toString(),
                        et_rb.text.toString(), et_cm.text.toString(), et_cm2.text.toString(),
                        et_cm3.text.toString(), et_lw.text.toString(), et_rw.text.toString(),
                        et_cf.text.toString()
                    )

                    documentReference = fStore.collection("postava").document(currentUser?.uid!!)
                    val postava: MutableMap<String, Any> = HashMap<String, Any>()
                    postava.put("DRAGOVOLJAC", setLineupData)
                    documentReference.set(postava)

                    Toast.makeText(this, "Podaci su poslani, hvala!", Toast.LENGTH_LONG).show()
                }
            }
        }

        if (name == "HNK Hajduk Split") {
            btn_setData.setOnClickListener {
                val currentUser = auth.currentUser
                val currentUserDb = databaseReference?.child(currentUser?.uid!!)

                if (TextUtils.isEmpty(et_gk.text.toString())) {
                    et_gk.setError("Molimo vas unesite ime/prezime golmana!")
                }
                else if(TextUtils.isEmpty(et_cb.text.toString()))
                {
                    et_cb.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_cb2.text.toString()))
                {
                    et_cb2.setError("Molimo vas unesite ime/prezime stopera!")
                }
                else if(TextUtils.isEmpty(et_lb.text.toString()))
                {
                    et_lb.setError("Molimo vas unesite ime/prezime lijevog beka!")
                }
                else if(TextUtils.isEmpty(et_rb.text.toString()))
                {
                    et_rb.setError("Molimo vas unesite ime/prezime desnog beka!")
                }
                else if(TextUtils.isEmpty(et_cm.text.toString()))
                {
                    et_cm.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm2.text.toString()))
                {
                    et_cm2.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cm3.text.toString()))
                {
                    et_cm3.setError("Molimo vas unesite ime/prezime veznjaka!")
                }
                else if(TextUtils.isEmpty(et_cf.text.toString()))
                {
                    et_cf.setError("Molimo vas unesite ime/prezime centarfora!")
                }

                else if(TextUtils.isEmpty(et_lw.text.toString()))
                {
                    et_lw.setError("Molimo vas unesite ime/prezime lijevog krilnog napadača!")
                }

                else if(TextUtils.isEmpty(et_rw.text.toString()))
                {
                    et_rw.setError("Molimo vas unesite ime/prezime desnog krilnog napadača!")
                }
                else {
                    currentUserDb?.child(("golman"))?.setValue(et_gk.text.toString())
                    currentUserDb?.child(("stoper"))?.setValue(et_cb.text.toString())
                    currentUserDb?.child(("stoper2"))?.setValue(et_cb2.text.toString())
                    currentUserDb?.child(("lijevi_bek"))?.setValue(et_lb.text.toString())
                    currentUserDb?.child(("desni_bek"))?.setValue(et_rb.text.toString())
                    currentUserDb?.child(("veza"))?.setValue(et_cm.text.toString())
                    currentUserDb?.child(("veza1"))?.setValue(et_cm2.text.toString())
                    currentUserDb?.child(("veza2"))?.setValue(et_cm3.text.toString())
                    currentUserDb?.child(("lijevo_krilo"))?.setValue(et_lw.text.toString())
                    currentUserDb?.child(("desno_krilo"))?.setValue(et_rw.text.toString())
                    currentUserDb?.child(("napadac"))?.setValue(et_cf.text.toString())

                    val setLineupData = FavouriteLineup(
                        et_gk.text.toString(),
                        et_cb.text.toString(), et_cb2.text.toString(), et_lb.text.toString(),
                        et_rb.text.toString(), et_cm.text.toString(), et_cm2.text.toString(),
                        et_cm3.text.toString(), et_lw.text.toString(), et_rw.text.toString(),
                        et_cf.text.toString()
                    )

                    documentReference = fStore.collection("postava").document(currentUser?.uid!!)
                    val postava: MutableMap<String, Any> = HashMap<String, Any>()
                    postava.put("HAJDUK", setLineupData)
                    documentReference.set(postava)

                    Toast.makeText(this, "Podaci su poslani, hvala!", Toast.LENGTH_LONG).show()
                }
            }
        }



    }


}