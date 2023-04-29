// 10 : 지역코드조회
// 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점) ID
// 13 : 지역 기반 관광정보조회
let serviceKey = "M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D";
let areaUrl = "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey="+serviceKey+"&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";
var currAreaNum = -1;
var currSigunguNum = -1;
var types = [12, 14, 15, 25, 28, 32, 38, 39];
var originTypeNums = [12, 14, 15, 25, 28, 32, 38, 39];
var currResults = [];

window.onload = init();

function init() {
    fetchAllAreas(areaUrl);
    document.getElementById("select-all-btn").addEventListener("click", selectAll);
    var checks = document.getElementsByClassName("form-check-input");

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
    addMarker(currResult);
}

function addCard(result) {
    var cardPanel = document.getElementById("card-panel");

        var titleEl = document.createElement("h5");
        titleEl.setAttribute("class", "card-title");
        titleEl.appendChild(document.createTextNode(result.title));

        var pEl = document.createElement("p");
        pEl.setAttribute("class", "card-text");
        pEl.appendChild(document.createTextNode(result.addr1));

        var buttonEl = document.createElement("button");
        buttonEl.setAttribute("type", "button");
        buttonEl.setAttribute("class", "btn btn-primary");
        buttonEl.setAttribute("data-bs-toggle", "modal");
        buttonEl.setAttribute("data-bs-target", "#trip-info-modal");
        buttonEl.appendChild(document.createTextNode("더 보기"));

        var cardBodyEl = document.createElement("div");
        cardBodyEl.setAttribute("class", "card-body");
        cardBodyEl.appendChild(titleEl);
        cardBodyEl.appendChild(pEl);
        cardBodyEl.appendChild(buttonEl);

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

function addMarker(result) {
    console.log(result);
    var place = {
        title: result.title,
        addr1: result.addr1,
        firstimage: result.firstimage,
        x: result.mapx,
        y: result.mapy,
    }
    displayMarker(place);
}

var mapContainer = document.getElementById("map"), // 지도의 중심좌표
      mapOption = {
        // {36.35536, 127.298294 }
        center: new kakao.maps.LatLng(36.35536, 127.298294), // 지도의 중심좌표
        level: 3, // 지도의 확대 레벨
      };

    var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다


    var overlay = new daum.maps.CustomOverlay({
      position: mapOption.latlng,
      content: content,
    });
    function overLay(marker, tmp) {
      overlay = new kakao.maps.CustomOverlay({
        content: tmp,
        map: map,
        position: marker.getPosition(),
      });
    }

    // 지도에 마커를 표시합니다
    function displayMarker(place) {
      // 마커를 생성하고 지도에 표시합니다
      var marker = new kakao.maps.Marker({
        map: map,
          position: new kakao.maps.LatLng(place.y, place.x),
    });

      var content =
        `<div class="wrap">
            <div class="info">
                <div class="title">
                    ${place.title}
                </div>
                <div class="body">
                    <div class="img">+
                        <img src="${place.firstimage}" width="73" height="70">
                   </div>
                    <div class="desc">
                        <div class="ellipsis">${place.addr1}</div>
                    </div>
                </div>
            </div>
        </div>`;

        overlay = new kakao.maps.CustomOverlay({
        content: content,
        position: marker.getPosition(),
        });
        
      kakao.maps.event.addListener(marker, "click", function () {
        overlay.setMap(null);
        overLay(marker, content);
      });
      map.setCenter(new kakao.maps.LatLng(place.y, place.x));
    }