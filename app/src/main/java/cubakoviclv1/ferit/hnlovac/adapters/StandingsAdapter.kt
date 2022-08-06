package cubakoviclv1.ferit.hnlovac

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.databinding.ItemTableBinding
import cubakoviclv1.ferit.hnlovac.models.standingsModel.Item


class StandingsAdapter(val context: Context, val list: List<Item>): RecyclerView.Adapter<StandingsAdapter.TableViewHolder>() {

    class TableViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = ItemTableBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        return TableViewHolder(LayoutInflater.from(context).inflate(R.layout.item_table, parent, false))
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {

        val item = list[position]

        if (item.Id == 131 ) {
            holder.binding.clubLogo.setImageResource(R.drawable.dinamo)
            holder.binding.clubName.text = "GNK Dinamo Zagreb"
        }
        else if (item.Id == 139) {
            holder.binding.clubName.text = "NK Osijek"

            holder.binding.clubLogo.setImageResource(R.drawable.osijek)
        }
        else if (item.Id == 134) {
            holder.binding.clubName.text = "HNK Hajduk Split"
            holder.binding.clubLogo.setImageResource(R.drawable.hajduk)

        }
        else if (item.Id == 138) {
            holder.binding.clubName.text = "HNK Rijeka"
            holder.binding.clubLogo.setImageResource(R.drawable.rijeka)

        }
        else if (item.Id == 140) {
            holder.binding.clubName.text = "NK Lokomotiva"
            holder.binding.clubLogo.setImageResource(R.drawable.lokomotiva)

        }
        else if (item.Id == 132) {
            holder.binding.clubName.text = "NK Gorica"
            holder.binding.clubLogo.setImageResource(R.drawable.gorica)

        }
        else if (item.Id == 137) {
            holder.binding.clubName.text = "NK Slaven Belupo"
            holder.binding.clubLogo.setImageResource(R.drawable.slaven)

        }
        else if (item.Id == 133) {
            holder.binding.clubName.text = "NK Istra 1961"
            holder.binding.clubLogo.setImageResource(R.drawable.istra)

        }
        else if (item.Id == 136) {
            holder.binding.clubName.text = "HNK Šibenik"
            holder.binding.clubLogo.setImageResource(R.drawable.sibenik)

        }
        else if (item.Id == 135) {
            holder.binding.clubName.text = "NK Varaždin"
            holder.binding.clubLogo.setImageResource(R.drawable.varazdin)
        }

            val goalDifference = ((item.GoalsScored) - (item.GoalsConceded))

            holder.binding.position.text = item.Rank.toString()
            holder.binding.gamesPlayed.text = item.TotalMatches.toString()
            holder.binding.gamesVictory.text = item.Won.toString()
            holder.binding.gamesDrawn.text = item.Drew.toString()
            holder.binding.gamesLoss.text = item.Lost.toString()
            holder.binding.points.text = item.Points.toString()
            holder.binding.goalDifference.text = goalDifference.toString()


    }

    override fun getItemCount(): Int {
        return list.size
    }

}