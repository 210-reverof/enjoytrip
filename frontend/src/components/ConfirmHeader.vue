<template>
    <header class="p-3 text-white">
        <div class="container-fluid">
            <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0 align-items-center">
                    <li>
                        <router-link to="/" class="nav-link mx-5 p-3 ps-5 px-2 fs-1" style="color: SeaGreen">Enjoy Trip</router-link>
                    </li>
                    <li>
                        <router-link to="/search" class="nav-link ps-5 px-2 fs-5" style="color: ForestGreen">지역별여행지</router-link>
                    </li>
                    <li>
                        <router-link to="/myroute" class="nav-link ps-5 px-2 fs-5" style="color: SkyBlue">나의여행계획</router-link>
                    </li>
                    <li>
                        <router-link to="/hotplace" class="nav-link ps-5 px-2 fs-5" style="color: Crimson">핫플자랑하기</router-link>
                    </li>
                    <li>
                        <router-link to="/share" class="nav-link ps-5 px-2 fs-5" style="color: Plum">여행정보공유</router-link>
                    </li>
                    <li>
                        <router-link to="/confirm" class="nav-link ps-5 px-2 fs-5" style="color: Plum">공지사항</router-link>
                    </li>
                </ul>
            </div>
        </div>
    </header>
</template>

<script>

export default {
    
}

</script>
