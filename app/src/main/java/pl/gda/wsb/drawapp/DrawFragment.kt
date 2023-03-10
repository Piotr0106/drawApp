package pl.gda.wsb.drawapp

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import pl.gda.wsb.drawapp.databinding.FragmentDrawBinding
import pl.gda.wsb.drawapp.models.Name

class DrawFragment : Fragment() {
    private lateinit var binding: FragmentDrawBinding
    private lateinit var viewModel: DrawViewModel
    private lateinit var elementAdapter: ElementAdapter
    private lateinit var pairAdapter: PairAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_draw, container, false
        )

        viewModel = DrawViewModel()
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        val mediaPlayer: MediaPlayer = MediaPlayer.create(requireContext(), R.raw.ucl)
        mediaPlayer.start()
        mediaPlayer.isLooping = true
        viewModel.events
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { handleEvent(it) }

        viewModel.list.observe(viewLifecycleOwner) { names ->

            val layoutManager = LinearLayoutManager(requireContext())
            binding.listOfNames.layoutManager = layoutManager
            elementAdapter = ElementAdapter(names)
            binding.listOfNames.adapter = elementAdapter

            binding.drawButton.setOnClickListener {
                val layoutManager1 = LinearLayoutManager(requireContext())
                binding.drawnNames.layoutManager = layoutManager1
                pairAdapter = PairAdapter(draw(names))
                binding.drawnNames.adapter = pairAdapter
                val mediaPlayer2: MediaPlayer = MediaPlayer.create(requireContext(), R.raw.kaszanka)
                mediaPlayer.pause()
                mediaPlayer2.start()
                mediaPlayer2.setOnCompletionListener {
                    mediaPlayer.start()
                }
            }
        }

        return binding.root
    }


    private fun draw(list: List<Name>): List<List<Name>> {
        //check if the number of elements is even
        if (list.size % 2 == 0) {
            var counter = 0
            for (elem in list) {
                if (elem.pot == 1) {
                    counter += 1
                }
            }
            //check if there are equal number of teams in each pot
            if (counter == list.size / 2) {

                //draw process
                val drawnList = mutableListOf<List<Name>>()
                val potOne = mutableListOf<Name>()
                val potTwo = mutableListOf<Name>()
                for (elem in list) {
                    if (elem.pot == 1) {
                        potOne.add(elem)
                    } else {
                        potTwo.add(elem)
                    }
                }
                while (potOne.size >= 1 && potTwo.size >= 1) {

                    val ele = potOne.random()
                    potOne.remove(ele)
                    val ele2 = potTwo.random()
                    potTwo.remove(ele2)
                    val miniList = listOf(ele, ele2)
                    drawnList.add(miniList)
                }

                return drawnList.toList()
            } else if (counter == list.size) {
                val drawnList = mutableListOf<List<Name>>()
                val mutableList = list.toMutableList()
                while (mutableList.size >= 1) {

                    val ele = mutableList.random()
                    mutableList.remove(ele)
                    val ele2 = mutableList.random()
                    mutableList.remove(ele2)
                    val miniList = listOf(ele, ele2)
                    drawnList.add(miniList)
                }
                return drawnList.toList()
            }
            //not equal number of teams in each pot
            else {
                Snackbar.make(
                    binding.root,
                    "Podział zespołów na koszyki musi być równy!",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
        return listOf()

    }

    private fun handleEvent(event: DrawViewModel.Event) {
        when (event) {
            is DrawViewModel.Event.OnAddNameClick -> {
                viewModel.list.observe(viewLifecycleOwner) { list ->
                    elementAdapter.notifyItemInserted(list.size)

                    for (elem in list) {
                        Log.i("names", "${elem.name}, ${elem.pot}")
                    }
                }
                binding.editText.text = null
            }
        }
    }
}