<template>
        <div class="row m-1">
        <div class="col-9">
          <div class="row row-cols-1 row-cols-lg-3 m-3 flex-nowrap justify-content-md-center">
            <div class="m-3" style="box-shadow: 0px 0px 15px grey" data-bs-toggle="modal" data-bs-target="#area-trip-modal">
              <img src="@/assets/home/img/junimg03.png" class="card-img-top" />
            </div>
            <div class="m-3" style="box-shadow: 0px 0px 15px grey" data-bs-toggle="modal" data-bs-target="#area-trip-modal">
              <img src="@/assets/home/img/junimg05.png" class="card-img-top" />
            </div>
            <div class="m-3" style="box-shadow: 0px 0px 15px grey" data-bs-toggle="modal" data-bs-target="#area-trip-modal">
              <img src="@/assets/home/img/junimg06.jpg" class="card-img-top" />
            </div>
          </div>
        </div>
        <div class="col-3">
          <div id="our-area-title" class="fs-2 text-start m-3">핫플 자랑하기</div>
          <div class="fs-5 text-start m-3">나만 알고있는 핫플!!! 자랑해 주세요.</div>
        </div>
      </div>
</template>

<script>

export default {
  name: "HotPlaceImg",
}
</script>
