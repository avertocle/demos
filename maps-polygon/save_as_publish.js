class PoliticalBoundaryCountry {
    constructor(pb) {
        this.level = LevelCountry;
        this.name = pb.name;
        this.boundType = pb.boundType;
        this.bounds = getBounds(pb.boundType, pb.boundObj);
        this.parents = pb.parents;
        this.children = pb.children;
    }

    setChildren(children) {
        this.children = children
    }
}

class PoliticalBoundaryState {
    constructor(pb) {
        this.level = LevelState;
        this.name = pb.name;
        this.boundType = pb.boundType;
        this.bounds = getBounds(pb.boundType, pb.boundObj);
        this.parents = pb.parents;
        this.children = pb.children;
    }

    setChildren(children) {
        this.children = children
    }
}

class PoliticalBoundaryCity {
    constructor(pb) {
        this.level = LevelCity;
        this.name = pb.name;
        this.boundType = pb.boundType;
        this.bounds = getBounds(pb.boundType, pb.boundObj);
        this.parents = pb.parents;
        this.children = pb.children;
    }

    setChildren(children) {
        this.children = children
    }
}


function getBounds(boundType, boundObj) {
    if (boundType == BoundTypePolygon) {
        return getBoundsPolygon(boundObj)
    }
}

function getBoundsPolygon(poly) {
    var path = poly.getPath();
    var len = path.getLength();
    var bounds = [];
    for (var i = 0; i < len; i++) {
        bounds[i] = [roundCoord(path.getAt(i).lng()), roundCoord(path.getAt(i).lat())];
    }
    return bounds;
}


function roundCoord(raw) {
    var mult = Math.pow(10, CoordPrecision)
    return Math.round(raw * mult) / mult
}

function decorate(pb) {
    if (pb.level == LevelCountry) {
        return new PoliticalBoundaryCountry(pb)
    } else if (pb.level == LevelState) {
        return new PoliticalBoundaryState(pb)
    } else if (pb.level == LevelCity) {
        return new PoliticalBoundaryCity(pb)
    }
}


class PublishSaver {
    constructor() {
    }

    getData(list) {
        var listHirar = this.arrangePbByHierarchy(list)
        var jsonDump = JSON.stringify(listHirar);
        return jsonDump
    }

    arrangePbByHierarchy(list) {
        var listDecor = []
        var listHirar = [];

        var pb1;
        var children = []

        for (var i = 0; i < list.length; i++) {
            listDecor[i] = decorate(list[i])
        }

        console.log(listDecor.length)

        // populate all countries
        for (var i = 0; i < listDecor.length; i++) {
            pb1 = listDecor[i];
            if (pb1.level == LevelCountry) {
                listHirar.push(pb1)
            }
        }

        // populate all states
        var k1
        for (var i = 0; i < listHirar.length; i++) {
            pb1 = listHirar[i];
            children = this.findAllStates(listDecor, pb1.name)
            pb1.setChildren(children)
        }

        // populate all cities
        var k2
        var pb2
        for (var i = 0; i < listHirar.length; i++) {
            pb1 = listHirar[i];
            for (var j = 0; j < pb1.children.length; j++) {
                pb2 = pb1.children[j];
                children = this.findAllCities(listDecor, pb1.name, pb2.name)
                pb2.setChildren(children)
            }
        }

        return listHirar
    }

    findAllStates(list, countryName) {
        var pb;
        var results = []
        for (var i = 0; i < list.length; i++) {
            pb = list[i];
            if (pb.level == LevelState && pb.parents.country == countryName) {
                results.push(pb)
            }
        }
        return results
    }

    findAllCities(list, countryName, stateName) {
        var pb;
        var results = []
        for (var i = 0; i < list.length; i++) {
            pb = list[i];
            if (pb.level == LevelCity && pb.parents.country == countryName && pb.parents.state == stateName) {
                results.push(pb)
            }
        }
        return results
    }
}




