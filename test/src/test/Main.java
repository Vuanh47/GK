package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FresherManager fm = new FresherManager(null);
        ExperienceManager em = new ExperienceManager();
        InternManager im = new InternManager(null);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("------------MENU-----------");
            System.out.println("Chọn chức năng:");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Cập nhật nhân viên");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Tìm kiếm nhân viên");
            System.out.println("5. Hiển thị thông tin nhân viên");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    System.out.println("Nhập loại nhân viên (1. Experience, 2. Fresher, 3. Intern): ");
                    int type = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    
                    switch (type) {
                    System.out.print("Nhập ID: ");
                    String ID = scanner.nextLine();
                    System.out.print("Nhập Họ và Tên: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Nhập Ngày Sinh: ");
                    String birthDay = scanner.nextLine();
                    System.out.print("Nhập Số Điện Thoại: ");
                    String phone = scanner.nextLine();
                    System.out.print("Nhập Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Nhập Số Năm Kinh Nghiệm: ");
                    int expInYear = scanner.nextInt();
                    scanner.nextLine(); // Consume newline left-over
                    System.out.print("Nhập Kỹ Năng Chuyên Môn: ");
                    String proSkill = scanner.nextLine();

                    ExperienceManager experience = new ExperienceManager(ID, fullName, birthDay, phone, email, expInYear, proSkill);
                    manager.addEmployee(experience);
                    }
                        case 2:
                        	 System.out.print("Nhập ID: ");
                             String ID = scanner.nextLine();
                             System.out.print("Nhập Họ và Tên: ");
                             String fullName = scanner.nextLine();
                             System.out.print("Nhập Ngày Sinh: ");
                             String birthDay = scanner.nextLine();
                             System.out.print("Nhập Số Điện Thoại: ");
                             String phone = scanner.nextLine();
                             System.out.print("Nhập Email: ");
                             String email = scanner.nextLine();
                             System.out.print("Nhập Ngày Tốt Nghiệp: ");
                             String graduationDate = scanner.nextLine();
                             System.out.print("Nhập Xếp Loại Tốt Nghiệp: ");
                             String graduationRank = scanner.nextLine();
                             System.out.print("Nhập Trường Đào Tạo: ");
                             String education = scanner.nextLine();

                             Fresher fresher = new Fresher(ID, fullName, birthDay, phone, email, graduationDate, graduationRank, education);
                             manager.addEmployee(fresher);
                        case 3:
                            System.out.print("Nhập ID: ");
                            String internID = scanner.nextLine();
                            // Tiếp tục nhập thông tin cần thiết cho thực tập sinh
                            
                            Intern internEmployee = new Intern(...);
                            manager.addEmployee(internEmployee);
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Nhập ID của nhân viên cần cập nhật: ");
                    String updateID = scanner.nextLine();
                    Employee existingEmployee = manager.findEmployee(updateID);
                    if (existingEmployee != null) {
                        // Yêu cầu nhập thông tin mới cho nhân viên và cập nhật thông tin
                        // Sau khi cập nhật, gọi phương thức updateEmployee() của manager
                    } else {
                        System.out.println("Không tìm thấy nhân viên có ID " + updateID);
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID của nhân viên cần xóa: ");
                    String removeID = scanner.nextLine();
                    boolean removed = manager.removeEmployee(removeID);
                    if (removed) {
                        System.out.println("Nhân viên có ID " + removeID + " đã được xóa.");
                    } else {
                        System.out.println("Không tìm thấy nhân viên có ID " + removeID);
                    }
                    break;
                case 4:
                    System.out.print("Nhập ID của nhân viên cần tìm: ");
                    String searchID = scanner.nextLine();
                    Employee searchedEmployee = manager.findEmployee(searchID);
                    if (searchedEmployee != null) {
                        System.out.println("Thông tin của nhân viên:");
                        searchedEmployee.showInfo();
                    } else {
                        System.out.println("Không tìm thấy nhân viên có ID " + searchID);
                    }
                    break;
                case 5:
                    manager.showAllEmployees();
                    break;
                case 6:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                    break;
            }
        }
    }
}
