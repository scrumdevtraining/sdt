<html>
<body>
<h1 id='astroport-name'>Astroport : Scrum Development Trainee</h1>
<div id='gate-1'>
	<h3 id='ship-1'>Ship 1</h3>
</div>
<div id='gate-2'>
	<h3 id='ship-2'>Ship 2</h3>
</div>

<div id='gate-3'>
	<h3 id='ship-3'>Ship 3</h3>
</div>


Ship: <input type="text" id="ship" value="Falcon">
<button id="dock" onclick="myFunction()">Dock</button>

<script>
function myFunction() {
   var x = document.getElementById("ship").value;
   document.getElementById("ship-1").innerHTML = x;
}
</script>

</body>
</html>