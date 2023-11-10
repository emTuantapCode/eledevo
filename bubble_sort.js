
// Khai báo đầu vào
var arr = [4, 7, 6, 8, 1]

//Hàm sắp xếp
function sapXep(arr) {
    //Khai báo output
    let output = {
        status: true / false,
        content: [],
        message: " "
    }
    //Tạo hàm kiểm tra kiểu dữ liệu
    const validateError = (arr) => {
        // Kiểm tra kiểu dữ liệu là số tự nhiên và lơn hơn bằng 0
        return !arr.every(item => Number.isInteger(item) && item >= 0)
    }
    //Kiểm tra mảng có rỗng không:
    if (arr.length == 0) {
        //Nếu số phần tử trong mảng = 0
        output.status = false
        output.content = []
        output.message = "Dãy không có phần tử nào"
        return output;
    } else if (validateError(arr)) {
        // Kiểm tra kiểu dữ liệu của dãy
        output.status = false
        output.content = []
        output.message = "Dãy ban đầu sai kiểu dữ liệu cần so sánh"
        return output;
    } else if (arr.length == 1) {
        // Kiểm tra tổng số phần tử có = 1 hay không
        output.status = true
        output.content = arr
        output.message = "Dãy số đã được sắp xếp"
        return output;
    } else {
        /* Khai báo vòng for để kiểm tra số lần không đổi */
        for (let i = 0; i < arr.length; i++) {
            //Khai báo số lần không đổi
            let numberOfUnSwap = 0
            /* Khai báo vòng for gọi ra từng phần tử của dãy để so sánh */
            for (let j = 0; j < arr.length - 1; j++) {
                // Vị trí đang xét là j tức giá trị đang xét là arr[j]
                // So sánh phần tử tại vị trí j với j+1
                if (arr[j] > arr[j + 1]) {
                    // Đổi chỗ giá trị 2 vị trí
                    let temp = arr[j]
                    arr[j] = arr[j + 1]
                    arr[j + 1] = temp
                } else numberOfUnSwap++
            }
            // Kiểm tra số lần không đổi
            if (numberOfUnSwap == arr.length - 1) {
                output.status = true
                output.content = arr
                output.message = "Dãy số đã được sắp xếp"
                return output;
            }
        }
    }
}

console.log(sapXep(arr))