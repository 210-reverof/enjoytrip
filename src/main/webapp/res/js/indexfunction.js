// 대전 구 개수 : 5개
var types = [12, 14, 15, 25, 28, 32, 38, 39];

window.onload = init();

function init() {
    getOurTrips();
}


function getOurTrips() {
    let tripsUrl = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A&contentTypeId=28&areaCode=3&sigunguCode=5";
    fetch(tripsUrl)
        .then((response) => response.json())
        .then((data) => getResults(data));

}

function getResults(result) {   
    var tmp = result.response.body.items.item;

    let sel = [true, false, true, false, true];
    shuffle(sel);

    for (i = 0; i < tmp.length; i++) {
        if (sel[i]) {
            console.log(tmp[i].title);
            addCard(tmp[i]);
        }
    }
}

function addCard(result) {
    var cardPanel = document.getElementById("our-trips-panel");

    var cardBodyEl = document.createElement("div");
    cardBodyEl.setAttribute("class", "m-3");
    cardBodyEl.setAttribute("style", "box-shadow: 0px 0px 15px grey");
    cardBodyEl.setAttribute("data-bs-toggle", "modal");
    cardBodyEl.setAttribute("data-bs-target", "#area-trip-modal");

    var imgEl = document.createElement("img");
    imgEl.setAttribute("src", result.firstimage);
    imgEl.setAttribute("class", "card-img-top");

    cardBodyEl.appendChild(imgEl);
    cardPanel.appendChild(cardBodyEl);
}

function shuffle(a) {
    var j, x, i;
    for (i = a.length - 1; i > 0; i--) {
        j = Math.floor(Math.random() * (i + 1));
        x = a[i];
        a[i] = a[j];
        a[j] = x;
    }
    return a;
  }