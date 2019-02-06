package taxipark

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> =
        this.allDrivers.filter { it !in this.trips.map { trip -> trip.driver } }.toSet()

/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
        this.allPassengers.filter { it -> this.trips.filter { trip -> it in trip.passengers }.size >= minTrips }.toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
        this.allPassengers.filter { it -> this.trips.filter { trip -> it in trip.passengers && trip.driver == driver }.size > 1 }.toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
        this.allPassengers.filter { it ->
            this.trips.filter { trip -> it in trip.passengers && trip.discount != null}.size > this.trips.filter { trip -> it in trip.passengers && trip.discount == null }.size
        }.toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    var resultRange: IntRange? = null
    if (this.trips.isEmpty()) {
        return null
    } else {
        val maxDuration = this.trips.map { trip -> trip.duration }.max() ?: 0
        var max = 0
        for (i in 0..maxDuration step 10) {
            val tmp = this.trips.filter { it.duration in i..i + 9 }.size
            if (tmp > max) {
                max = tmp
                resultRange = i..i + 9
            }
        }
        return resultRange
    }
}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (this.trips.isEmpty()) {
        return false
    } else {
        val total = this.trips.map { it.cost }.sum()
        val sortedTrip = this.trips.groupBy { it.driver }.mapValues { (_, trips) -> trips.sumByDouble { it.cost } }.toList().sortedByDescending { it.second }.toMap()

        var current = 0.0
        var driverNumber = 0
        for (i in sortedTrip) {
            driverNumber++
            current += i.value
            if(current >= total * 0.8) break
        }
        return driverNumber <= this.allDrivers.size * 0.2
    }
}