const balanceEl = document.querySelector(".balance .value");
const incomeTotalEl = document.querySelector(".Budget-total");
const outcomeTotalEl = document.querySelector(".outcome-total");
const incomeEl = document.querySelector("#Budget");
const expenseEl = document.querySelector("#expense");
const allEl = document.querySelector("#all");
const incomeList = document.querySelector("#Budget .list");
const expenseList = document.querySelector("#expense .list");
const allList = document.querySelector("#all .list");


const expenseBtn = document.querySelector(".tab1");
const incomeBtn = document.querySelector(".tab2");
const allBtn = document.querySelector(".tab3");


const addExpense = document.querySelector(".add-expense");
const expenseTitle = document.getElementById("expense-title-input");
const expenseAmount = document.getElementById("expense-amount-input");

const addIncome = document.querySelector(".add-Budget");
const incomeTitle = document.getElementById("Budget-title-input");
const incomeAmount = document.getElementById("Budget-amount-input");


let ENTRY_LIST;
let balance = 0, Budget = 0, outcome = 0;
const DELETE = "delete", EDIT = "edit";


ENTRY_LIST = JSON.parse(localStorage.getItem("entry_list")) || [];
updateUI();


expenseBtn.addEventListener("click", function(){
    show(expenseEl);
    hide( [incomeEl, allEl] );
    active( expenseBtn );
    inactive( [incomeBtn, allBtn] );
})
incomeBtn.addEventListener("click", function(){
    show(incomeEl);
    hide( [expenseEl, allEl] );
    active( incomeBtn );
    inactive( [expenseBtn, allBtn] );
})
allBtn.addEventListener("click", function(){
    show(allEl);
    hide( [incomeEl, expenseEl] );
    active( allBtn );
    inactive( [incomeBtn, expenseBtn] );
})

addExpense.addEventListener("click", function(){
    
    if(!expenseTitle.value || !expenseAmount.value ) return;

    
    let expense = {
        type : "expense",
        title : expenseTitle.value,
        amount : parseInt(expenseAmount.value)
    }
    ENTRY_LIST.push(expense);

    updateUI();
    clearInput( [expenseTitle, expenseAmount] )
})

addIncome.addEventListener("click", function(){
    
    if(!incomeTitle.value || !incomeAmount.value ) return;

    
    let Budget = {
        type : "Budget",
        title : incomeTitle.value,
        amount : parseInt(incomeAmount.value)
    }
    ENTRY_LIST.push(Budget);

    updateUI();
    clearInput( [incomeTitle, incomeAmount] )
})

incomeList.addEventListener("click", deleteOrEdit);
expenseList.addEventListener("click", deleteOrEdit);
allList.addEventListener("click", deleteOrEdit);



function deleteOrEdit(event){
    const targetBtn = event.target;

    const entry = targetBtn.parentNode;

    if( targetBtn.id == DELETE ){
        deleteEntry(entry);
    }else if(targetBtn.id == EDIT ){
        editEntry(entry);
    }
}

function deleteEntry(entry){
    ENTRY_LIST.splice( entry.id, 1);

    updateUI();
}

function editEntry(entry){
    console.log(entry)
    let ENTRY = ENTRY_LIST[entry.id];

    if(ENTRY.type == "Budget"){
        incomeAmount.value = ENTRY.amount;
        incomeTitle.value = ENTRY.title;
    }else if(ENTRY.type == "expense"){
        expenseAmount.value = ENTRY.amount;
        expenseTitle.value = ENTRY.title;
    }

    deleteEntry(entry);
}

function updateUI(){
    Budget = calculateTotal("Budget", ENTRY_LIST);
    outcome = calculateTotal("expense", ENTRY_LIST);
    balance = Math.abs(calculateBalance(Budget, outcome));

    
    let sign = (Budget >= outcome) ? "Rs." : "-Rs.";

    
    balanceEl.innerHTML = `<small>${sign}</small>${balance}`;
    outcomeTotalEl.innerHTML = `<small>Rs.</small>${outcome}`;
    incomeTotalEl.innerHTML = `<small>Rs.</small>${Budget}`;

    clearElement( [expenseList, incomeList, allList] );

    ENTRY_LIST.forEach( (entry, index) => {
        if( entry.type == "expense" ){
            showEntry(expenseList, entry.type, entry.title, entry.amount, index)
        }else if( entry.type == "Budget" ){
            showEntry(incomeList, entry.type, entry.title, entry.amount, index)
        }
        showEntry(allList, entry.type, entry.title, entry.amount, index)
    });

    updateChart(Budget, outcome);

    localStorage.setItem("entry_list", JSON.stringify(ENTRY_LIST));
}

function showEntry(list, type, title, amount, id){

    const entry = ` <li id = "${id}" class="${type}">
                        <div class="entry">${title}: Rs.${amount}</div>
                        <div id="edit"></div>
                        <div id="delete"></div>
                    </li>`;

    const position = "afterbegin";

    list.insertAdjacentHTML(position, entry);
}

function clearElement(elements){
    elements.forEach( element => {
        element.innerHTML = "";
    })
}
function calculateBudget(type, list){
    let sum = 0;

    list.forEach( entry => {
        if( entry.type == type ){
            sum += entry.amount;
        }
    })

    return sum;
}

function calculateTotal(type, list){
    let sum = 0;

    list.forEach( entry => {
        if( entry.type == type ){
            sum += entry.amount;
        }
    })

    return sum;
}

function calculateBalance(Budget, outcome){
    return Budget - outcome;
}

function clearInput(inputs){
    inputs.forEach( input => {
        input.value = "";
    })
}
function show(element){
    element.classList.remove("hide");
}

function hide( elements ){
    elements.forEach( element => {
        element.classList.add("hide");
    })
}

function active(element){
    element.classList.add("active");
}

function inactive( elements ){
    elements.forEach( element => {
        element.classList.remove("active");
    })
}