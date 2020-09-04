
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

    get duration() {
        return this.#duration * 1000 + " seconds";
    }

    set duration(d) {
        this.#duration = d;
    }

    getDuration() {
        return this.#duration * 1000 + " seconds";
    }
}
