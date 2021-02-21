function scrollAppear() {
    var introContent = document.querySelector('.intro-content');
    var introPos = introContent.getBoundingClientRect().top;
    var screenPos = window.innerHeight / 2;

    // var introText = document.querySelector('.intro-text');
    // var introTextPos = introText.getBoundingClientRect().top;
    // var screenTextPos = window.innerHeight / 2;

    if(introPos < screenPos) {
        introContent.classList.add('intro-appear');
    }

    // if(introTextPos < screenTextPos) {
    //     introText.classList.add('intro-appear');
    // }
}

window.addEventListener('scroll', scrollAppear);