package cubakoviclv1.ferit.hnlovac.adapters

import android.content.Context
import android.graphics.Typeface
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.databinding.ItemMatchLiveBinding
import cubakoviclv1.ferit.hnlovac.models.liveModel.Event
import kotlinx.android.synthetic.main.fragment_live.view.*
import java.text.SimpleDateFormat
import java.util.*


class LiveAdapter(val context: Context, val list: List<Event>): RecyclerView.Adapter<LiveAdapter.LiveViewHolder>() {

    class LiveViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = ItemMatchLiveBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveViewHolder {
        return LiveViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_match_live,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LiveViewHolder, position: Int) {

        val item = list[position]

        if(item.tournament.name == "HNL") {

            if (item.homeTeam.name == "GNK Dinamo Zagreb") {
                holder.binding.ivHomeTeam.setImageResource(R.drawable.dinamo)
            } else if (item.awayTeam.name == "GNK Dinamo Zagreb") {
                holder.binding.ivAwayTeam.setImageResource(R.drawable.dinamo)
            }

            if (item.homeTeam.name == "NK Osijek") {
                holder.binding.ivHomeTeam.setImageResource(R.drawable.osijek)
            } else if (item.awayTeam.name == "NK Osijek") {
                holder.binding.ivAwayTeam.setImageResource(R.drawable.osijek)
            }

            if (item.homeTeam.name == "HNK Hajduk Split") {
                holder.binding.ivHomeTeam.setImageResource(R.drawable.hajduk)
            } else if (item.awayTeam.name == "HNK Hajduk Split") {
                holder.binding.ivAwayTeam.setImageResource(R.drawable.hajduk)
            }

            if (item.homeTeam.name == "HNK Rijeka") {
                holder.binding.ivHomeTeam.setImageResource(R.drawable.rijeka)
            } else if (item.awayTeam.name == "HNK Rijeka") {
                holder.binding.ivAwayTeam.setImageResource(R.drawable.rijeka)
            }

            if (item.homeTeam.name == "NK Lokomotiva Zagreb") {
                holder.binding.ivHomeTeam.setImageResource(R.drawable.lokomotiva)
            } else if (item.awayTeam.name == "NK Lokomotiva Zagreb") {
                holder.binding.ivAwayTeam.setImageResource(R.drawable.lokomotiva)
            }

            if (item.homeTeam.name == "HNK Gorica") {
                holder.binding.ivHomeTeam.setImageResource(R.drawable.gorica)
            } else if (item.awayTeam.name == "HNK Gorica") {
                holder.binding.ivAwayTeam.setImageResource(R.drawable.gorica)
            }

            if (item.homeTeam.name == "NK Slaven Belupo") {
                holder.binding.ivHomeTeam.setImageResource(R.drawable.slaven)
            } else if (item.awayTeam.name == "NK Slaven Belupo") {
                holder.binding.ivAwayTeam.setImageResource(R.drawable.slaven)
            }

            if (item.homeTeam.name == "NK Istra 1961") {
                holder.binding.ivHomeTeam.setImageResource(R.drawable.istra)
            } else if (item.awayTeam.name == "NK Istra 1961") {
                holder.binding.ivAwayTeam.setImageResource(R.drawable.istra)
            }

            if (item.homeTeam.name == "HNK Šibenik") {
                holder.binding.ivHomeTeam.setImageResource(R.drawable.sibenik)
            } else if (item.awayTeam.name == "HNK Šibenik") {
                holder.binding.ivAwayTeam.setImageResource(R.drawable.sibenik)
            }

            if (item.homeTeam.name == "NK Varaždin") {
                holder.binding.ivHomeTeam.setImageResource(R.drawable.varazdin)
            } else if (item.awayTeam.name == "NK Varaždin") {
                holder.binding.ivAwayTeam.setImageResource(R.drawable.varazdin)
            }


            val simpleDateFormat = SimpleDateFormat("dd. MM. yyyy., HH:mm:ss", Locale.ENGLISH)
            val simpleTimeFormat = SimpleDateFormat("mm", Locale.ENGLISH)

            fun getDateString(time: Int): String = simpleDateFormat.format(time * 1000L)
            fun getTimeString(time: Int): String = simpleTimeFormat.format(time * 1000L)

            val time = item.startTimestamp
            val timeElapsed = item.changes.changeTimestamp

           val date = getDateString(time)

            val currentTime = getTimeString(timeElapsed)


            var status = ""
            var half = ""

            if (item.status.type == "Ended") {
                status = "Završeno"
            } else if (item.status.type == "Postponed") {
                status = "Odgođeno"
            } else if (item.status.type == "inprogress") {
                status = "U tijeku"
            } else if (item.status.type == "Not started") {
                status = "Nije počelo"
            }

            if (item.status.description == "1st half") {
                half = "1. poluvrijeme"
            } else if (item.status.description == "2st half") {
                half = "2. poluvrijeme"
            } else if (item.status.description == "Halftime") {
                half = "Poluvrijeme"
            } else if (item.status.description == "1nd half") {
                half = "1. poluvrijeme"
            } else if (item.status.description == "2nd half") {
                half = "2. poluvrijeme"
            }



            holder.binding.tvHomeTeam.text = item.homeTeam.name
            holder.binding.tvAwayTeam.text = item.awayTeam.name
            holder.binding.tvHomeTeamScore.text = item.homeScore.current.toString()
            holder.binding.tvAwayTeamScore.text = item.awayScore.current.toString()
            holder.binding.tvMatchStatus.text = status
            holder.binding.tvRound.text ="KOLO: " + item.roundInfo.round.toString()
            holder.binding.tvDate.text = date
            //holder.binding.tvCurrentTime.text = currentTime + "'"
            holder.binding.tvCurrentHalf.text = half

            if(item.homeScore.current.toString() > item.awayScore.current.toString()) {
                holder.binding.tvHomeTeamScore.setTypeface(Typeface.DEFAULT_BOLD)
            } else if (item.homeScore.current.toString() < item.awayScore.current.toString()) {
                holder.binding.tvAwayTeamScore.setTypeface(Typeface.DEFAULT_BOLD)
            }

        }
        else {
            holder.itemView.visibility = View.GONE
            holder.itemView.layoutParams = RecyclerView.LayoutParams(0, 0)
        }


    }


    override fun getItemCount(): Int {
        return list.size
    }
}
