/*
   Author: Tanner Watmough
   Date:   December 14, 2022

   Filename: comments.js


*/

// When add review is clicked, call addComments()
document.getElementById("addReview").onclick = addComments;

function addComments() {
  // Finds the div that will store the reviews
  var reviewsDIV = document.getElementById("reviews");

  // Create the review elements
  var blockquote = document.createElement("blockquote");

  // Creating star paragraph element and its text
  var stars = document.createElement("p");
  var starContent = document.getElementById("stars").value;
  if (starContent == 1) {
    // Value of 1 star, creates one star and gives it the source and alt attrs.
    var starImg1 = document.createElement("img");
    starImg1.setAttribute("src", "/images/star.png");
    starImg1.setAttribute("alt", "One Star");
    stars.appendChild(starImg1);
  } else if (starContent == 2) {
    // Value of 2 stars, creates two stars and gives the source and alt attrs.
    var starImg1 = document.createElement("img");
    starImg1.setAttribute("src", "/images/star.png");
    var starImg2 = document.createElement("img");
    starImg2.setAttribute("src", "/images/star.png");
    starImg1.setAttribute("alt", "Two Stars");
    stars.appendChild(starImg1);
    stars.appendChild(starImg2);
  } else if (starContent == 3) {
    // Value of 3 stars, creates three stars and gives the source and alt attrs.
    var starImg1 = document.createElement("img");
    starImg1.setAttribute("src", "/images/star.png");
    var starImg2 = document.createElement("img");
    starImg2.setAttribute("src", "/images/star.png");
    var starImg3 = document.createElement("img");
    starImg3.setAttribute("src", "/images/star.png");
    starImg1.setAttribute("alt", "Three Stars");
    stars.appendChild(starImg1);
    stars.appendChild(starImg2);
    stars.appendChild(starImg3);
  } else {
    // Value of 4 stars, creates four stars and gives the source and alt attrs.
    var starImg1 = document.createElement("img");
    starImg1.setAttribute("src", "/images/star.png");
    var starImg2 = document.createElement("img");
    starImg2.setAttribute("src", "/images/star.png");
    var starImg3 = document.createElement("img");
    starImg3.setAttribute("src", "/images/star.png");
    var starImg4 = document.createElement("img");
    starImg4.setAttribute("src", "/images/star.png");
    starImg1.setAttribute("alt", "Four Stars");
    stars.appendChild(starImg1);
    stars.appendChild(starImg2);
    stars.appendChild(starImg3);
    stars.appendChild(starImg4);
  }

  // Creating comment paragraph element and its text
  var comment = document.createElement("p");
  // Gets value of textarea and assigns it to the text node
  var commentContent = document.getElementById("comment").value;
  var commentTextNode = document.createTextNode(commentContent);
  comment.appendChild(commentTextNode);

  // Creating userName paragraph element and its text
  var userName = document.createElement("p");
  // Gets value of user name and assigns it to the text node.
  var userContent = document.getElementById("username").value;
  var userText = document.createTextNode("-- "+ userContent);
  userName.appendChild(userText);

  // Creating postTime paragraph element and its text
  var postTime = document.createElement("p");
  /* 
    Getting current date. Adjusted for UTC so different users from other time 
    zones don't have comments in the "future" as a user in Australia could post 
    at the same time as someone in BC and it'd appear as if the Austrlian 
    posted a day later. 
  */
  var date = new Date();
  var year = date.getUTCFullYear();
  var month = date.getUTCMonth();
  var day = date.getUTCDate();
  var hours = date.getUTCHours();
  var minutes = date.getUTCMinutes();
  var time = hours + ":" + minutes;
  var dateText = day + "/" + month + "/" + year + " " + time;
  var timeText = document.createTextNode(dateText);
  postTime.appendChild(timeText);

  // Appends all created elements to the blockquote
  blockquote.appendChild(stars);
  blockquote.appendChild(comment);
  blockquote.appendChild(userName);
  blockquote.appendChild(postTime);
  // Makes it so the newest comment appears first in list. 
  reviewsDIV.after(blockquote);
}