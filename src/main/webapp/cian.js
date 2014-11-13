/**
 * Created by Валерий on 12.11.14.
 */
function cian($scope, $http) {
    $http.get('http://localhost:8080/rest/get?url=http://www.cian.ru/rent/flat/13070713/').
        success(function(data) {
            $scope.pagedata = data;
        });
}

function btnClick(){
        var urlrequest = encodeURIComponent(document.getElementById("url1").value);
    if (urlrequest != "") {
        var resp = sendRequest(urlrequest);
        var objs = JSON.parse(resp);
        console.log(objs);
        var imagedata = ""
        var counter;
        objs.appartments.forEach(
            function(item,idx){
                imagedata = "";
                counter = idx + 1;
                makeNods(document.getElementById("searchresult"),idx+1);
                document.getElementById('appartmentdesc'+counter).innerHTML = "<a href='"+ item.url +"' target='_blank'>" + item.descr + "</a>";
                item.images.forEach(function(item){imagedata = imagedata + "<img style='max-width: 100%; max-height: 100%' src='"+item+"'>";})
                document.getElementById('appartmentimages'+counter).innerHTML = imagedata;
            }
        )
    }
}

function makeNods(node, id){
    var appartment = addChild(node, "tr", "appartment"+id);
    var desctd = addChild(appartment, "td", "");
    var appartmentdesc = addChild(desctd, "div", "appartmentdesc"+id);
    appartmentdesc.setAttribute("style", "height: 100px; width: 300px");
    var imgtd = addChild(appartment, "td", "");
    var appartmentimages = addChild(imgtd,"div", "appartmentimages"+id);
    appartmentimages.setAttribute("style", "height: 100px; width: auto");
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