const questions = [
  {
    question: "Какая планета является самой большой в Солнечной системе?",
    answer: "Юпитер",
  },
  {
    question: 'Кто написал роман "Война и мир"?',
    answer: "Лев Толстой",
  },
  {
    question: "Какой химический символ у золота?",
    answer: "Au",
  },
  {
    question: "В каком году началась Вторая мировая война?",
    answer: "1939",
  },
  {
    question: "Какое животное является самым быстрым на суше?",
    answer: "Гепард",
  },
  {
    question: "Какой язык программирования создал Брендан Эйх?",
    answer: "JavaScript",
  },
  {
    question: "Какая столица Японии?",
    answer: "Токио",
  },
  {
    question: "Сколько дней в високосном году?",
    answer: "366",
  },
  {
    question: "Какой элемент имеет атомный номер 1?",
    answer: "Водород",
  },
  {
    question: "Кто изобрел лампу накаливания?",
    answer: "Томас Эдисон",
  },
];

function startQuiz() {
  let correctAnswers = 0;

  for (let i = 0; i < questions.length; i++) {
    const userAnswer = prompt(questions[i].question);
    if (
      userAnswer &&
      userAnswer.toLowerCase() === questions[i].answer.toLowerCase()
    ) {
      correctAnswers++;
    }
  }

  const percentage = (correctAnswers / questions.length) * 100;
  document.write(`<p>Викторина завершена!</p>`);
  document.write(
    `<p>Правильных ответов: ${correctAnswers} из ${questions.length}</p>`
  );
  document.write(`<p>Процент правильных ответов: ${percentage}%</p>`);
}
