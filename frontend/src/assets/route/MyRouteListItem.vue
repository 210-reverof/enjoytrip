<template>
    <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
            <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">나의 여행 목록</mark>
            </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
            <div class="row align-self-center mb-2">
            <div class="col-md-2 text-start">
                <a href="#" class="btn btn-outline-primary btn-sm">
                여행 경로 추가하기
                </a>
            </div>
            </div>
            <table class="table table-hover">
            <thead>
                <tr class="text-center">
                <th scope="col">경로번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">생성일</th>
                </tr>
            </thead>
            <tbody>
                 
            </tbody>
            </table>
        </div>
    </div>
</template>

<script>
export default {
    name: "MyRouteList",
}
</script>
