function checkUpdateEmployee() {
    let check1 = checkName("employeeName", "invalid-name");
    let check2 = checkPhone("employeePhone", "invalid-phone");
    let check3 = checkFreeStyle("employeeAddress", "invalid-address");
    let check4 = checkAccount("account", "invalid-account");
    let check5 = checkEmail("employeeEmail", "invalid-email");
    let check6 = checkPassword("password", "invalid-password");
    let check7 = checkDOB("employeeBirthDate", "invalid-dob");

    if (check1 && check2 && check3 && check4 && check5 && check6 && check7) {
        return confirm("Do you want to update employee?")
    } else {
        return false;
    }
}

function checkUpdateParkingLot() {
    let check1 = checkAddress("parkName", "invalid-parking-lot-name");
    let check2 = checkArea("parkArea", "invalid-parking-lot-area");
    let check3 = checkPrice("parkPrice", "invalid-parking-lot-price");

    if (check1 && check2 && check3) {
        return confirm("Do you want to update parking lots?")
    } else {
        return false;
    }
}

function checkUpdateCar() {
    let check1 = checkLicensePlate("licensePlate", "invalid-license-plate");
    let check2 = checkFreeStyle("carType", "invalid-car-type");
    let check3 = checkName("carColor", "invalid-car-color");

    if (check1 && check2 && check3) {
        return confirm("Do you want to update cars?")
    } else {
        return false;
    }
}

function checkUpdateTrip() {
    let check1 = checkAddress("destination", "invalid-destination");
    let check2 = checkName("driverName", "invalid-driver");
    let check3 = checkAddress("carType", "invalid-car-type");
    let check4 = checkArea("maximumTicket", "invalid-maximum-ticket");
    let check5 = checkDate("departureDate", "invalid-departure-date")
    // let check6 = checkTime("departureTime", "invalid-departure-time")

    if (check1 && check2 && check3 && check4 && check5) {
        return confirm("Do you want to update trips?")
    } else {
        return false;
    }
}

function checkUpdateTicket() {
    let check1 = checkName("customerName", "invalid-customer-name");
    // let check2 = checkTime("bookingTime", "invalid-departure-time");

    if (check1) {
        return confirm("Do you want to update tickets?")
    } else {
        return false;
    }
}

function checkUpdateOffice() {
    let check1 = checkAddress("officeName", "invalid-office-name");
    let check2 = checkPhone("officePhone", "invalid-phone-number");
    let check3 = checkPrice("officePrice", "invalid-price");
    let check4 = checkDate("startContractDeadline", "invalid-start-deadline")
    let check5 = checkDateAfter("endContractDeadline", "invalid-end-deadline")

    if (check1 && check2 && check3 && check4 && check5) {
        return confirm("Do you want to update offices?")
    } else {
        return false;
    }
}

// Name
function checkName(id, idFeedback) {
    let name = document.getElementById(id).value;
    let regex = /^[A-Za-z\s]{3,50}$/i;
    if (!regex.test(name)) {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    } else {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}

// Account
function checkAccount(id, idFeedback) {
    let account = document.getElementById(id).value;
    let regex = /^[A-Za-z0-9]{3,50}$/i;
    if (!regex.test(account)) {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    } else {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}

// License Plate
function checkLicensePlate(id, idFeedback) {
    let license = document.getElementById(id).value;
    let regex = /^[A-Za-z0-9]{3,10}-[A-Za-z0-9]{2,10}$/i;
    if (!regex.test(license)) {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    } else {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}

// Email
function checkEmail(id, idFeedback) {
    let email = document.getElementById(id).value;
    let regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/i;
    if (!regex.test(email)) {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    } else {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}

//Price
function checkPrice(id, idFeedback) {
    let password = document.getElementById(id).value;
    // let regex = /^\d{1,10}$/i;
    let regex = /^[0-9]+$/;
    if (!regex.test(password)) {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    } else {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}

//Area
function checkArea(id, idFeedback) {
    let password = document.getElementById(id).value;
    // let regex = /^\d{2,50}$/i;
    let regex = /^[0-9]+$/;
    if (!regex.test(password)) {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    } else {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}

//Password
function checkPassword(id, idFeedback) {
    let password = document.getElementById(id).value;
    let regex = /^[A-Za-z0-9]\w{6,14}$/;
    if (!regex.test(password)) {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    } else {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}

// Address
function checkAddress(id, idFeedback) {
    let address = document.getElementById(id).value;
    let regex = /^[A-Za-z0-9\s]{3,50}$/i;
    if (!regex.test(address)) {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    } else {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}

// Address 2
function checkFreeStyle(id, idFeedback) {
    let input = document.getElementById(id).value.toString();
    if (input.length <= 50 && input.length >= 3) {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    } else {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    }
}

// Phone
function checkPhone(id, idFeedback) {
    let phone = document.getElementById(id).value;
    let regex = /^\d{10,11}$/i;
    if (!regex.test(phone)) {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    } else {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    }
}

function checkDate(id, idFeedback) { //after
    let today = new Date().getTime().toString(); // today

    let input = document.getElementById(id).value;
    let date = new Date(input).getTime().toString();

    if (parseInt(date) > parseInt(today)) {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    } else {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    }
}

function checkDateAfter(id, idFeedback) { //after
    let day = document.getElementById("startContractDeadline").value;
    let before = new Date(day).getTime().toString();

    let input = document.getElementById(id).value;
    let after = new Date(input).getTime().toString();

    if (parseInt(after) > parseInt(before)) {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    } else {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    }
}

function checkDOB(id, idFeedback) { //before
    let today = new Date().getTime().toString(); // today

    let input = document.getElementById(id).value;
    let date = new Date(input).getTime().toString();

    if (parseInt(date) < parseInt(today)) {
        document.getElementById(idFeedback).style.display = "none";
        return true;
    } else {
        document.getElementById(idFeedback).style.display = "block";
        return false;
    }

}

// function checkTime(id, idFeedback) {
//     let time = document.getElementById(id).value;
//     let timer = time.toString().length;
//     console.log(timer);
//
//     let timeParts = time.split(":");
//     let hour = timeParts[0].toString();
//     let minute = timeParts[1].toString();
//     let second = timeParts[2].toString();
//
//     if (timer > 8 || timer <8) {
//         document.getElementById(idFeedback).style.display = "block";
//         return false;
//     } else {
//         if (parseInt(hour) < 0 || parseInt(hour) > 23) {
//             document.getElementById(idFeedback).style.display = "block";
//             return false;
//         } else {
//             if (parseInt(minute) < 0 || parseInt(minute) > 59) {
//                 document.getElementById(idFeedback).style.display = "block";
//                 return false;
//             } else {
//                 if (parseInt(second) < 0 || parseInt(second) > 59) {
//                     document.getElementById(idFeedback).style.display = "block";
//                     return false;
//                 } else {
//                     document.getElementById(idFeedback).style.display = "none";
//                     return true;
//                 }
//             }
//         }
//     }
// }