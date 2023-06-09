let serviceKey = "M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D";
let areaUrl = "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey="+serviceKey+"&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";
var currAreaNum = -1;
var currSigunguNum = -1;
var types = [12, 14, 15, 25, 28, 32, 38, 39];
var originTypeNums = [12, 14, 15, 25, 28, 32, 38, 39];
var currResults = [];
const cids = [];

window.onload = init();

function init() {
    fetchAllAreas(areaUrl);
    document.getElementById("select-all-btn").addEventListener("click", selectAll);
    var checks = document.getElementsByClassName("form-check-input");
    getRoutes();

    for (i = 0; i < checks.length; i++) {
        checks[i].addEventListener("click", selectType);
    }
}

function fetchAllAreas(areaUrl) {
    fetch(areaUrl)
  .then((response) => response.json())
  .then((data) => makeOption(data));
}

function makeOption(data) {
    let areas = data.response.body.items.item;
    let sel = document.getElementById("search-area-sel");
    areas.forEach(function (area) {
    let opt = document.createElement("option");
        opt.setAttribute("value", area.code);
        opt.appendChild(document.createTextNode(area.name));
        sel.appendChild(opt);
    });
}

function changeAreaSel() {
    let detailSel = document.getElementById("search-area-detail-sel");
    let cnt = detailSel.options.length;
    for (i = 0; i < cnt; i++) {
        detailSel.options[0].remove();
    }

    var currSel = document.getElementById("search-area-sel")
    currAreaNum = currSel.options[currSel.selectedIndex].value;
    currSigunguNum = -1;
    
    let areaDetailUrl = "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&areaCode=" + currAreaNum + "&_type=json";
    fetch(areaDetailUrl)
        .then((response) => response.json())
        .then((data) => makeDetailOption(data));
} 

function makeDetailOption(data) {
    let areas = data.response.body.items.item;
    let sel = document.getElementById("search-area-detail-sel");

    areas.forEach(function (area) {
    let opt = document.createElement("option");
        opt.setAttribute("value", area.code);
        opt.appendChild(document.createTextNode(area.name));
        sel.appendChild(opt);
    });
}

function changeSigunguSel() {
    var currSel = document.getElementById("search-area-detail-sel")
    currSigunguNum = currSel.options[currSel.selectedIndex].value;
    getTrips();
}

function selectAll() {
    types = [12, 14, 15, 25, 28, 32, 38, 39];
    var checks = document.getElementsByClassName("form-check-input");

    for (i = 0; i < checks.length; i++) {
        checks[i].checked = true;
    }
    getTrips();
}

function selectType() {
    types = [];
    var checks = document.getElementsByClassName("form-check-input");

    for (i = 0; i < checks.length; i++) {
        if (checks[i].checked) {
            types.push(originTypeNums[i]);
        }
    }
    getTrips();
}

function getTrips() {
    currResults = [];
    for (i = 0; i < types.length; i++) {
        let tripsUrl = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A&contentTypeId=" + types[i] + "&areaCode=" + currAreaNum + "&sigunguCode=" + currSigunguNum;
        fetch(tripsUrl)
            .then((response) => response.json())
            .then((data) => getResults(data));
    }
}

function getResults(result) {
    if (!result.response.body.items.item) return;
    var cardPanel = document.getElementById("card-panel");

    let originCnt = cardPanel.children.length;
    for (i = 0; i < originCnt; i++){
        cardPanel.children[0].remove();
    }
    
    var tmp = result.response.body.items.item;
    for (i = 0; i < tmp.length; i++) {
        excute(tmp[i]);
    }
}

function excute(currResult) {
    addCard(currResult);
}

function addCard(result) {
    var cardPanel = document.getElementById("card-panel");

        var titleEl = document.createElement("h5");
        titleEl.setAttribute("class", "card-title");
        titleEl.appendChild(document.createTextNode(result.title));

        var pEl = document.createElement("p");
        pEl.setAttribute("class", "card-text");
        pEl.appendChild(document.createTextNode(result.addr1));
        
        var form = document.createElement("form");
        form.action = "${root}/user";
        form.method = "post";
        
        var input0 = document.createElement("input");
        input0.setAttribute("type", "hidden");
        input0.setAttribute("name", "action");
        input0.setAttribute("value", "addroute");
        form.appendChild(input0);
        
        var input1 = document.createElement("input");
        input1.setAttribute("type", "hidden");
        input1.setAttribute("name", "contentid");
        input1.setAttribute("value", result.contentid);
        form.appendChild(input1);
        
        var input101 = document.createElement("input");
        input101.setAttribute("type", "hidden");
        input101.setAttribute("name", "longitude");
        input101.setAttribute("value", result.mapx);
        form.appendChild(input101);
        
        var input102 = document.createElement("input");
        input102.setAttribute("type", "hidden");
        input102.setAttribute("name", "latitude");
        input102.setAttribute("value", result.mapy);
        form.appendChild(input102);
        
        var input11 = document.createElement("input");
        input11.setAttribute("type", "hidden");
        input11.setAttribute("name", "userid");
        input11.setAttribute("value", "${userinfo.id}");
        form.appendChild(input11);
        
        var input2 = document.createElement("input");
        input2.setAttribute("type", "submit");
        input2.setAttribute("class", "w-100 mb-2 btn btn-lg rounded-3 btn-primary");
        input2.setAttribute("value", "추가");
        form.appendChild(input2);

        var cardBodyEl = document.createElement("div");
        cardBodyEl.setAttribute("class", "card-body");
        cardBodyEl.appendChild(titleEl);
        cardBodyEl.appendChild(pEl);
        cardBodyEl.appendChild(form);

        var imgEl = document.createElement("img");
        imgEl.setAttribute("src", result.firstimage);
        imgEl.setAttribute("class", "card-img-top");

        var cardEl = document.createElement("div");
        cardEl.setAttribute("class", "card m-2");
        cardEl.setAttribute("style", "width: 18rem");
        cardEl.appendChild(imgEl);
        cardEl.appendChild(cardBodyEl);

        var colEl = document.createElement("div");
        colEl.setAttribute("class", "col");
    colEl.appendChild(cardEl);
    
    cardPanel.appendChild(colEl);
}

function getRoutes() {
    var cardPanel = document.getElementById("route-panel");

    let originCnt = cardPanel.children.length;
    for (i = 0; i < originCnt; i++){
        cardPanel.children[0].remove();
    }
    
	for (i = 0; i < cids.length; i++) {
        let tripsUrl = "https://apis.data.go.kr/B551011/KorService1/detailCommon1?serviceKey=M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D&MobileOS=ETC&MobileApp=AppTest&_type=json&contentId="+ cids[i] +"&defaultYN=Y&firstImageYN=Y&areacodeYN=Y&catcodeYN=Y&addrinfoYN=Y&mapinfoYN=Y&overviewYN=Y";
        fetch(tripsUrl)
            .then((response) => response.json())
            .then((data) => getRouteResults(data));
    }
}

function getRouteResults(result) {
    if (!result.response.body.items.item) return;
    
    var tmp = result.response.body.items.item;
    for (i = 0; i < tmp.length; i++) {
    	addRouteCard(tmp[i]);
    }
}

function addRouteCard(result) {
    var cardPanel = document.getElementById("route-panel");

    var titleEl = document.createElement("h5");
    titleEl.setAttribute("class", "card-title");
    titleEl.appendChild(document.createTextNode(result.title));

    var pEl = document.createElement("p");
    pEl.setAttribute("class", "card-text");
    pEl.appendChild(document.createTextNode(result.addr1));
    
    var form = document.createElement("form");
    form.action = "${root}/user";
    form.method = "post";
    
    var input0 = document.createElement("input");
    input0.setAttribute("type", "hidden");
    input0.setAttribute("name", "action");
    input0.setAttribute("value", "deleteroute");
    form.appendChild(input0);
    
    var input1 = document.createElement("input");
    input1.setAttribute("type", "hidden");
    input1.setAttribute("name", "contentid");
    input1.setAttribute("value", result.contentid);
    form.appendChild(input1);
    
    var input11 = document.createElement("input");
    input11.setAttribute("type", "hidden");
    input11.setAttribute("name", "userid");
    input11.setAttribute("value", "${userinfo.id}");
    form.appendChild(input11);
    
    var input2 = document.createElement("input");
    input2.setAttribute("type", "submit");
    input2.setAttribute("class", "w-100 mb-2 btn btn-lg rounded-3 btn-primary");
    input2.setAttribute("value", "삭제");
    form.appendChild(input2);

    var imgEl = document.createElement("img");
    imgEl.setAttribute("src", result.firstimage);
    imgEl.setAttribute("class", "card-img-top");
    
    var cardBodyEl = document.createElement("div");
    cardBodyEl.setAttribute("class", "card-body");
    cardBodyEl.appendChild(titleEl);
    cardBodyEl.appendChild(pEl);
    cardBodyEl.appendChild(form);

    var cardEl = document.createElement("div");
    cardEl.setAttribute("class", "card m-2");
    cardEl.setAttribute("style", "width: 18rem");
    cardEl.appendChild(imgEl);
    cardEl.appendChild(cardBodyEl);

    var colEl = document.createElement("div");
    colEl.setAttribute("class", "col");
    colEl.appendChild(cardEl);
    
    cardPanel.appendChild(colEl);
}