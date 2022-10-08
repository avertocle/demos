/*
 - draws all from seeds as independent polygons
 - doesn't give a shit about hierarchy
 - hierarchy arrangement is done while downloading
 */

var seedPopulaterInstance;

function getSeedPopulater() {
    if(seedPopulaterInstance == null){
        seedPopulaterInstance = new SeedPopulater();
    }
    return seedPopulaterInstance
}

class SeedPopulater {

    constructor(){
    }

    populateAndDrawAll() {
        var countryList = getCountrySeeds()
        this.populateAndDraw(countryList, this.getPbObjectForCountry)

        var stateList = getStateSeeds()
        this.populateAndDraw(stateList, this.getPbObjectForState)

        var cityList = getCitySeeds()
        this.populateAndDraw(cityList, this.getPbObjectForCity)
    }

    populateAndDraw(entityList, pbBuilderFunc) {
        var entity;
        var polyPath, poly, pb
        for (var i = 0; i < entityList.length; i++) {
            entity = entityList[i]
            polyPath = this.getPolyPath(entity);
            poly = this.getPolyObject(polyPath)
            pb = pbBuilderFunc(entity, poly);
            addTableRow(poly, pb);
            poly.setMap(map);
            pbList.push(pb);
        }
    }

    getPolyObject(path) {
        var color = getRandomColor()
        var poly = new google.maps.Polygon({
            paths: path,
            strokeColor: color,
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: color,
            fillOpacity: 0.35,
            editable: true,
            draggable: true
        });
        return poly
    }

    getPolyPath(seed) {
        var xlen = Math.abs(Number(seed.swlatitude - seed.nelatitude))
        var ylen = Math.abs(Number(seed.nelongitude - seed.swlongitude))
        var x = Number(seed.nelatitude)
        var y = Number(seed.nelongitude)

        var pathx = [
            {lat: x, lng: y},
            {lat: x - xlen, lng: y},
            {lat: x - xlen, lng: y - ylen},
            {lat: x, lng: y - ylen},
            {lat: x, lng: y}
        ];
        return pathx
    }

    getPbObjectForCountry(meta, poly) {
        var parents = {}
        var pb = new PoliticalBoundary(LevelCountry, meta.country, "polygon", poly, parents);
        return pb;
    }

    getPbObjectForState(meta, poly) {
        var parents = {}
        parents[LevelCountry] = cleanName(meta.country)
        var pb = new PoliticalBoundary(LevelState, meta.state, "polygon", poly, parents);
        return pb;
    }


    getPbObjectForCity(meta, poly) {
        var parents = {}
        parents[LevelCountry] = cleanName(meta.country)
        parents[LevelState] = cleanName(meta.state)
        var pb = new PoliticalBoundary(LevelCity, meta.city, "polygon", poly, parents);
        return pb;
    }

}

