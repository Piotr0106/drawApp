package pl.gda.wsb.drawapp.ui.draw

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.gda.wsb.drawapp.databinding.PairBinding
import pl.gda.wsb.drawapp.models.Name

class PairAdapter(private val listOfNames: List<List<Name>>): RecyclerView.Adapter<PairViewHolder>() {
    private lateinit var binding: PairBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PairViewHolder {
        binding = PairBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val layoutInflater = LayoutInflater.from(parent.context)
        val pairBinding = PairBinding.inflate(layoutInflater, parent, false)

        return PairViewHolder(pairBinding)
    }

    override fun onBindViewHolder(holder: PairViewHolder, position: Int) {
        val list: List<Name> = listOfNames[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int {
        return listOfNames.size
    }
}

class PairViewHolder(private val binding: PairBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(list: List<Name>){
        binding.list = list
        binding.executePendingBindings()
    }
}