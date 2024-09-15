function addToCart(itemId, buyQuantity, action) {
                                                // Make the asynchronous request to the server
                                                $.ajax({
                                                    url: 'addCartItem', // Servlet URL
                                                    type: 'POST',
                                                    data: {
                                                        id: itemId,
                                                        quantity: buyQuantity
                                                    },
                                                    success: function(response) {
                                                        if(response.succeeded === "1"){
                                                             //$('#err-' + itemId).text("quantity out of stock!");
                                                             showStockError("Added Successfully!");
                                                         }
                                                        else{
                                                            showStockError("quantity out of stock!");
                                                        }
                                                    },
                                                    error: function() {
                                                        alert("Error adding item!");
                                                    }
                                                });
                                            }
                                            function showStockError(msg) {
                                                var popup = document.getElementById("stock-error");
                                                popup.innerHTML = msg;
                                                popup.style.display = "block"; // Show the popup

                                                // Hide the popup after 3 seconds (3000 milliseconds)
                                                setTimeout(function() {
                                                    popup.style.display = "none"; // Hide the popup
                                                }, 3000);
                                                }