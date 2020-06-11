function showMoreInfo(obj) {

  // Remove button "Show more Info"
  document.getElementById("moreInfo").remove();

  // Create new list element with elements from wiki page
  var list = fetchWikiInfo();

  // Create button to hide info about registration pages
  var hideButton = document.createElement("button");
  var hideButtonText = document.createTextNode("Hide all");
  hideButton.appendChild(hideButtonText);
  hideButton.setAttribute("id", "hideButton");
  hideButton.setAttribute("onClick", "JavaScript:hideInfo(this)")

  // Add button and list to content
  var content = document.getElementById("content");
  content.appendChild(list);
  content.appendChild(hideButton);
};


function fetchWikiInfo() {

    var url = "https://en.wikipedia.org/w/api.php";
    var params = {
        action: "query",
        format: "json",
        list: "allpages",
        apfrom: "Registration"
    };
    var lstWithNewElements = document.createElement("ul");

    url = url + "?origin=*";
    Object.keys(params).forEach(function(key){url += "&" + key + "=" + params[key];});

    fetch(url)
        .then(function(response){return response.json();})
        .then(function(response) {
        var pages =  response.query.allpages;
        console.log(pages);

        for (i = 0; i < 10; i++)  {
            var listElement = document.createElement("li");
            console.log(pages[i]);
            var listText = document.createTextNode("Page title is: " + pages[i].title);
            listElement.appendChild(listText);
            lstWithNewElements.appendChild(listElement);
            };
        })
        .catch(function(error){console.log(error);});

    console.log(lstWithNewElements)
    return lstWithNewElements;
    }

function hideInfo(obj) {
  // Remove hide info button
  document.getElementById("hideButton").remove();

  // Remove all elements inside node with id=content
  var content = document.getElementById("content");
  content.innerHTML = '';

  // Create button "Show more Info"
  var showButton = document.createElement("button");
  var showButtonText = document.createTextNode("Click here to see more");

  // Add button to node with id=content
  showButton.appendChild(showButtonText);
  showButton.setAttribute("id", "moreInfo");
  showButton.setAttribute("onClick", "JavaScript:showMoreInfo(this)")
  content.appendChild(showButton);
};