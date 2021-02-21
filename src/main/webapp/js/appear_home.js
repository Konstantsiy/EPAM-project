function scrollAppear() {
    var introContent = document.querySelector('.intro-content');
    var introPos = introContent.getBoundingClientRect().top;
    var screenPos = window.innerHeight / 2;

    var introGenres = document.querySelector('.intro-genres');
    var introGenresPos = introGenres.getBoundingClientRect().top;
    var screenPosForGenres = window.innerHeight;

    var introAuthors = document.querySelector('.intro-authors');
    var introAuthorsPos = introAuthors.getBoundingClientRect().top;
    var screenPosForAuthors = window.innerHeight;

    if(introPos < screenPos) {
        introContent.classList.add('intro-appear');
    }

    if(introGenresPos < screenPosForGenres) {
        introGenres.classList.add('intro-genres-appear');
    }

    if(introAuthorsPos < screenPosForAuthors) {
        introAuthors.classList.add('intro-authors-appear');
    }
}

window.addEventListener('scroll', scrollAppear);