console.log('hi');
console.log("intro return value = " + intro());
testExists();

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
    let element = document.getElementById('greeting')
    if (element.innerHTML.startsWith('Hello')) {
        element.innerHTML = 'Goodbye Grads';
    } else {
        element.innerHTML = 'Hello Grads';
    }
}

function updateDate() {
    document.getElementById('datePoint').innerHTML = new Date();
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
    const stocks1 = ["VOD" ,"BT" ,"BP" ,"HSBA" ,"GOOG"];
    console.log("stocks1=" + stocks1);
    let result1 = exists(stocks1, "BT");
    console.log("result1=" + result1);
    let result2 = exists(stocks1, "TSLA");
    console.log("result2=" + result2);
    console.log("stocks1=" + stocks1);
}

// var stocks2 = ["ANTO", "VOD", "GOOGL", "BP"];

