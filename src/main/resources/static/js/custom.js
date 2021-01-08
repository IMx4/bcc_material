/**
 * 
 */

function validate() {

	const qty = document.getElementById("code").value;
    document.getElementById("modalBody").innerHTML = "Logging In - ";


}

function addItem() {
	const x = document.getElementById("description").value;
	document.getElementById("modalBody").innerHTML = "Add - " + x;

}

function addEmployee() {
	const fName = document.getElementById("first-name").value;
	const lName = document.getElementById("last-name").value;
	document.getElementById("modalBody").innerHTML = "Add " + fName + " " + lName;

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

    const currentQty = document.getElementById("qty").value;
    document.getElementById("qty").value = parseInt(document.getElementById("code").value) + parseInt(currentQty);

	const desc = document.getElementById("description").innerHTML;
	const qty = document.getElementById("code").value;
	let addRadio = document.getElementById("radioAdd").checked;
	let delRadio = document.getElementById("radioDelete").checked;

    if(addRadio){
        document.getElementById("qty").value = parseInt(currentQty) + parseInt(document.getElementById("code").value);
       document.getElementById("modalBody").innerHTML = "Add - " + qty;
    } else if (delRadio){
        document.getElementById("qty").value = parseInt(currentQty)- parseInt(document.getElementById("code").value);
        document.getElementById("modalBody").innerHTML = "Remove - " + qty;
    }

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

function employeeToast(name){

    const employeeName = name;

    document.getElementById("toast-body").innerHTML = employeeName;

$(document).ready(function(){

        $("#myToast").toast('show');
});

}