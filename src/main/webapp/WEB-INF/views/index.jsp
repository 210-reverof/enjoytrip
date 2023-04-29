<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <!-- HTML link 태그를 활용한 BootStrap 연동 -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
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
    </style>
  </head>

  <body>
    <!-- BootStrap Navigation Bar Sample -->
    <%@ include file="/WEB-INF/views/common/confirm.jsp" %>

    <!-- 캐러셀 이미지 슬라이드 시작-->
    <div class="container text-center">
      <div class="row bg-primary-subtle">
        <div class="column bg-primary-subtle mb-5 bg-body rounded">
          <div
            id="carouselExampleControls"
            class="carousel slide shadow-lg"
            data-bs-ride="carousel"
          >
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="<%= root %>/res/img/top7.flower.png" class="d-block w-100" alt="..." />
              </div>
              <div class="carousel-item">
                <img src="<%= root %>/res/img/junimg12.png" class="d-block w-100" alt="..." />
              </div>
              <div class="carousel-item">
                <img src="<%= root %>/res/img/junimg10.png" class="d-block w-100" alt="..." />
              </div>
            </div>
            <button
              class="carousel-control-prev"
              type="button"
              data-bs-target="#carouselExampleControls"
              data-bs-slide="prev"
            >
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button
              class="carousel-control-next"
              type="button"
              data-bs-target="#carouselExampleControls"
              data-bs-slide="next"
            >
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>
      </div>
      <!-- 캐러셀 이미지 슬라이드 끝 -->

      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--원영 시작-->
      <div class="row m-1">
        <div class="col-3">
          <div id="our-area-title" class="fs-2 text-start m-3">우리지역 관광지</div>
          <div class="fs-5 text-start m-3">
            우리지역의 숨어있는 아름다운 관광지를 알려드립니다. 관광지 주변의 맛집, 숙박업소와
            여행코스, 지역 축제등을 보실수도 있습니다.
          </div>
        </div>

        <div class="col-9">
          <div id="our-trips-panel" class="row row-cols-1 row-cols-lg-3 m-3 flex-nowrap justify-content-md-center">
            <!-- 우리지역 관광지 시작-->
            <!--우리지역 관광지 끝 -->
          </div>
        </div>
      </div>

      <!--모달 시작 우리지역 관광지-->
      <div class="modal fade" id="area-trip-modal" tabindex="-1">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" style="color: SeaGreen; font-weight: bold">관광지 정보</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <h5 class="modal-title" style="color: SeaGreen">서울</h5>
              <div class="card">
                <div style="width: fit-content">
                  <img src="<%= root %>/res/img/junimg04.png" class="card-img-top" alt="..." />
                </div>
                <div class="card-body text-left">
                  <p class="card-text text-start m-1">주소</p>
                  <p class="card-text text-start m-1">설명</p>
                  <p class="card-text text-start m-1">전화번호</p>
                  <p class="card-text text-start m-1">조회수</p>
                  <p class="card-text text-start m-1">홈페이지</p>
                  <p class="card-text text-start m-1">길찾기</p>
                </div>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Save changes</button>
            </div>
          </div>
        </div>
      </div>
      <!--모달 끝-->

      <hr width="”길이”" color="”색상코드”" noshade />

      <!--핫플 자랑하기 시작-->
      <div class="row m-1">
        <div class="col-9">
          <div class="row row-cols-1 row-cols-lg-3 m-3 flex-nowrap justify-content-md-center">
            <!--우리지역 관광지 시작-->
            <div
              class="m-3"
              style="box-shadow: 0px 0px 15px grey"
              data-bs-toggle="modal"
              data-bs-target="#area-trip-modal"
            >
              <img src="<%= root %>/res/img/junimg03.png" class="card-img-top" />
            </div>
            <!--우리지역 관광지 끝-->
            <!--우리지역 관광지 시작-->
            <div
              class="m-3"
              style="box-shadow: 0px 0px 15px grey"
              data-bs-toggle="modal"
              data-bs-target="#area-trip-modal"
            >
              <img src="<%= root %>/res/img/junimg05.png" class="card-img-top" />
            </div>
            <!--우리지역 관광지 끝-->
            <!--우리지역 관광지 시작-->
            <div
              class="m-3"
              style="box-shadow: 0px 0px 15px grey"
              data-bs-toggle="modal"
              data-bs-target="#area-trip-modal"
            >
              <img src="<%= root %>/res/img/junimg06.jpg" class="card-img-top" />
            </div>
            <!--우리지역 관광지 끝-->
          </div>
        </div>
        <div class="col-3">
          <div id="our-area-title" class="fs-2 text-start m-3">핫플 자랑하기</div>
          <div class="fs-5 text-start m-3">나만 알고있는 핫플!!! 자랑해 주세요.</div>
        </div>
      </div>

      <!--원영 끝-->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
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

    <div class="container d-flex flex-column">
      <img src="<%= root %>/res/img/junimg20.jpg" class="shadow-lg" alt="" />
      <footer
        class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top"
      >
        <div class="col-md-4 d-flex align-items-center">
          <span class="mb-3 mb-md-0 text-success">&copy; 2023 Company, Inc</span>
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
    
    <script src="<%= root %>/res/js/indexfunction.js"></script>
    <script src="https://kit.fontawesome.com/64df31442a.js" crossorigin="anonymous"></script>
  </body>
</html>
