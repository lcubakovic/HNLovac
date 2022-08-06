package cubakoviclv1.ferit.hnlovac

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.databinding.ItemScorersBinding
import cubakoviclv1.ferit.hnlovac.models.topScorersModel.Result

@Suppress("NAME_SHADOWING")
class TopScorersAdapter(val context: Context, val list: List<Result>): RecyclerView.Adapter<TopScorersAdapter.ScorersViewHolder>() {

    class ScorersViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = ItemScorersBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScorersViewHolder {
        return ScorersViewHolder(LayoutInflater.from(context).inflate(R.layout.item_scorers, parent,false))
    }

    override fun onBindViewHolder(holder: ScorersViewHolder, position: Int) {
        val item = list[position]


        if (item.team.name == "GNK Dinamo Zagreb") {
            holder.binding.ivPlayer.setImageResource(R.drawable.dinamo)
        }
        else if (item.team.name == "NK Osijek") {
            holder.binding.ivPlayer.setImageResource(R.drawable.osijek)
        }
        else if (item.team.name == "HNK Hajduk Split") {
            holder.binding.ivPlayer.setImageResource(R.drawable.hajduk)

        }
        else if (item.team.name =="HNK Rijeka") {
            holder.binding.ivPlayer.setImageResource(R.drawable.rijeka)

        }
        else if (item.team.name == "NK Lokomotiva Zagreb") {
            holder.binding.ivPlayer.setImageResource(R.drawable.lokomotiva)

        }
        else if (item.team.name == "NK Gorica") {
            holder.binding.ivPlayer.setImageResource(R.drawable.gorica)

        }
        else if (item.team.name == "NK Slaven Belupo") {
            holder.binding.ivPlayer.setImageResource(R.drawable.slaven)

        }
        else if (item.team.name== "NK Istra 1961") {
            holder.binding.ivPlayer.setImageResource(R.drawable.istra)

        }
        else if (item.team.name == "HNK Šibenik") {
            holder.binding.ivPlayer.setImageResource(R.drawable.sibenik)

        }
        else if (item.team.name == "NK Varaždin") {
            holder.binding.ivPlayer.setImageResource(R.drawable.varazdin)
        }


            holder.binding.playerPosition.text = item.rating.toString()
            holder.binding.playerName.text = item.player.name
            holder.binding.goalsScored.text = item.goals.toString()
            holder.binding.driblings.text = item.successfulDribbles.toString()
            holder.binding.chancesMissed.text = item.bigChancesMissed.toString()
            holder.binding.shots.text = item.totalShots.toString()
            holder.binding.goalPercentage.text = (item.goalConversionPercentage.toString() +"%")

    }

    override fun getItemCount(): Int {
        return list.size
    }
}