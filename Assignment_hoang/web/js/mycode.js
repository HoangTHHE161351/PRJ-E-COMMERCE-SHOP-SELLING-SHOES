/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function addToCartNewArrival(code){
    document.newArrival.action = "buy?code=" + code + "&quantity=1&color=1";
    document.newArrival.submit();
}

function addToCartWomen(code){
    document.womenForm.action = "buy?code=" + code + "&quantity=1&color=1";
    document.womenForm.submit();
}

function addToCartAccessories(code){
    document.accessories.action = "buy?code=" + code + "&quantity=1&color=1";
    document.accessories.submit();
}

function addToCartSellers(code){
    document.sellers.action = "buy?code=" + code + "&quantity=1&color=1";
    document.sellers.submit();
}

function addToCartProductView(code){
    var quantity = document.getElementById('quantity_value').textContent;
    var size = document.getElementById('size_value').selected;
    
    document.producerView.action = "buy?code=" + code + "&quantity=" + quantity + "&size=" + size.value;
    document.producerView.submit();
}

