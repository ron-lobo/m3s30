const gtnRoot = "http://localhost:8080/gtn/";
let gameId = null;
let isGameComplete = true;

function showGames() {
  fetch(gtnRoot + "game/")
    .then((response) => response.json())
    .then((games) => {
      let rows = "";
      games.forEach((game) => {
        let isComplete = game.answer != 0;
        let answer = isComplete ? game.answer : "(incomplete)";
        let row = `<tr><td><a href="#" onclick="showRoundsOfGame(${game.id}, ${isComplete})">
                ${game.id}</a></td><td>${answer}</td></tr>`;
        rows = row + rows;
      });
      document.getElementById("gamesDiv").innerHTML = rows;
      setAvailability();
    })
    .catch((err) => console.log("fail: " + err));
}

function showRoundsOfGame(selectedGameId, isComplete) {
  this.gameId = selectedGameId;
  this.isGameComplete = isComplete;
  let rows = "";
  fetch(gtnRoot + "rounds/" + this.gameId).then((response) => {
    console.log("response.status: ", response.status);
    if (response.status == 200) {
      response
        .json()
        .then((rounds) => {
          console.log("rounds=" + rounds);
          rounds.forEach((round) => {
            let exact = round.result.substring(2, 3);
            let partial = round.result.substring(6);
            let row = `<tr><td>${round.id}</td><td>${round.guess}</td>
                <td>${exact}</td><td>${partial}</td></tr>`;
            rows = row + rows;
          });
          document.getElementById("roundsDiv").innerHTML = rows;
        })
        .catch((err) => console.log("fail: " + err));
    } else {
      // response.text().then((r) => console.log(r));
      document.getElementById("roundsDiv").innerHTML = "";
    }
    setAvailability();
  });
}

function newGame() {
  fetch(gtnRoot + "begin", {
    method: "POST",
  })
    .then((response) => response.json())
    .then((newGameId) => {
      this.gameId = newGameId;
      this.isGameComplete = false;
      document.getElementById("guessText").value = "";
      document.getElementById("roundsDiv").innerHTML = "";
      showGames();
      setAvailability();
    })
    .catch((err) => console.log("fail: " + err));
}

function makeGuess() {
  let guess = document.getElementById("guessText").value;
  if (!/^(?!.*(.).*\1)\d{4}$/.test(guess)) {
    alert("Error: Please enter 4 distinct digits.");
    return;
  }
  fetch(gtnRoot + "guess", {
    method: "POST",
    body: JSON.stringify({
      guess: guess,
      gameId: this.gameId,
    }),
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },
  })
    .then((response) => response.json())
    .then((result) => {
      for (prop in result) {
        console.log("prop: " + prop + " = " + result[prop]);
      }
      let exact = result.result.substring(2, 3);
      let partial = result.result.substring(6);
      let rows = `<tr><td>${result.id}</td><td>${result.guess}</td>
                <td>${exact}</td><td>${partial}</td></tr>
                ${document.getElementById("roundsDiv").innerHTML}`;
      document.getElementById("roundsDiv").innerHTML = rows;
      document.getElementById("guessText").value = "";
      setAvailability();
    })
    .catch((err) => console.log("fail: " + err));
}

function setAvailability() {
  // console.log("setAvailability: ", this.gameId, this.isGameComplete);
  document.getElementById("selectGameDiv").innerHTML =
    this.gameId == null
      ? "Please select a game or click 'New Game'"
      : "Game " + this.gameId;

  let isInActive = this.gameId == null || this.isGameComplete;
  // console.log("isInActive: ", isInActive);

  let guessText = document.getElementById("guessText");
  let guessButton = document.getElementById("guessButton");

  guessText.disabled = isInActive;
  guessButton.disabled =
    isInActive || guessText.value.length != guessText.maxLength;
}

function maxLengthCheck(object) {
  if (object.value.length > object.maxLength) {
    object.value = object.value.slice(0, object.maxLength);
  }
  setAvailability();
}

showGames();
