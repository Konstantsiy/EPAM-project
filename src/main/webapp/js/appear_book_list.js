function scrollAppear() {
    console.log("start processing");
    var introGenres = document.querySelector('.intro-genres');
    var introGenresPos = introGenres.getBoundingClientRect().top;
    var screenPosForGenres = window.innerHeight / 2;

    var introAuthors = document.querySelector('.intro-authors');
    var introAuthorsPos = introAuthors.getBoundingClientRect().top;
    var screenPosForAuthors = window.innerHeight / 2;

    if(introGenresPos < screenPosForGenres) {
        introGenres.classList.add('intro-genres-appear');
    }

    if(introAuthorsPos < screenPosForAuthors) {
        introAuthors.classList.add('intro-authors-appear');
    }
}

window.addEventListener('scroll', scrollAppear);