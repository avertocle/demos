class PoliticalBoundaryDump {
    constructor(pb) {
        this.level = pb.level;
        this.name = pb.name;
        this.boundType = pb.boundType;
        this.bounds = getBounds(pb.boundType, pb.boundObj);
        this.parents = pb.parents;
        this.children = pb.children;
    }
}

class DumpSaver {
    constructor() {
    }

    getData(list) {
        var dump = []
        console.log(list.length)
        for (var i = 0; i < list.length; i++) {
            dump[i] = new PoliticalBoundaryDump(list[i])
        }
        var jsonDump = JSON.stringify(dump);
        return jsonDump
    }
}