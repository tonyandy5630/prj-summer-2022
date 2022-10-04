let navItem = document.querySelectorAll('.nav-item-container');
navItem.forEach(function(item) {

    item.addEventListener('mouseover', function() {
        let borderBottom = item.querySelector(".bottom-border");
        if (borderBottom != null) {
            borderBottom.style.animation = 'underline 0.3s ease-in-out';
            borderBottom.style.borderBottom = '1px solid white'
        }
    })

    item.addEventListener('mouseout', function() {
        let borderBottom = item.querySelector(".bottom-border");
        if (borderBottom != null) {
            borderBottom.removeAttribute('style');
        }
    })
})