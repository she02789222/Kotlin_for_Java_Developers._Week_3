# Kotlin_for_Java_Developers._Week_3
## Nice String
We'll say a string is nice if at least two of the following conditions are satisfied:

It doesn't contain substrings bu, ba or be;
It contains at least three vowels (vowels are a, e, i, o and u);
It contains a double letter (at least two similar letters following one another), like b in "abba".
Your task is to check whether a given string is nice. Strings for this task will consist of lowercase letters only. Note that for the purpose of this task, we don't consider 'y' as a vowel.

### Example 1

"bac" isn't nice. No conditions are satisfied: it contains a ba substring, contains only one vowel and no doubles.

### Example 2

"aza" isn't nice. Only the first condition is satisfied, but the string doesn't contain enough vowels or doubles.

### Example 3

"abaca" isn't nice. The second condition is satisfied: it contains three vowels a, but the other two aren't satisfied: it contains ba and no doubles.

### Example 4

"baaa" is nice. The conditions #2 and #3 are satisfied: it contains three vowels a and a double a.

### Example 5

"aaab" is nice, because all three conditions are satisfied.

## Taxi Park
The TaxiPark class stores information about the registered drivers, passengers, and their trips. Your task is to implement six functions which collect different statistics about the data.

### Task 1

fun TaxiPark.findFakeDrivers(): Collection<Driver>
Find all the drivers who performed no trips.

### Task 2

fun TaxiPark.findFaithfulPassengers(minTrips: Int): List<Passenger>
Find all the clients who completed at least the given number of trips.

### Task 3

fun TaxiPark.findFrequentPassengers(driver: Driver): List<Passenger>
Find all the passengers, who were taken by a given driver more than once.

### Task 4

fun TaxiPark.findSmartPassengers(): Collection<Passenger>
Let's call "smart" a passenger who had a discount for the majority of the trips he or she made or took part in (including the trips with more than one passenger). Find all the "smart" passengers. Note that the discount can't be 0.0, it's always non-zero if it's recorded.

### Task 5

fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange?
Find the most frequent trip duration period among minute periods 0..9, 10..19, 20..29, and so on. Return any suitable period if many are the most frequent, return null if there're no trips.

### Task 6

fun TaxiPark.checkParetoPrinciple(): Boolean
Check whether no more than 20% of the drivers contribute 80% of the income. The function should return true if the top 20% drivers (meaning the top 20% best performers) represent 80% or more of all trips total income, or false if not. The drivers that have no trips should be considered as contributing zero income. If the taxi park contains no trips, the result should be false.

For example, if there're 39 drivers in the taxi park, we need to check that no more than 20% of the most successful ones, which is seven drivers (39 * 0.2 = 7.8), contribute at least 80% of the total income. Note that eight drivers out of 39 is 20.51% which is more than 20%, so we check the income of seven the most successful drivers.

To find the total income sum up all the trip costs. Note that the discount is already applied while calculating the cost.
