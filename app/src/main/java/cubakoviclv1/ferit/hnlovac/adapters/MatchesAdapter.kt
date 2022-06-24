package cubakoviclv1.ferit.hnlovac.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import cubakoviclv1.ferit.hnlovac.R
import cubakoviclv1.ferit.hnlovac.databinding.ItemMatchBinding
import cubakoviclv1.ferit.hnlovac.matchesModel.Data
import java.util.*
import kotlin.collections.ArrayList

class MatchesAdapter(val context: Context, val list: List<Data>): RecyclerView.Adapter<MatchesAdapter.MatchViewHolder>() {


        class MatchViewHolder(view: View): RecyclerView.ViewHolder(view) {
            var binding = ItemMatchBinding.bind(view)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
            return MatchViewHolder(LayoutInflater.from(context).inflate(R.layout.item_match, parent,false))
        }

        override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {

            val item = list[position]

                if (item.home_team.team_id == 2047) {
                    holder.binding.ivHomeTeam.setImageResource(R.drawable.dinamo)
                } else if (item.away_team.team_id == 2047) {
                    holder.binding.ivAwayTeam.setImageResource(R.drawable.dinamo)
                }

                if (item.home_team.team_id == 2053) {
                    holder.binding.ivHomeTeam.setImageResource(R.drawable.osijek)
                } else if (item.away_team.team_id == 2053) {
                    holder.binding.ivAwayTeam.setImageResource(R.drawable.osijek)
                }
                if (item.home_team.team_id == 2057) {
                    holder.binding.ivHomeTeam.setImageResource(R.drawable.hajduk)
                } else if (item.away_team.team_id == 2057) {
                    holder.binding.ivAwayTeam.setImageResource(R.drawable.hajduk)
                }
                if (item.home_team.team_id == 2067) {
                    holder.binding.ivHomeTeam.setImageResource(R.drawable.rijeka)
                } else if (item.away_team.team_id == 2067) {
                    holder.binding.ivAwayTeam.setImageResource(R.drawable.rijeka)
                }
                if (item.home_team.team_id == 2049) {
                    holder.binding.ivHomeTeam.setImageResource(R.drawable.lokomotiva)
                } else if (item.away_team.team_id == 2049) {
                    holder.binding.ivAwayTeam.setImageResource(R.drawable.lokomotiva)
                }
                if (item.home_team.team_id == 2074) {
                    holder.binding.ivHomeTeam.setImageResource(R.drawable.gorica)
                } else if (item.away_team.team_id == 2074) {
                    holder.binding.ivAwayTeam.setImageResource(R.drawable.gorica)
                }
                if (item.home_team.team_id == 2051) {
                    holder.binding.ivHomeTeam.setImageResource(R.drawable.slaven)
                } else if (item.away_team.team_id == 2051) {
                    holder.binding.ivAwayTeam.setImageResource(R.drawable.slaven)
                }
                if (item.home_team.team_id == 2098) {
                    holder.binding.ivHomeTeam.setImageResource(R.drawable.dragovoljac)
                } else if (item.away_team.team_id == 2098) {
                    holder.binding.ivAwayTeam.setImageResource(R.drawable.dragovoljac)
                }
                if (item.home_team.team_id == 2065) {
                    holder.binding.ivHomeTeam.setImageResource(R.drawable.sibenik)
                } else if (item.away_team.team_id == 2065) {
                    holder.binding.ivAwayTeam.setImageResource(R.drawable.sibenik)
                }
                if (item.home_team.team_id == 2055) {
                    holder.binding.ivHomeTeam.setImageResource(R.drawable.istra)
                } else if (item.away_team.team_id == 2055) {
                    holder.binding.ivAwayTeam.setImageResource(R.drawable.istra)
                }


                holder.binding.tvHomeTeam.text = item.home_team.name
                holder.binding.tvAwayTeam.text = item.away_team.name
                holder.binding.tvHomeTeamScore.text = item.stats.home_score.toString()
                holder.binding.tvAwayTeamScore.text = item.stats.away_score.toString()
                holder.binding.tvMatchStatus.text = item.status
                holder.binding.tvRound.text = "KOLO:  " + item.round.name
                holder.binding.tvDate.text = item.match_start


        }

        override fun getItemCount(): Int {
            return list.size
        }



    }
