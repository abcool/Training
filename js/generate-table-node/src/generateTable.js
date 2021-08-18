export function createMultiplicationTable(rows,cols){
    let tabtableStr="";
    for(let rowNumber of Array(rows).keys()){
        for(let colNumber of Array(cols).keys()){
            tabtableStr += ` ${(rowNumber+1) * (colNumber+1)} `;
        }
        tabtableStr+='\n';
    }
    return tabtableStr;
}