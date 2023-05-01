<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <!-- HTML link 태그를 활용한 BootStrap 연동 -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css"
    />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap"
      rel="stylesheet"
    />
    <style>
      /* 캐러셀(이미지슬라이드) 이미지 크기변경 */
      .carousel-inner {
        width: 100%;
        height: 400px;
        /* 이미지 높이 변경 */
      }

      .carousel-item {
        width: 100%;
        height: 100%;
      }

      .d-block {
        display: block;
        width: 100%;
        height: 100%;
      }

      body {
        font-family: "Gowun Dodum", sans-serif;
      }

      .wrap {
        position: absolute;
        left: 0;
        bottom: 40px;
        width: 288px;
        height: 132px;
        margin-left: -144px;
        text-align: left;
        overflow: hidden;
        font-size: 12px;
        font-family: "Malgun Gothic", dotum, "돋움", sans-serif;
        line-height: 1.5;
      }
      .wrap * {
        padding: 0;
        margin: 0;
      }
      .wrap .info {
        width: 286px;
        height: 120px;
        border-radius: 5px;
        border-bottom: 2px solid #ccc;
        border-right: 1px solid #ccc;
        overflow: hidden;
        background: #fff;
      }
      .wrap .info:nth-child(1) {
        border: 0;
        box-shadow: 0px 1px 2px #888;
      }
      .info .title {
        padding: 5px 0 0 10px;
        height: 30px;
        background: #eee;
        border-bottom: 1px solid #ddd;
        font-size: 18px;
        font-weight: bold;
      }
      .info .close {
        position: absolute;
        top: 10px;
        right: 10px;
        color: #888;
        width: 17px;
        height: 17px;
        background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/overlay_close.png");
      }
      .info .close:hover {
        cursor: pointer;
      }
      .info .body {
        position: relative;
        overflow: hidden;
      }
      .info .desc {
        position: relative;
        margin: 13px 0 0 90px;
        height: 75px;
      }
      .desc .ellipsis {
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
      }
      .desc .jibun {
        font-size: 11px;
        color: #888;
        margin-top: -2px;
      }
      .info .img {
        position: absolute;
        top: 6px;
        left: 5px;
        width: 73px;
        height: 71px;
        border: 1px solid #ddd;
        color: #888;
        overflow: hidden;
      }
      .info:after {
        content: "";
        position: absolute;
        margin-left: -12px;
        left: 50%;
        bottom: 0;
        width: 22px;
        height: 12px;
        background: url("https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white.png");
      }
      .info .link {
        color: #5085bb;
      }
    </style>
  </head>

  <body>
    <!-- BootStrap Navigation Bar Sample -->
    <%@ include file="/WEB-INF/views/common/confirm.jsp" %>

    <div class="container">
      <!--원영 시작-->
      <!-- 관광지 검색 start -->
      <div id="search-top-label" class="fs-1 text-center">나의 여행 계획</div>
      
      <div id ="my-route-panel" class="container text-start">
          <div id="search-top-label" class="fs-4">현재 나의 여행</div>
      </div>
      <div id="route-panel"
        class="search-cards m-4 row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4 d-flex"
      >
        <!--내 여행 카드 시작-->
        <!--내 여행 카드 끝-->
      </div>
      <div id ="weight-panel" class="container text-start mb-2">
          <div id="weight-label" class="fs-6">여행지 개수 : ${fn:length(mycids)}</div>
          <div id="weight-label" class="fs-6">최소 이동 거리 : ${minweight} km </div>
      </div>
      
      
      
      <div id ="adding" class="container text-start">
          <div id="search-top-label" class="fs-4">추가하기</div>
      </div>      
      <form class="d-flex justify-content-evenly mt-3" role="search">
        <!--지역 선택-->
        <div class="row">
          <div class="d-inline-flex p-2">
            <select id="search-area-sel" class="form-select mx-2" onchange="changeAreaSel()">
              <option value="-1" selected>지역선택</option>
            </select>
            <select
              id="search-area-detail-sel"
              class="form-select mx-2"
              onchange="changeSigunguSel()"
            >
              <option value="-1" selected>구군선택</option>
            </select>
          </div>

          <!--유형 선택-->
          <div class="d-inline-flex p-2 align-items-center">
            <div class="px-4">
              <button type="button" class="btn btn-primary" id="select-all-btn">모두선택</button>
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
      <!-- 관광지 검색 end -->
      <div
        id="card-panel"
        class="search-cards m-4 row row-cols-1 row-cols-md-2 row-cols-lg-4 g-4 d-flex"
      >
        <!--카드 시작-->
        <!--카드 끝-->
      </div>

      <!--모달 시작-->
      <div class="modal fade" id="trip-info-modal" tabindex="-1">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">Modal title</h5>
              <button
                type="button"
                class="btn-close"
                data-bs-dismiss="modal"
                aria-label="Close"
              ></button>
            </div>
            <div class="modal-body">
              <p>Modal body text goes here.</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Save changes</button>
            </div>
          </div>
        </div>
      </div>
      <!--모달 끝-->
    </div>

    <svg xmlns="http://www.w3.org/2000/svg" style="display: none">
      <symbol id="bootstrap" viewBox="0 0 118 94">
        <title>Bootstrap</title>
        <path
          fill-rule="evenodd"
          clip-rule="evenodd"
          d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z"
        ></path>
      </symbol>
      <symbol id="facebook" viewBox="0 0 16 16">
        <path
          d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"
        />
      </symbol>
      <symbol id="instagram" viewBox="0 0 16 16">
        <path
          d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"
        />
      </symbol>
      <symbol id="twitter" viewBox="0 0 16 16">
        <path
          d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"
        />
      </symbol>
    </svg>

    <div class="container">
      <footer
        class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top"
      >
        <div class="col-md-4 d-flex align-items-center">
          <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
            <svg class="bi" width="30" height="24"><use xlink:href="#bootstrap" /></svg>
          </a>
          <span class="mb-3 mb-md-0 text-muted">&copy; 2023 Company, Inc</span>
        </div>

        <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
          <li class="ms-3">
            <a class="text-muted" href="#"
              ><svg class="bi" width="24" height="24"><use xlink:href="#twitter" /></svg
            ></a>
          </li>
          <li class="ms-3">
            <a class="text-muted" href="#"
              ><svg class="bi" width="24" height="24"><use xlink:href="#instagram" /></svg
            ></a>
          </li>
          <li class="ms-3">
            <a class="text-muted" href="#"
              ><svg class="bi" width="24" height="24"><use xlink:href="#facebook" /></svg
            ></a>
          </li>
        </ul>
      </footer>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e4cbdf27c43a803ff3c0f8fa1a9ec113&libraries=services,clusterer,drawing"
    ></script>
    <script>
    let serviceKey = "M3KVNZZ77dEKVDzXocK%2BBbXaXghygQd25WflNl70WZA9pOgx2ihFZSzaJbarptjUqHil53iFe%2F1oNLZtbi0DHg%3D%3D";
    let areaUrl = "https://apis.data.go.kr/B551011/KorService1/areaCode1?serviceKey="+serviceKey+"&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=AppTest&_type=json";
    var currAreaNum = -1;
    var currSigunguNum = -1;
    var types = [12, 14, 15, 25, 28, 32, 38, 39];
    var originTypeNums = [12, 14, 15, 25, 28, 32, 38, 39];
    var currResults = [];
    const cids = ${mycids};

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
    
    </script>
    <script src="https://kit.fontawesome.com/64df31442a.js" crossorigin="anonymous"></script>
  </body>
</html>
