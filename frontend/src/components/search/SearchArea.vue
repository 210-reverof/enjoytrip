<template>
  <div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
      <h2 class="my-3 py-3 shadow-sm bg-light text-center">
        <mark class="sky">지역별 여행지</mark>
      </h2>
    </div>
    <!--지역 선택-->
    <form class="d-flex justify-content-evenly mt-3" role="search">
      <div class="row">
        <div class="d-inline-flex p-2">
          <select
            id="search-area-sel"
            class="form-select mx-2"
            @change="changeAreaSel"
          ></select>
          <select
            id="search-area-detail-sel"
            class="form-select mx-2"
            @change="changeSigunguSel"
          ></select>
        </div>

        <!--유형 선택-->
        <div class="d-inline-flex p-2 align-items-center">
          <div class="px-4">
            <button type="button" class="btn btn-primary" id="select-all-btn">
              모두선택
            </button>
          </div>
          <div class="form-check px-4">
            <input class="form-check-input" type="checkbox" checked />
            <label class="form-check-label">관광지</label>
          </div>
          <div class="form-check px-4">
            <input class="form-check-input" type="checkbox" checked />
            <label class="form-check-label">문화시설</label>
          </div>
          <div class="form-check px-4">
            <input class="form-check-input" type="checkbox" checked />
            <label class="form-check-label">행사/공연/축제</label>
          </div>
          <div class="form-check px-4">
            <input class="form-check-input" type="checkbox" checked />
            <label class="form-check-label">여행코스</label>
          </div>
          <div class="form-check px-4">
            <input class="form-check-input" type="checkbox" checked />
            <label class="form-check-label">레포츠</label>
          </div>
          <div class="form-check px-4">
            <input class="form-check-input" type="checkbox" checked />
            <label class="form-check-label">숙박</label>
          </div>
          <div class="form-check px-4">
            <input class="form-check-input" type="checkbox" checked />
            <label class="form-check-label">쇼핑</label>
          </div>
          <div class="form-check px-4">
            <input class="form-check-input" type="checkbox" checked />
            <label class="form-check-label">음식점</label>
          </div>
        </div>
      </div>
    </form>
    <div id="map" style="width: 1000px; height: 600px"></div>
    <div
      id="card-panel"
      class="search-cards m-4 row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4 d-flex"
    >
      <!--카드-->
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchArea",
  data() {
    return {
      serviceKey:
        "M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D",
      areaUrl: "",
      currAreaNum: 1,
      currSigunguNum: 1,
      types: [12, 14, 15, 25, 28, 32, 38, 39],
      originTypeNums: [12, 14, 15, 25, 28, 32, 38, 39],
      currResults: [],
      route: [],
      attractions: [],
      map: null,
    };
  },
  created() {
    this.areaUrl =
      "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=" +
      this.serviceKey +
      "&numOfRows=20&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";
  },
  mounted() {
    const container = document.getElementById("map");
    const options = {
      center: new window.kakao.maps.LatLng(37.5665, 126.978),
      level: 8,
    };
    this.map = new window.kakao.maps.Map(container, options);
    this.fetchAllAreas(this.areaUrl);
    this.currAreaNum = 1;
    this.currSigunguNum = -1;

    let areaDetailUrl =
      "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&areaCode=" +
      this.currAreaNum +
      "&_type=json";
    fetch(areaDetailUrl)
      .then((response) => response.json())
      .then((data) => this.makeDetailOption(data));

    document
      .getElementById("select-all-btn")
      .addEventListener("click", this.selectAll);
    var checks = document.getElementsByClassName("form-check-input");

    for (var i = 0; i < checks.length; i++) {
      checks[i].addEventListener("click", this.selectType);
    }
    this.getTrips();
  },
  methods: {
    fetchAllAreas(areaUrl) {
      fetch(areaUrl)
        .then((response) => response.json())
        .then((data) => this.makeOption(data));
    },

    makeOption(data) {
      let areas = data.response.body.items.item;
      let sel = document.getElementById("search-area-sel");
      areas.forEach(function (area) {
        let opt = document.createElement("option");
        opt.setAttribute("value", area.code);
        opt.appendChild(document.createTextNode(area.name));
        sel.appendChild(opt);
      });
    },

    changeAreaSel() {
      let detailSel = document.getElementById("search-area-detail-sel");
      let cnt = detailSel.options.length;
      for (var i = 0; i < cnt; i++) {
        detailSel.options[0].remove();
      }

      var currSel = document.getElementById("search-area-sel");
      this.currAreaNum = currSel.options[currSel.selectedIndex].value;
      this.currSigunguNum = -1;

      let areaDetailUrl =
        "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey=M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&areaCode=" +
        this.currAreaNum +
        "&_type=json";
      fetch(areaDetailUrl)
        .then((response) => response.json())
        .then((data) => this.makeDetailOption(data));
    },

    makeDetailOption(data) {
      let areas = data.response.body.items.item;
      let sel = document.getElementById("search-area-detail-sel");
      let self = this;

      areas.forEach(function (area) {
        if (self.currSigunguNum == -1) {
          self.currSigunguNum = area.code;
          self.getTrips();
        }
        let opt = document.createElement("option");
        opt.setAttribute("value", area.code);
        opt.appendChild(document.createTextNode(area.name));
        sel.appendChild(opt);
      });
    },

    changeSigunguSel() {
      var currSel = document.getElementById("search-area-detail-sel");
      this.currSigunguNum = currSel.options[currSel.selectedIndex].value;
      this.getTrips();
    },

    selectAll() {
      this.types = [12, 14, 15, 25, 28, 32, 38, 39];
      var checks = document.getElementsByClassName("form-check-input");

      for (var i = 0; i < checks.length; i++) {
        checks[i].checked = true;
      }
      this.getTrips();
    },

    selectType() {
      this.types = [];
      var checks = document.getElementsByClassName("form-check-input");

      for (var i = 0; i < checks.length; i++) {
        if (checks[i].checked) {
          this.types.push(this.originTypeNums[i]);
        }
      }
      this.getTrips();
    },

    getTrips() {
      this.currResults = [];
      var typesStr = "0";
      for (var i = 0; i < this.types.length; i++) {
        typesStr += "," + this.types[i];
      }

      let tripsUrl =
        "http://localhost:8080/enjoytrip/attraction/list?sido=" +
        this.currAreaNum +
        "&gugun=" +
        this.currSigunguNum +
        "&types=" +
        typesStr;

      fetch(tripsUrl)
        .then((response) => response.json())
        .then((data) => this.getResults(data));
    },

    getResults(result) {
      var cardPanel = document.getElementById("card-panel");

      let originCnt = cardPanel.children.length;
      for (var i = 0; i < originCnt; i++) {
        cardPanel.children[0].remove();
      }

      for (var j = 0; j < result.length; j++) {
        this.excute(result[j]);
      }
    },

    excute(currResult) {
      this.addCard(currResult);
    },

    addCard(result) {
      var cardPanel = document.getElementById("card-panel");

      var titleEl = document.createElement("h5");
      titleEl.setAttribute("class", "card-title");
      titleEl.appendChild(document.createTextNode(result.title));

      var pEl = document.createElement("p");
      pEl.setAttribute("class", "card-text");
      pEl.appendChild(document.createTextNode(result.addr1));

      var form = document.createElement("div");
      var input0 = document.createElement("input");
      input0.setAttribute("type", "hidden");
      input0.setAttribute("name", "action");
      input0.setAttribute("value", "addroute");
      form.appendChild(input0);

      var input1 = document.createElement("input");
      input1.setAttribute("type", "hidden");
      input1.setAttribute("name", "contentid");
      input1.setAttribute("value", result.contentId);
      form.appendChild(input1);

      var input101 = document.createElement("input");
      input101.setAttribute("type", "hidden");
      input101.setAttribute("name", "longitude");
      input101.setAttribute("value", result.longitude);
      form.appendChild(input101);

      var input102 = document.createElement("input");
      input102.setAttribute("type", "hidden");
      input102.setAttribute("name", "latitude");
      input102.setAttribute("value", result.latitude);
      form.appendChild(input102);

      var input11 = document.createElement("input");
      input11.setAttribute("type", "hidden");
      input11.setAttribute("name", "userid");
      input11.setAttribute("value", "${userinfo.id}");
      form.appendChild(input11);

    //   var input2 = document.createElement("button");
    //   input2.setAttribute("class", "w-100 btn rounded-3 btn-primary");
    //   input2.setAttribute("value", "추가");
    //   input2.innerHTML = "추가";
    //   let self = this;
    //   input2.onclick = function () {
    //     self.route.push(result);
    //     self.attractions.push(result.contentId);
    //     self.getRoutes();
    //   };
    //   form.appendChild(input2);

      var cardBodyEl = document.createElement("div");
      cardBodyEl.setAttribute("class", "card-body");
      cardBodyEl.appendChild(titleEl);
      cardBodyEl.appendChild(pEl);
      cardBodyEl.appendChild(form);

      var imgEl = document.createElement("img");
      imgEl.setAttribute("src", result.firstImage);
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
    },

    getRoutes() {
      var cardPanel = document.getElementById("route-panel");

      let originCnt = cardPanel.children.length;
      for (var i = 0; i < originCnt; i++) {
        cardPanel.children[0].remove();
      }

      this.getRouteResults();
    },

    getRouteResults() {
      for (var i = 0; i < this.route.length; i++) {
        this.addRouteCard(this.route[i], i);
      }
    },

    addRouteCard(result, idx) {
      var cardPanel = document.getElementById("route-panel");

      var titleEl = document.createElement("h5");
      titleEl.setAttribute("class", "card-title");
      titleEl.appendChild(document.createTextNode(result.title));

      var pEl = document.createElement("p");
      pEl.setAttribute("class", "card-text");
      pEl.appendChild(document.createTextNode(result.addr1));

      var form = document.createElement("div");

      var input0 = document.createElement("input");
      input0.setAttribute("type", "hidden");
      input0.setAttribute("name", "action");
      input0.setAttribute("value", "deleteroute");
      form.appendChild(input0);

      var input1 = document.createElement("input");
      input1.setAttribute("type", "hidden");
      input1.setAttribute("name", "contentid");
      input1.setAttribute("value", result.contentId);
      form.appendChild(input1);

      var input11 = document.createElement("input");
      input11.setAttribute("type", "hidden");
      input11.setAttribute("name", "userid");
      input11.setAttribute("value", "${userinfo.id}");
      form.appendChild(input11);

      var input2 = document.createElement("button");
      input2.setAttribute(
        "class",
        "w-100 mb-2 btn btn-lg rounded-3 btn-primary"
      );
      input2.innerHTML = "삭제";
      let self = this;
      input2.onclick = function () {
        self.route.splice(idx, 1);
        self.attractions.splice(idx, 1);
        self.getRoutes();
      };
      form.appendChild(input2);

      var imgEl = document.createElement("img");
      imgEl.setAttribute("src", result.firstImage);
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
    },
  }
};
</script>
