/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function warning(){
    return window.confirm("Do you want to remove this prouduct ?");
}

let activatedPage;

document.querySelector('#manageAccount').addEventListener('click',function(){
//    event.preventDefault();
    activatedPage = event.target.parentNode.parentNode;
    activatedPage.classList.add("nav__tab__active");
    console.log(event.target.parentNode.parentNode);
});

function activePage(event){
    event.preventDefault();
    console.log(event.target.parentNode);
}

function confirm(message)
{
    return  window.confirm(message)
}

let warningSign = document.querySelector("#warning");
 warningSign.addEventListener("dblclick",function(){
     warningSign.style.display = 'none';
 })

