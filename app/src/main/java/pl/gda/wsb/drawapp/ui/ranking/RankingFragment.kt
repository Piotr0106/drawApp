package pl.gda.wsb.drawapp.ui.ranking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import pl.gda.wsb.drawapp.R
import pl.gda.wsb.drawapp.tableview.ClubTableDataAdapter
import pl.gda.wsb.drawapp.tableview.SortableClubTableView
import pl.gda.wsb.drawapp.databinding.FragmentRankingBinding
import pl.gda.wsb.drawapp.models.DataFactory

class RankingFragment : Fragment() {
    private lateinit var binding: FragmentRankingBinding
    private lateinit var viewModel: RankingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_ranking, container, false
        )

        val clubTableView: SortableClubTableView = binding.ranking
        val clubTableDataAdapter = ClubTableDataAdapter(requireContext(), DataFactory().createClubList(), clubTableView)
        clubTableView.dataAdapter = clubTableDataAdapter


        return binding.root
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[RankingViewModel::class.java]


    }

}