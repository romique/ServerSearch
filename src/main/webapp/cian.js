/**
 * Created by Валерий on 12.11.14.
 */
var objs;  //полученный результат поиска

function search(){
    document.getElementById("searchform").className = "invisible";
    document.getElementById("searchresultdiv").className = "visible";
    var urlrequest = encodeURIComponent(document.getElementById("url1").value);
    if (urlrequest != "") {
        var resp = sendRequest(urlrequest);
        objs = JSON.parse(resp);
        document.getElementById("resulthead").innerHTML = "Найдено " + objs.appartments.length + " квартир";
        displayResult(objs);
    }
}

function displayResult(data){
    var imagedata = ""
    var counter;
    if (document.getElementById("searchresult") != undefined){
        document.getElementById("searchresultdiv").removeChild(document.getElementById("searchresult"));
    }
    var searchresult = document.createElement("table");
    searchresult.setAttribute("id", "searchresult");
    document.getElementById("searchresultdiv").appendChild(searchresult);
    data.appartments.forEach(
        function(item,idx){
            imagedata = "";
            counter = idx + 1;
            makeNods(document.getElementById("searchresult"),idx+1);
            var applink = addChild(document.getElementById('appartmentdesc'+counter), "a", "");
            applink.setAttribute("href", item.url);
            applink.setAttribute("target", "_blank");
            applink.innerHTML = item.descr;
            item.images.forEach(function(item, idx){
                var appimgid = "app"+counter+"img"+(idx+1);
                var image = addChild(document.getElementById('appartmentimages'+counter), "img", appimgid);
                image.className = "standart";
                image.src = item;
                image.addEventListener('click', resizeImg);
            })

        }
    )
}

function resizeImg(ev){
    if (this.className == "standart"){
        this.className = "big";
    } else {
        this.className="standart";
    }
}

function makeNods(node, id){
    var appartment = addChild(node, "tr", "appartment"+id);
    appartment.className = "appartment";
    var desctd = addChild(appartment, "td", "");
    var appartmentdesc = addChild(desctd, "div", "appartmentdesc"+id);
    appartmentdesc.className = "appartment-desc";
    var imgtd = addChild(appartment, "td", "");
    var appartmentimages = addChild(imgtd,"div", "appartmentimages"+id);
}

function addChild(parent, child, idvalue){
    var childNode = document.createElement(child);
    if (idvalue != ""){
        childNode.setAttribute("id", idvalue);
    }
    parent.appendChild(childNode);
    return childNode;
}

function sendRequest(url){
    var xmlhttp = new XMLHttpRequest();
    var request = "/rest/search?url=" + url;
    xmlhttp.open("GET", request, false);
    xmlhttp.send();
    return xmlhttp.response;
}

function hideAndShow(divid){
    if (document.getElementById(divid).className == "visible") {
        document.getElementById(divid).className = "invisible";
    } else document.getElementById(divid).className = "visible";
}

function check(ev){
    this.className = "checkbox-checked";
    this.setAttribute("checked",true);
    this.removeEventListener('click', check);
    this.addEventListener('click', uncheck);
}

function uncheck(ev){
    this.className = "checkbox";
    this.setAttribute("checked",false);
    this.removeEventListener('click',uncheck);
    this.addEventListener('click', check);
}

function updateResults(){
    var url = encodeURIComponent(document.getElementById("url1").value);
    var newObjs = JSON.parse(sendRequest(url));
    var diff = compareResults(newObjs);
    document.getElementById("resulthead").innerHTML = "Найдено " + newObjs.appartments.length + " квартир. " + diff.length + " новых предложений";
    displayResult(newObjs);
    diff.forEach(function(item){
        document.getElementById("appartment"+(item+1)).className = "newappartment";
    })
    console.log(diff);
}

function compareResults(newObjs){
    var result = [];
    newObjs.appartments.forEach(function(item, idx){
        var isNew = true;
        for (i = 0; i< objs.appartments.length; i++){
            if (item.url == objs.appartments[i].url){isNew = false; break;}
        }
        if (isNew) {result.add(idx);}
    })
    return result;
}