// import: khi khai báo 1 đối tượng mới thì hệ thống tự động import trong thư viện java
import java.util.ArrayList;
import java.util.List;

// Khai báo đối tượng output hiển thị kết quả
class Output{
	//Khai báo thuộc tính cho đối tượng.
	public boolean status;
	public List<Integer> content;
	public String message;
	
	// khai báo hàm có đối tượng trả về là thuộc tính của output
	public String toString() {
		return "output [status=" + status + ", content=" + content + ", message=" + message + "]";
	}	
}

//Đối tượng chính
public class Main {
	
	//Khai báo hàm validate kiểm tra phần tử trong dãy <0 
	public static boolean validateError(List<Integer> arr) {
		
		//khởi tạo vòng lặp để lấy từng phần tử so sánh xem có < 0 không
		for (Integer integer : arr) {
		// Nếu đúng thì trả về true
			if (integer < 0)
				return true;
		}
		//Nếu sai thì trả về false
		return false;
	}
	
	//Khai báo hàm sắp xếp dãy đã cho
	public static Output sapXep(List<Integer> arr) {
		// Khởi tạo đối tượng Ouput
		Output output= new Output();
		
		//Kiểm tra danh sách đã cho không có phần tử
		if (arr.size()==0) {
			output.status = false;
			output.content = new ArrayList<Integer>();
			output.message = "Dãy đã cho không có phần tử nào";
		}
		//Kiểm tra xem danh sách có phải là số tự nhiên không
		else if (validateError(arr)) {
			output.status = false;
			output.content = new ArrayList<Integer>();
			output.message = "Dãy đã cho không phải dãy tự nhiên";
		}
		//Kiểm tra số phần tử trong danh sách có bằng 1 không
		else if (arr.size()==1) {
			output.status = true;
			output.content = arr;
			output.message = "Dãy đã cho chỉ có 1 phần tử";
		}
		//Thực hiện so sánh và sắp xếp dãy đã cho
		else {
			//Kiểm tra số lần không đổi
			for (int i= 0;i<arr.size();i++) {
				//Khởi tạo biến đếm số lần không đổi
				int numberOfUnSwap = 0;
				
				//So sánh và đổi vị trí giá trị phần tử trong dãy đã cho
				for (int j=0;j<arr.size()-1;j++) {
					//Kiểm tra giá trị tại vị trí đang xét có lớn hơn giá trị
					//tại vị trí đang xét cộng một
					if (arr.get(j)>arr.get(j+1)) {
						//Hóan đổi giá trị hai vị trí
						int temp = arr.get(j);
						arr.set(j,arr.get(j+1));
						arr.set(j+1,temp);
						
					}else {
						//Cộng số lần không đổi
						numberOfUnSwap++;
						
					}
				}
				//Kiểm tra số lần không đổi có bằng tổng số phần tử -1 
				
				if (numberOfUnSwap == arr.size()-1) {
					output.status = true;
					output.content = arr;
					output.message = "Dãy đã được sắp xếp";
					System.out.println("hung");
				}
			}
		}
		//trả về output
		return output;
	}
	//Khai báo hàm chính trong lớp 
	public static void main(String[] args) {
		//Khởi tạo một danh sách chứa các phần tử cần sắp xếp
		List<Integer> arr = new ArrayList<Integer>();
		//Thêm các phần tử vào danh sách
		   	arr.add(10);
		    arr.add(5);
		    arr.add(4);
		    arr.add(7);
		    arr.add(9);
		    arr.add(2);
		    arr.add(4);
		    arr.add(1);
		    arr.add(0);
		//Gọi sắp xếp và in ra kết quả
		System.out.println(sapXep(arr));
	}
    }
}