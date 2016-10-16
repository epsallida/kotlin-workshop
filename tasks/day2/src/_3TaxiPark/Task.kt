package _3TaxiPark

// Task #1.
// Find all the drivers that completed no orders
fun TaxiPark.findFakeDrivers(): Collection<Driver> =
        this.allDrivers.filter { d -> this.orders.none { it.driver == d} }

// Task #2.
// Find all passengers ordering more than 'minTrips' number of trips
fun TaxiPark.findFaithfulPassengers(minTrips: Int): List<Passenger> =
        this.allPassengers.filter { p -> this.orders.count { p in it.passengers } > minTrips  }

// Task #3.
// Find all passengers that were taken by this driver more than once
fun TaxiPark.findFrequentPassengers(driver: Driver): List<Passenger> =
        this.allPassengers.filter { p -> this.orders.count { it.driver == driver && p in it.passengers } > 1 }

// Task #4.
// Find passengers that used discounts for majority of the trips
fun TaxiPark.findSmartPassengers(): Collection<Passenger> =
        TODO()

// Task #5.
// Find the most frequent trip interval duration among 0-9 minutes, 10-19 minutes, 20-29 minutes etc.
fun TaxiPark.findTheMostFrequentTripDuration(): IntRange? {
    TODO()
}

// Task #6.
// Check whether 20% of the drivers make 80% of the profit
fun TaxiPark.checkParetoPrinciple(): Boolean {
    TODO()
}