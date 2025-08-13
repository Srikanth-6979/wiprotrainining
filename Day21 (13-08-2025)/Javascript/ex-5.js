var x =10;

function varDemo() {
    x=x+5;
    let y=10;
    const z=11;
    console.log("x is inside the block-" + x);
    console.log("y is inside the block-" + y);
    console.log("z is inside the block-" + z);
}
varDemo();
console.log("x is Outside the block-" + x);
console.log("y is Outside the block-" + y);
console.log("z is Outside the block-" + z);
