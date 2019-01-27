<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Results</title>
    </head>
    <body>
        <div style="display: flex;">        
<h1 style="width: 80%;margin-left: 10%;margin-top: 10px;">${article.question}</h1>        
        <div id="piechart" style="margin-top: -110px;margin-bottom: -50px;"></div>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
  ['Task', 'Recent Votes'],
  ['Yes', ${yes}],
  ['No', ${no}],
  ['Do not know', ${dknow}]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Results until now', 'width':550, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
  chart.draw(data, options);
}
</script>
</div>
        
    </body>
</html>
