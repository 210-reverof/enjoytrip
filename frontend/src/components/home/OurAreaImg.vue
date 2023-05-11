<template>
  <div class="row m-1">
    <div class="col-3">
      <div id="our-area-title" class="fs-2 text-start m-3">우리지역 관광지</div>
      <div class="fs-5 text-start m-3">
        우리지역의 숨어있는 아름다운 관광지를 알려드립니다. 관광지 주변의 맛집, 숙박업소와
        여행코스, 지역 축제등을 보실수도 있습니다.
      </div>
    </div>

    <div class="col-9">
      <div id="our-trips-panel" class="row row-cols-1 row-cols-lg-3 m-3 flex-nowrap justify-content-md-center"></div>
    </div>
  </div>
</template>

<script>

export default {
  name: "OurAreaImg",
  created() {
    this.getOurTrips();
  },
  methods: {
    getOurTrips() {
      let tripsUrl = "https://apis.data.go.kr/B551011/KorService1/areaBasedList1?serviceKey=M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json&listYN=Y&arrange=A&contentTypeId=28&areaCode=3&sigunguCode=5";
      fetch(tripsUrl)
          .then((response) => response.json())
          .then((data) => this.getResults(data));
    },

    getResults(result) {   
      var tmp = result.response.body.items.item;

      let sel = [true, false, true, false, true];
      this.shuffle(sel);

      for (var i = 0; i < tmp.length; i++) {
        if (sel[i]) {
          this.addCard(tmp[i]);
        }
      }
    },
    
    addCard(result) {
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
    },

    shuffle(a) {
      var j, x, i;
      for (i = a.length - 1; i > 0; i--) {
          j = Math.floor(Math.random() * (i + 1));
          x = a[i];
          a[i] = a[j];
          a[j] = x;
      }
      return a;
    }
  }
}
</script>
