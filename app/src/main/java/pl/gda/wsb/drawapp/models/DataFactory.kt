package pl.gda.wsb.drawapp.models

import pl.gda.wsb.drawapp.models.Club

class DataFactory {
    fun createClubList(): List<Club> {
        return listOf(
            Club("Anglia", 22.642, 18.571, 24.357, 21.000, 18.571),
            Club("Hiszpania", 19.571, 18.928, 19.500, 18.428, 13.714),
            Club("Niemcy", 15.214, 18.714, 15.214, 16.214, 16.000),
            Club("Włochy", 12.642, 14.928, 16.285, 15.714, 15.928),
            Club("Francja", 10.583, 11.666, 7.916, 18.416, 12.083),
            Club("Holandia",8.600, 9.400, 9.200, 19.200, 11.500),
            Club("Portugalia", 10.900, 10.300, 9.600, 12.916, 11.666),
            Club("Belgia", 7.800, 7.600, 6.000, 6.600,12.000),
            Club("Szkocja", 6.750, 9.750, 8.500, 7.900, 3.500),
            Club("Austria", 6.200, 5.800, 6.700, 10.400, 4.900),
            Club("Polska", 2.250, 2.125, 4.000, 4.625, 6.750)
        )
    }
}