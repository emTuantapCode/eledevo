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
	
	//Khai báo hàm sắp xếp dãy đã cho
	public static Output sapXep(List<Integer> daySo) {
		// Khởi tạo đối tượng Ouput
		Output output= new Output();

        //Khởi tạo biến đếm tổng số phần tử
		int tongSoPhanTu = daySo.size();

        //Khởi tạo biến đếm số lần không đổi
		int soLanKhongDoi;
		
		//Kiểm tra danh sách đã cho không có phần tử
		if (tongSoPhanTu==0) {
			output.status = false;
			output.content = new ArrayList<Integer>();
			output.message = "dãy số không có phần tử nào, không thể sắp xếp";
		}
		//Kiểm tra số phần tử trong danh sách có bằng 1 không
		else if (tongSoPhanTu==1) {
			output.status = true;
			output.content = daySo;
			output.message = "dãy số có 1 phần tử và không cần sắp xếp";
		}
		//Thực hiện so sánh và sắp xếp dãy đã cho
		else {
            //Kiểm tra số lần không đổi = tổng số phần tử -1 thực thi ít nhất 1 lần
            do{
                soLanKhongDoi = 0;

                //So sánh và đổi vị trí giá trị phần tử trong dãy đã cho
				for (int j=0;j<tongSoPhanTu-1;j++) {
					//Kiểm tra giá trị tại vị trí đang xét có lớn hơn giá trị
					//tại vị trí đang xét cộng một
					if (daySo.get(j)>daySo.get(j+1)) {
						//Hóan đổi giá trị hai vị trí
						int giaTriBanDau = daySo.get(j);
						daySo.set(j,daySo.get(j+1));
						daySo.set(j+1,giaTriBanDau);
						
					}else {
						//Cộng số lần không đổi
						soLanKhongDoi++;
						
					}
				}
            }while(soLanKhongDoi == tongSoPhanTu-1)
		}
		//trả về output
		return output;
	}
	//Khai báo hàm chính trong lớp 
	public static void main(String[] args) {
		//Khởi tạo một danh sách chứa các phần tử cần sắp xếp
		List<Integer> daySo = new ArrayList<Integer>(4, 56, -2, 4,-23, 2, -2);
		//Gọi sắp xếp và in ra kết quả
		System.out.println(sapXep(daySo));
	}
    }
}