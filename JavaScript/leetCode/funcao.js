// Para rodar os códigos no terminal do vscode use node + nome do arquivo

// Basic syntax
function func1(a, b) {
  const sum = a + b;
  return sum;
}

console.log(func1(3, 4));
console.log("-".repeat(50));

// Anonymous function
const func2 = function (a, b, c) {
  const med = (a + b + c) / 3;
  return med;
};

console.log(func2(10, 8, 9));
console.log("-".repeat(50));

// Immediately Invoked Function Expression (IIFE)
const result = (function (a, b) {
  const sum = a + b;
  return sum;
})(3, 4);

console.log(result);
console.log("-".repeat(50));

// Functions Within Functions
function createFunction() {
  function f(a, b) {
    const sum = a + b;
    return sum;
  }
  return f;
}

const newFunction = createFunction();
console.log(newFunction(10, 10));
console.log("-".repeat(50));

// Function Hoisting
function func3() {
  return f;
  function f(a, b) {
    const sum = a + b;
    return sum;
  }
}

const func03 = func3();
console.log(func03(9, 9));
console.log("-".repeat(50));

// Closures
function createAdder(a) {
  function f(b) {
    const sum = a + b;
    return sum;
  }
  return f;
}

const func04 = createAdder(3);
console.log(func04(4));
console.log("-".repeat(50));

// Arrow syntax
const func05 = (a, b) => {
  const sum = a + b;
  return sum;
};
console.log(func05(8, 8));
console.log("-".repeat(50));

// Omit Return
const f = (a, b) => a + b;
console.log(f(10, 200));
