"use strict";
/* 
   Author: Tanner Watmough
   Date: December 15, 2022

   File: forms.js

   The purpose of this script is to provide form validation.
  	
*/

/* Validation function from Tutorial 7 of New Perspectives on HTML and CSS, 7E */
window.onload = setForm;

function setForm() {
  document.forms[0].onsubmit = function() {
     if (this.checkValidity()) alert("No invalid data detected. Will retain data for further testing.");
     return false;
  }
}


/* Custom code to make a reset button that works with confirm alert validation */
document.getElementById("resetBtn").onclick = reset;

function reset() {
  console.log("Got here");
  if (confirm("Do you wish to reset your progress?")) {
    console.log("And here");
    var inputs = document.getElementsByTagName("input");
    console.log(inputs);
    for (var i = 0; i < inputs.length; i++) {
      inputs[i].value = "";
      if (i == inputs.length-1) {
        inputs[i].value = "Send";
      }
    }
  }
}