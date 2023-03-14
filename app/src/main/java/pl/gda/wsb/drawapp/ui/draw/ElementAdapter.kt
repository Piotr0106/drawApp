package pl.gda.wsb.drawapp.ui.draw

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pl.gda.wsb.drawapp.databinding.ElementBinding
import pl.gda.wsb.drawapp.models.Name

class ElementAdapter(private val listOfNames: List<Name>): RecyclerView.Adapter<ElementViewHolder>() {
    private lateinit var binding: ElementBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        binding = ElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val layoutInflater = LayoutInflater.from(parent.context)
        val elementBinding = ElementBinding.inflate(layoutInflater, parent, false)

        return ElementViewHolder(elementBinding)
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        val name: Name = listOfNames[position]
        holder.bind(name)


    }

    override fun getItemCount(): Int {
        return listOfNames.size
    }
}

class ElementViewHolder(private val binding: ElementBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(name: Name){
        binding.name = name
        binding.pot1.setOnClickListener {
            name.pot = 1
        }
        binding.pot2.setOnClickListener {
            name.pot = 2
        }
        binding.executePendingBindings()
    }
}
