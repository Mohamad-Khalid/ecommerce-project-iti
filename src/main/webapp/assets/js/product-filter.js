var currentSize = 12;
var currentPage = 1;
var filterDict = {
    page: 1,
    size: currentSize
};

function changePage(pageNum){
    filterDict.page=pageNum;
    search();
}

function changeSize(){
    currentSize =  $("#selectPageSize").val();
    filterDict = {
        page: 1,
        size: currentSize
    };
    search();
}

    function filter() {
        filterDict = {
            page: 1,
            size:currentSize,
            'min-price': parseInt($('[data-handle="0"]').attr('aria-valuetext')) * 100,
            'max-price': parseInt($('[data-handle="1"]').attr('aria-valuetext')) * 100
        }

        const category = $('input[name="category"]:checked')
        if(category.val()!==undefined){
            filterDict['category']=category.val();
            category.prop('checked', false);
        }

        const brand =$('input[name="brand"]:checked');
        if(brand.val()!==undefined){
            filterDict['brand']=brand.val();
            brand.prop('checked', false);
        }

        const processor =$('input[name="processor"]:checked');
        if(processor.val()!==undefined){
            filterDict['processor']=processor.val();
            processor.prop('checked', false);
        }

        const memory =$('input[name="memory"]:checked');
        if(memory.val()!==undefined){
            filterDict['memory']=parseInt(memory.val());
            memory.prop('checked', false);
        }

        const os =$('input[name="os"]:checked');
        if(os.val()!==undefined){
            filterDict['os']=os.val();
            os.prop('checked', false);
        }


        search();
    }

function search() {
    var queryParams = new URLSearchParams(filterDict).toString();
    $.get("products?" + queryParams, function (response) {
        console.log(response);
        // Assuming response is an array of ProductDTO objects
        var data = response.data;
        var page = response.page;
        createPagination(page, filterDict.page);

        // Clear the productBox before appending new products
        $('#productBox').empty();
        // Iterate over each product and generate HTML
        $.each(data, function (index, product) {
            var productHtml = `
                        <div class="col-lg-4 col-md-6">
                            <div class="single-product">
                                <div class="img-container">
                                <img class="img-fluid" src="${product.image}" alt="${product.name}">
                            </div>
                                <div class="product-details">
                                    <h6>${product.name}</h6>
                                    <div class="price">
                                        <h6>${(Number.parseFloat(product.price) / 100).toFixed(2)} EGP</h6>
                                    </div>
                                    <div class="prd-bottom">
                                        <a href="#" class="social-info" onclick="event.preventDefault(); addToCart(${product.id},1);">
                                            <span class="ti-bag"></span>
                                            <p class="hover-text">add to bag</p>
                                        </a>
                                        <a href="/ecommerce/web/single-product.jsp?id=${product.id}" class="social-info">
                                            <span class="lnr lnr-move"></span>
                                            <p class="hover-text">view more</p>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    `;
            // Append the generated HTML to productBox
            $('#productBox').append(productHtml);
        });
    });
}

function createPagination(totalPages, currentPage) {
    const container = document.getElementById('pagination');
    container.innerHTML = '';  // Clear previous pagination

    const delta = 2; // Pages to show around the current page

    const createPageButton = (pageNum) => {
        const pageButton = document.createElement('a');
        pageButton.innerText = pageNum;
        if (pageNum === currentPage) {
            pageButton.classList.add('active');  // Highlight current page
        }
        pageButton.onclick = function() {
            loadPage(pageNum);
        };
        container.appendChild(pageButton);
    };

    const createLeftButton = () => {
        const pageButton = document.createElement('a');
        pageButton.classList.add('prev-arrow');
        pageButton.classList.add('fa');
        pageButton.classList.add('fa-long-arrow-left');
        if(currentPage===1){
            pageButton.style.pointerEvents="none";
        }
        pageButton.onclick = function() {
            if(currentPage > 1){
                loadPage(currentPage - 1);
            }
        };
        container.appendChild(pageButton);
    }

    const createRightButton = () => {
        const pageButton = document.createElement('a');
        pageButton.classList.add('next-arrow');
        pageButton.classList.add('fa');
        pageButton.classList.add('fa-long-arrow-right');
        if(currentPage===totalPages){
            pageButton.style.pointerEvents="none";
        }
        pageButton.onclick = function() {
            if(currentPage < totalPages){
                loadPage(currentPage + 1);
            }
        };
        container.appendChild(pageButton);
    }

    createLeftButton();

    // First page
    if (currentPage > 1) {
        createPageButton(1);
    }

    // Dots if currentPage is not close to the beginning
    if (currentPage - delta > 2) {
        const dots = document.createElement('span');
        dots.innerText = '...';
        container.appendChild(dots);
    }

    // Pages around currentPage
    for (let i = Math.min(currentPage, Math.max(2, currentPage - delta)); i <= Math.max(currentPage, Math.min(totalPages - 1, currentPage + delta)); i++) {
        createPageButton(i);
    }

    // Dots if currentPage is not close to the end
    if (currentPage + delta < totalPages - 1) {
        const dots = document.createElement('span');
        dots.innerText = '...';
        container.appendChild(dots);
    }

    // Last page
    if (currentPage < totalPages) {
        createPageButton(totalPages);
    }
    createRightButton();
}

function loadPage(pageNumber) {
    currentPage = pageNumber;
    createPagination(10, pageNumber);
    changePage(pageNumber);
}

$(document).ready(function () {
    document.getElementById('selectPageSize').addEventListener('change', function() {
        const selectedSize = this.value;
        changeSize(selectedSize);
    });
    search();

        if (document.getElementById("price-range")) {
            var nonLinearSlider = document.getElementById("price-range");
            var minPriceFetched = parseInt(
                nonLinearSlider.getAttribute("data-min-price")
            )/100;
            var maxPriceFetched = parseInt(
                nonLinearSlider.getAttribute("data-max-price")
            )/100;
            console.log(minPriceFetched);
            if (nonLinearSlider.noUiSlider) {
                nonLinearSlider.noUiSlider.destroy();
            }
            noUiSlider.create(nonLinearSlider, {
                connect: true,
                behaviour: "tap",
                start: [minPriceFetched, maxPriceFetched],
                range: {
                    // Starting at 500, step the value by 500,
                    // until 4000 is reached. From there, step by 1000.
                    min: [minPriceFetched],
                    max: [maxPriceFetched],
                },
            });

            var nodes = [
                document.getElementById("lower-value"), // 0
                document.getElementById("upper-value"), // 1
            ];

            // Display the slider value and how far the handle moved
            // from the left edge of the slider.
            nonLinearSlider.noUiSlider.on(
                "update",
                function (values, handle, unencoded, isTap, positions) {
                    nodes[handle].innerHTML = values[handle];
                }
            );
        }

});


