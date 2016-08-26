<html>
<style>
.free {
    
background-color: white;
}
.occupied{
    
background-color: blue;
}
.hidden{
    
background-color: yellow;
}
.docked{
    
background-color: green;
}
</style>
<body>
<h1 id='astroport-name'>Astroport : Scrum Development Trainee</h1>
<div id='gate-1' class='free'>
 <h3 id='ship-1'>Ship 1</h3>
</div>
<div id='gate-2'>
 <h3 id='ship-2'>Ship 2</h3>
</div>
<div id='gate-3'>
 <h3 id='ship-3'>Ship 3</h3>
</div>

<div id='info' class='hidden'>
 <h5 id='information'>No Ship docked here</h5>
</div>


Ship: <input type="text" id="ship" value="Falcon" onkeypress="changeName()">
<button id="dock" onclick="myFunction()">Dock</button>

<script>
function myFunction() {
   var x = document.getElementById("ship").value;
   document.getElementById("ship-1").innerHTML = x;
   document.getElementById("gate-1").className += " occupied";
   document.getElementById("info").className += " docked";
   document.getElementById("information").innerHTML = "Ship 1 docked here";
}

function changeName() {
   document.getElementById("info").className += " hidden";
   document.getElementById("information").innerHTML = "Typingggg.....";
}
</script>

</body>
</html>