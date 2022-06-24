package cubakoviclv1.ferit.hnlovac.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.databinding.ItemMatchBinding
import cubakoviclv1.ferit.hnlovac.liveEventsModel.hnl22_23.Event

class LiveAdapter(val context: Context, val list: List<Event>): RecyclerView.Adapter<LiveAdapter.LiveViewHolder>() {


    class LiveViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var binding = ItemMatchBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LiveViewHolder {
        return LiveViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent,false))
    }

    override fun onBindViewHolder(holder: LiveViewHolder, position: Int) {

        val item = list[position]

        if (item.homeTeam.id == 2032 ) {
            holder.binding.ivHomeTeam.setImageResource(R.drawable.dinamo)
        }else if(item.awayTeam.id == 2032) {
            holder.binding.ivAwayTeam.setImageResource(R.drawable.dinamo)
        }

        if (item.homeTeam.id  == 2040 ) {
            holder.binding.ivHomeTeam.setImageResource(R.drawable.osijek)
        }else if(item.awayTeam.id  == 2040) {
            holder.binding.ivAwayTeam.setImageResource(R.drawable.osijek)
        }
        if (item.homeTeam.id == 2036 ) {
            holder.binding.ivHomeTeam.setImageResource(R.drawable.hajduk)
        }else if(item.awayTeam.id  == 2036) {
            holder.binding.ivAwayTeam.setImageResource(R.drawable.hajduk)
        }
        if (item.homeTeam.id  == 2039 ) {
            holder.binding.ivHomeTeam.setImageResource(R.drawable.rijeka)
        }else if(item.awayTeam.id  == 2039) {
            holder.binding.ivAwayTeam.setImageResource(R.drawable.rijeka)
        }
        if (item.homeTeam.id  == 36246 ) {
            holder.binding.ivHomeTeam.setImageResource(R.drawable.lokomotiva)
        }else if(item.awayTeam.id == 36246) {
            holder.binding.ivAwayTeam.setImageResource(R.drawable.lokomotiva)
        }
        if (item.homeTeam.id  == 43917 ) {
            holder.binding.ivHomeTeam.setImageResource(R.drawable.gorica)
        }else if(item.awayTeam.id == 43917) {
            holder.binding.ivAwayTeam.setImageResource(R.drawable.gorica)
        }
        if (item.homeTeam.id == 2042 ) {
            holder.binding.ivHomeTeam.setImageResource(R.drawable.slaven)
        }else if(item.awayTeam.id == 2042) {
            holder.binding.ivAwayTeam.setImageResource(R.drawable.slaven)
        }
        if (item.homeTeam.id  == 25529 ) {
            holder.binding.ivHomeTeam.setImageResource(R.drawable.istra)
        }else if(item.awayTeam.id == 25529) {
            holder.binding.ivAwayTeam.setImageResource(R.drawable.istra)
        }
        if (item.homeTeam.id == 2029 ) {
            holder.binding.ivHomeTeam.setImageResource(R.drawable.sibenik)
        }else if(item.awayTeam.id == 2029) {
            holder.binding.ivAwayTeam.setImageResource(R.drawable.sibenik)
        }
        if (item.homeTeam.id  == 231380 ) {
            holder.binding.ivHomeTeam.setImageResource(R.drawable.varazdin)
        }else if(item.awayTeam.id== 231380) {
            holder.binding.ivAwayTeam.setImageResource(R.drawable.varazdin)
        }

            holder.binding.tvHomeTeam.text = item.homeTeam.name
            holder.binding.tvAwayTeam.text = item.awayTeam.name
//            holder.binding.tvHomeTeamScore.text = item.homeScore.toString()
//            holder.binding.tvAwayTeamScore.text = item.awayScore.toString()
            holder.binding.tvMatchStatus.text = item.status.type
            holder.binding.tvRound.text ="KOLO: " + item.roundInfo.round.toString()
            holder.binding.tvDate.text = item.tournament.uniqueTournament.name

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
