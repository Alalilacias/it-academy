// Display all documents in the restaurants collection
db.restaurants.find({})

// Display _id, name, borough, and cuisine for all documents in the restaurant collection
db.restaurants.find({}, { _id: 1, name: 1, borough: 1, cuisine: 1 })

// Display _id, name, borough, and cuisine (exclude _id field)
db.restaurants.find({}, { _id: 0, name: 1, borough: 1, cuisine: 1 })

// Display _id, name, borough, and zip code (exclude _id field)
db.restaurants.find({}, { _id: 0, name: 1, borough: 1, "address.zipcode": 1 })

// Show all restaurants in the Bronx
db.restaurants.find({ borough: "Bronx" })

// Show the first 5 restaurants in the Bronx
db.restaurants.find({ borough: "Bronx" }).limit(5)

// Display the next 5 restaurants after skipping the first 5 in the Bronx
db.restaurants.find({ borough: "Bronx" }).skip(5).limit(5)

// Find restaurants with a score greater than 90
db.restaurants.find({ "grades.score": { $gt: 90 } })

// Find restaurants with a score between 80 and 100
db.restaurants.find({ "grades.score": { $gt: 80, $lt: 100 } })

// Find restaurants with latitude less than -95.754168. Not sure if less than means closer to 0 or further away. Logic would imply this solution, but that gives 0 results.
db.restaurants.find({ "address.coord.1": { $lt: -95.754168 } })

// Find restaurants that do not serve 'American' cuisine, have a rating > 70, and longitude < -65.754168
db.restaurants.find({ cuisine: { $ne: "American" }, "grades.score": { $gt: 70 }, "address.coord.0": { $lt: -65.754168 } })

// Find restaurants that do not serve 'American' cuisine, have a rating > 70, and longitude < -65.754168 (without $and). Technically, this uses the $and operator implicitly, but, since it's not explicitly written and I'm out of time, I'll pretend this is the correct way.
db.restaurants.find({ cuisine: { $ne: "American" }, "grades.score": { $gt: 70 }, "address.coord.0": { $lt: -65.754168 } })

// Find restaurants that do not serve 'American' cuisine, received an 'A' grade, and not in Brooklyn, sorted by cuisine in descending order
db.restaurants.find({ cuisine: { $ne: "American" }, "grades.grade": "A", borough: { $ne: "Brooklyn" } }).sort({ cuisine: -1 })

// Find _id, name, borough, and cuisine for names starting with 'Wil'
db.restaurants.find({ name: /^Wil/ }, { _id: 1, name: 1, borough: 1, cuisine: 1 })

// Find _id, name, borough, and cuisine for names ending with 'ces'
db.restaurants.find({ name: /ces$/ }, { _id: 1, name: 1, borough: 1, cuisine: 1 })

// Find _id, name, borough, and cuisine for names containing 'Reg'
db.restaurants.find({ name: /Reg/ }, { _id: 1, name: 1, borough: 1, cuisine: 1 })

// Find restaurants in the Bronx serving American or Chinese dish
db.restaurants.find({ borough: "Bronx", $or: [{ cuisine: "American" }, { cuisine: "Chinese" }] })

// Find _id, name, borough, and cuisine for restaurants in Staten Island, Queens, Bronx, or Brooklyn
db.restaurants.find({ borough: { $in: ["Staten Island", "Queens", "Bronx", "Brooklyn"] } }, { _id: 1, name: 1, borough: 1, cuisine: 1 })

// Find _id, name, borough, and cuisine for restaurants not in Staten Island, Queens, Bronx, or Brooklyn
db.restaurants.find({ borough: { $nin: ["Staten Island", "Queens", "Bronx", "Brooklyn"] } }, { _id: 1, name: 1, borough: 1, cuisine: 1 })

// Find _id, name, borough, and cuisine for restaurants with a score <= 10
db.restaurants.find({ "grades.score": { $lte: 10 } }, { _id: 1, name: 1, borough: 1, cuisine: 1 })

// Find _id, name, borough, and cuisine for fish restaurants excluding American and Chinese or names starting with 'Wil'
db.restaurants.find({
  $or: [
    { name: /Fish/, $and: [{ cuisine: { $ne: "American" } }, { cuisine: { $ne: "Chinese" } }] },
    { name: /^Wil/ }
  ]
}, { _id: 1, name: 1, borough: 1, cuisine: 1 })

// Find _id, name, and grades for restaurants with an "A" grade and score 11 on ISODate "2014-08-11T00:00:00Z"
db.restaurants.find({ "grades.grade": "A", "grades.score": 11, "grades.date": ISODate("2014-08-11T00:00:00Z")}
, { "_id": 1, "name": 1, "grades": 1 })

// Find _id, name, and grades for restaurants where 2nd grade array element contains grade "A" and score 9 on ISODate "2014-08-11T00:00:00Z"
db.restaurants.find({ "grades.1.grade": "A", "grades.1.score": 9, "grades.1.date": ISODate("2014-08-11T00:00:00Z")}
, { "_id": 1, "name": 1, "grades": 1 })

// Find _id, name, address, and geographic location for restaurants where the second element of the coord array contains a value > 42 and <= 52
db.restaurants.find({
    "address.coord.1": { $gt: 42, $lte: 52 }
}, {"_id": 1, "name": 1, "address": 1, "_id": 0 })

// Arrange restaurant name in ascending order along with all columns
db.restaurants.find().sort({ name: 1 })

// Arrange restaurant name in descending order along with all columns
db.restaurants.find().sort({ name: -1 })

// Arrange cuisine name in ascending order and by cuisine district in descending order
db.restaurants.find().sort({ cuisine: 1, borough: -1 })

// Find addresses that do not contain the word "street"
db.restaurants.find({ "address.street": { $not: /street/i } }, { address: 1 })

// Select documents where the coord field is of type Double
db.restaurants.find({ "address.coord": { $type: "double" } })

// Select _id, name, and grade for restaurants where score % 7 equals 0
db.restaurants.find({ "grades.score": { $mod: [7, 0] } }, { _id: 1, name: 1, grades: 1 })

// Find restaurant name, borough, longitude, altitude, and cuisine for names containing 'mon'
db.restaurants.find({ name: /mon/ }, { name: 1, borough: 1, "address.coord": 1, cuisine: 1 })

// Find restaurant name, borough, longitude, latitude, and cuisine for names starting with 'Mad'
db.restaurants.find({ name: /^Mad/ }, { name: 1, borough: 1, "address.coord": 1, cuisine: 1 })
