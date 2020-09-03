console.log("hi");
console.log("intro return value = " + intro());
testExists();
sumExercises();

function intro() {
  let i = 0;
  let j = "hello world";
  i++;
  i += 2;
  console.log("i=" + i + ", j=" + j);
  i = j;
  console.log("i=" + i + ", j=" + j);

  if (i == j) {
    i = 123;
    j = "123";
    console.log("i==j : " + (i == j));
    console.log("i===j : " + (i === j));
  }
  // alert("watch out!");
  return i;
}

function toggleText() {
  let element = document.getElementById("greeting");
  if (element.innerHTML.startsWith("Hello")) {
    element.innerHTML = "Goodbye Grads";
  } else {
    element.innerHTML = "Hello Grads";
  }
}

function updateDate() {
  document.getElementById("datePoint").innerHTML = new Date();
}

function exists(array, value) {
  // for (let i = 0; i < array.length; i++) {
  //     if (array[i] === value) {
  //         return array;
  //     }
  // }
  if (array.indexOf(value) < 0) {
    array.push(value);
  }
  return array;
}

function testExists() {
  const stocks1 = ["VOD", "BT", "BP", "HSBA", "GOOG"];
  console.log("stocks1=" + stocks1);
  let result1 = exists(stocks1, "BT");
  console.log("result1=" + result1);
  let result2 = exists(stocks1, "TSLA");
  console.log("result2=" + result2);
  console.log("stocks1=" + stocks1);
}

// var stocks2 = ["ANTO", "VOD", "GOOGL", "BP"];

function sumExercises() {
  // Create a function(sumNumArray) that returns the sum of all numbers in an array of numbers.
  let shares = [99.45, 185.34, 45.45];
  let result = calcSumOfArray(shares); // 330.24
  console.log("sum of array: " + result);

  // Create a function(sumSharePrices) that returns the sum of all number properties in a list of objects
  let shares1 = [
    {
      id: "123456",
      currency: "USD",
      symbol: "AAPL",
      exchangeName: "NMS",
      value: 99.45,
    },
    {
      id: "454534",
      value: 185.34,
      currency: "USD",
      symbol: "FB",
      exchangeName: "NMS",
    },
    {
      id: "987646",
      currency: "USD",
      symbol: "GOOG",
      exchangeName: "NMS",
      value: 45.45,
    },
  ];
  let sumShares = sumSharePrices2(shares1); // 330.24
  console.log("sumShares=" + sumShares);

  //   Create a function that takes an object with originalSet, toReplace and newValue properties.
  // Each value in toReplace is replaced with newValue within originalSet
  // It will return a new array, and will not modify the argument.
  let replacement = {
    originalSet: [
      "FRF",
      "USD",
      "GBP",
      "ITL",
      "FRF",
      "YEN",
      "USD",
      "FRF",
      "EUR",
      "YEN",
      "ITL",
      "DEM",
    ],
    toReplace: ["ESP", "FRF", "ITL", "DEM"],
    newValue: "EUR",
  };

  console.log("replacement.originalSet=" + replacement.originalSet); // not changed
  let myNewArray = replaceInArray3(replacement);
  console.log("myNewArray=" + myNewArray); // new array with replacements!
  console.log("replacement.originalSet=" + replacement.originalSet); // not changed
}

function replaceInArray(replacement) {
  let originalSet = replacement["originalSet"];
  let toReplace = replacement["toReplace"];
  let newValue = replacement["newValue"];
  let newArray = originalSet.slice();
  for (i = 0; i < originalSet.length; i++) {
    for (j = 0; j < toReplace.length; j++) {
      if (originalSet[i] == toReplace[j]) {
        newArray[i] = newValue;
      }
    }
  }
  return newArray;
}

function replaceInArray1(replacement) {
  return [...replacement.originalSet].map((value) => {
    if (replacement.toReplace.indexOf(value) != -1) {
      return replacement.newValue;
    }
    return value;
  });
}

function replaceInArray2(replacement) {
  let replacedArray = replacement.originalSet.slice();
  for (let i = 0; i < replacement.originalSet.length; i++) {
    if (replacement.toReplace.indexOf(replacement.originalSet[i]) != -1) {
      replacedArray[i] = replacement.newValue;
    }
  }
  return replacedArray;
}

function replaceInArray3(obj) {
  let newArray = [];
  obj.originalSet.map(item =>
      newArray.push(obj.toReplace.includes(item) ? obj.newValue : item));
  return newArray;
}


function sumSharePrices(shares) {
  let total = 0;
  const properties = Object.getOwnPropertyNames(shares[0]);
  for (let prop of properties) {
    if (typeof shares[0][prop] == "number") {
      for (let obj of shares) {
        total += obj[prop];
      }
    }
  }
  return total;
}

function sumSharePrices2(shares) {
  let sum = 0;
  shares.forEach((share) => {
    for (let key in share) {
      if (typeof share[key] == "number") {
        sum += share[key];
      }
    }
  });
  return sum;
}

function calcSumOfArray(arr) {
  // let sum = 0;
  // for (i = 0; i < arr.length; i++) {
  //     sum += arr[i];
  // }
  // return sum;

  return arr.reduce((a, b) => a + b, 0);
}

function createBank(name, country, rank) {
  let bank = {
    name: name,
    country: country,
    worldRanking: rank,
    incWorldRanking: function (v) {
      return (this.worldRanking += v);
    },
  };
  return bank;
}

class Bank {
  constructor(name, country, rank) {
    if (name === undefined) {
      this.name = null;
    } else {
      this.name = name;
    }
    this.country = country === undefined ? null : country;
    this.rank = rank === undefined ? null : rank;
  }

  getRank() {
    return this.rank;
  }
}

let bank1 = createBank("hsbc", "UK", 3);
let bank2 = createBank("jpmc", "USA", 2);
let bank3 = createBank("boa", "USA", 1);

let bank0 = new Bank();
let bank1a = new Bank("hsbc", "UK", 3);

console.log(bank1);
console.log(bank0);
console.log(bank1a);
