
function buttonClick() {
    
    var test = "This is a test";
    var site = CreateURL();
        var suffix =
            [".com", ".net", ".gov", ".org", ".cn", ".uk", ".info", ".nl", ".EU",
                    ".RU", ".DE"];
    site = "https://www." + site + suffix[generateRandomNumber(0, 10)];
    document.getElementById("p1").innerHTML = site;
        check = checkURL(site, function (check) {
            if (check) {
                window.location.replace(site);
            }
            else {
                document.getElementById("p1").innerHTML = site + " bad URL";
                buttonClick();
            }
        }
        );
            
       

    }

function generateRandomNumber(min, max) {
    return Math.round(Math.random() * (max - min) + min);
}

function checkURL(url, callback) {
    // try to load favicon
    var timer = setTimeout(function () {
        // timeout after 5 seconds
        callback(false);
    }, 5000)

    var img = document.createElement("img");
    img.onload = function () {
        clearTimeout(timer);
        callback(true);
    }

    img.onerror = function () {
        clearTimeout(timer);
        callback(false);
    }

    img.src = url + "/favicon.ico";
}

  function CreateURL()
{
    var site = "";
    var alphabet =
        [
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
          ];
      var i;
      for (i = 0; i < generateRandomNumber(2, 12); i++)
      {
        site += alphabet[generateRandomNumber(0,25)];
    }
    return site;
}