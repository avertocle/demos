function getCountrySeeds(){
    var seedObjs = JSON.parse(countrySeedsRawData);
    return seedObjs;
}

var countrySeedsRawData = `[
{
    "country": "IN",
    "nelatitude": 35.513327,
    "nelongitude": 97.3953586,
    "swlatitude": 6.4626999,
    "swlongitude": 68.1097
},
{
    "country": "PK",
    "nelatitude": 37.0841069,
    "nelongitude": 77.8231711,
    "swlatitude": 23.6344999,
    "swlongitude": 60.8729721
}
]`