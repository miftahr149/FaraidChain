console.log("This is from createWasiat.js")

var nameDetails = [];
var icDetails = [];

function addSonNameField() {
  var sonNamesContainer = document.getElementById("sonNamesContainer");
  var selectedSon = document.getElementById("anakLelaki").value;

  sonNamesContainer.innerHTML = "";

  for (var i = 0; i < selectedSon; i++) {
    var newSonEntry = document.createElement("div");
    newSonEntry.className = "sonEntry";

    var newLabelName = document.createElement("label");
    newLabelName.textContent = "\nNama Anak Lelaki " + (i + 1) + " :";

    var newNameInput = document.createElement("input");
    newNameInput.type = "text";
    newNameInput.name = "anakLelakiDetails[" + i + "].name";
    newNameInput.placeholder = "Name";

    var newIcInput = document.createElement("input");
    newIcInput.type = "text";
    newIcInput.name = "anakLelakiDetails[" + i + "].ic";
    newIcInput.placeholder = "IC";

    var newLabel = document.createElement("label");
    newLabel.textContent = "\nAdakah anak ini OKU?";

    var newOkuInput = document.createElement("select");
    newOkuInput.name = "anakLelakiDetails[" + i + "].oku";

    var option1 = document.createElement("option");
    option1.value = "";
    option1.text = "pilih";

    var option2 = document.createElement("option");
    option2.value = "ya";
    option2.text = "ya";

    var option3 = document.createElement("option");
    option3.value = "tidak";
    option3.text = "tidak";

    newOkuInput.add(option1);
    newOkuInput.add(option2);
    newOkuInput.add(option3);

    newSonEntry.appendChild(newLabelName);
    newSonEntry.appendChild(newNameInput);
    newSonEntry.appendChild(newIcInput);
    newSonEntry.appendChild(newLabel);
    newSonEntry.appendChild(newOkuInput);

    sonNamesContainer.appendChild(newSonEntry);

    // Validate and store details
    newNameInput.addEventListener("blur", function (event) {
      validateName(event.target);
    });

    newIcInput.addEventListener("blur", function (event) {
      validateIc(event.target);
    });
  }
}

function addDaughterNameField() {
  var daughterNamesContainer = document.getElementById(
    "daughterNamesContainer",
  );
  var selectedDaughter = document.getElementById("anakPerempuan").value;

  daughterNamesContainer.innerHTML = "";

  for (var j = 0; j < selectedDaughter; j++) {
    var newDaughterEntry = document.createElement("div");
    newDaughterEntry.className = "daughterEntry";
    var newLabelName = document.createElement("label");
    newLabelName.textContent = "\nNama Anak Perempuan " + (j + 1) + " :";

    var newNameInput = document.createElement("input");
    newNameInput.type = "text";
    newNameInput.name = "anakPerempuanDetails[" + j + "].name";
    newNameInput.placeholder = "Name";

    var newIcInput = document.createElement("input");
    newIcInput.type = "text";
    newIcInput.name = "anakPerempuanDetails[" + j + "].ic";
    newIcInput.placeholder = "IC";

    var newLabel = document.createElement("label");
    newLabel.textContent = "\nAdakah anak ini OKU?";

    var newOkuInput = document.createElement("select");
    newOkuInput.name = "anakPerempuanDetails[" + j + "].oku";

    var option1 = document.createElement("option");
    option1.value = "";
    option1.text = "pilih";

    var option2 = document.createElement("option");
    option2.value = "ya";
    option2.text = "ya";

    var option3 = document.createElement("option");
    option3.value = "tidak";
    option3.text = "tidak";

    newOkuInput.add(option1);
    newOkuInput.add(option2);
    newOkuInput.add(option3);

    newDaughterEntry.appendChild(newLabelName);
    newDaughterEntry.appendChild(newNameInput);
    newDaughterEntry.appendChild(newIcInput);
    newDaughterEntry.appendChild(newLabel);
    newDaughterEntry.appendChild(newOkuInput);

    daughterNamesContainer.appendChild(newDaughterEntry);

    newNameInput.addEventListener("blur", function (event) {
      validateName(event.target);
    });

    newIcInput.addEventListener("blur", function (event) {
      validateIc(event.target);
    });
  }
}

function addAngkatNameField() {
  var angkatNamesContainer = document.getElementById("angkatNamesContainer");
  var selectedAngkat = document.getElementById("anakAngkat").value;

  angkatNamesContainer.innerHTML = "";

  for (var i = 0; i < selectedAngkat; i++) {
    var newAngkatEntry = document.createElement("div");
    newAngkatEntry.className = "angkatEntry";
    var newLabelName = document.createElement("label");
    newLabelName.textContent = "\nNama Anak Angkat " + (i + 1) + " :";

    var newNameInput = document.createElement("input");
    newNameInput.type = "text";
    newNameInput.name = "anakAngkatDetails[" + i + "].name";
    newNameInput.placeholder = "Name";

    var newIcInput = document.createElement("input");
    newIcInput.type = "text";
    newIcInput.name = "anakAngkatDetails[" + i + "].ic";
    newIcInput.placeholder = "IC";

    var newLabel = document.createElement("label");
    newLabel.textContent = "\nAdakah anak ini OKU?";

    var newOkuInput = document.createElement("select");
    newOkuInput.name = "anakAngkatDetails[" + i + "].oku";

    var option1 = document.createElement("option");
    option1.value = "";
    option1.text = "pilih";

    var option2 = document.createElement("option");
    option2.value = "ya";
    option2.text = "ya";

    var option3 = document.createElement("option");
    option3.value = "tidak";
    option3.text = "tidak";

    newOkuInput.add(option1);
    newOkuInput.add(option2);
    newOkuInput.add(option3);

    newAngkatEntry.appendChild(newLabelName);
    newAngkatEntry.appendChild(newNameInput);
    newAngkatEntry.appendChild(newIcInput);
    newAngkatEntry.appendChild(newLabel);
    newAngkatEntry.appendChild(newOkuInput);

    angkatNamesContainer.appendChild(newAngkatEntry);

    newNameInput.addEventListener("blur", function (event) {
      validateName(event.target);
    });

    newIcInput.addEventListener("blur", function (event) {
      validateIc(event.target);
    });
  }
}

function updateIsteriInputs() {
  var isteriNamesContainer = document.getElementById("isteriNamesContainer");
  var selectedIsteri = document.getElementById("isteri").value;

  // Clear existing entries
  isteriNamesContainer.innerHTML = "";

  // Generate new entries based on the selected number of Isteri
  for (var i = 0; i < selectedIsteri; i++) {
    var newIsteriEntry = document.createElement("div");
    newIsteriEntry.className = "isteriEntry";
    var newLabel = document.createElement("label");
    newLabel.textContent = "\nNama Isteri " + (i + 1) + " :";

    var newNameInput = document.createElement("input");
    newNameInput.type = "text";
    newNameInput.name = "isteriDetails[" + i + "].name";
    newNameInput.placeholder = "Name";

    var newIcInput = document.createElement("input");
    newIcInput.type = "text";
    newIcInput.name = "isteriDetails[" + i + "].ic";
    newIcInput.placeholder = "IC";

    newIsteriEntry.appendChild(newLabel);
    newIsteriEntry.appendChild(newNameInput);
    newIsteriEntry.appendChild(newIcInput);

    isteriNamesContainer.appendChild(newIsteriEntry);

    newNameInput.addEventListener("blur", function (event) {
      validateName(event.target);
    });

    newIcInput.addEventListener("blur", function (event) {
      validateIc(event.target);
    });
  }
}

function validateName(inputElement) {
  var inputValue = inputElement.value;

  // Check for duplicates
  /* if (nameDetails.includes(inputValue)) {
          alert("Error: Duplicate name. Please enter a different name");
          inputElement.value = ""; // Clear the input field
          nameDetails.length = 0;
        } else {
          nameDetails.push(inputValue); // Store the value
        } */

  nameDetails.push(inputValue);
}

function validateIc(inputElement) {
  var inputValue = inputElement.value;

  // Check for duplicates
  /* if (icDetails.includes(inputValue)) {
          alert("Error: Duplicate IC. Please enter a different IC");
          inputElement.value = ""; // Clear the input field
          icDetails.length = 0;
        } else if (inputValue.length !== 12) {
          alert(
            "Error: IC must be exactly minimum and maximum 8 characters long",
          );
          inputElement.value = "";
        } else {
          icDetails.push(inputValue); // Store the value
        } */

  icDetails.push(inputValue);
}

function updateSuami() {
  var i = 0;
  var suamiNamesContainer = document.getElementById("suamiNamesContainer");
  var selectedSuami = document.getElementById("suami").value;

  suamiNamesContainer.innerHTML = "";

  if (selectedSuami === "ada") {
    var newSuamiEntry = document.createElement("div");
    newSuamiEntry.className = "suamiEntry";
    var newLabel = document.createElement("label");
    newLabel.textContent = "\nNama Suami:";

    var newNameInput = document.createElement("input");
    newNameInput.type = "text";
    newNameInput.name = "suamiDetails[" + i + "].name";
    newNameInput.placeholder = "Name";

    var newIcInput = document.createElement("input");
    newIcInput.type = "text";
    newIcInput.name = "suamiDetails[" + i + "].ic";
    newIcInput.placeholder = "IC";

    newSuamiEntry.appendChild(newLabel);
    newSuamiEntry.appendChild(newNameInput);
    newSuamiEntry.appendChild(newIcInput);

    suamiNamesContainer.appendChild(newSuamiEntry);
  }
}

//---------------------------------------------------------------------------

function showForm() {
  var genderSelect = document.getElementById("gender");
  var isteriForm = document.getElementById("isteriNum");
  var suamiForm = document.getElementById("suamiNum");

  // Reset the visibility for both forms
  isteriForm.classList.add("hidden");
  suamiForm.classList.add("hidden");

  if (genderSelect.value === "lelaki") {
    // Show the isteriNum form
    isteriForm.classList.remove("hidden");
  } else if (genderSelect.value === "perempuan") {
    // Show the suamiNum form
    suamiForm.classList.remove("hidden");
  }
}

function showNextForm(prev, next) {
  var prevForm = document.getElementById(prev);
  var nextForm = document.getElementById(next);

  // Hide the prevForm
  prevForm.classList.add("hidden");

  // Display the next form
  nextForm.classList.remove("hidden");

  //fix problem for showing anakLelaki only
  if (next === "anakPunya") {
    document.getElementById("anakPerempuanContainer").classList.add("hidden");
    document.getElementById("anakAngkatContainer").classList.add("hidden");
    document.getElementById("okuContainer").classList.add("hidden");
  }
}

function showPrevForm(prev, next) {
  var prevForm = document.getElementById(prev);
  var nextForm = document.getElementById(next);

  // Hide the prevForm
  nextForm.classList.add("hidden");

  // Display the next form
  prevForm.classList.remove("hidden");
}

function checkFormCompleteness() {
  // Get values of the input elements
  var perbelanjaan = document.getElementById("perbelanjaan").value;
  var anggaran = document.getElementById("anggaran").value;
  var hibah = document.getElementById("hibah").value;

  // Check if all required fields are filled
  if (perbelanjaan !== "" && anggaran !== "" && hibah !== "") {
    // If yes, show the submit button
    document.getElementById("submitButton").classList.remove("hidden");
  } else {
    // If not, hide the submit button
    document.getElementById("submitButton").classList.add("hidden");
  }
}
