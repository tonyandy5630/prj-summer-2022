/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let status = document.querySelectorAll('#status');

const statusArr = [...status];

statusArr.forEach(function(item){
    if(item.innerText==='Processing')
    {
        item.classList.add('processing')
        console.log(item)
        
    }
    else if(item.innerText === 'Canceled')
    {
         item.classList.add('canceled')
    }
    else if(item.innerText === 'Completed'){
         item.classList.add('completed')
    }
})


