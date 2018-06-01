function getCitySeeds(){
    var seedObjs = JSON.parse(citySeedsRawData);
    return seedObjs;
}

var citySeedsRawData = `[
    {
        "country": "IN",
        "state": "Gujarat",
        "city": "Ahmedabad",
        "nelatitude": 23.1378156,
        "nelongitude": 72.7053737,
        "swlatitude": 22.9028759,
        "swlongitude": 72.4541115
    },
    {
        "country": "IN",
        "state": "Gujarat",
        "city": "Rajkot",
        "nelatitude": 22.3534892,
        "nelongitude": 70.9481892,
        "swlatitude": 22.1934847,
        "swlongitude": 70.69440349999999
    },
    {
        "country": "IN",
        "state": "Gujarat",
        "city": "Surat",
        "nelatitude": 21.2705834,
        "nelongitude": 72.9432106,
        "swlatitude": 21.0478169,
        "swlongitude": 72.7013819
    },
    {
        "country": "IN",
        "state": "Gujarat",
        "city": "Vadodara",
        "nelatitude": 22.4219466,
        "nelongitude": 73.2730072,
        "swlatitude": 22.2222587,
        "swlongitude": 73.0731653
    },
    {
        "country": "IN",
        "state": "Karnataka",
        "city": "Bengaluru",
        "nelatitude": 13.173706,
        "nelongitude": 77.8826809,
        "swlatitude": 12.7342888,
        "swlongitude": 77.3791981
    },
    {
        "country": "IN",
        "state": "Maharashtra",
        "city": "Mumbai",
        "nelatitude": 19.2716339,
        "nelongitude": 72.9864994,
        "swlatitude": 18.8928676,
        "swlongitude": 72.7758729
    },
    {
        "country": "IN",
        "state": "Maharashtra",
        "city": "Nagpur",
        "nelatitude": 21.2633008,
        "nelongitude": 79.18919559999999,
        "swlatitude": 21.0588709,
        "swlongitude": 78.9558247
    },
    {
        "country": "IN",
        "state": "Maharashtra",
        "city": "Nashik",
        "nelatitude": 20.071733,
        "nelongitude": 73.91575809999999,
        "swlatitude": 19.9101931,
        "swlongitude": 73.6912036
    },
    {
        "country": "IN",
        "state": "Maharashtra",
        "city": "Pune",
        "nelatitude": 18.6357545,
        "nelongitude": 73.9864569,
        "swlatitude": 18.4134784,
        "swlongitude": 73.7394779
    }
]`