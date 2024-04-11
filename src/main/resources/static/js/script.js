

    addProductButton.addEventListener('click', function() {
        productFormContainer.style.display = 'block';
        addProductButton.style.display = 'none';
    });

    const productForm = document.getElementById('productForm');
    const productTable = document.getElementById('productTable').getElementsByTagName('tbody')[0];

 function editProduct(button) {
        const row = button.parentNode.parentNode;
        const cells = row.cells;
        const productId = cells[0].textContent;
        const productName = cells[1].textContent;
        const description = cells[2].textContent;
        const price = cells[3].textContent;
        const category = cells[4].textContent;
        const quantity = cells[5].textContent;

        // Populate form fields with product details
        document.getElementById('productId').value = productId;
        document.getElementById('productName').value = productName;
        document.getElementById('description').value = description;
        document.getElementById('price').value = price;
        document.getElementById('category').value = category;
        document.getElementById('quantity').value = quantity;

        // Show the product form container
        document.getElementById('productFormContainer').style.display = 'block';
        // Hide the add product button
        document.getElementById('addProductButton').style.display = 'none';
    }









