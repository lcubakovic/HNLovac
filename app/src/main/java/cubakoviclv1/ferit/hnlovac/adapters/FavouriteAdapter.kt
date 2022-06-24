import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.db.Team
import cubakoviclv1.ferit.hnlovac.topScorersModel.Data
import cubakoviclv1.ferit.hnlovac.ui.ActivityFragment
import kotlinx.android.synthetic.main.list_item.view.*

class FavouriteAdapter(private val context: Activity, private val arrayList: List<Team>) : ArrayAdapter<Team>(context,
R.layout.list_item, arrayList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.list_item, null)

        val imageView: ImageView = view.findViewById(R.id.ivTeam)
        val tv_teamname: TextView = view.findViewById(R.id.tv_teamName)


        imageView.setImageResource(arrayList[position].image)
        tv_teamname.text = (arrayList[position].name)

        return view
    }


}