import { createMultiplicationTable } from './generateTable';

    let args= process.argv.slice(2);
    let rowsInput = args[0];
    let colsInput = args[1];
    let rows = Number(rowsInput);
    let cols = Number(colsInput);
    if(!isNaN(rows) && !isNaN(cols)){
        let output = createMultiplicationTable(rows,cols);
        console.log(output);
    }else{
        console.log('Invalid inputs entered');
    }
