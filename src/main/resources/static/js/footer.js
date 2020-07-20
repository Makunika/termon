"use strict";



document.addEventListener('DOMContentLoaded', (event) => {

    window.addEventListener("resize", footerBottom);


    footerBottom();

    function footerBottom() {
        if (document.querySelector('.content_all').offsetHeight < screen.height - 200) {
            document.querySelector('.footer').classList.add('footer-fix');
            document.querySelector('.footer').classList.remove('footer-bottom');
        } else {
            document.querySelector('.footer').classList.add('footer-bottom');
            document.querySelector('.footer').classList.remove('footer-fix');
        }
    }
});