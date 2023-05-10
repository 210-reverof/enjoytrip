// 로그인
function login() {
  opener.document.getElementById("header_nav_confirm_off").style.display = "none";
  opener.document.getElementById("header_nav_confirm_on").style.display = "contents";
}

// 로그아웃
function logout() {
  document.getElementById("header_nav_confirm_off").style.display = "contents";
  document.getElementById("header_nav_confirm_on").style.display = "none";
}