package cubakoviclv1.ferit.hnlovac

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.databinding.ItemTableBinding
import cubakoviclv1.ferit.hnlovac.standingsModel.Standing

class StandingsAdapter(val context: Context, val list: List<Standing>): RecyclerView.Adapter<StandingsAdapter.TableViewHolder>() {

    class TableViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = ItemTableBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableViewHolder {
        return TableViewHolder(LayoutInflater.from(context).inflate(R.layout.item_table, parent, false))
    }

    override fun onBindViewHolder(holder: TableViewHolder, position: Int) {

        val item = list[position]


        if (item.team_id == 2047 ) {
            holder.binding.clubLogo.setImageResource(R.drawable.dinamo)
            holder.binding.clubName.text = "GNK Dinamo Zagreb"
        }
        else if (item.team_id == 2053) {
            holder.binding.clubName.text = "NK Osijek"

            holder.binding.clubLogo.setImageResource(R.drawable.osijek)
        }
        else if (item.team_id == 2057) {
            holder.binding.clubName.text = "HNK Hajduk Split"
            holder.binding.clubLogo.setImageResource(R.drawable.hajduk)

        }
        else if (item.team_id == 2067) {
            holder.binding.clubName.text = "HNK Rijeka"
            holder.binding.clubLogo.setImageResource(R.drawable.rijeka)

        }
        else if (item.team_id == 2049) {
            holder.binding.clubName.text = "NK Lokomotiva"
            holder.binding.clubLogo.setImageResource(R.drawable.lokomotiva)

        }
        else if (item.team_id == 2074) {
            holder.binding.clubName.text = "NK Gorica"
            holder.binding.clubLogo.setImageResource(R.drawable.gorica)

        }
        else if (item.team_id == 2051) {
            holder.binding.clubName.text = "NK Slaven Belupo"
            holder.binding.clubLogo.setImageResource(R.drawable.slaven)

        }
        else if (item.team_id == 2065) {
            holder.binding.clubName.text = "NK Istra 1961"
            holder.binding.clubLogo.setImageResource(R.drawable.istra)

        }
        else if (item.team_id == 2055) {
            holder.binding.clubName.text = "HNK Šibenik"
            holder.binding.clubLogo.setImageResource(R.drawable.sibenik)

        }
        else if (item.team_id == 2098) {
            holder.binding.clubName.text = "NK Hrvatski Dragovoljac"
            holder.binding.clubLogo.setImageResource(R.drawable.dragovoljac)
        }

            holder.binding.position.text = item.position.toString()
            holder.binding.gamesPlayed.text = item.overall.games_played.toString()
            holder.binding.gamesVictory.text = item.overall.won.toString()
            holder.binding.gamesDrawn.text = item.overall.draw.toString()
            holder.binding.gamesLoss.text = item.overall.lost.toString()
            holder.binding.points.text = item.points.toString()

    }

    override fun getItemCount(): Int {
        return list.size
    }

}