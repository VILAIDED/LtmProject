const form = document.querySelector("form"),
  fileInput = document.querySelector(".file-input"),
  progressArea = document.querySelector(".progress-area"),
  uploadedArea = document.querySelector(".uploaded-area");

form.addEventListener("click", () => {
  fileInput.click();
});

fileInput.onchange = ({ target }) => {
  for (let i = 0; i < target.files.length; i++) {
    let file = target.files[i];
    if (file) {
      let fileName = file.name;
      let fileSize = file.size;
      if (fileSize / 1000 >= 1024) {
        fileSize = (fileSize / (1024 * 1024)).toFixed(2) + " MB";
      } else {
        fileSize = Math.round(fileSize / 1024) + " KB";
      }
      if (fileName.length >= 12) {
        let splitName = fileName.split(".");
        fileName = splitName[0].substring(0, 13) + "... ." + splitName[1];
      }
    // convertFile(fileName, fileSize);
    // uploadFile(fileName);
    }
  }
};

function convertFile(fileName, fileSize) {
  let progressHTML = `<li class="row">
    <i class="fas fa-file-alt"></i>
    <div class="content">
      <div class="details">
        <span class="name">${fileName}</span>
        <span class="size">${fileSize}</span>
      </div>
      <div class="button-download">
        <a class="download" href="#"><i class="fas fa-download"></i></a>
      </div>
    </div>
  </li>`;

  //   uploadedArea.classList.add("onprogress");
  uploadedArea.classList.remove("onprogress");

  //   progressArea.innerHTML = progressHTML;
  uploadedArea.insertAdjacentHTML("afterbegin", progressHTML);
}



