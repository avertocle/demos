class PoliticalBoundary {
    constructor(level, name, boundType, boundObj, parents, children) {
        this.level = level;
        this.name = cleanName(name);
        this.boundType = boundType;
        this.boundObj = boundObj;
        this.parents = parents;
        this.children = [];
    }

    addChild(child) {
        this.children.push(children)
    }

    setChildren(children) {
        this.children = children
    }

    hideFromMap() {
        this.boundObj.setMap(null);
    }

    showOnMap() {
        this.boundObj.setMap(map);
    }
}

function cleanName(raw){
    return raw.trim().replace(" ", "_").toLowerCase();
}

function findAllStates(pbList, countryName) {
    var pb;
    var results = []
    for (var i = 0; i < pbList.length; i++) {
        pb = pbList[i];
        if(pb.level == LevelState && pb.parents.country == countryName){
            results[pb.name] = (pb)
        }
    }
    return results
}

function findAllCities(pbList, countryName, stateName) {
    var pb;
    var results = []
    for (var i = 0; i < pbList.length; i++) {
        pb = pbList[i];
        if(pb.level == LevelCity && pb.parents.country == countryName && pb.parents.state == stateName){
            results[pb.name] = pb
        }
    }
    return results
}


