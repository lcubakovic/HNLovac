package cubakoviclv1.ferit.hnlovac

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.databinding.FragmentScorersBinding
import cubakoviclv1.ferit.hnlovac.databinding.ItemScorersBinding
import cubakoviclv1.ferit.hnlovac.databinding.ItemTableBinding
import cubakoviclv1.ferit.hnlovac.standingsModel.Standing
import cubakoviclv1.ferit.hnlovac.topScorersModel.Data

@Suppress("NAME_SHADOWING")
class TopScorersAdapter(val context: Context, val list: List<Data>): RecyclerView.Adapter<TopScorersAdapter.ScorersViewHolder>() {

    class ScorersViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = ItemScorersBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScorersViewHolder {
        return ScorersViewHolder(LayoutInflater.from(context).inflate(R.layout.item_scorers, parent,false))
    }

    override fun onBindViewHolder(holder: ScorersViewHolder, position: Int) {
        val item = list[position]
            holder.binding.playerPosition.text = item.pos.toString()
            holder.binding.playerName.text = item.player.player_name
            holder.binding.goalsScored.text = item.goals.overall.toString()
            holder.binding.matchesPlayed.text = item.matches_played.toString()

        }

    override fun getItemCount(): Int {
        return list.size
    }
}