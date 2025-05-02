window.onload = function () {
    document.querySelector("#printList").onclick = printList;
    document.querySelector("#addList").onclick = addList;
    document.querySelector("#updateList").onclick = updateList;
    document.querySelector("#deleteList").onclick = deleteList;
    document.querySelectorAll(".showModal").forEach((element, index) => {
        element.addEventListener("click", function () {
            document.querySelectorAll(".modal")[index].style.display = "block";
        })
    });
    document.querySelectorAll(".exitModal").forEach((element, index) => {
        element.addEventListener("click", function () {
            document.querySelectorAll(".modal")[index].style.display = "none";
            document.querySelectorAll("input").forEach((element) => {
                element.value = null;
            });
        })
    });
    document.querySelector("#showDeleteYN").onclick = function () {
        document.querySelector(".YNmodal").style.display = "block";
    };
    document.querySelector("#exitYNmodal").onclick = function () {
        document.querySelector(".YNmodal").style.display = "none";
    }
}

window.onkeydown = function (event) {
    if (event.key === "Escape") {
        document.querySelectorAll(".modal").forEach((element) => {
            element.style.display = 'none';
        });
        document.querySelectorAll("input").forEach((element) => {
            element.value = null;
        });
    }
}

function printList() {
    fetch("/data", {
        method: "GET"
    })
        .then(response => {
            if(!response.ok){
                throw new Error("네트워크 응답 오류");
            }
            return response.json();
        })
        .then(datas => {
            console.log(datas);
            displayList(datas);
        })
        .catch(error => {
            console.log("읽기 중 에러 : ", error);
        })
}

function displayList(datas) {
    const printResult = document.querySelector("#printResult");
    printResult.innerHTML = "";
    const table = document.createElement("table");
    table.border = "1";
    table.innerHTML = "<tr><th>아이디</th><th>이름</th><th>수량</th><th>여/부</th></tr>";

    datas.forEach(data => {
        const row = document.createElement("tr");
        const idCell = document.createElement("td");
        idCell.textContent = data.id;
        const titleCell = document.createElement("td");
        titleCell.textContent = data.title;
        const orderCell = document.createElement("td");
        orderCell.textContent = data.order;
        const completedCell = document.createElement("td");
        completedCell.textContent = data.completed;

        row.appendChild(idCell);
        row.appendChild(titleCell);
        row.appendChild(orderCell);
        row.appendChild(completedCell);
        table.appendChild(row);
    });

    printResult.appendChild(table);
}

function addList() {
    const titleInput = document.querySelector("#insertTitle");
    const orderInput = document.querySelector("#insertOrder");
    const completedInput = document.querySelector("#insertCompleted");

    const title = titleInput.value;
    const order = orderInput.value;
    const completed = completedInput.value;

    fetch("/data", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({title: title, order: order, completed: completed})
    })
        .then(response => {
            if(!response.ok){
                throw new Error("네트워크 응답 오류");
            }
            return response.text();
        })
        .then(() => {
            document.querySelectorAll(".modal")[0].style.display = "none";
            titleInput.value = null;
            orderInput.value = null;
            completedInput.value = null;
            printList();
        })
        .catch(error => {
            document.querySelector(".warningmodal").style.display = "block";
            console.log("읽기 중 에러 : ", error);
        })
}

function updateList() {
    const idInput = document.querySelector("#updateId");
    const titleInput = document.querySelector("#updateTitle");
    const orderInput = document.querySelector("#updateOrder");
    const completedInput = document.querySelector("#updateCompleted");

    const id = idInput.value;
    const title = titleInput.value;
    const order = orderInput.value;
    const completed = completedInput.value;

    fetch(`/data/${id}`, {
        method: "PATCH",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({title: title, order: order, completed: completed})
    })
        .then(response => {
            if(!response.ok){
                throw new Error("네트워크 응답 오류");
            }
            return response.text();
        })
        .then(() => {
            document.querySelectorAll(".modal")[1].style.display = "none";
            idInput.value = null;
            titleInput.value = null;
            orderInput.value = null;
            completedInput.value = null;
            printList();
        })
        .catch(error => {
            document.querySelector(".warningmodal").style.display = "block";
            console.log("읽기 중 에러 : ", error);
        })
}

function deleteList() {
    const idInput = document.querySelector("#deleteId");

    const id = idInput.value;

    fetch(`/data/${id}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json",
        },
        body: id
    })
        .then(response => {
            if(!response.ok){
                throw new Error("네트워크 응답 오류");
            }
            return response.text();
        })
        .then(() => {
            document.querySelectorAll(".modal")[2].style.display = "none";
            document.querySelectorAll(".modal")[3].style.display = "none";
            idInput.value = null;
            printList();
        })
        .catch(error => {
            console.log("읽기 중 에러 : ", error);
        })
}