const API_URL = "http://localhost:8080/students";

// Load students on page load
window.onload = fetchStudents;

function fetchStudents() {
    fetch(API_URL)
        .then(res => res.json())
        .then(data => {
            let table = document.getElementById("studentTable");
            table.innerHTML = "";

            data.forEach(student => {
                table.innerHTML += `
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.age}</td>
                        <td>
                            <button onclick="deleteStudent(${student.id})">Delete</button>
                        </td>
                    </tr>
                `;
            });
        });
}

function addStudent() {
    const name = document.getElementById("name").value;
    const age = document.getElementById("age").value;

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({ name, age })
    })
    .then(() => {
        fetchStudents();
    });
}

function deleteStudent(id) {
    fetch(`${API_URL}/${id}`, {
        method: "DELETE"
    })
    .then(() => fetchStudents());
}