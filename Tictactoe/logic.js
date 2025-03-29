let players = ["x", "o"];
let activePlayer = 0;
let gameBoard = [];

function startGame() {
  gameBoard = Array(3)
    .fill()
    .map(() => Array(3).fill(""));
  activePlayer = Math.floor(Math.random() * 2);
  renderBoard(gameBoard);
}

function click(row, col) {
  if (gameBoard[row][col] !== "") {
    return;
  }

  gameBoard[row][col] = players[activePlayer];
  console.log("Ход сделан:", row, col, players[activePlayer]);
  console.log("Текущее поле:", gameBoard);

  if (checkWin()) {
    console.log("Победа! Игрок:", activePlayer);
    showWinner(activePlayer);
    return;
  }

  activePlayer = (activePlayer + 1) % 2;
  console.log("Следующий игрок:", activePlayer);

  renderBoard(gameBoard);
}

function checkWin() {
  for (let i = 0; i < 3; i++) {
    if (
      gameBoard[i][0] &&
      gameBoard[i][0] === gameBoard[i][1] &&
      gameBoard[i][1] === gameBoard[i][2]
    ) {
      console.log("Победа по строке:", i);
      return true;
    }
  }

  for (let j = 0; j < 3; j++) {
    if (
      gameBoard[0][j] &&
      gameBoard[0][j] === gameBoard[1][j] &&
      gameBoard[1][j] === gameBoard[2][j]
    ) {
      console.log("Победа по столбцу:", j);
      return true;
    }
  }

  if (
    gameBoard[0][0] &&
    gameBoard[0][0] === gameBoard[1][1] &&
    gameBoard[1][1] === gameBoard[2][2]
  ) {
    console.log("Победа по главной диагонали");
    return true;
  }

  if (
    gameBoard[0][2] &&
    gameBoard[0][2] === gameBoard[1][1] &&
    gameBoard[1][1] === gameBoard[2][0]
  ) {
    console.log("Победа по побочной диагонали");
    return true;
  }

  return false;
}
