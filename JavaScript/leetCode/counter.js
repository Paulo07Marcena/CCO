let call = 0;
let lastN;

function createCounter(n) {
  return function add() {
    if (lastN != n) {
      call = 0;
    }
    const sum = n + call;
    call = call + 1;
    lastN = n;
    return sum;
  };
}

createCounter();
