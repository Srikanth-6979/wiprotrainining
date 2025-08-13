const questions = [
    {
        question: "1.Is Javascript is front-end or Back-end?",
        options: ["Frontend", "Backend", "All of the Above", "None"],
        answer: "Frontend"
    },
    {
        question: "2.What is the capital of Telanagana",
        options: ["Kammam", "Nalgonda", "Hyderbad", "Karimnagar"],
        answer: "Hyderbad"
    },
    {
        question: "3.Who is the Prime Minister Of India?",
        options: ["Rahul Gandhi", "Narendra Modi", "Indira Gandhi", "None"],
        answer: "Narendra Modi"
    }
];

let currentIndex = 0;
let score = 0;

function loadQuestion() {
    const questionEl = document.getElementById("question");
    const optionsEl = document.getElementById("options");
    const feedbackEl = document.getElementById("feedback");
    const nextBtn = document.getElementById("nextBtn");


    feedbackEl.textContent = "";
    nextBtn.disabled = true;

    const currentQ = questions[currentIndex];
    questionEl.textContent = currentQ.question;

    optionsEl.innerHTML = "";
    currentQ.options.forEach(option => {
        const btn = document.createElement("button");
        btn.textContent = option;
        btn.classList.add("option");
        btn.onclick = () => checkAnswer(option);
        optionsEl.appendChild(btn);
    });

    document.getElementById("score").textContent = `Score: ${score} / ${questions.length}`;
}

function checkAnswer(selectedOption) {
    const feedbackEl = document.getElementById("feedback");
    const currentQ = questions[currentIndex];

    if (selectedOption === currentQ.answer) {
        feedbackEl.textContent = " Correct!";
        feedbackEl.style.color = "green";
        score++;
    } else {
        feedbackEl.textContent = ` Wrong! Correct answer: ${currentQ.answer}`;
        feedbackEl.style.color = "red";
    }

    document.querySelectorAll(".option").forEach(btn => btn.disabled = true);
    document.getElementById("nextBtn").disabled = false;
}

function nextQuestion() {
    currentIndex++;
    if (currentIndex < questions.length) {
        loadQuestion();
    } else {
        document.getElementById("question").textContent = " Quiz Completed!";
        document.getElementById("options").innerHTML = "";
        document.getElementById("feedback").textContent = "";
        document.getElementById("nextBtn").style.display = "none";
        document.getElementById("score").textContent = `Final Score: ${score} / ${questions.length}`;
    }
}

window.onload = loadQuestion;
