console.log('hi');
console.log("intro return value = " + intro());

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
