/**
 * 
 */

function addItem() {
	const x = document.getElementById("description").value;
	document.getElementById("modalBody").innerHTML = "Add - " + x;

}

function getDesc() {
	const x = document.getElementById("description").value;
	document.getElementById("modalBody").innerHTML = "Change - " + x;

}

function getDescForDelete() {
	const x = document.getElementById("del-desc").innerHTML;
	document.getElementById("modalBody").innerHTML = "Item Deleted - " + x;

}

function empAdd() {
	const desc = document.getElementById("description").innerHTML;
	const qty = document.getElementById("code").value;
	document.getElementById("modalBody").innerHTML = "Add - " + desc;
}

function empRemove() {
	const desc = document.getElementById("description").innerHTML;

	document.getElementById("modalBody").innerHTML = "Remove - " + desc;
}

function showMinStock(){

    const min = document.getElementById("inventory-control-toggle");
    const minQty = document.getElementById("min-stock");

        if(min.checked === true){

            minQty.hidden = false;

        } else {
            minQty.hidden = true;
        }


}