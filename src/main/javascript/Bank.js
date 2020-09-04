
export default class Bank {

    #country;
    #rank;

  constructor(name, country, rank) {
    if (name === undefined) {
      this.name = null;
    } else {
      this.name = name;
    }
    this.#country = country === undefined ? null : country;
    this.#rank = rank === undefined ? null : rank;
  }

  getRank() {
    return this.#rank;
  }
}
