function addNewSmartPhone() {
  //lấy dữ liệu từ form html
  let producer = $("#producer").val();
  let model = $("#model").val();
  let price = $("#price").val();
  let newSmartphone = {
    producer: producer,
    model: model,
    price: price,
  };
  // gọi phương thức ajax
  $.ajax({
    headers: {
      "Accept": "application/json",
      "Content-Type": "application/json",
    },
    type: "POST",
    data: JSON.stringify(newSmartphone),
    //tên API
    url: "http://localhost:8080/api/smartphones",
    //xử lý khi thành công
    success: successHandler,
  });
  //chặn sự kiện mặc định của thẻ
  event.preventDefault();
}

function successHandler() {
  $.ajax({
    type: "GET",
    //tên API
    url: "http://localhost:8080/api/smartphones",
    //xử lý khi thành công
    success: function (data) {
      // hiển thị danh sách ở đây
      let content =
        '    <table id="display-list"  border="1"><tr>\n' +
        "        <th>Producer</td>\n" +
        "        <th>Model</td>\n" +
        "        <th>Price</td>\n" +
        "        <th>Delete</td>\n" +
        "    </tr>";
      for (let i = 0; i < data.length; i++) {
        content += getSmartphone(data[i]);
      }
      content += "</table>";
      document.getElementById("smartphoneList").innerHTML = content;
      document.getElementById("smartphoneList").style.display = "block";
      document.getElementById("smartphone-form").style.display = "none";
      document.getElementById("display-create").style.display = "block";
      document.getElementById("title").style.display = "block";
    },
  });
}

function displayFormCreate() {
  document.getElementById("smartphoneList").style.display = "none";
  document.getElementById("smartphone-form").style.display = "block";
  document.getElementById("display-create").style.display = "none";
  document.getElementById("title").style.display = "none";

  $("#form-title").text("Create Smartphone");
  $("#smartphoneId").val("");
  $("#producer").val("");
  $("#model").val("");
  $("#price").val("");
  $("#submit-button").val("Add");
  $("#submit-button").attr("onclick", "addNewSmartPhone()");
}

function getSmartphone(smartphone) {
  return `<tr>
                <td >${smartphone.producer}</td>
                <td >${smartphone.model}</td>
                <td >${smartphone.price}</td>
                <td class="btn"><button class="deleteSmartphone" onclick="deleteSmartphone(${smartphone.id})">Delete</button></td>
                <td class="btn"><button class="editSmartphone" onclick="displayFormUpdate(${smartphone.id})">Edit</button></td>
            </tr>`;
}

function deleteSmartphone(id) {
  $.ajax({
    type: "DELETE",
    //tên API
    url: `http://localhost:8080/api/smartphones/${id}`,
    //xử lý khi thành công
    success: successHandler,
  });
}

function displayFormUpdate(id) {
  // Gọi API lấy chi tiết smartphone
  $.ajax({
    type: "GET",
    url: `http://localhost:8080/api/smartphones/${id}`,
    success: function (smartphone) {
      // Ẩn bảng danh sách, hiện form
      document.getElementById("smartphoneList").style.display = "none";
      document.getElementById("smartphone-form").style.display = "block";
      document.getElementById("display-create").style.display = "none";
      document.getElementById("title").style.display = "none";

      // Điền thông tin vào form
      $("#form-title").text("Edit Smartphone"); // Đổi tiêu đề form
      $("#smartphoneId").val(smartphone.id);
      $("#producer").val(smartphone.producer);
      $("#model").val(smartphone.model);
      $("#price").val(smartphone.price);

      // Thay đổi nút submit thành nút update
      $("#submit-button").val("Update");
      $("#submit-button").attr("onclick", "updateSmartphone()");
    },
  });
}

function updateSmartphone() {
  // Lấy dữ liệu từ form
  let id = $("#smartphoneId").val();
  let producer = $("#producer").val();
  let model = $("#model").val();
  let price = $("#price").val();
  let updatedSmartphone = {
    producer: producer,
    model: model,
    price: price,
  };

  // Gọi AJAX
  $.ajax({
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    type: "PUT",
    data: JSON.stringify(updatedSmartphone),
    url: `http://localhost:8080/api/smartphones/${id}`,
    success: successHandler, // Sau khi thành công, gọi lại hàm hiển thị danh sách
  });
  // Chặn sự kiện submit mặc định
  event.preventDefault();
}
