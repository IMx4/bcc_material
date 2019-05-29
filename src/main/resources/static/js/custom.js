/**
 * 
 */

function getDesc() {
	const x = document.getElementById("description").value;
	document.getElementById("modalBody").innerHTML = "Add - " + x
			+ "  to Database?";
}

function showMinStock(){

    const min = document.getElementById("min-stock");

    if(min.hidden === true){

        min.hidden = false;

    } else {
        min.hidden = true;
    }

}