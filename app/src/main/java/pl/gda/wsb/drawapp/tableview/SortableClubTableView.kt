package pl.gda.wsb.drawapp.tableview

import android.R.attr.listViewStyle
import android.content.Context
import android.util.AttributeSet
import de.codecrafters.tableview.SortableTableView
import de.codecrafters.tableview.model.TableColumnWeightModel
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter
import de.codecrafters.tableview.toolkit.SortStateViewProviders
import de.codecrafters.tableview.toolkit.TableDataRowBackgroundProviders
import pl.gda.wsb.drawapp.ClubComparators
import pl.gda.wsb.drawapp.R
import pl.gda.wsb.drawapp.models.Club


class SortableClubTableView : SortableTableView<Club> {
    constructor(context: Context) : this(context, null)
    constructor (context: Context, attributes: AttributeSet?) : this(context, attributes, listViewStyle)
    constructor(context: Context, attributes: AttributeSet?, styleAttributes: Int):super(context, attributes, styleAttributes) {
        val simpleTableHeaderAdapter = SimpleTableHeaderAdapter(
            context,
            "Kraj",
            "18/19",
            "19/20",
            "20/21",
            "21/22",
            "22/23",
            "Suma"
        )

        headerAdapter = simpleTableHeaderAdapter
        headerSortStateViewProvider = SortStateViewProviders.brightArrows()
        val tableColumnWeightModel = TableColumnWeightModel(7)
        tableColumnWeightModel.setColumnWeight(0, 2)
        tableColumnWeightModel.setColumnWeight(6, 2)
        columnModel = tableColumnWeightModel
        val colorEvenRows = resources.getColor(R.color.white)
        val colorOddRows = resources.getColor(R.color.teal_200)
        setDataRowBackgroundProvider(TableDataRowBackgroundProviders.alternatingRowColors(colorEvenRows,colorOddRows))

        setColumnComparator(1, ClubComparators().getSeasonOneComparator())
        setColumnComparator(2, ClubComparators().getSeasonTwoComparator())
        setColumnComparator(3, ClubComparators().getSeasonThreeComparator())
        setColumnComparator(4, ClubComparators().getSeasonFourComparator())
        setColumnComparator(5, ClubComparators().getSeasonFiveComparator())
        setColumnComparator(6, ClubComparators().getSumComparator())
    }
}