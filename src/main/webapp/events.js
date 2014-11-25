/**
 * Created by Валерий on 15.11.14.
 */
function onLoad(){
    document.getElementById("searchform").className = "visible"; //Показать форму поиска
    document.getElementById("searchresultdiv").className = "invisible"; // скрыть результаты поиска
    document.getElementById("searchbtn").addEventListener('click', search); // onClick кнопки поиска
    document.getElementById("updatebtn").addEventListener('click', updateResults); //onClick кнопки обновления
    /*подписаться на клики по чекбоксам
    [].forEach.call(document.querySelectorAll('.checkbox'), function(btn){
        btn.addEventListener('click', check);
    });*/
}