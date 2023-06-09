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
    <link rel="stylesheet" href="css/main.css" />
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
	<c:if test="${empty userinfo}">
        <script>
        alert("로그인 해주세요.");
        location.href = "${root}/hotplacearticle?pgno=1&key=&word=";
        </script>
    </c:if>

      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
      <!--원영 시작-->
    <div class="sb-nav-fixed">
      <div class="mt-5 pt-5">
        <div class="container px-4">
          <h1 class="mt-4 d-flex justify-content-center">핫플 자랑하기</h1>
          <div class="container rounded bg-success bg-opacity-75 text-white text-center fs-2 p-4">
            글수정
          </div>
  
          <div class="container">
            <form id="form-modify-inform" method="POST" action="" >
          	  <input type="hidden" name="pgno" value="${pgno}">
		      <input type="hidden" name="key" value="${key}">
		   	  <input type="hidden" name="word" value="${word}">
          	  <input type="hidden" name="articleNo" value="${article.articleNo}">
              <div class="pt-4 pb-4">
                <label for="title">제목</label>
                <input
                  type="text"
                  class="form-control"
                  id="title"
                  name="title"
                  placeholder="${article.title}"
                />
               	 제목을 입력하세요
              </div>
              <div class="pb-4">
                <label for="content">내용</label>
                <textarea
                  class="form-control"
                  id="content"
                  name="content"
                  rows="3"
                  placeholder="${article.content}"
                ></textarea>
              </div>
              <div class=" col-md-1 text-nowrap">
	            <button type="button" id="btn-modify-inform" class="btn btn-outline-primary mb-3">
					글수정
	            </button>
	            <button type="button" id="btn-list" class="btn btn-outline-danger mb-3">
	               	목록으로이동...
	            </button>
	          </div>
            </form>
          </div>
        </div>
      </main>
    </div>
    <!--모달 시작-->
    <div class="modal fade" id="area-trip-modal" tabindex="-1">
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

    <!--원영 끝-->
    <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
    <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
    <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
    <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
    <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
    <!--구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 구분선 -->
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
      <footer class="py-5">
        <div class="d-flex flex-column flex-sm-row justify-content-between py-4 my-4 border-top">
          <p>&copy; 2023 Company, Inc. All rights reserved.</p>
          <ul class="list-unstyled d-flex">
            <li class="ms-3">
              <a class="link-dark" href="#">
                <svg class="bi" width="24" height="24">
                  <use xlink:href="#twitter" />
                </svg>
              </a>
            </li>
            <li class="ms-3">
              <a class="link-dark" href="#">
                <svg class="bi" width="24" height="24">
                  <use xlink:href="#instagram" />
                </svg>
              </a>
            </li>
            <li class="ms-3">
              <a class="link-dark" href="#">
                <svg class="bi" width="24" height="24">
                  <use xlink:href="#facebook" />
                </svg>
              </a>
            </li>
          </ul>
        </div>
      </footer>
    </div>
    
    <form id="form-param" method="get" action="">
      <input type="hidden" id="pgno" name="pgno" value="${pgno}">
      <input type="hidden" id="key" name="key" value="${key}">
      <input type="hidden" id="word" name="word" value="${word}">
    </form>
    <script>
      document.querySelector("#btn-modify-inform").addEventListener("click", function () {
    	if (!document.querySelector("#title").value) {
          alert("제목 입력!!");
          return;
        } else if (!document.querySelector("#content").value) {
          alert("내용 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-modify-inform");
          form.setAttribute("action", "${root}/hotplacearticle/modify");
          form.submit();
        }
      });
      
      document.querySelector("#btn-list").addEventListener("click", function () {
         	if(confirm("취소를 하시면 작성중인 글은 삭제됩니다.\n취소하시겠습니까?")) {
         		let form = document.querySelector("#form-param");
            	form.setAttribute("action", "${root}/hotplacearticle");
              form.submit();
        	}
       });
    </script>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
    <script src="https://kit.fontawesome.com/64df31442a.js" crossorigin="anonymous"></script>
  </body>
</html>
