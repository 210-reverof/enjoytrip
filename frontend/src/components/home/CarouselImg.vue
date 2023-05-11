<template>
    <div class="container text-center">
      <div class="row bg-primary-subtle">
        <div class="column bg-primary-subtle mb-5 bg-body rounded">
          <div id="carouselExampleControls" class="carousel slide shadow-lg" data-bs-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="@/assets/home/img/top7.flower.png" class="d-block w-100" alt="..." />
              </div>
              <div class="carousel-item">
                <img src="@/assets/home/img/junimg12.png" class="d-block w-100" alt="..." />
              </div>
              <div class="carousel-item">
                <img src="@/assets/home/img/junimg10.png" class="d-block w-100" alt="..." />
              </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>
      </div>
    </div>
</template>

<script>

export default {
    name: "CarouselImage",
    mounted() {
      const script = document.createElement('script')
      script.src = 'https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'
      document.head.appendChild(script)
    }
}
</script>
