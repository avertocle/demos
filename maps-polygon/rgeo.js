const HtmlElemOutputJson = "outputjson";
const HtmlElemTablePolygons = "table_polygons";

const LevelCountry = "country";
const LevelState = "state";
const LevelCity = "city";
const CoordPrecision = 7
const BoundTypePolygon = "polygon"

const FileNamePublish = "political_boundaries_hierarchical.json"
const FileNameSave = "rgeo_saved.json"

var map;
var pbList = []
var checkboxList = []

function initMap() {

    map = new google.maps.Map(document.getElementById('map'), {
        center: new google.maps.LatLng(23.473324, 77.947998),
        zoom: 5,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    //getSeedPopulater().populateAndDrawAll()
}

function purgeMap(){
    var pb;
    for (var i=0; i<pbList.length; i++){
        pb = pbList[i];
        pb.hideFromMap();
    }
    pbList = [];
    var tbl = document.getElementById(HtmlElemTablePolygons);
    tbl.innerHTML = "";
}

function addTableRow(polygon, pb){
    var tbl = document.getElementById(HtmlElemTablePolygons);
    var tr =  document.createElement('tr');

    var tdCheck = document.createElement('td');
    var input = document.createElement('input');
    input.type = 'checkbox';
    input.checked = "true";
    input.onclick = function () {
        if(input.checked){
            pb.showOnMap()
        }else{
            pb.hideFromMap();
        }
    }
    checkboxList.push(input);
    tdCheck.appendChild(input);
    tdCheck.style.width = '10px'
    tr.appendChild(tdCheck);

    var tdName = document.createElement('td');
    tdName.innerHTML = pb.name;
    tr.appendChild(tdName);

    tbl.appendChild(tr);
}

function selectAll(){
    for(var i=0; i<checkboxList.length; i++){
        checkboxList[i].checked = false;
        checkboxList[i].click()
    }
}

function selectNone(){
    for(var i=0; i<checkboxList.length; i++){
        checkboxList[i].checked = true;
        checkboxList[i].click()
    }
}

function publish(){
    var x = new PublishSaver();
    var jsonDump = x.getData(pbList)
    downloadFile(FileNamePublish, jsonDump)
}

function saveProject(files) {
    var jsonDump = new DumpSaver().getData(pbList)
    downloadFile(FileNameSave, jsonDump)
}

function loadProject(files) {
    uploadFiles(files)
}

//==========================================================================================

function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

//==========================================================================================

function downloadFile(filename, text) {
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);

    element.style.display = 'none';
    document.body.appendChild(element);

    element.click();

    document.body.removeChild(element);
}

function uploadFiles(files) {
    // Check for the various File API support.
    if (window.FileReader) {

        var reader = new FileReader();

        reader.onerror = function(evt){
            if(evt.target.error.name == "NotReadableError") {
                alert("can not read file !");
            }
        };

        reader.onload = function (evt) {
            var jsonDump = event.target.result;
            getSavedPopulater().populateAndDrawAll(jsonDump)
        };

        reader.readAsText(files[0]);
    }else {
        alert('FileReader are not supported in this browser.');
    }
}

