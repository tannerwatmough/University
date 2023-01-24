"use strict";

/*
  New Perspectives on HTML5 and CSS3, 7th Edition
  Tutorial 9
  Tutorial Case

   Author: Tanner Watmough
   Date: December 16, 2022
   
   Filename:   clock.js   
*/

/* Execute the function to run and display the countdown clock */
runClock();
setInterval("runClock()", 1000);

/* Function to create and run the countdown clock */
function runClock() {
  /* Store the current date and time */
  var currentDay = new Date();
  var dateStr = currentDay.toLocaleDateString();
  var timeStr = currentDay.toLocaleTimeString();

  /* Display the current date and time */
  document.getElementById("currentTime").innerHTML = dateStr + "<br />" + timeStr;

  /* Calculate the days until January 1st */
  var carnival = new Date("February 17, 2022");
  var nextYear = currentDay.getFullYear() + 1;
  carnival.setFullYear(nextYear);
  var daysLeft = (carnival - currentDay)/(1000*60*60*24);
  // newYear - currentDay is in milliseconds, so we convert to days. 
  var hoursLeft = (daysLeft - Math.floor(daysLeft)) * 24;
  var minutesLeft = (hoursLeft - Math.floor(hoursLeft)) * 60;
  var secondsLeft = (minutesLeft - Math.floor(minutesLeft)) * 60;

  /* Display the time left until New Year's Eve */
  document.getElementById("days").textContent = Math.floor(daysLeft);
  document.getElementById("hours").textContent = Math.floor(hoursLeft);
  document.getElementById("minutes").textContent = Math.floor(minutesLeft);
  document.getElementById("seconds").textContent = Math.floor(secondsLeft);

}