const form = document.querySelector("form"),
  fileInput = document.querySelector(".file-input")

form.addEventListener("click", () => {
  fileInput.click();
});

fileInput.onchange = ({ target }) => {
form.submit();
};




