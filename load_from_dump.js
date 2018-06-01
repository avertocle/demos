/*
 - draws all from seeds as independent polygons
 - doesn't give a shit about hierarchy
 - hierarchy arrangement is done while downloading
 */

var savedPopulaterInstance;

function getSavedPopulater() {
    if(savedPopulaterInstance == null){
        savedPopulaterInstance = new SavedPopulater();
    }
    return savedPopulaterInstance
}

class SavedPopulater {

    constructor(){
    }

    populateAndDrawAll(jsonDump) {
        purgeMap()
        var list = JSON.parse(jsonDump)
        this.populateAndDraw(list, this.getPbObjectFromPbDumpObject)
    }

    populateAndDraw(entityList, pbBuilderFunc) {
        var entity;
        var polyPath, poly, pb
        for (var i = 0; i < entityList.length; i++) {
            entity = entityList[i]
            poly = this.getPolyObject(entity)
            pb = pbBuilderFunc(entity, poly);
            addTableRow(poly, pb);
            poly.setMap(map);
            pbList.push(pb);
        }
    }

    getPolyObject(entity) {
        var path = this.getPolyPath(entity);
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

    getPolyPath(entity) {
        var bounds = entity.bounds
        var path = []
        for(var i=0; i<bounds.length; i++){
            path.push({lat: bounds[i][1], lng: bounds[i][0]})
        }
        if(bounds[0][0] != bounds[i-1][0] && bounds[0][1] != bounds[i-1][1]){
            console.log("polygon completed .... " + entity.name)
            path.push({lat: bounds[0][1], lng: bounds[0][0]})
        }
        return path
    }

    getPbObjectFromPbDumpObject(pbDump, poly) {
        var pb = new PoliticalBoundary(pbDump.level, pbDump.name, "polygon", poly, pbDump.parents);
        return pb;
    }

}

