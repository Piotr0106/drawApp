package pl.gda.wsb.drawapp

import pl.gda.wsb.drawapp.models.Club

class ClubComparators {
    fun getSeasonOneComparator(): Comparator<Club>{
        return ClubSeasonOneComparator()
    }
    fun getSeasonTwoComparator(): Comparator<Club>{
        return ClubSeasonTwoComparator()
    }
    fun getSeasonThreeComparator(): Comparator<Club>{
        return ClubSeasonThreeComparator()
    }
    fun getSeasonFourComparator(): Comparator<Club>{
        return ClubSeasonFourComparator()
    }
    fun getSeasonFiveComparator(): Comparator<Club>{
        return ClubSeasonFiveComparator()
    }
    fun getSumComparator(): Comparator<Club> {
        return ClubSumComparator()
    }

    class ClubSeasonOneComparator : Comparator<Club> {
        override fun compare(club1: Club, club2: Club): Int {
            return club1.seasonOne.compareTo(club2.seasonOne)
        }
    }
    class ClubSeasonTwoComparator : Comparator<Club> {
        override fun compare(club1: Club, club2: Club): Int {
            return club1.seasonTwo.compareTo(club2.seasonTwo)
        }
    }
    class ClubSeasonThreeComparator : Comparator<Club> {
        override fun compare(club1: Club, club2: Club): Int {
            return club1.seasonThree.compareTo(club2.seasonThree)
        }
    }
    class ClubSeasonFourComparator : Comparator<Club> {
        override fun compare(club1: Club, club2: Club): Int {
            return club1.seasonFour.compareTo(club2.seasonFour)
        }
    }
    class ClubSeasonFiveComparator : Comparator<Club> {
        override fun compare(club1: Club, club2: Club): Int {
            return club1.seasonFive.compareTo(club2.seasonFive)
        }
    }
    class ClubSumComparator : Comparator<Club> {
        override fun compare(club1: Club, club2: Club): Int {
            return club1.sum.compareTo(club2.sum)
        }
    }

}