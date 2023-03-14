package pl.gda.wsb.drawapp.tableview

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import de.codecrafters.tableview.TableView
import de.codecrafters.tableview.toolkit.LongPressAwareTableDataAdapter
import pl.gda.wsb.drawapp.models.Club


class ClubTableDataAdapter(context: Context, data: List<Club>, tableView: TableView<Club>) :
    LongPressAwareTableDataAdapter<Club>(context, data, tableView) {

    private fun renderName(club: Club): View {
        val seasonNameString: String = club.name
        val textView = TextView(context)
        textView.text = seasonNameString
        textView.setPadding(20,10,20,10)

        return textView
    }

    private fun renderSeasonOne(club: Club): View {
        val seasonOneString: String = club.seasonOne.toString()
        val textView = TextView(context)
        textView.text = seasonOneString
        textView.setPadding(20,10,20,10)


        return textView
    }

    private fun renderSeasonTwo(club: Club): View {
        val seasonTwoString: String = club.seasonTwo.toString()
        val textView = TextView(context)
        textView.setPadding(20,10,20,10)
        textView.text = seasonTwoString

        return textView
    }

    private fun renderSeasonThree(club: Club): View {
        val seasonThreeString: String = club.seasonThree.toString()
        val textView = TextView(context)
        textView.text = seasonThreeString
        textView.setPadding(20,10,20,10)

        return textView
    }

    private fun renderSeasonFour(club: Club): View {
        val seasonFourString: String = club.seasonFour.toString()
        val textView = TextView(context)
        textView.text = seasonFourString
        textView.setPadding(20,10,20,10)

        return textView
    }

    private fun renderSeasonFive(club: Club): View {
        val seasonFiveString: String = club.seasonFive.toString()
        val textView = TextView(context)
        textView.text = seasonFiveString
        textView.setPadding(20,10,20,10)

        return textView
    }
    private fun renderSum(club: Club): View {
        val sumString = "%.3f".format(club.sum)
        val textView = TextView(context)
        textView.text = sumString
        textView.setPadding(20,10,20,10)

        return textView
    }

    override fun getDefaultCellView(
        rowIndex: Int,
        columnIndex: Int,
        parentView: ViewGroup?
    ): View? {
        val club = getRowData(rowIndex)
        var renderedView: View? = null

        when (columnIndex) {
            0 -> renderedView = renderName(club)
            1 -> renderedView = renderSeasonOne(club)
            2 -> renderedView = renderSeasonTwo(club)
            3 -> renderedView = renderSeasonThree(club)
            4 -> renderedView = renderSeasonFour(club)
            5 -> renderedView = renderSeasonFive(club)
            6 -> renderedView = renderSum(club)
        }
        return renderedView
    }

    override fun getLongPressCellView(
        rowIndex: Int,
        columnIndex: Int,
        parentView: ViewGroup?
    ): View? {
        Log.i("cos", "cos")
        val renderedView: View? = null

        return renderedView
    }


}