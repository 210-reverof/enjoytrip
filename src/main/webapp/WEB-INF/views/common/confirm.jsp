<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%
String root = request.getContextPath();
%>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<c:if test="${not empty msg}">
<script type="text/javascript">
  alert("${msg}");

</script>
</c:if>
<c:if test="${not empty userinfo}">
	<header class="p-3 text-white">
      <div class="container-fluid">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
          <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 align-items-center">
            <!--<img src="/wyimg/grean-obj-3.png" alt="">-->
            <li>
              <a href="<%= root %>/" class="nav-link mx-5 p-3 ps-5 px-2 fs-1" style="color: SeaGreen">Enjoy Trip</a>
            </li>
            <li>
              <a href="<%= root %>/searchpage" class="nav-link ps-5 px-2 fs-5" style="color: ForestGreen">지역별여행지</a>
            </li>
            <li>
              <a href="<%= root %>/routepage/userid=${userinfo.id}" class="nav-link ps-3 px-2 fs-5" style="color: SkyBlue">나의여행계획</a>
            </li>
            <li>
              <a href="#" class="nav-link ps-3 px-2 fs-5" style="color: Crimson">핫플자랑하기</a>
            </li>
            <li>
              <a href="<%= root %>/sharearticlelistpage" class="nav-link ps-3 px-2 fs-5" style="color: Plum">여행정보공유</a>
            </li>
            <li>
              <a href="${root}/informarticle?pgno=1&key=&word=" class="nav-link ps-3 px-2 fs-5" style="color: Plum">공지사항</a>
            </li>
          </ul>


          <!--로그인 후-->
         <div class="text-end mx-5" id="header_nav_confirm_off">
            <a
              class="btn fs-5"
              style="color: SeaGreen"
              id="btnlogout"
              href="<%= root %>/user/logout"
            >로그아웃
            </a>
            <button
              type="button"
              class="btn fs-5"
              style="color: CornflowerBlue"
              id="btnmy"
              data-bs-toggle="modal"
              data-bs-target="#mypageModal"
            >내 정보
            </button>
         </div>
    </header>
        <!-- The Modal 내정보-->
    <div class="modal fade" tabindex="-1" role="dialog" id="mypageModal">
      <div class="modal-dialog" role="document">
        <div class="modal-content rounded-4 shadow">
          <div class="modal-header p-5 pb-2 border-bottom-0">
            <!-- <h1 class="modal-title fs-5" >Modal title</h1> -->
            <h1 class="fw-bold mb-0 fs-4">내 정보</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body p-5 pt-0">
            <form id="form-modify" method="POST" action="<%= root %>/user/modify" >
              <div class="form-floating mb-3">
                <input type="text" class="form-control rounded-3" name="name" id="floatingPassword" placeholder="Name" value="${userinfo.name}" />
                <label for="floatingPassword">name</label>
              </div>
              <div class="form-floating mb-3">
                <input type="text" class="form-control rounded-3" name="id" id="floatingPassword" placeholder="Id" value="${userinfo.id}" />
                <label for="floatingPassword">id</label>
              </div>
              <div class="form-floating mb-3">
                <input type="password" class="form-control rounded-3" name="pw" id="floatingPassword" placeholder="Password" value="${userinfo.pw}" />
                <label for="floatingPassword">password</label>
              </div>
              <div class="form-floating mb-3">
                <input type="password" class="form-control rounded-3" name="pwcheck" id="floatingInput" placeholder="Passwordcheck" value="${userinfo.pw}" />
                <label for="floatingInput">password check</label>
              </div>
              <div class="form-floating mb-3">
                <input type="email" class="form-control rounded-3" name="email" id="floatingPassword" placeholder="Email" value="${userinfo.email}" />
                <label for="floatingPassword">email</label>
              </div>
              <input class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit" id="btn-modify" value = "정보 수정" />
            </form>
            <a class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" href="<%= root %>/user/delete/${userinfo.id}" id="btn-modify">회원 탈퇴</a>
          </div>
        </div>
      </div>
    </div>
</c:if>
<c:if test="${empty userinfo}">
 <header class="p-3 text-white">
      <div class="container-fluid">
        <div
          class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start"
        >
          <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 align-items-center">
            <!--<img src="/wyimg/grean-obj-3.png" alt="">-->
            <li>
              <a href="<%= root %>/" class="nav-link mx-5 p-3 ps-5 px-2 fs-1" style="color: SeaGreen">Enjoy Trip</a>
            </li>
            <li>
              <a href="<%= root %>/searchpage" class="nav-link ps-5 px-2 fs-5" style="color: ForestGreen">지역별여행지</a>
            </li>
            <li>
              <a href="<%= root %>/routepage/userid=${userinfo.id}" class="nav-link ps-3 px-2 fs-5" style="color: SkyBlue">나의여행계획</a>
            </li>
            <li>
              <a href="#" class="nav-link ps-3 px-2 fs-5" style="color: Crimson">핫플자랑하기</a>
            </li>
            <li>
              <a href="<%= root %>/sharearticlelistpage" class="nav-link ps-3 px-2 fs-5" style="color: Plum">여행정보공유</a>
            </li>
            <li>
              <a href="${root}/informarticle?pgno=1&key=&word=" class="nav-link ps-3 px-2 fs-5" style="color: Plum">공지사항</a>
            </li>
          </ul>

          <!--로그인 전-->
          <div class="text-end mx-5" id="header_nav_confirm_off">
            <button
              type="button"
              class="btn fs-5"
              style="color: SeaGreen"
              id="btnlogin"
              data-bs-toggle="modal"
              data-bs-target="#loginModal"
            >
              로그인
            </button>
            <button
              type="button"
              class="btn fs-5"
              style="color: Plum"
              id="btnsignin"
              data-bs-toggle="modal"
              data-bs-target="#signinModal"
            >
              회원가입
            </button>
          </div>
        </div>
      </div>
    </header>

    <!-- The Modal 로그인-->
    <div class="modal fade" tabindex="-1" role="dialog" id="loginModal">
      <div class="modal-dialog" role="document">
        <div class="modal-content rounded-4 shadow">
          <div class="modal-header p-5 pb-4 border-bottom-0">
            <!-- <h1 class="modal-title fs-5" >Modal title</h1> -->
            <h1 class="fw-bold mb-0 fs-2">로그인</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body p-5 pt-0">
            <form id="form-login" method="POST" action="<%= root %>/user/login" enctype="text">
	              <div class="form-floating mb-3">
	                <input type="text" class="form-control rounded-3" name="id" id="inputid" placeholder="Id" />
	                <label for="floatingInput">SSAFY</label>
	              </div>
	              <div class="form-floating mb-3">
	                <input type="password" class="form-control rounded-3" name="pw" id="inputpw" placeholder="Password"
	                />
	                <label for="floatingPassword">1234</label>
	              </div>
	              <input class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit" id="btnlogin2" value = "로그인" />
            </form>
          </div>
        </div>
      </div>
    </div>

    <!-- The Modal 회원가입-->
    <div class="modal fade" tabindex="-1" role="dialog" id="signinModal">
      <div class="modal-dialog" role="document">
        <div class="modal-content rounded-4 shadow">
          <div class="modal-header p-5 pb-2 border-bottom-0">
            <!-- <h1 class="modal-title fs-5" >Modal title</h1> -->
            <h1 class="fw-bold mb-0 fs-4">회원가입</h1>
            <button
              type="button"
              class="btn-close"
              data-bs-dismiss="modal"
              aria-label="Close"
            ></button>
          </div>
          <div class="modal-body p-5 pt-0">
             <form id="form-signup" method="POST" action="<%= root %>/user/join" >
              <div class="form-floating mb-3">
              	<input type="text" class="form-control rounded-3" name="name" id="floatingPassword" placeholder="Name" />
                <label for="floatingPassword">사용자 이름</label>
              </div>
              <div class="form-floating mb-3">
                <input type="text" class="form-control rounded-3" name="id" id="floatingPassword" placeholder="Id" />
                <label for="floatingPassword">ID</label>
              </div>
              <div class="form-floating mb-3">
                <input type="password" class="form-control rounded-3" name="pw" id="floatingPassword" placeholder="Password"/>
                <label for="floatingPassword">1234</label>
              </div>
              <div class="form-floating mb-3">
                <input type="password" class="form-control rounded-3" name="pwcheck" id="floatingInput" placeholder="Passwordcheck"/>
                <label for="floatingInput">1234</label>
              </div>
              <div class="form-floating mb-3">
                <input type="email" class="form-control rounded-3" name="email" id="floatingPassword" placeholder="Email" />
                <label for="floatingPassword">SSAFY@SSAFY.com</label>
              </div>
              <input class="w-100 mb-2 btn btn-lg rounded-3 btn-primary" type="submit" id="btn-join" value = "회원가입" />
            </form>
          </div>
        </div>
      </div>
    </div>
</c:if>