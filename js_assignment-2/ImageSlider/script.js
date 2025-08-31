document.addEventListener("DOMContentLoaded", () => {
  const images = [
    "https://picsum.photos/id/1015/720/360",
    "https://picsum.photos/id/1016/720/360",
    "https://picsum.photos/id/1018/720/360",
    "https://picsum.photos/id/1020/720/360",
    "https://picsum.photos/id/1024/720/360"
  ];

  let currentIndex = 0;
  let intervalId = null;

  const slide = document.getElementById("slide");
  const nextBtn = document.getElementById("next");
  const prevBtn = document.getElementById("prev");
  const slider = document.getElementById("slider");

  function show(index) {
    if (index < 0) index = images.length - 1;
    if (index >= images.length) index = 0;
    currentIndex = index;
    slide.src = images[currentIndex];
  }

  function next() { show(currentIndex + 1); }
  function prev() { show(currentIndex - 1); }

  function startAutoPlay() {
    intervalId = setInterval(next, 3000); // change every 3 sec
  }

  function stopAutoPlay() {
    clearInterval(intervalId);
  }

  nextBtn.addEventListener("click", next);
  prevBtn.addEventListener("click", prev);

  slider.addEventListener("mouseenter", stopAutoPlay);
  slider.addEventListener("mouseleave", startAutoPlay);

  show(currentIndex);
  startAutoPlay();
});
