"use strict";
/* 
   Author: Tanner Watmough
   Date: December 15, 2022

   File: marking.js

   The purpose of this script is to help with marking and the cross reference
   page. I also snuck in the dark mode theme to save on script files.

   Variables
   =========
  	
*/
var modeOn = true;


document.getElementById("marking").addEventListener("click", markingMode);
document.getElementById("markingList").addEventListener("click", markingMode); 

function markingMode() {
  var allInfo = document.getElementsByClassName("fa-circle-info");
  console.log(allInfo);

  if (modeOn) {
    console.log("on");
    for (var i = 0; i < allInfo.length; i++) {
      console.log(allInfo[i]);
      allInfo[i].style = "visibility: visible;";
    }
    modeOn = false;
  } else {
    console.log("off");
    for (var i = 0; i < allInfo.length; i++) {
      allInfo[i].style = "visibility: hidden;";
    }
    modeOn = true; 
  }
}

/* Dark Mode */
var darkModeBoolean = true;

function darkModeToggle() {
  if (darkModeBoolean) {
    console.log("darkmode off");
    document.getElementById("dark_theme").disabled = true;
    darkModeBoolean = false;
  } else {
    console.log("darkmode on");
    document.getElementById("dark_theme").disabled = false;
    darkModeBoolean = true;
  }
}

