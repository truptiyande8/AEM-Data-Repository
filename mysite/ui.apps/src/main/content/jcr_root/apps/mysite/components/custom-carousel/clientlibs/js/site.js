document.addEventListener("DOMContentLoaded", function () {

    console.log("Carousel Started");

    const carousel = document.querySelector(".custom-carousel");

    const slides =
        carousel.querySelectorAll(".custom-carousel__slide");

    console.log("Slides:", slides.length);

    let currentIndex = 0;

    function showSlide(index) {

        console.log("Showing slide:", index);

        slides.forEach(function (slide, i) {

            slide.style.display =
                i === index ? "block" : "none";

        });
    }

    showSlide(currentIndex);

    setInterval(function () {

        currentIndex =
            (currentIndex + 1) % slides.length;

        console.log("Next slide:", currentIndex);

        showSlide(currentIndex);

    }, 3000);
});