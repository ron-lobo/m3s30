class StopWatch {
  #duration = 0;
  #isRunning = false;
  #startTime = null;

  constructor() {
    console.log("creating a new stopwatch");
  }

  start() {
    if (this.#isRunning) {
      throw new Error("StopWatch already started");
    } else {
      this.#isRunning = true;
      this.#startTime = new Date();
    }
  }

  stop() {
    if (this.#isRunning) {
      this.#isRunning = false;
      let now = new Date();
      this.#duration += (now.getTime() - this.#startTime.getTime()) / 1000;
    } else {
      throw new Error("StopWatch already stopped");
    }
  }

  reset() {
    this.#isRunning = false;
    this.#duration = 0;
    this.#startTime = null;
  }

  getDuration() {
    return this.#duration * 1000 + " seconds";
  }

  get duration() {
    return this.#duration * 1000 + " seconds";
  }

  set duration(d) {
    this.#duration = d;
  }
}

function toggleText(id, start0, start1, suffix) {
  let element = document.getElementById(id);
  let start = element.innerHTML.startsWith(start0) ? start1 : start0;
  element.innerHTML = start + " " + suffix;
}

function toggleVisibility(id) {
  let datePoint = document.getElementById(id);
  datePoint.style.visibility =
    datePoint.style.visibility == "hidden" ? "visible" : "hidden";
}

function toggleTime() {
  toggleText("timeButton", "show", "hide", "time");
  toggleVisibility("timeParagraph");
}

function toggleGame() {
  toggleText("playButton", "Play", "Quit", "Game");
  toggleVisibility("gtn");
}

function updateDate() {
  document.getElementById("datePoint").innerHTML = new Date();
}

function gtnAJAX() {
  let xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function () {
    document.getElementById("showGames").innerHTML = this.responseText;
  };
  xhr.open("GET", "http://localhost:8080/gtn/game", true);
  xhr.send();
}

function gtnFetch() {
  fetch("http://localhost:8080/gtn/game")
    .then((response) => response.json())
    .then((r) =>
      r.forEach((game) =>
        console.log(`${game.id}, ${game.answer}, ${game.finished}`)
      )
    )
    .catch((err) => console.log("fail: " + err));
}

function promises() {
  console.log("a1");

  let myFirstPromise = new Promise((resolve, reject) => {
    setTimeout(function () {
      resolve("work done (resolved)");
    }, 500);
  });

  console.log("a2");

  myFirstPromise.then((successMessage) => {
    console.log("promise kept: " + successMessage);
  });

  console.log("a3");
}

promises();

toggleTime();
// toggleGame();
