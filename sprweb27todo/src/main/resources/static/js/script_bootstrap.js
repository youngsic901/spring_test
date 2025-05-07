window.onload = function () {
    document.querySelector("#printList").onclick = printList;
    document.querySelector("#addList").onclick = addList;
    document.querySelector("#updateList").onclick = updateList;
    document.querySelector("#deleteList").onclick = deleteList;
    
    // 모달 여백 클릭 시 모달창 닫히게
    document.querySelectorAll('.modal').forEach(modal => {
        modal.addEventListener('click', (e) => {
            if (e.target === modal) {
                modal.style.display = 'none';
                document.querySelectorAll("input").forEach((element) => {
                    element.value = null;
                });
            }
        });
    });

    // 버튼 클릭 시 해당 기능 모달 출력
    document.querySelectorAll(".showModal").forEach((element, index) => {
        element.addEventListener("click", function () {
            // document.querySelectorAll(".modal")[index].style.display = "block";
            const modal = document.querySelectorAll(".modal")[index];
            modal.style.display = 'block';

            // 첫 번째 input에 focus
            const input = modal.querySelector("input, select, textarea");
            if (input) input.focus();
        })
    });

    // 각 모달창 버튼 클릭 시 창 닫기
    document.querySelectorAll(".exitModal").forEach((element, index) => {
        element.addEventListener("click", function () {
            document.querySelectorAll(".modal")[index].style.display = "none";
            //입력 필드 초기화
            document.querySelectorAll("input").forEach((element) => {
                element.value = null;
            });
        })
    });
    // 삭제 확인 모달 활성화
    document.querySelector("#showDeleteYN").onclick = function () {
        document.querySelector(".YNmodal").style.display = "block";
    };
    // 삭제 확인 모달 비활성화
    document.querySelector("#exitYNmodal").onclick = function () {
        document.querySelector(".YNmodal").style.display = "none";
    }
}
// esc 입력시 모달 비활성화
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

// 할일 목록 요청
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

// 할일 목록 출력
function displayList(datas) {
    const printResult = document.querySelector("#printResult");
    printResult.innerHTML = "";

    const table = document.createElement("table");
    table.classList.add("table", "table-bordered", "table-striped", "text-center", "align-middle");

    const thead = document.createElement("thead");
    thead.innerHTML = `
        <tr class="table-light">
            <th>할 일</th>
            <th>순서</th>
            <th>진행 여부</th>
            <th>관리번호</th>
        </tr>
    `;
    table.appendChild(thead);

    const tbody = document.createElement("tbody");

    datas.forEach(data => {
        const row = document.createElement("tr");
        row.innerHTML = `
            <td>${data.title}</td>
            <td>${data.order}</td>
            <td>${data.completed ? "진행완료" : "진행중"}</td>
            <td>${data.id}</td>
        `;
        tbody.appendChild(row);
    });

    table.appendChild(tbody);
    printResult.appendChild(table);
}

// 할일 추가
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
            document.querySelector(".warningModal").style.display = "block";
            console.log("읽기 중 에러 : ", error);
        })
}

// 할일 수정
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
            document.querySelector(".warningModal").style.display = "block";
            console.log("읽기 중 에러 : ", error);
        })
}

// 할일 삭제
function deleteList() {
    const idInput = document.querySelector("#deleteId");

    const id = idInput.value;

    fetch(`/data/${id}`, {
        method: "DELETE",
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